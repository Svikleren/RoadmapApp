package lv.svikleren.roadmapapp.personbuilder;

import lv.svikleren.roadmapapp.model.Person;

public interface PersonBuilder {

    PersonBuilder setName(String name);

    PersonBuilder setSurname(String surname);

    PersonBuilder setGroup(String group);

    PersonBuilder setPhoneNumber(String phoneNumber);

    PersonBuilder setEmail(String email);

    PersonBuilder setComments(String comments);

    Person build();

}
