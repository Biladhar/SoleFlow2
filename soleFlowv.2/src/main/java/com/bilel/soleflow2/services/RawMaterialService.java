package com.bilel.soleflow2.services;

import java.util.List;

import com.bilel.soleflow2.dto.RawMaterialDTO;
import com.bilel.soleflow2.models.RawMaterial;
import com.bilel.soleflow2.models.Unit;

public interface RawMaterialService {

    
    
    RawMaterialDTO saveRawMaterial(RawMaterialDTO rm);
    RawMaterialDTO getRawMaterial(Long id);
    List<RawMaterialDTO> getAllRawMaterials();
    
    
    RawMaterialDTO updateRawMaterial(RawMaterialDTO rm);
    void deleteRawMaterial(RawMaterial rm);
    void deleteRawMaterialById(Long id);
    
    
    RawMaterial findByReferenceRm(String referenceRm);
    List<RawMaterial> findByReferenceRmContains(String referenceRm);
    List<RawMaterial> findByReferenceRmPriceRm(String ref, Double prix);
    List<RawMaterial> findByUnit(Unit unit);
    List<RawMaterial> findByUnitIdUnit(Long id);
    List<RawMaterial> findByOrderByReferenceRmAsc();
    List<RawMaterial> findByOrderByReferenceRmAscPriceRmDesc();

    RawMaterialDTO convertEntityToDto(RawMaterial rm);
    RawMaterial convertDtoToEntity(RawMaterialDTO rmDTO);



}
