package lv.svikleren.roadmapapp.validation;

import lombok.extern.slf4j.Slf4j;
import lv.svikleren.roadmapapp.model.Person;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static lv.svikleren.roadmapapp.constants.Constants.REGEX_PHONE;

@Slf4j
@Service
public class DataValidationService {

    public boolean validateData(Person person) {
        return validatePhoneNumber(person.getPhoneNumber()) && validateEmailAddress(person.getEmail());
    }

    private boolean validatePhoneNumber(String number) {
        return Pattern.compile(REGEX_PHONE).matcher(number).matches();
    }

    private boolean validateEmailAddress(String email) {
        return Pattern.compile(REGEX_PHONE).matcher(email).matches();
    }
}
