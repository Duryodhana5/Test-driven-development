package temperaturetest;

import org.junit.Test;
import temperature.Unit;

import static temperaturetest.Context.*;


public class LengthTest {

    private final Context lets = new Context();

    private final Unit _12_Inches = new Unit(12, Inches);
    private final Unit _36_Inches= new Unit(36, Inches);

    private final Unit _1_Mile = new Unit(1, Mile);
    private final Unit _1_Yard = new Unit(1, Yard);
    private final Unit _1_Feet = new Unit(1, Feet);
    private final Unit _1_Inches = new Unit(1, Inches);
    private final Unit _3520_Yard = new Unit(3520, Yard);
    private final Unit _2_Mile = new Unit(2, Mile);
    private final Unit _10560_Feet = new Unit(10560,Feet);


    @Test
    public void verifyFeetInInches() {
        lets.verify(_1_Feet.in(Inches)).is(_12_Inches);
    }

    @Test
    public void verifyMilesInYard(){
        lets.verify(_2_Mile.in(Yard)).is(_3520_Yard);
    }

    @Test
    public void verifyInchesInYard(){
        lets.verify(_36_Inches.in(Yard)).is(_1_Yard);
    }

    @Test
    public void verifyYardInFeet(){
        lets.verify(_3520_Yard.in(Feet)).is(_10560_Feet);
    }

    @Test
    public void convertToSelf(){
        lets.verify(_1_Yard.in(Yard)).is(_1_Yard);
        lets.verify(_1_Mile.in(Mile)).is(_1_Mile);
        lets.verify(_1_Inches.in(Inches)).is(_1_Inches);
        lets.verify(_1_Feet.in(Feet)).is(_1_Feet);
    }





}
