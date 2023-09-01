package temperaturetest;

import org.junit.Test;
import temperature.Unit;

import static temperaturetest.Context.*;

public class TemperatureTest {


    private final Unit _0_Celsius = new Unit(0, Celsius);
    private final Unit _100_Celsius = new Unit(100, Celsius);
    private final Unit minus40Celsius = new Unit(-40, Celsius);
    private final Unit minus5Celsius = new Unit(-5, Celsius);


    private final Unit _32_Fahrenheit = new Unit(32, Fahrenheit);

    private final Unit _98_6_Fahrenheit = new Unit(98.6,Fahrenheit);

    private final Unit _273_15_KELVIN = new Unit(273.15, Kelvin);
    private final Unit _37_Celsius = new Unit(37, Celsius);
    private final Unit minus40Fahrenheit = new Unit(-40,Fahrenheit);
    private final Unit _212_Fahrenheit = new Unit(212,Fahrenheit);
    private final Unit _23_Fahrenheit = new Unit(23,Fahrenheit);

    private final Unit _373_15_KELVIN= new Unit(373.15,Kelvin);

    private final Context lets = new Context();


    @Test
    public void convertToSelf() {
        lets.verify(_0_Celsius.in(Celsius)).is(_0_Celsius);
        lets.verify(_100_Celsius.in(Celsius)).is(_100_Celsius);
        lets.verify(_32_Fahrenheit.in(Fahrenheit)).is(_32_Fahrenheit);
        lets.verify(_98_6_Fahrenheit.in(Fahrenheit)).is(_98_6_Fahrenheit);
        lets.verify(_273_15_KELVIN.in(Kelvin)).is(_273_15_KELVIN);
    }

    @Test
    public void convertCelsiusToFahrenheit() {
        lets.verify(_0_Celsius.in(Fahrenheit)).is(_32_Fahrenheit);
        lets.verify(minus40Celsius.in(Fahrenheit)).is(minus40Fahrenheit);
        lets.verify(_100_Celsius.in(Fahrenheit)).is(_212_Fahrenheit);
        lets.verify(_37_Celsius.in(Fahrenheit)).is(_98_6_Fahrenheit);
    }

    @Test
    public void convertFahrenheitToCelsius() {

        lets.verify(_32_Fahrenheit.in(Celsius)).is(_0_Celsius);
        lets.verify(minus40Fahrenheit.in(Celsius)).is(minus40Celsius);
        lets.verify(_23_Fahrenheit.in(Celsius)).is(minus5Celsius);

    }

    @Test
    public void convertCelsiusToKelvin() {
        lets.verify(_0_Celsius.in(Kelvin)).is(_273_15_KELVIN);
        lets.verify(_100_Celsius.in(Kelvin)).is(_373_15_KELVIN);
    }

    @Test
    public void convertKelvinToFahrenheit() {
        lets.verify(_273_15_KELVIN.in(Fahrenheit)).is(_32_Fahrenheit);
        lets.verify(_373_15_KELVIN.in(Fahrenheit)).is(_212_Fahrenheit);

    }


}
