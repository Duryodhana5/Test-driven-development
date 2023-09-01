package com.jiotelecom.ex;

import static java.lang.Math.max;

public class Plan {
    private final double basicMonthlyRate;
    private final int minsIncluded;
    private final double extraMInCharge;
    private final double additionalLineRate;
    private final FamilyDiscount discount;

    public Plan(double basicMonthlyRate, int minIncluded, double extraMInCharge, double additionalLineRate, FamilyDiscount discount) {
        this.basicMonthlyRate = basicMonthlyRate;
        this.minsIncluded = minIncluded;
        this.extraMInCharge = extraMInCharge;
        this.additionalLineRate = additionalLineRate;
        this.discount = discount;
    }

    public double CalculateBill(int minsUsed, int additionalLines) {
        return basicMonthlyRate + chargedForExtraMins(minsUsed) + additionalLineCharge(additionalLines);
    }

    private double additionalLineCharge(int additionalLines) {
        double standardAdditionalLineCharge = discount.additionalNonQualifyingLines(additionalLines) * additionalLineRate;
        double familyDiscountAdditionalLineCharge = discount.qualifyingCharge(additionalLines);
        return standardAdditionalLineCharge + familyDiscountAdditionalLineCharge;
    }

    private double chargedForExtraMins(int minsUsed) {
        return max(minsUsed - minsIncluded, 0) * extraMInCharge;

    }
}