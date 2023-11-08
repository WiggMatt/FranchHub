package ru.accelerator.FranchHub.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "franchises")
@Data
public class FranchiseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int franchise_id;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String title;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String juridicalInformation;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String innLink;
    @Column(nullable = false, columnDefinition = "SMALLINT")
    private short yearOfCompanyOpening;
    @Column(nullable = false, columnDefinition = "SMALLINT")
    private short franchiseStartYear;
    @Column(nullable = false, columnDefinition = "SMALLINT")
    private short numberOfOwnPoints;
    @Column(nullable = false, columnDefinition = "SMALLINT")
    private short numberOfFranchisePoints;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String cityHeadOffice;
    @Column(nullable = false, columnDefinition = "INTEGER")
    private int registeredTrademarkNumber;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String dateOfTrademarkRegistration;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String linkToTheFranchiseWebsite;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String investmentsFromAndTo;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String lumpSumPayment;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String royaltiesMonthlyDeductions;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String paybackPeriod;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String monthlyProfit;
    @Column(nullable = false, columnDefinition = "SMALLINT")
    private short businessLaunchDeadline;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String geographyOfDevelopment;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String desiredPlacementSections;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String companyDescription;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String juicyDescriptionOfTheFranchise;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String whatIsIncludedInTheLumpSum;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String trainingAndSupport;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String roomRequirements;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String exampleOfProfitCalculation;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String mostImportantChoosingFactors;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String whatIsYourMainProduct;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String costsAtTheFranchiseLaunchStage;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String inWhichCitiesShouldIOpenAFranchise;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String advantagesOverCompetitors;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String requiredNumberOfEmployees;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "franchise")
    private List<ImageEntity> images = new ArrayList<>();
    //TODO: Возможно, стоит сделать FK на таблицу с изображениями
    @Column(columnDefinition = "INTEGER")
    private int previewImageId;
}
