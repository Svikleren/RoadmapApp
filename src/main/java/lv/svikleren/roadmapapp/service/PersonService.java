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
public class PersonService {

    private final PersonRepository personRepository;
    private final DataValidationService dataValidationService;
    private final PersonMapper mapper;

    public List<ContactDto> getAllContacts() {
        return personRepository.findAll().stream()
                .map(mapper::personToDto)
                .collect(Collectors.toList());
    }

    public void addContact(ContactDto addedPerson) {
        if (dataValidationService.validateData(addedPerson)) {
            personRepository.save(mapper.dtoToPerson(addedPerson));
            log.info("Contact with id {} added", addedPerson.getId());
        } else {
            log.error("Contact with id {} can't be added - not valid data", addedPerson.getId());
        }

    }

    public ContactDto getItemById(Long id) {
        return personRepository.findById(id)
                .map(mapper::personToDto)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
    }

    public void updateContact(ContactDto editedPerson) {
        if (dataValidationService.validateData(editedPerson)) {
            personRepository.save(mapper.dtoToPerson(editedPerson));
            log.info("Contact with id {} updated", editedPerson.getId());
        } else {
            log.error("Contact with id {} can't be edited - not valid data", editedPerson.getId());
        }
    }

    public void deleteContact(Long id) {
        personRepository.deleteById(id);
        log.info("Contact with id {} deleted", id);
    }

}
