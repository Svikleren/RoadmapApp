package lv.svikleren.roadmapapp.chainofresponsibility;

import lv.svikleren.roadmapapp.model.Person;

import java.util.Optional;
import java.util.regex.Pattern;

import static lv.svikleren.roadmapapp.constants.Constants.REGEX_EMAIL;

public class EmailValidator extends DataValidationHandler {

    public EmailValidator(DataValidationHandler dataValidationHandler) {
        super(dataValidationHandler);
    }

    @Override
    public boolean checkData(Person personToValidateEmail) {
        Optional<String> emailToValidate = Optional.ofNullable(personToValidateEmail.getEmail());
        if (!emailToValidate.isPresent() || emailToValidate.get().isEmpty()) {
            return checkNext(personToValidateEmail);
        } else if (Pattern.compile(REGEX_EMAIL).matcher(emailToValidate.get()).matches()) {
            return checkNext(personToValidateEmail);
        } else return false;
    }
}
