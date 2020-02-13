package lv.svikleren.roadmapapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.svikleren.roadmapapp.dto.ContactDto;
import lv.svikleren.roadmapapp.mapper.PersonMapper;
import lv.svikleren.roadmapapp.repository.PersonRepository;
import lv.svikleren.roadmapapp.validation.DataValidationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final DataValidationService dataValidationService;
    private final PersonMapper mapper;

    @Override
    public List<ContactDto> getAllContacts() {
        return personRepository.findAll().stream()
                .map(mapper::personToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addContact(ContactDto addedContact) {
        if (dataValidationService.validateData(addedContact)) {
            personRepository.save(mapper.dtoToPerson(addedContact));
            log.info("Contact with id {} added", addedContact.getId());
        } else {
            log.error("Contact with id {} can't be added - not valid data", addedContact.getId());
        }

    }

    @Override
    public ContactDto getItemById(Long id) {
        return personRepository.findById(id)
                .map(mapper::personToDto)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
    }

    @Override
    public void updateContact(ContactDto editedContact) {
        if (dataValidationService.validateData(editedContact)) {
            personRepository.save(mapper.dtoToPerson(editedContact));
            log.info("Contact with id {} updated", editedContact.getId());
        } else {
            log.error("Contact with id {} can't be edited - not valid data", editedContact.getId());
        }
    }

    @Override
    public void deleteContact(Long id) {
        personRepository.deleteById(id);
        log.info("Contact with id {} deleted", id);
    }

}
