package lv.svikleren.roadmapapp.chainofresponsibility;

import lv.svikleren.roadmapapp.dto.ContactDto;

public abstract class DataValidationHandler {
    private DataValidationHandler nextValidator;

    public DataValidationHandler(DataValidationHandler dataValidationHandler) {
        this.nextValidator = dataValidationHandler;
    }

    public abstract boolean checkData(ContactDto personToValidate);

    protected boolean checkNext(ContactDto personToValidate) {
        if (nextValidator == null) {
            return true;
        }
        return nextValidator.checkData(personToValidate);
    }
}
