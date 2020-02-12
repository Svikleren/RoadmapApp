package lv.svikleren.roadmapapp.validation;

import lombok.extern.slf4j.Slf4j;
import lv.svikleren.roadmapapp.chainofresponsibility.DataValidationHandler;
import lv.svikleren.roadmapapp.chainofresponsibility.EmailValidator;
import lv.svikleren.roadmapapp.chainofresponsibility.PhoneNumberValidator;
import lv.svikleren.roadmapapp.model.Person;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DataValidationService {

    public boolean validateData(Person person) {
        DataValidationHandler dataValidationHandler = new PhoneNumberValidator(new EmailValidator(null));
        return dataValidationHandler.checkData(person);
    }
}
