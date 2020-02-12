package lv.svikleren.roadmapapp.mapper;


import lv.svikleren.roadmapapp.dto.ContactDto;
import lv.svikleren.roadmapapp.model.Person;

public class PersonMapper {

    public Person dtoToPerson(ContactDto contactDto) {
        Person person = new Person();
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

        contactDto.setName(person.getName());
        contactDto.setSurname(person.getSurname());
        contactDto.setGroup(person.getGroup());
        contactDto.setPhoneNumber(person.getPhoneNumber());
        contactDto.setEmail(person.getEmail());
        contactDto.setComments(person.getComments());

        return contactDto;
    }
}