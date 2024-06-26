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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RawMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRm;

    
    private String referenceRm;
    private String descriptionRm;
    private int stockRm;
    private Double amountRm;
    private Double priceRm;


    //!Relationships
    //^ unit
    @ManyToOne
    private Unit unit;

    //^ Order
    @OneToMany(mappedBy = "rawMaterial")
    @JsonIgnore
    private List<Order> orders;

    //^ Supplier
    @ManyToOne
    private Supplier supplier;

    //^ Category
    @ManyToOne
    private Category category;

    //^ Color
    @ManyToOne
    private Color color;

        
    //Createdat and Updatedat
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAtRm;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAtRm;

    @PrePersist
    protected void onCreate() {
        this.createdAtRm = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAtRm = new Date();
    }
    

    //Constructors
    // create a constructor for Raw material where the stockRm is by default 0 , and the amountRm is stockRm * priceRm
//    public RawMaterial(String referenceRm, String descriptionRm, Double priceRm, Unit unit,Supplier supplier) {
//        this.referenceRm = referenceRm;
//        this.descriptionRm = descriptionRm;
//        this.priceRm = priceRm;
//        this.stockRm = 0;
//        this.amountRm = this.stockRm * this.priceRm;
//        this.unit = unit;
//        this.supplier = supplier;}
        
    
    
    
    

  
    
    
    
    
}
