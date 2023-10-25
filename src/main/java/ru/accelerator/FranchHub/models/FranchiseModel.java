package ru.accelerator.FranchHub.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FranchiseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int franchise_id;
    private String title;
    private String short_desc;
    private String min_coast;
    private String category_id;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserModel owner;
}
