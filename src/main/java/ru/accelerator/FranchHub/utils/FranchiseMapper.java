package ru.accelerator.FranchHub.utils;

import org.springframework.stereotype.Component;
import ru.accelerator.FranchHub.dto.FranchiseCreateDTO;
import ru.accelerator.FranchHub.dto.FranchiseDetailDTO;
import ru.accelerator.FranchHub.dto.FranchiseHomeScreenDTO;
import ru.accelerator.FranchHub.entity.FranchiseEntity;

//TODO: Подумать над повторением кода в этом классе
@Component
public class FranchiseMapper {
    public static FranchiseCreateDTO toCreateDTO(FranchiseEntity franchiseEntity) {
        FranchiseCreateDTO franchiseCreateDTO = new FranchiseCreateDTO();
        franchiseCreateDTO.setTitle(franchiseEntity.getTitle());
        franchiseCreateDTO.setJuridicalInformation(franchiseEntity.getJuridicalInformation());
        franchiseCreateDTO.setInnLink(franchiseEntity.getInnLink());
        franchiseCreateDTO.setYearOfCompanyOpening(franchiseEntity.getYearOfCompanyOpening());
        franchiseCreateDTO.setFranchiseStartYear(franchiseEntity.getFranchiseStartYear());
        franchiseCreateDTO.setNumberOfOwnPoints(franchiseEntity.getNumberOfOwnPoints());
        franchiseCreateDTO.setNumberOfFranchisePoints(franchiseEntity.getNumberOfFranchisePoints());
        franchiseCreateDTO.setCityHeadOffice(franchiseEntity.getCityHeadOffice());
        franchiseCreateDTO.setRegisteredTrademarkNumber(franchiseEntity.getRegisteredTrademarkNumber());
        franchiseCreateDTO.setDateOfTrademarkRegistration(franchiseEntity.getDateOfTrademarkRegistration());
        franchiseCreateDTO.setLinkToTheFranchiseWebsite(franchiseEntity.getLinkToTheFranchiseWebsite());
        franchiseCreateDTO.setInvestmentsFromAndTo(franchiseEntity.getInvestmentsFromAndTo());
        franchiseCreateDTO.setLumpSumPayment(franchiseEntity.getLumpSumPayment());
        franchiseCreateDTO.setRoyaltiesMonthlyDeductions(franchiseEntity.getRoyaltiesMonthlyDeductions());
        franchiseCreateDTO.setPaybackPeriod(franchiseEntity.getPaybackPeriod());
        franchiseCreateDTO.setMonthlyProfit(franchiseEntity.getMonthlyProfit());
        franchiseCreateDTO.setBusinessLaunchDeadline(franchiseEntity.getBusinessLaunchDeadline());
        franchiseCreateDTO.setGeographyOfDevelopment(franchiseEntity.getGeographyOfDevelopment());
        franchiseCreateDTO.setDesiredPlacementSections(franchiseEntity.getDesiredPlacementSections());
        franchiseCreateDTO.setCompanyDescription(franchiseEntity.getCompanyDescription());
        franchiseCreateDTO.setJuicyDescriptionOfTheFranchise(franchiseEntity.getJuicyDescriptionOfTheFranchise());
        franchiseCreateDTO.setWhatIsIncludedInTheLumpSum(franchiseEntity.getWhatIsIncludedInTheLumpSum());
        franchiseCreateDTO.setTrainingAndSupport(franchiseEntity.getTrainingAndSupport());
        franchiseCreateDTO.setRoomRequirements(franchiseEntity.getRoomRequirements());
        franchiseCreateDTO.setExampleOfProfitCalculation(franchiseEntity.getExampleOfProfitCalculation());
        franchiseCreateDTO.setMostImportantChoosingFactors(franchiseEntity.getMostImportantChoosingFactors());
        franchiseCreateDTO.setWhatIsYourMainProduct(franchiseEntity.getWhatIsYourMainProduct());
        franchiseCreateDTO.setCostsAtTheFranchiseLaunchStage(franchiseEntity.getCostsAtTheFranchiseLaunchStage());
        franchiseCreateDTO.setInWhichCitiesShouldIOpenAFranchise(franchiseEntity.getInWhichCitiesShouldIOpenAFranchise());
        franchiseCreateDTO.setAdvantagesOverCompetitors(franchiseEntity.getAdvantagesOverCompetitors());
        franchiseCreateDTO.setRequiredNumberOfEmployees(franchiseEntity.getRequiredNumberOfEmployees());
        return franchiseCreateDTO;
    }

    public static FranchiseEntity toCreateEntity(FranchiseCreateDTO franchiseCreateDTO) {
        FranchiseEntity franchiseEntity = new FranchiseEntity();
        franchiseEntity.setTitle(franchiseCreateDTO.getTitle());
        franchiseEntity.setJuridicalInformation(franchiseCreateDTO.getJuridicalInformation());
        franchiseEntity.setInnLink(franchiseCreateDTO.getInnLink());
        franchiseEntity.setYearOfCompanyOpening(franchiseCreateDTO.getYearOfCompanyOpening());
        franchiseEntity.setFranchiseStartYear(franchiseCreateDTO.getFranchiseStartYear());
        franchiseEntity.setNumberOfOwnPoints(franchiseCreateDTO.getNumberOfOwnPoints());
        franchiseEntity.setNumberOfFranchisePoints(franchiseCreateDTO.getNumberOfFranchisePoints());
        franchiseEntity.setCityHeadOffice(franchiseCreateDTO.getCityHeadOffice());
        franchiseEntity.setRegisteredTrademarkNumber(franchiseCreateDTO.getRegisteredTrademarkNumber());
        franchiseEntity.setDateOfTrademarkRegistration(franchiseCreateDTO.getDateOfTrademarkRegistration());
        franchiseEntity.setLinkToTheFranchiseWebsite(franchiseCreateDTO.getLinkToTheFranchiseWebsite());
        franchiseEntity.setInvestmentsFromAndTo(franchiseCreateDTO.getInvestmentsFromAndTo());
        franchiseEntity.setLumpSumPayment(franchiseCreateDTO.getLumpSumPayment());
        franchiseEntity.setRoyaltiesMonthlyDeductions(franchiseCreateDTO.getRoyaltiesMonthlyDeductions());
        franchiseEntity.setPaybackPeriod(franchiseCreateDTO.getPaybackPeriod());
        franchiseEntity.setMonthlyProfit(franchiseCreateDTO.getMonthlyProfit());
        franchiseEntity.setBusinessLaunchDeadline(franchiseCreateDTO.getBusinessLaunchDeadline());
        franchiseEntity.setGeographyOfDevelopment(franchiseCreateDTO.getGeographyOfDevelopment());
        franchiseEntity.setDesiredPlacementSections(franchiseCreateDTO.getDesiredPlacementSections());
        franchiseEntity.setCompanyDescription(franchiseCreateDTO.getCompanyDescription());
        franchiseEntity.setJuicyDescriptionOfTheFranchise(franchiseCreateDTO.getJuicyDescriptionOfTheFranchise());
        franchiseEntity.setWhatIsIncludedInTheLumpSum(franchiseCreateDTO.getWhatIsIncludedInTheLumpSum());
        franchiseEntity.setTrainingAndSupport(franchiseCreateDTO.getTrainingAndSupport());
        franchiseEntity.setRoomRequirements(franchiseCreateDTO.getRoomRequirements());
        franchiseEntity.setExampleOfProfitCalculation(franchiseCreateDTO.getExampleOfProfitCalculation());
        franchiseEntity.setMostImportantChoosingFactors(franchiseCreateDTO.getMostImportantChoosingFactors());
        franchiseEntity.setWhatIsYourMainProduct(franchiseCreateDTO.getWhatIsYourMainProduct());
        franchiseEntity.setCostsAtTheFranchiseLaunchStage(franchiseCreateDTO.getCostsAtTheFranchiseLaunchStage());
        franchiseEntity.setInWhichCitiesShouldIOpenAFranchise(franchiseCreateDTO.getInWhichCitiesShouldIOpenAFranchise());
        franchiseEntity.setAdvantagesOverCompetitors(franchiseCreateDTO.getAdvantagesOverCompetitors());
        franchiseEntity.setRequiredNumberOfEmployees(franchiseCreateDTO.getRequiredNumberOfEmployees());
        return franchiseEntity;
    }

    public static FranchiseHomeScreenDTO toHomeScreenDTO(FranchiseEntity franchiseEntity) {
        FranchiseHomeScreenDTO franchiseHomeScreenDTO = new FranchiseHomeScreenDTO();
        franchiseHomeScreenDTO.setTitle(franchiseEntity.getTitle());
        franchiseHomeScreenDTO.setInvestmentsFromAndTo(franchiseEntity.getInvestmentsFromAndTo());
        return franchiseHomeScreenDTO;
    }

    public static FranchiseDetailDTO toDetailDTO(FranchiseEntity franchiseEntity) {
        FranchiseDetailDTO franchiseDetailDTO = new FranchiseDetailDTO();
        franchiseDetailDTO.setTitle(franchiseEntity.getTitle());
        franchiseDetailDTO.setJuridicalInformation(franchiseEntity.getJuridicalInformation());
        franchiseDetailDTO.setInnLink(franchiseEntity.getInnLink());
        franchiseDetailDTO.setYearOfCompanyOpening(franchiseEntity.getYearOfCompanyOpening());
        franchiseDetailDTO.setFranchiseStartYear(franchiseEntity.getFranchiseStartYear());
        franchiseDetailDTO.setNumberOfOwnPoints(franchiseEntity.getNumberOfOwnPoints());
        franchiseDetailDTO.setNumberOfFranchisePoints(franchiseEntity.getNumberOfFranchisePoints());
        franchiseDetailDTO.setCityHeadOffice(franchiseEntity.getCityHeadOffice());
        franchiseDetailDTO.setRegisteredTrademarkNumber(franchiseEntity.getRegisteredTrademarkNumber());
        franchiseDetailDTO.setDateOfTrademarkRegistration(franchiseEntity.getDateOfTrademarkRegistration());
        franchiseDetailDTO.setLinkToTheFranchiseWebsite(franchiseEntity.getLinkToTheFranchiseWebsite());
        franchiseDetailDTO.setInvestmentsFromAndTo(franchiseEntity.getInvestmentsFromAndTo());
        franchiseDetailDTO.setLumpSumPayment(franchiseEntity.getLumpSumPayment());
        franchiseDetailDTO.setRoyaltiesMonthlyDeductions(franchiseEntity.getRoyaltiesMonthlyDeductions());
        franchiseDetailDTO.setPaybackPeriod(franchiseEntity.getPaybackPeriod());
        franchiseDetailDTO.setMonthlyProfit(franchiseEntity.getMonthlyProfit());
        franchiseDetailDTO.setBusinessLaunchDeadline(franchiseEntity.getBusinessLaunchDeadline());
        franchiseDetailDTO.setGeographyOfDevelopment(franchiseEntity.getGeographyOfDevelopment());
        franchiseDetailDTO.setDesiredPlacementSections(franchiseEntity.getDesiredPlacementSections());
        franchiseDetailDTO.setCompanyDescription(franchiseEntity.getCompanyDescription());
        franchiseDetailDTO.setJuicyDescriptionOfTheFranchise(franchiseEntity.getJuicyDescriptionOfTheFranchise());
        franchiseDetailDTO.setWhatIsIncludedInTheLumpSum(franchiseEntity.getWhatIsIncludedInTheLumpSum());
        franchiseDetailDTO.setTrainingAndSupport(franchiseEntity.getTrainingAndSupport());
        franchiseDetailDTO.setRoomRequirements(franchiseEntity.getRoomRequirements());
        franchiseDetailDTO.setExampleOfProfitCalculation(franchiseEntity.getExampleOfProfitCalculation());
        franchiseDetailDTO.setMostImportantChoosingFactors(franchiseEntity.getMostImportantChoosingFactors());
        franchiseDetailDTO.setWhatIsYourMainProduct(franchiseEntity.getWhatIsYourMainProduct());
        franchiseDetailDTO.setCostsAtTheFranchiseLaunchStage(franchiseEntity.getCostsAtTheFranchiseLaunchStage());
        franchiseDetailDTO.setInWhichCitiesShouldIOpenAFranchise(franchiseEntity.getInWhichCitiesShouldIOpenAFranchise());
        franchiseDetailDTO.setAdvantagesOverCompetitors(franchiseEntity.getAdvantagesOverCompetitors());
        franchiseDetailDTO.setRequiredNumberOfEmployees(franchiseEntity.getRequiredNumberOfEmployees());

        franchiseDetailDTO.setCategory_id(franchiseEntity.getCategory_id());
        franchiseDetailDTO.setImages(franchiseEntity.getImages());
        return franchiseDetailDTO;
    }
}
