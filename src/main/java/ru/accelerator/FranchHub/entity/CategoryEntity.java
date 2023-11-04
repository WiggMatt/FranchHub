package ru.accelerator.FranchHub.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String title;
}
