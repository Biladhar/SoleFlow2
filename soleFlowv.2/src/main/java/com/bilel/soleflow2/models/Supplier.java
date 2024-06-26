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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "suppliers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSupplier;


    //location
    @NotNull(message = "Supplier name is required")
    private String nameSupplier;

    //email
    @NotNull(message = "Supplier email is required")
    @Email(message = "Supplier email is invalid")
    private String emailSupplier;

    //phone
    @NotNull(message = "Supplier phone is required")
    private String phoneSupplier;

    //Createdat and Updatedat
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAtSupplier;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAtSupplier;

    @PrePersist
    protected void onCreate() {
        this.createdAtSupplier = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAtSupplier = new Date();
    }


    //relationship with rawmaterial
    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    private List<RawMaterial> rawMaterials;







 

}
