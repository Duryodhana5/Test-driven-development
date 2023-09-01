package temperaturetest;

import org.junit.Test;
import temperature.Unit;

import static temperaturetest.Context.*;

public class VolumeTest {

    private final Unit _1_Cup = new Unit(1,Cup);
    private final Unit _1_Pint = new Unit(1,Pint);
    private final Unit _1_TableSpoon = new Unit(1,TableSpoon);
    private final Unit _3_TeaSpoon = new Unit(3,TeaSpoon);
    private final Unit _16_TableSpoon = new Unit(16,TableSpoon);
    private final Unit _2_Cup = new Unit(2,Cup);
    private final Unit _32_TableSpoon = new Unit(32,TableSpoon);
    private final Unit _48_TeaSpoon = new Unit(48,TeaSpoon);
    private Context lets = new Context();

    @Test
    public void convertToSelf(){
        lets.verify(_1_Cup.in(Cup)).is(_1_Cup);
        lets.verify(_1_Pint.in(Pint)).is(_1_Pint);
        lets.verify(_32_TableSpoon.in(TableSpoon)).is(_32_TableSpoon);
        lets.verify(_48_TeaSpoon.in(TeaSpoon)).is(_48_TeaSpoon);

    }

    @Test
    public void convertTeaSpoonToTableSpoon(){
        lets.verify(_3_TeaSpoon.in(TableSpoon)).is(_1_TableSpoon);
    }
    @Test
    public void convertCupToTableSpoon(){
        lets.verify(_1_Cup.in(TableSpoon)).is(_16_TableSpoon);
    }
    @Test
    public void convertPintToCup(){
        lets.verify(_1_Pint.in(Cup)).is(_2_Cup);
    }
    @Test
    public void convertPintToTableSpoon(){
        lets.verify(_1_Pint.in(TableSpoon)).is(_32_TableSpoon);
    }
    @Test
    public void convertCupToTeaSpoon(){
        lets.verify(_1_Cup.in(TeaSpoon)).is(_48_TeaSpoon);
    }


}
