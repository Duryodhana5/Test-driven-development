package com.jio.roman.ex.rules;

import com.jio.roman.ex.RomanDigit;

import java.util.List;

public interface RuleEnforcer {

    void scan (List<RomanDigit> digits);
}
