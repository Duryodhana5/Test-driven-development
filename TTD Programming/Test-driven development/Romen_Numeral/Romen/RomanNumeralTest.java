import com.jio.roman.ex.RomanNumeral;
import org.junit.Test;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class RomanNumeralTest {
    @Test
    public void emptyStringAndNullAreInvalid(){
        assertParseException("", "Empty String is not a valid Roman Numeral");
        assertParseException(" ", "Empty String is not a valid Roman Numeral");
        assertParseException(null, "null is not a valid Roman Numeral");
    }
    @Test
    public void parsesGivenStringToBuildItself(){
        for (String s : asList("I", "i", "V", "v", "X", "x", "L", "l", "C", "c", "D", "d", "M", "m", "XVI", "MDCLXVI", "MDcLxVI")) {
            assertEquals(s.toUpperCase(), romanNumeral(s).toString());
        }
    }
    @Test
    public void whiteSpaceAreIgnored(){
        for(String s : asList(" M ", "X V I", "X VI", "XV\tI ")){
            assertEquals(s.replaceAll("\\s+", ""), romanNumeral(s).toString());
        }
    }
    @Test
    public void returnDecimalValue(){
        assertEquals(1, romanNumeral("I").decimalValue());
        assertEquals(5, romanNumeral("V").decimalValue());
        assertEquals(10, romanNumeral("X").decimalValue());
        assertEquals(50, romanNumeral("L").decimalValue());
        assertEquals(100, romanNumeral("C").decimalValue());
        assertEquals(500, romanNumeral("D").decimalValue());
        assertEquals(1000, romanNumeral("M").decimalValue());
        assertEquals(267, romanNumeral("CCLXVII").decimalValue());
        assertEquals(1666, romanNumeral("mdclxvi").decimalValue());
        assertEquals(1997, romanNumeral("MCMXCVII").decimalValue());
        assertEquals(99, romanNumeral("XCIX").decimalValue());
        assertEquals(243, romanNumeral("CCXLIII").decimalValue());
    }
    @Test
    public void satisfiesRepetitionRule(){
        assertParseException("LL", "L cannot repeat itself, this violates the Repetition Rule for Roman Numerals");
        assertParseException("CLLX", "L cannot repeat itself, this violates the Repetition Rule for Roman Numerals");
        assertParseException("CLXVV", "V cannot repeat itself, this violates the Repetition Rule for Roman Numerals");
        assertParseException("DDCLXVV", "D cannot repeat itself, this violates the Repetition Rule for Roman Numerals");
        assertParseException("XXXX", "X cannot repeat more than thrice, this violates the Repetition Rule for Roman Numerals");
        assertParseException("MDCLXVIIII", "I cannot repeat more than thrice, this violates the Repetition Rule for Roman Numerals");
    }
    @Test
    public void subtractsOnlyDigitFromAnotherDigit(){
        assertParseException("XXL", "XX cannot be subtracted from L, this violates the subtraction Rule for Roman Numerals");
        assertParseException("CCD", "CC cannot be subtracted from D, this violates the subtraction Rule for Roman Numerals");
    }
    @Test
    public void onlyPowerOfTenCanBeSubtracted(){
        assertParseException("VX","V cannot be subtracted from X, since V is not a power of ten. This violates the subtraction Rule for Roman Numerals");
        assertParseException("CLVX","V cannot be subtracted from X, since V is not a power of ten. This violates the subtraction Rule for Roman Numerals");
        assertParseException("LC", "L cannot be subtracted from C, since L is not a power of ten. This violates the subtraction Rule for Roman Numerals");
        assertParseException("DM", "D cannot be subtracted from M, since D is not a power of ten. This violates the subtraction Rule for Roman Numerals");
    }
    @Test
    public void onlyOneTenthOrOneFifthDigitsCanBeSubtracted(){
        assertParseException("IC", "I cannot be subtracted from C, since I is not a power of one tenth or one fifth of C. This violates the subtraction Rule for Roman Numerals");
        assertParseException("XM", "X cannot be subtracted from M, since X is not a power of one tenth or one fifth of M. This violates the subtraction Rule for Roman Numerals");
        assertParseException("IL", "I cannot be subtracted from L, since I is not a power of one tenth or one fifth of L. This violates the subtraction Rule for Roman Numerals");
        assertParseException("XD", "X cannot be subtracted from D, since X is not a power of one tenth or one fifth of D. This violates the subtraction Rule for Roman Numerals");

    }
    @Test
    public void digitFollowingTheLargerDigitShouldBeSmallerThanTheDigitPrecedingLargerOne(){
        assertParseException("XCL", "X cannot be subtracted from C, since X is smaller than or equal to L. This violates the subtraction Rule for Roman Numerals");
        assertParseException("XCX", "X cannot be subtracted from C, since X is smaller than or equal to X. This violates the subtraction Rule for Roman Numerals");
    }
      private void assertParseException(final String romanDigits, final String expectedErrorMsg){
        try{
            romanNumeral(romanDigits);
            fail("Should have thrown an exception");
        } catch (NumberFormatException e){
            assertEquals(expectedErrorMsg, e.getMessage());
        }
      }
    private RomanNumeral romanNumeral(final String romanDigits){
        return RomanNumeral.parse(romanDigits);
    }
}
