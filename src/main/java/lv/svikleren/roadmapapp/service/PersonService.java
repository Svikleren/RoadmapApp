package lv.svikleren.roadmapapp.service;

import lombok.extern.slf4j.Slf4j;
import lv.svikleren.roadmapapp.model.Person;
import lv.svikleren.roadmapapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void addContact(Person person) {
        personRepository.save(person);
        log.info("Contact {} added", person.getName());
    }

    public void editContact(Long id) {
        Optional<Person> item = personRepository.findById(id);
    }

    public void deleteContact(Long id) {
        personRepository.deleteById(id);
        log.info("Contact with id {} deleted", id);
    }

    public List<Person> getAllItems() {
        return personRepository.findAll();
    }

    public Person getItemById(Long id) {
        return personRepository.findById(id).orElse(new Person());
    }
}
