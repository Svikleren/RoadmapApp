package lv.svikleren.roadmapapp.chainofresponsibility;

import lv.svikleren.roadmapapp.model.Person;

public abstract class DataValidationHandler {
    private DataValidationHandler nextValidator;

    public DataValidationHandler(DataValidationHandler dataValidationHandler) {
        this.nextValidator = dataValidationHandler;
    }

    public DataValidationHandler linkWith(DataValidationHandler nextValidator) {
        this.nextValidator = nextValidator;
        return nextValidator;
    }

    public abstract boolean checkData(Person personToValidate);

    protected boolean checkNext(Person personToValidate) {
        if (nextValidator == null) {
            return true;
        }
        return nextValidator.checkData(personToValidate);
    }
}