package lv.svikleren.roadmapapp.bootstrap;

import lv.svikleren.roadmapapp.model.Person;
import lv.svikleren.roadmapapp.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.event.ContextRefreshedEvent;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class InitDataBootstrapTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private InitDataBootstrap initDataBootstrap;

    @Test
    public void onApplicationEvent() {

        ArgumentCaptor<Person> captor = ArgumentCaptor.forClass(Person.class);

        initDataBootstrap.onApplicationEvent(new ContextRefreshedEvent(new InitDataBootstrapTestListener()));

        verify(personRepository, times(3)).save(captor.capture());
        assertEquals(3, captor.getAllValues().size());
        assertEquals("Anna", captor.getAllValues().get(0).getName());
        assertEquals("Janis", captor.getAllValues().get(1).getName());
        assertEquals("Arvis", captor.getAllValues().get(2).getName());
    }
}