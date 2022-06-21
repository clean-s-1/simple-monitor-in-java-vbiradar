package vitals;

public interface BatteryHealth {

    boolean isOutOfRange(float temperature, float soc, float chargeRate);

}
