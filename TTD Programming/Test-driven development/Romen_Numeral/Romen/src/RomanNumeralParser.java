package com.jio.roman.ex;

import com.jio.roman.ex.rules.RepetitionRuleEnforcer;
import com.jio.roman.ex.rules.RuleEnforcer;
import com.jio.roman.ex.rules.SubtractionRuleEnforcer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RomanNumeralParser {
    private final Set<RuleEnforcer> enforcers = new HashSet<>(){
        {
            add(new RepetitionRuleEnforcer());
            add(new SubtractionRuleEnforcer());
        }
    };
    RomanNumeral compose(String romanDigits){
        validateInput(romanDigits);
        String cleanRomanDigits = removeAllWhiteSpace(romanDigits);
        List<RomanDigit> validDigits = validateDigits(cleanRomanDigits);
        enforcers.forEach(enforcer -> enforcer.scan(validDigits));
        return new RomanNumeral(validDigits);
    }
    private List<RomanDigit> validateDigits(String romanDigits){
        List<RomanDigit> validDigits = new ArrayList<>(romanDigits.length());
        for (int i = 0; i < romanDigits.length(); i++){
            validDigits.add(RomanDigit.parse(romanDigits.charAt(i)));
        }
        return validDigits;
    }
    private String removeAllWhiteSpace(String romanDigits){
        return romanDigits.replaceAll("\\s", "");
    }
    private void validateInput(String romanDigits){
        if (romanDigits == null)
            throw new NumberFormatException("null is not a valid Roman Numeral");
        if (romanDigits.trim().length() == 0)
            throw new NumberFormatException("Empty String is not a valid Roman Numeral");
    }


}