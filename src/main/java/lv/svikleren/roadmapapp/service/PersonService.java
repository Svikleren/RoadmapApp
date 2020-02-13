package lv.svikleren.roadmapapp.service;

import lv.svikleren.roadmapapp.dto.ContactDto;

import java.util.List;

public interface PersonService {
    List<ContactDto> getAllContacts();

    void addContact(ContactDto addedPerson);

    ContactDto getItemById(Long id);

    void updateContact(ContactDto editedPerson);

    void deleteContact(Long id);

}
