package temperaturetest;

import temperature.MetricType;
import temperature.Unit;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static temperature.MetricType.Type.*;

public class Context {

    public static final MetricType Inches = new MetricType("Inch",LENGTH,1,0);
    public static final MetricType Feet = new MetricType("Feet",LENGTH,12*1,0);
    public static final MetricType Yard = new MetricType("Yard",LENGTH,3*12*1,0);
    public static final MetricType Mile = new MetricType("Mile",LENGTH,1760*3*12*1,0);
    public static final MetricType TeaSpoon = new MetricType("Tea Spoon",VOLUME,1,0);
    public static final MetricType TableSpoon = new MetricType("Table Spoon",VOLUME,3 *1,0);
    public static final MetricType Kelvin = new MetricType("Kelvin",TEMPERATURE,1.0,273.15);
    public static final MetricType Celsius = new MetricType("Celsius",TEMPERATURE,1.0,0);
    public static final MetricType Fahrenheit = new MetricType("Fahrenheit",TEMPERATURE,5.0/9,32);

    public static final MetricType Cup = new MetricType("Cup",VOLUME,16*3*1,0);
    public static final MetricType Pint = new MetricType("Pint",VOLUME,2*16*3*1,0);
    private Unit actualUnit ;

    protected void is(Unit expected){
        assertEquals(actualUnit.value ,expected.value);
        assertTrue(actualUnit.equals(expected));
    }

    public Context verify(Unit actualUnit) {
        this.actualUnit = actualUnit;
        return this;
    }
}
