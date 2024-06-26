package com.bilel.soleflow2;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bilel.soleflow2.models.RawMaterial;
import com.bilel.soleflow2.models.Supplier;
import com.bilel.soleflow2.models.Unit;
import com.bilel.soleflow2.repositories.RawMaterialRepository;
import com.bilel.soleflow2.repositories.SupplierRepository;
import com.bilel.soleflow2.repositories.UnitRepository;


@SpringBootTest
class ApplicationTests {

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private RawMaterialRepository rawMaterialRepository;
    
    @Autowired
    private SupplierRepository supplierRepository;


    //^ Unit
    @Test
    public void testCreateUnit() {
        Unit unit = new Unit("meter");
        unitRepository.save(unit);
        System.out.println(unit);
    }

    @Test
    public void testFindUnit() {
        Unit unit = unitRepository.findById(1L).get();
        System.out.println(unit);
    }

    @Test
    public void testUpdateUnit() {
        Unit unit = unitRepository.findById(1L).get();
        unit.setName("test2");
        unitRepository.save(unit);
        System.out.println(unit);
    }
    
    @Test
    public void testDeleteUnit() {
        unitRepository.deleteById(3L);
        
    }

    @Test
    public void testGetAllUnit() {
        List<Unit> units = unitRepository.findAll();
        for(Unit u: units) {
            System.out.println(u);
        }   
    }


    //^ RawMaterial
//    @Test
//    public void testCreateRawMaterial() {
//        Unit unit = unitRepository.findById(2L).get();
//        Supplier supplier = supplierRepository.findById(1L).get();
//        RawMaterial rawMaterial = new RawMaterial("Gomme Blanc", "Gomme Blanc ", 7.0, unit, supplier);
//        rawMaterialRepository.save(rawMaterial);
//    }

    @Test
    public void testFindRmByRef() {
        RawMaterial rm = rawMaterialRepository.findByReferenceRm("Test Raw Material");
        System.out.println(rm);
    }

    @Test
    public void testFindRmByRefContain() {
        List<RawMaterial> rms = rawMaterialRepository.findByReferenceRmContains("x");
        for(RawMaterial rm: rms) {
            System.out.println(rm);
        }
    }
    
    
    //! just for test
//    @Test
//    public void testFindRmByRefPrice() {
//        List<RawMaterial> rms = rawMaterialRepository.findByReferenceRmPriceRmV2("Test Raw Material", 5.0);
//        for(RawMaterial rm: rms) {
//            System.out.println(rm);
//        }
//    }

    //! Query with entity in parameter
    @Test
    public void testFindRmByUnit() {
        Unit unit = unitRepository.findById(2L).get();
        List<RawMaterial> rms = rawMaterialRepository.findByUnit(unit);
        for(RawMaterial rm: rms) {
            System.out.println(rm);
        }
    }



    // find by id of unit
    @Test
    public void testFindRmByUnitId() {
        List<RawMaterial> rms = rawMaterialRepository.findByUnitIdUnit(1L);
        for(RawMaterial rm: rms) {
            System.out.println(rm);
        }
    }

    // find by order by referenceRm asc
    @Test
    public void testFindRmByOrderAsc() {
        List<RawMaterial> rms = rawMaterialRepository.findByOrderByReferenceRmAsc();
        for(RawMaterial rm: rms) {
            System.out.println(rm);
        }
    } 

    // find by order by referenceRm asc and priceRm desc
    @Test
    public void testFindRmByOrderAscPriceDesc() {
        List<RawMaterial> rms = rawMaterialRepository.findByOrderByReferenceRmAscPriceRmDesc();
        for(RawMaterial rm: rms) {
            System.out.println(rm);
        }
    }
    
    
    

    

    
    


    
        

    
    
    
    

    
}
