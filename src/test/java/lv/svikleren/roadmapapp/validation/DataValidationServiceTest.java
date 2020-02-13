package lv.svikleren.roadmapapp.validation;

import lv.svikleren.roadmapapp.model.Person;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DataValidationServiceTest {

    Person person = new Person();

    DataValidationService dataValidationService = new DataValidationService();


    @Test
    public void validateDataGood() {

        person.setPhoneNumber("12345678");
        person.setEmail("aaa@bbb.cc");

        assertTrue(dataValidationService.validateData(person));
    }

    @Test
    public void validateDataPhoneNumberBad() {

        person.setPhoneNumber("12345678910");
        person.setEmail("aaa@bbb.cc");

        assertFalse(dataValidationService.validateData(person));
    }

    @Test
    public void validateDataEmailBad() {

        person.setPhoneNumber("12345678");
        person.setEmail("aaabbb.cc");

        assertFalse(dataValidationService.validateData(person));
    }

    @Test
    public void validateDataPhoneNumberEmpty() {

        person.setPhoneNumber("");
        person.setEmail("aaa@bbb.cc");

        assertTrue(dataValidationService.validateData(person));
    }

    @Test
    public void validateDataEmailEmpty() {

        person.setPhoneNumber("12345678");
        person.setEmail("");

        assertTrue(dataValidationService.validateData(person));
    }

    @Test
    public void validateDataPhoneNumberNull() {

        person.setPhoneNumber(null);
        person.setEmail("aaa@bbb.cc");

        assertTrue(dataValidationService.validateData(person));
    }

    @Test
    public void validateDataEmailNull() {

        person.setPhoneNumber("12345678");
        person.setEmail(null);

        assertTrue(dataValidationService.validateData(person));
    }
}
