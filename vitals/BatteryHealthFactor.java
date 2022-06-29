package vitals;

public enum BatteryHealthFactor implements BatteryHealth {

    TEMPERATURE {
        @Override
        public boolean isOutOfRange(float temperature, float soc, float chargeRate) {
            boolean batteryHealthState = true;
            if (temperature < 0 || temperature > 45) {
                System.out.println("Temperature is out of range!");
                batteryHealthState = false;
            }
            return batteryHealthState;
        }
    },
    CHARGE_STATE {
        @Override
        public boolean isOutOfRange(float temperature, float soc, float chargeRate) {
            boolean batteryHealthState = true;
            if (soc < 20 || soc > 80) {
                System.out.println("State of Charge is out of range!");
                batteryHealthState = false;
            }
            return batteryHealthState;
        }
    },
    CHARGE_RATE {
        @Override
        public boolean isOutOfRange(float temperature, float soc, float chargeRate) {
            boolean batteryHealthState = true;
            if (chargeRate > 0.8) {
                System.out.println("Charge Rate is out of range!");
                batteryHealthState = false;
            }
            return batteryHealthState;
        }

    }
}
