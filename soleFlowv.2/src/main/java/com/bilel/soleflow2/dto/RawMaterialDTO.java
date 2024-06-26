package com.bilel.soleflow2.dto;

import com.bilel.soleflow2.models.Category;
import com.bilel.soleflow2.models.Color;
import com.bilel.soleflow2.models.Supplier;
import com.bilel.soleflow2.models.Unit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RawMaterialDTO {

    private Long idRm;
    private String referenceRm;
    private String descriptionRm;
    private Double priceRm;
    private int stockRm;
    private Double amountRm;
    private Unit unit;
    private Supplier supplier;
    private Category category;
    private Color color;
    //name of unit from 
//    private String name;

}
