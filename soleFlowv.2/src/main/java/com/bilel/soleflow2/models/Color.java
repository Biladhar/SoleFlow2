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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "colors")
public class Color {

    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColor;

    //nameColor
    @NotNull(message = "Color name is required")
    private String nameColor;

    //createdat and updatedat
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAtColor;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAtColor;

    @PrePersist
    protected void onCreate() {
        this.createdAtColor = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAtColor = new Date();
    }

    //^ Relationships
    @OneToMany(mappedBy = "color")
    @JsonIgnore
    private List<RawMaterial> rawMaterials;

}
