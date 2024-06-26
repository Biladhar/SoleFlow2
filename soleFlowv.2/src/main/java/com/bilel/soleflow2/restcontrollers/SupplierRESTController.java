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

import com.bilel.soleflow2.models.Supplier;
import com.bilel.soleflow2.services.SupplierService;



@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin
public class SupplierRESTController {
	
    @Autowired
    private SupplierService supplierService;
    
   
    //get all suppliers
    @GetMapping("/all")
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }
        		
    //create a supplier
    @PostMapping("/create")
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierService.createSupplier(supplier);
    }

    //get a supplier by id
    @GetMapping("/get/{id}")
    public Supplier getSupplier(@PathVariable("id") Long id) {
        return supplierService.getSupplier(id);
    }

    //Update a supplier
    @PutMapping("/update")
    public Supplier updateSupplier(@RequestBody Supplier supplier) {
        return supplierService.updateSupplier(supplier);
    }

    //delete a supplier
    @DeleteMapping("/delete/{id}")
    public void deleteSupplier(@PathVariable("id") Long id) {
        supplierService.deleteSupplier(id);
    }
    
	
    

}
