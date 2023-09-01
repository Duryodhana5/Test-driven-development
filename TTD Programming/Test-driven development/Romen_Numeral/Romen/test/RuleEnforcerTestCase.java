package com.jio.roman.ex;

import com.jio.roman.ex.rules.RuleEnforcer;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

public abstract class RuleEnforcerTestCase {
    protected RuleEnforcer enforcer;

    protected List<RomanDigit> romanDigits(String romanValue){
        List<RomanDigit> digits = new ArrayList<>(romanValue.length());
        for (int i = 0; i < romanValue.length(); i++){
            digits.add(RomanDigit.parse(romanValue.charAt(i)));
        }
        return digits;
    }
    protected void assertRuleViolationException(String expectedExceptionMsg, String romanNumeral){
        try{
            enforcer.scan(romanDigits(romanNumeral));
            TestCase.fail("should have thrown an exception");
        } catch (NumberFormatException e){
            TestCase.assertEquals(expectedExceptionMsg, e.getMessage());
        }
    }
}
