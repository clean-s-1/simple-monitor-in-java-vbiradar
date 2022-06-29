package vitals;

public class SysInput {

    float validationValue;
    String unitType;
    boolean isMessageEnabled;
    public SysInput(float validationValue, String unitType, boolean isMessageEnabled) {
        this.validationValue = validationValue;
        this.unitType = unitType;
        this.isMessageEnabled = isMessageEnabled;
    }
}
