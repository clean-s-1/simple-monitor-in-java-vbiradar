package vitals;

import java.util.Arrays;

public class Main {
    boolean batteryIsOk(SysInput temperature, SysInput soc, SysInput chargeRate, String local) {
        TemperatureValidator temperatureValidatorComposite = new TemperatureValidator(temperature.validationValue, temperature.unitType, temperature.isMessageEnabled);
        SocValidator socValidatorComposite = new SocValidator(soc.validationValue, soc.unitType, soc.isMessageEnabled);
        ChargeRateValidator chargeRateValidatorComposite = new ChargeRateValidator(chargeRate.validationValue, chargeRate.unitType, chargeRate.isMessageEnabled);
        return new StatusValidator(Arrays.asList(temperatureValidatorComposite, socValidatorComposite, chargeRateValidatorComposite), local).batteryIsOk();
    }

    public static void main(String[] args) {
        Main main = new Main();
        LocaleI18N.loadLocalizations();
        BoundryRules.setConditions();
        assert (main.batteryIsOk(new SysInput(47, FAHRENHEIT_CONST, true), new SysInput(77, null, true), new SysInput(0.9f, null, true), "de") == false);
        assert (main.batteryIsOk(new SysInput(8.33f, CELSIUS_CONST, true), new SysInput(77, null, true), new SysInput(0.9f, null, true), "en") == false);

        assert (main.batteryIsOk(new SysInput(25, FAHRENHEIT_CONST, true), new SysInput(70, null, true), new SysInput(0.7f, null, true), "de") == true);
        assert (main.batteryIsOk(new SysInput(0, FAHRENHEIT_CONST, true), new SysInput(80, null, true), new SysInput(0.80f, null, true), "en") == false);
        assert (main.batteryIsOk(new SysInput(20, FAHRENHEIT_CONST, true), new SysInput(50, null, true), new SysInput(0.60f, null, true), "en") == true);
    }

    static String FAHRENHEIT_CONST = "Fahrenheit";
    static String CELSIUS_CONST = "Celsius";
}
