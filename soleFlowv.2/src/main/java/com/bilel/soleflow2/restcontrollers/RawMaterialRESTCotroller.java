package com.bilel.soleflow2.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bilel.soleflow2.dto.RawMaterialDTO;
import com.bilel.soleflow2.models.RawMaterial;
import com.bilel.soleflow2.services.RawMaterialService;


@RestController
@RequestMapping("/api/rawmaterials")
@CrossOrigin
public class RawMaterialRESTCotroller {


    @Autowired
    RawMaterialService rawMaterialService;

    //All RawMaterials
    @GetMapping("/all")
    public List<RawMaterialDTO> getAllRawMaterials(){
        return rawMaterialService.getAllRawMaterials();
    }

    // One RawMaterial by Id
    @GetMapping("/{id}")
    public RawMaterialDTO getRawMaterial(@PathVariable("id") Long id){
        return rawMaterialService.getRawMaterial(id);
    }

    // Create RawMaterial
    @PostMapping("/save")
    public RawMaterialDTO saveRawMaterial(@RequestBody RawMaterialDTO rmDTO){
        RawMaterial rm = rawMaterialService.convertDtoToEntity(rmDTO);
        rm.setStockRm(0);
        rm.setAmountRm(0.0);
        RawMaterialDTO rmDTO2 = rawMaterialService.convertEntityToDto(rm);
        return rawMaterialService.saveRawMaterial(rmDTO2);
    }

    // Update RawMaterial
    @PutMapping("/update")
    public RawMaterialDTO updateRawMaterial(@RequestBody RawMaterialDTO rmDTO){
        return rawMaterialService.updateRawMaterial(rmDTO);
    }

    // Delete RawMaterial
    @DeleteMapping("/delete/{id}")
    public void deleteRawMaterial(@PathVariable("id") Long id){
        rawMaterialService.deleteRawMaterialById(id);
    }

    // All RawMaterials with idUnit
    @GetMapping("/unit/{id}")
    public List<RawMaterial> getRawMaterialsByUnit(@PathVariable("id") Long id){
        return rawMaterialService.findByUnitIdUnit(id);
    }













}
