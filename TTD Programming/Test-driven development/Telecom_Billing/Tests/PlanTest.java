package com.jiotelecom.ex;

import org.junit.Test;
public class PlanTest {

    private final double goldPlanBasicMonthlyRate = 49.95;
    private final double goldPlanExtraMInCharge = 0.45;
    private final int goldPlanMinsInclude = 1000;
    private final double goldAdditionalLinesRate = 14.5;
    private final int familyDiscountLineThreshold = 2;
    private double familyDiscountRate = 5;
    private final FamilyDiscount discount = new FamilyDiscount(familyDiscountLineThreshold, familyDiscountRate);
    private final Plan goldPlan = new Plan(goldPlanBasicMonthlyRate, goldPlanMinsInclude, goldPlanExtraMInCharge, goldAdditionalLinesRate, discount);
    private final Context lets = new Context();

    @Test
    public void customerShouldBeChargedForMonthlyFixedAmount() {
        lets.verify(goldPlan).isCharged(goldPlanBasicMonthlyRate);

    }

    @Test
    public void customerShouldBeChargedForExtraMinsUsed() {
        lets.verify(goldPlan).withMinsUsed(goldPlanMinsInclude + 1).isCharged(goldPlanBasicMonthlyRate + goldPlanExtraMInCharge);
    }

    @Test
    public void customerShouldBeChargedForAdditionalLines() {
        int additionalLines = 2;
        lets.verify(goldPlan).withAdditionalLines(additionalLines).isCharged(goldPlanBasicMonthlyRate + additionalLines * goldAdditionalLinesRate);
    }

    @Test
    public void customersCanAvailFamilyDiscount() {
        int additionalLines = 4;
        int linesQualifyingForFamilyDiscount = additionalLines - familyDiscountLineThreshold;
        lets.verify(goldPlan).withAdditionalLines(additionalLines).isCharged(goldPlanBasicMonthlyRate + linesQualifyingForFamilyDiscount * goldAdditionalLinesRate + (additionalLines - linesQualifyingForFamilyDiscount) * familyDiscountRate);
    }
}

