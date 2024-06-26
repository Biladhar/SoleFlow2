package com.bilel.soleflow2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bilel.soleflow2.models.RawMaterial;
import com.bilel.soleflow2.models.Unit;


@RepositoryRestResource(path = "restrawmaterials")
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {

    RawMaterial findByReferenceRm(String referenceRm);
    
    List<RawMaterial> findByReferenceRmContains(String referenceRm);


    //!just for test query with 2 param
    @Query("SELECT r FROM RawMaterial r WHERE r.referenceRm like ?1 AND r.priceRm > ?2")
    List<RawMaterial> findByReferenceRmPriceRm(String ref, Double prix);

    //! test same query with @param

//    @Query("SELECT r FROM RawMaterial r WHERE r.referenceRm like %:ref and r.priceRm > :prix")
//    List<RawMaterial> findByReferenceRmPriceRmV2(@Param("ref") String ref, @Param("prix") Double prix);

    //! Query with entity in parameter
    //^ find by unit
    @Query("SELECT r FROM RawMaterial r WHERE r.unit = ?1")
    List<RawMaterial> findByUnit(Unit unit);

    // find by id of unit
    List<RawMaterial> findByUnitIdUnit(Long id);

    // find by order by name asc
    List<RawMaterial> findByOrderByReferenceRmAsc();

    // Order by name and price
    @Query("SELECT r FROM RawMaterial r ORDER BY r.referenceRm ASC, r.priceRm ASC")
    List<RawMaterial> findByOrderByReferenceRmAscPriceRmDesc();

    // find by supplier id
    List<RawMaterial> findBySupplierIdSupplier(Long id);



}
