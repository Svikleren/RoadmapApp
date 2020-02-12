package lv.svikleren.roadmapapp.chainofresponsibility;

import lv.svikleren.roadmapapp.model.Person;

import java.util.Optional;
import java.util.regex.Pattern;

import static lv.svikleren.roadmapapp.constants.Constants.REGEX_PHONE;

public class PhoneNumberValidator extends DataValidationHandler {
    public PhoneNumberValidator(DataValidationHandler dataValidationHandler) {
        super(dataValidationHandler);
    }

    @Override
    public boolean checkData(Person personToValidatePhoneNumber) {
        Optional<String> phoneNumberToValidate = Optional.ofNullable(personToValidatePhoneNumber.getPhoneNumber());
        if (!phoneNumberToValidate.isPresent() || phoneNumberToValidate.get().isEmpty()) {
            return checkNext(personToValidatePhoneNumber);
        } else if (Pattern.compile(REGEX_PHONE).matcher(phoneNumberToValidate.get()).matches()) {
            return checkNext(personToValidatePhoneNumber);
        } else return false;
    }
}
