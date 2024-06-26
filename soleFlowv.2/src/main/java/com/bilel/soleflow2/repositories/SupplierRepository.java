package com.bilel.soleflow2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bilel.soleflow2.models.Supplier;



@RepositoryRestResource(path = "restsuppliers")
public interface SupplierRepository extends JpaRepository<Supplier, Long>{

    Supplier findByNameSupplier(String nameSupplier);

    List<Supplier> findByNameSupplierContains(String nameSupplier);

    Supplier findByEmailSupplier(String emailSupplier);

    Supplier findByPhoneSupplier(String phoneSupplier);

}
