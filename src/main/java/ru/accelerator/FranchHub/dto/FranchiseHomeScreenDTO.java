package ru.accelerator.FranchHub.dto;

import lombok.Data;

@Data
public class FranchiseHomeScreenDTO {
    private int franchise_id;
    private String title;
    private String investmentsFromAndTo;
    private String shortDescription;
    private String photoName;
}
