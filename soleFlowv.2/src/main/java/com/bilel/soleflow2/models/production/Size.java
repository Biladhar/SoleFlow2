package com.bilel.soleflow2.models.production;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "size")
@NoArgsConstructor
@AllArgsConstructor
public class Size {

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSize;

    //numberSize
    @NotNull
    private String numberSize;

    // createdat and updatedat
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAtSize;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAtSize;

    @PrePersist
    protected void onCreate() {
        this.createdAtSize = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAtSize = new Date();
    }

    //relationships

}
