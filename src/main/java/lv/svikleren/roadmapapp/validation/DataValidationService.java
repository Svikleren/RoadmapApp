package lv.svikleren.roadmapapp.validation;

import lombok.extern.slf4j.Slf4j;
import lv.svikleren.roadmapapp.dto.ContactDto;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DataValidationService {

    public boolean validateData(ContactDto person) {
        DataValidationHandler dataValidationHandler = new PhoneNumberValidator(new EmailValidator(null));
        return dataValidationHandler.checkData(person);
    }
}
