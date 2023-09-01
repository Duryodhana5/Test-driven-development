import com.jio.roman.ex.RomanDigit;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jio.roman.ex.RomanDigit.parse;
import static java.util.Arrays.asList;
import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

public class RomanDigitTest {
    @Test
    public void equalityIsBasedOnDecimalValue()  {
        RomanDigit one = new RomanDigit('I', 1);
        assertEquals(one, one);
        assertEquals(new RomanDigit('I', 1), one);
        assertNotEquals("null should not be equal to valid RomanDigit", null, one);
    }

    @Test
    public void isMapFriendly() {
        RomanDigit one = new RomanDigit('I', 1);
        RomanDigit anotherOne = new RomanDigit('I', 1);
        Map<RomanDigit, String> romanDigits = new HashMap<>();
        romanDigits.put(one, "One");
        romanDigits.put(anotherOne, "AnotherOne");
        assertEquals(1, romanDigits.size());
        assertEquals("AnotherOne", romanDigits.get(one));
        assertEquals("AnotherOne", romanDigits.get(anotherOne));
    }

    @Test
    public void onlySevenDigitsAreValid()  {
        for (char c : asList('I', 'V', 'X', 'L', 'D', 'M'))
            parse(c);
    }

    @Test
    public void otherDigitsAreInvalid()  {
        assertDigitIsInvalid('A');
        assertDigitIsInvalid('Z');
    }

    @Test
    public void negativeNumberAreInvalid()  {
        assertDigitIsInvalid('-');
    }

    @Test
    public void zeroIsInvalid()  {
        assertDigitIsInvalid('0');
    }

    @Test
    public void areCaseInsensitive() {
        for (char c : asList('i', 'v', 'x', 'l', 'd', 'm'))
            parse(c);
        assertDigitIsInvalid('a');
        assertDigitIsInvalid('z');
    }
    @Test
    public void appendsItsDecimalValueToGivenValue(){
        assertAppendedValue(2, 'I', 1);
        assertAppendedValue(7, 'V', 2);
        assertAppendedValue(15, 'X', 5 );
        assertAppendedValue(51, 'L', 1);
        assertAppendedValue(103, 'C', 3);
        assertAppendedValue(499, 'D', -1);
        assertAppendedValue(1001, 'M', 1);
    }
    @Test
    public void addsItsDecimalValueToGivenValueIfNextDigitsSmallerThanOrEqualToItself(){
        assertValuesBasedOnNextDigit(2, 'I', 'I');
        assertValuesBasedOnNextDigit(6, 'V', 'I');
        assertValuesBasedOnNextDigit(11, 'X', 'I');
        assertValuesBasedOnNextDigit(11, 'X', 'V');
    }
    @Test
    public void subtractsItsDecimalValueFromGivenValueIfNextDigitIsGreaterThanItself(){
        assertValuesBasedOnNextDigit(0, 'I', 'V');
        assertValuesBasedOnNextDigit(-4, 'V', 'X');
        assertValuesBasedOnNextDigit(-9, 'X', 'L');
    }
    @Test
    public void onlyPowerOfTensRepeate(){
        assertTrue("I is a power of Ten and can repeat", romanDigit('I').canRepeat());
        assertFalse("V is not a power of Ten and Should not repeat",romanDigit('V').canRepeat());
        assertTrue("X is a power of Ten and can repeat", romanDigit('X').canRepeat());
        assertFalse("L is not a power of Ten and Should not repeat",romanDigit('L').canRepeat());
    }
    private void assertAppendedValue(final int expected, final char digit, final int oldValue){
        assertEquals(expected, romanDigit(digit).appendValueTo(oldValue));
    }
    private RomanDigit romanDigit(final char testDigit){return parse(testDigit);}
    private void assertValuesBasedOnNextDigit(final int expected, final char digit, final char next){
        assertEquals(expected, romanDigit(digit).dependingOnNextDigitAppendValueTo(1, romanDigit(next)));
    }
    private void assertDigitIsInvalid(final char testDigitValue){
        try{
            romanDigit(testDigitValue);
            fail("Should have thrown an exception");
        } catch (NumberFormatException e){
            assertEquals(testDigitValue+ " is not a valid Roman Numeral Digit", e.getMessage());
        }
    }
}
