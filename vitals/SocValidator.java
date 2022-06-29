package vitals;

import java.util.ArrayList;

public class SocValidator implements Validator {

    private float validationValue;
    private String unitType;
    private boolean isMessageEnabled;

    public SocValidator(float validationValue, String unitType, boolean isMessageEnabled) {
        this.validationValue = validationValue;
        this.unitType = unitType;
        this.isMessageEnabled = isMessageEnabled;
    }

    @Override
    public float translateToCommonUnits() {
        //we can convert the units here
        return this.validationValue;
    }

    @Override
    public ArrayList<String> getWarningList(float validationValue) {
        if(this.isMessageEnabled) {
            BoundryRules boundryRules = new BoundryRules();
            return boundryRules.getMessagesBasedOnValue(validationValue, "soc", "WARNING");
        }
        return new ArrayList<>();
    }

    @Override
    public ArrayList<String> getErrorList(float validationValue) {

        BoundryRules boundryRules = new BoundryRules();
        return boundryRules.getMessagesBasedOnValue(validationValue, "soc", "BREACH");
    }

    @Override
    public boolean batteryIsOk() {
        BoundryRules boundryRules = new BoundryRules();
        return boundryRules.getMessagesBasedOnValue(validationValue, "soc", "BREACH").isEmpty();
    }
}
