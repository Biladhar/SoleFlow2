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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "color_article")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColorArticle {

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColorArticle;

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

    //! relationships

}
