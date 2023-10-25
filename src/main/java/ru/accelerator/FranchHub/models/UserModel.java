package ru.accelerator.FranchHub.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int owner_id;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String name;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String surname;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String second_name;
    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String email;
    @Column(nullable = false, columnDefinition = "VARCHAR(15)")
    private String phone_number;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String password;
}
