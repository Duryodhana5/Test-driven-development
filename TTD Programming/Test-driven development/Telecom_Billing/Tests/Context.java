package com.jiotelecom.ex;

import static junit.framework.TestCase.assertEquals;

public class Context {
    private Plan goldPlan;
    private int minsUsed;
    private int additionalLines;

    public Context verify(Plan goldPlan) {
        this.goldPlan = goldPlan;
        return this;
    }

    public Context withMinsUsed(int minsUsed) {
        this.minsUsed = minsUsed;
        return this;
    }

    public void isCharged(double expectedBillAmout) {
        assertEquals(expectedBillAmout, goldPlan.CalculateBill(minsUsed, additionalLines));
    }

    public Context withAdditionalLines(int additionalLines) {
        this.additionalLines = additionalLines;
        return this;
    }
}
