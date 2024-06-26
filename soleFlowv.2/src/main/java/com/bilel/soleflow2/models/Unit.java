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
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "units")
public class Unit {
    
    // Attributes
    // Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnit;

    // Name
    @NotEmpty (message = "Name is required")
    private String name;

    // Createdat and Updatedat
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }


    @OneToMany(mappedBy = "unit")
    @JsonIgnore
    private List<RawMaterial> rawMaterials;

 


    
    // toString
    @Override
    public String toString() {
        return "Unit [id=" + idUnit + ", name=" + name + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }
    
    // Constructor
    public Unit(String name) {
        this.name = name;
    }
    
    
    
    
    
    
}
