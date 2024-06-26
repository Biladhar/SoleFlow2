package com.bilel.soleflow2.services;

import java.util.List;

import com.bilel.soleflow2.models.RawMaterial;
import com.bilel.soleflow2.models.Supplier;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier);
    Supplier updateSupplier(Supplier supplier);
    Supplier getSupplier(Long id);
    void deleteSupplier(Long id);
    List<Supplier> getAllSuppliers();
    List<RawMaterial> getSupplierRawMaterials(Long id);
    Supplier findByNameSupplier(String nameSupplier);
    List<Supplier> findByNameSupplierContains(String nameSupplier);
    Supplier findByEmailSupplier(String emailSupplier);
    Supplier findByPhoneSupplier(String phoneSupplier);
}
