package ru.accelerator.FranchHub.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "franchises")
@Data
public class FranchiseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int franchise_id;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String shortDescription;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String juridicalInformation;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String innLink;
    @Column(nullable = false, columnDefinition = "SMALLINT")
    private short yearOfCompanyOpening;
    @Column(nullable = false, columnDefinition = "SMALLINT")
    private short franchiseStartYear;
    @Column(nullable = false, columnDefinition = "SMALLINT")
    private short numberOfOwnPoints;
    @Column(nullable = false, columnDefinition = "SMALLINT")
    private short numberOfFranchisePoints;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String cityHeadOffice;
    @Column(nullable = false, columnDefinition = "INTEGER")
    private int registeredTrademarkNumber;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String dateOfTrademarkRegistration;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String linkToTheFranchiseWebsite;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String investmentsFromAndTo;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String lumpSumPayment;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String royaltiesMonthlyDeductions;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String paybackPeriod;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String monthlyProfit;
    @Column(nullable = false, columnDefinition = "SMALLINT")
    private short businessLaunchDeadline;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String geographyOfDevelopment;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String desiredPlacementSections;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String companyDescription;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String juicyDescriptionOfTheFranchise;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String whatIsIncludedInTheLumpSum;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String trainingAndSupport;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String roomRequirements;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String exampleOfProfitCalculation;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String mostImportantChoosingFactors;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String whatIsYourMainProduct;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String costsAtTheFranchiseLaunchStage;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String inWhichCitiesShouldIOpenAFranchise;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String advantagesOverCompetitors;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String requiredNumberOfEmployees;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;
}
