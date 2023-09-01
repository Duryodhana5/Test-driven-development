package com.jio.roman.ex;

import com.jio.roman.ex.rules.SubtractionRuleEnforcer;
import org.junit.Test;

public class SubtractionRuleEnforcerTest extends RuleEnforcerTestCase{

    public SubtractionRuleEnforcerTest() {enforcer = new SubtractionRuleEnforcer();}

    @Test
    public void onlyPowerOfTensPreceedHigherValueDigit(){
        enforcer.scan((romanDigits("XCVIII")));
        enforcer.scan((romanDigits("CMXLVI")));
        assertRuleViolationException("V cannot be subtracted from X, since V is not a power of ten. This violates the subtraction Rule for Roman Numerals", "VX");
        assertRuleViolationException("L cannot be subtracted from C, since L is not a power of ten. This violates the subtraction Rule for Roman Numerals", "LCXIII");
    }

    @Test
    public void preceedingDigitMustBeOneTenthOrOneFifthOfFollowingHigherValueDigit(){
        enforcer.scan(romanDigits("IX"));
        enforcer.scan(romanDigits("IV"));
        enforcer.scan(romanDigits("XL"));
        enforcer.scan(romanDigits("XC"));
        enforcer.scan(romanDigits("CM"));
        enforcer.scan(romanDigits("CD"));
        assertRuleViolationException("I cannot be subtracted from L, since I is not a power of one tenth or one fifth of L. This violates the subtraction Rule for Roman Numerals", "IL");
        assertRuleViolationException("I cannot be subtracted from C, since I is not a power of one tenth or one fifth of C. This violates the subtraction Rule for Roman Numerals", "IC");
        assertRuleViolationException("X cannot be subtracted from D, since X is not a power of one tenth or one fifth of D. This violates the subtraction Rule for Roman Numerals", "XD");
        assertRuleViolationException("X cannot be subtracted from M, since X is not a power of one tenth or one fifth of M. This violates the subtraction Rule for Roman Numerals", "XM");
    }

    @Test
    public void preceedingDigitMustBeLargerThanDigitFollowHigherValueDigit(){
        enforcer.scan(romanDigits("XLV"));
        assertRuleViolationException("X cannot be subtracted from L, since X is smaller than or equal to X. This violates the subtraction Rule for Roman Numerals", "XLX");
        enforcer.scan(romanDigits("XCI"));
        assertRuleViolationException("X cannot be subtracted from C, since X is smaller than or equal to L. This violates the subtraction Rule for Roman Numerals", "XCL");
    }

    @Test
    public void onlyOneLowerValueDigitCanPreceedHigherValueDigit() {
        enforcer.scan(romanDigits("IX"));
        assertRuleViolationException("II cannot be subtracted from X, this violates the subtraction Rule for Roman Numerals", "IIX");
        enforcer.scan(romanDigits("XL"));
        assertRuleViolationException("XX cannot be subtracted from L, this violates the subtraction Rule for Roman Numerals", "XXL");
        enforcer.scan(romanDigits("CM"));
        assertRuleViolationException("CC cannot be subtracted from M, this violates the subtraction Rule for Roman Numerals", "CCM");
    }
}
