package lv.svikleren.roadmapapp.personbuilder;

import lv.svikleren.roadmapapp.model.Person;

public class PersonBuilderImpl implements PersonBuilder {

    Person person = new Person();

    @Override
    public PersonBuilder setName(String name) {
        person.setName(name);
        return this;
    }

    @Override
    public PersonBuilder setSurname(String surname) {
        person.setName(surname);
        return this;
    }

    @Override
    public PersonBuilder setGroup(String group) {
        person.setName(group);
        return this;
    }

    @Override
    public PersonBuilder setPhoneNumber(String phoneNumber) {
        person.setName(phoneNumber);
        return this;
    }

    @Override
    public PersonBuilder setEmail(String email) {
        person.setName(email);
        return this;
    }

    @Override
    public PersonBuilder setComments(String comments) {
        person.setName(comments);
        return this;
    }

    @Override
    public Person build() {
        return person;
    }
}
