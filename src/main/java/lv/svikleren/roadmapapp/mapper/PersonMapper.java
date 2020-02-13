package lv.svikleren.roadmapapp.mapper;


import lv.svikleren.roadmapapp.dto.ContactDto;
import lv.svikleren.roadmapapp.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

    public Person dtoToPerson(ContactDto contactDto) {
        Person person = new Person();
        person.setId(wrapId(contactDto));
        person.setName(contactDto.getName());
        person.setSurname(contactDto.getSurname());
        person.setGroup(contactDto.getGroup());
        person.setPhoneNumber(contactDto.getPhoneNumber());
        person.setEmail(contactDto.getEmail());
        person.setComments(contactDto.getComments());

        return person;
    }

    public ContactDto personToDto(Person person) {
        ContactDto contactDto = new ContactDto();
        contactDto.setId(wrapId(person));
        contactDto.setName(person.getName());
        contactDto.setSurname(person.getSurname());
        contactDto.setGroup(person.getGroup());
        contactDto.setPhoneNumber(person.getPhoneNumber());
        contactDto.setEmail(person.getEmail());
        contactDto.setComments(person.getComments());

        return contactDto;
    }

    private Long wrapId(ContactDto contactDto) {
        return contactDto.getId() == null ? 0 : contactDto.getId();
    }

    private Long wrapId(Person person) {
        return person.getId() == null ? 0 : person.getId();
    }
}