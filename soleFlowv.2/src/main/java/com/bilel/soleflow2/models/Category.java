package com.bilel.soleflow2.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    //CategoryName
    @NotNull(message = "Category name is required")
    private String nameCategory;

    //createdat and updatedat
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAtCategory;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAtCategory;

    @PrePersist
    protected void onCreate() {
        this.createdAtCategory = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAtCategory = new Date();
    }

    //^ Relationships
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<RawMaterial> rawMaterials;
    

}
