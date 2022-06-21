package vitals;

public class Main {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate, BatteryHealth batteryHealth) {
        return batteryHealth.isOutOfRange(temperature, soc, chargeRate);
    }


    public static void main(String[] args) {
        assert (batteryIsOk(25, 70, 0.7f, BatteryHealthFactor.valueOf("TEMPERATURE")) == true);
        assert (batteryIsOk(50, 85, 0.0f, BatteryHealthFactor.valueOf("TEMPERATURE")) == false);
        assert (batteryIsOk(25, 70, 0.7f, BatteryHealthFactor.valueOf("CHARGE_STATE")) == true);
        assert (batteryIsOk(25, 85, 0.0f, BatteryHealthFactor.valueOf("CHARGE_STATE")) == false);
        assert (batteryIsOk(25, 70, 0.9f, BatteryHealthFactor.valueOf("CHARGE_RATE")) == false);
        assert (batteryIsOk(30, 40, 0.7f, BatteryHealthFactor.valueOf("CHARGE_RATE")) == true);
        System.out.println("Battery Condition tested");
    }
}
