package com.bilel.soleflow2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilel.soleflow2.models.RawMaterial;
import com.bilel.soleflow2.models.Supplier;
import com.bilel.soleflow2.repositories.SupplierRepository;
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;


	//create a supplier
	@Override
	public Supplier createSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	//update a supplier
	@Override
	public Supplier updateSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}


	//get a supplier
	@Override
	public Supplier getSupplier(Long id) {
		return supplierRepository.findById(id).get();
	}


	//delete a supplier
	@Override
	public void deleteSupplier(Long id) {
		supplierRepository.deleteById(id);
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}

	@Override
	public List<RawMaterial> getSupplierRawMaterials(Long id) {
		return supplierRepository.findById(id).get().getRawMaterials();
	}

	@Override
	public Supplier findByNameSupplier(String nameSupplier) {
		return supplierRepository.findByNameSupplier(nameSupplier);
	}

	@Override
	public List<Supplier> findByNameSupplierContains(String nameSupplier) {
		return supplierRepository.findByNameSupplierContains(nameSupplier);
	}

	@Override
	public Supplier findByEmailSupplier(String emailSupplier) {
		return supplierRepository.findByEmailSupplier(emailSupplier);
	}

	@Override
	public Supplier findByPhoneSupplier(String phoneSupplier) {
		return supplierRepository.findByPhoneSupplier(phoneSupplier);
	}

}
