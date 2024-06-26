package com.bilel.soleflow2.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    //OrderQuantity
    @NotNull(message = "Order quantity is required")
    private int orderQuantity;

    //OrdrerAmount
    private Double orderAmount;

    //status
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    public enum OrderStatus {
        PENDING,
        SHIPPED, 
        DELIVERED
    }

    //createdat and updatedat
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAtOrder;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAtOrder;

    @PrePersist
    protected void onCreate() {
        this.createdAtOrder = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAtOrder = new Date();
    }

    //Relationship with RawMaterial
    @ManyToOne
    private RawMaterial rawMaterial;


        

    
    

}
