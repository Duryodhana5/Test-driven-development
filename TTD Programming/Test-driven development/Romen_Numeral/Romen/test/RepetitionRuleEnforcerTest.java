package com.jio.roman.ex;

import com.jio.roman.ex.rules.RepetitionRuleEnforcer;
import org.junit.Test;

public class RepetitionRuleEnforcerTest extends RuleEnforcerTestCase{
    public RepetitionRuleEnforcerTest() {enforcer = new RepetitionRuleEnforcer();}

    @Test
    public void powerOfTensCanRepeatUptoThreeTimes(){
        enforcer.scan(romanDigits("XXXVIII"));
        assertRuleViolationException("X cannot repeat more than thrice, this violates the Repetition Rule for Roman Numerals", "XXXX");
        assertRuleViolationException("I cannot repeat more than thrice, this violates the Repetition Rule for Roman Numerals", "IIIIX");
    }

    @Test
    public void powerOfFiveCannotRepeat(){
        assertRuleViolationException("V cannot repeat itself, this violates the Repetition Rule for Roman Numerals", "XVV");
        assertRuleViolationException("V cannot repeat itself, this violates the Repetition Rule for Roman Numerals", "VV");
        assertRuleViolationException("L cannot repeat itself, this violates the Repetition Rule for Roman Numerals", "XLL");
        assertRuleViolationException("D cannot repeat itself, this violates the Repetition Rule for Roman Numerals", "DD");
    }
}
