package com.jiotelecom.ex;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class FamilyDiscount {
    private final int lineThreshold;
    private final double rate;


    public FamilyDiscount(int LineThreshold, double rate) {
        this.lineThreshold = LineThreshold;
        this.rate = rate;
    }

    public double additionalNonQualifyingLines(int additionalLines) {
        return min(additionalLines, lineThreshold);
    }

    public double qualifyingCharge(int additionalLines) {
        return max(additionalLines - lineThreshold, 0) * rate;
    }
}
