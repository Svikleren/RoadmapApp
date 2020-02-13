package lv.svikleren.roadmapapp.service;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import lv.svikleren.roadmapapp.dto.ContactDto;
import lv.svikleren.roadmapapp.mapper.PersonMapper;
import lv.svikleren.roadmapapp.model.Person;
import lv.svikleren.roadmapapp.repository.PersonRepository;
import lv.svikleren.roadmapapp.validation.DataValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;
    @Mock
    private DataValidationService dataValidationService;
    @Spy
    private PersonMapper personMapper;

    @InjectMocks
    private PersonServiceImpl personServiceImpl;

    @Test
    public void getAllContacts() {

        personServiceImpl.getAllContacts();
        verify(personRepository, times(1)).findAll();
    }

    @Test
    public void addContact() {

        ContactDto contactDto = new ContactDto();
        contactDto.setId(1L);

        when(dataValidationService.validateData(any())).thenReturn(true);

        Logger logger = (Logger) LoggerFactory.getLogger(PersonServiceImpl.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);

        personServiceImpl.addContact(contactDto);

        verify(personRepository, times(1)).save(any());

        List<ILoggingEvent> loggingEvents = listAppender.list;
        ILoggingEvent event = loggingEvents.get(0);
        assertEquals(Level.INFO, event.getLevel());
        assertEquals("Contact with id 1 added", event.getFormattedMessage());
    }

    @Test
    public void addContactWrong() {

        ContactDto person = new ContactDto();
        person.setId(1L);

        when(dataValidationService.validateData(any())).thenReturn(false);

        Logger logger = (Logger) LoggerFactory.getLogger(PersonServiceImpl.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);

        personServiceImpl.addContact(person);

        verify(personRepository, times(0)).save(any());

        List<ILoggingEvent> loggingEvents = listAppender.list;
        ILoggingEvent event = loggingEvents.get(0);
        assertEquals(Level.ERROR, event.getLevel());
        assertEquals("Contact with id 1 can't be added - not valid data", event.getFormattedMessage());
    }

    @Test
    public void getItemById() {

        when(personRepository.findById(any())).thenReturn(java.util.Optional.of(new Person()));
        personServiceImpl.getItemById(1L);
        verify(personRepository, times(0)).save(any());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getItemByIdException() {

        try {
            personServiceImpl.getItemById(1L);
        } catch (IllegalArgumentException ex) {
            assertEquals("Invalid person Id:1", ex.getMessage());
            throw ex;
        }
        verify(personRepository, times(1)).save(any());
    }

    @Test
    public void updateContact() {

        ContactDto person = new ContactDto();
        person.setId(1L);

        when(dataValidationService.validateData(any())).thenReturn(true);

        Logger logger = (Logger) LoggerFactory.getLogger(PersonServiceImpl.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);

        personServiceImpl.updateContact(person);

        verify(personRepository, times(1)).save(any());

        List<ILoggingEvent> loggingEvents = listAppender.list;
        ILoggingEvent event = loggingEvents.get(0);
        assertEquals(Level.INFO, event.getLevel());
        assertEquals("Contact with id 1 updated", event.getFormattedMessage());
    }

    @Test
    public void updateContactWrong() {

        ContactDto person = new ContactDto();
        person.setId(1L);

        when(dataValidationService.validateData(any())).thenReturn(false);

        Logger logger = (Logger) LoggerFactory.getLogger(PersonServiceImpl.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);

        personServiceImpl.updateContact(person);

        verify(personRepository, times(0)).save(any());

        List<ILoggingEvent> loggingEvents = listAppender.list;
        ILoggingEvent event = loggingEvents.get(0);
        assertEquals(Level.ERROR, event.getLevel());
        assertEquals("Contact with id 1 can't be edited - not valid data", event.getFormattedMessage());
    }

    @Test
    public void deleteContact() {

        Logger logger = (Logger) LoggerFactory.getLogger(PersonServiceImpl.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);

        personServiceImpl.deleteContact(1L);

        verify(personRepository, times(1)).deleteById(1L);

        List<ILoggingEvent> loggingEvents = listAppender.list;
        ILoggingEvent event = loggingEvents.get(0);
        assertEquals(Level.INFO, event.getLevel());
        assertEquals("Contact with id 1 deleted", event.getFormattedMessage());
    }
}