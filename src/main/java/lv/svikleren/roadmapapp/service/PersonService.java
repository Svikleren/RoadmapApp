package lv.svikleren.roadmapapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.svikleren.roadmapapp.model.Person;
import lv.svikleren.roadmapapp.repository.PersonRepository;
import lv.svikleren.roadmapapp.validation.DataValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final DataValidationService dataValidationService;

    public List<Person> getAllContacts() {
        return personRepository.findAll();
    }

    public void addContact(Person addedPerson) {
        if (dataValidationService.validateData(addedPerson)) {
            personRepository.save(addedPerson);
            log.info("Contact with id {} added", addedPerson.getId());
        } else {
            log.error("Contact with id {} can't be added - not valid data", addedPerson.getId());
        }

    }

    public Person getItemById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
    }

    public void updateContact(Person editedPerson) {
        if (dataValidationService.validateData(editedPerson)) {
            personRepository.save(editedPerson);
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
