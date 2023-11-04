package ru.accelerator.FranchHub.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FranchiseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int franchise_id;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String title;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String short_desc;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String min_coast;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;
}
