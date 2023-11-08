package ru.accelerator.FranchHub.dto;

import lombok.Data;

@Data
public class FranchiseCreateDTO {
    private String title;
    private String juridicalInformation;
    private String innLink;
    private short yearOfCompanyOpening;
    private short franchiseStartYear;
    private short numberOfOwnPoints;
    private short numberOfFranchisePoints;
    private String cityHeadOffice;
    private int registeredTrademarkNumber;
    private String dateOfTrademarkRegistration;
    private String linkToTheFranchiseWebsite;
    private String investmentsFromAndTo;
    private String lumpSumPayment;
    private String royaltiesMonthlyDeductions;
    private String paybackPeriod;
    private String monthlyProfit;
    private short businessLaunchDeadline;
    private String geographyOfDevelopment;
    private String desiredPlacementSections;
    private String companyDescription;
    private String juicyDescriptionOfTheFranchise;
    private String whatIsIncludedInTheLumpSum;
    private String trainingAndSupport;
    private String roomRequirements;
    private String exampleOfProfitCalculation;
    private String mostImportantChoosingFactors;
    private String whatIsYourMainProduct;
    private String costsAtTheFranchiseLaunchStage;
    private String inWhichCitiesShouldIOpenAFranchise;
    private String advantagesOverCompetitors;
    private String requiredNumberOfEmployees;
}
