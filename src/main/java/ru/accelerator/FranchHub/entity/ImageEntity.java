package ru.accelerator.FranchHub.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "images")
@Data
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*@Column(nullable = false, columnDefinition = "BIGINT")
    private Long size;
    @Column(nullable = false, columnDefinition = "VARCHAR")
    private String contentType;*/
    @Column(nullable = false, columnDefinition = "bytea")
    private byte[] imageData;
    /*@Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isPreviewImage;*/
    /*@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private FranchiseEntity franchise;*/
}
