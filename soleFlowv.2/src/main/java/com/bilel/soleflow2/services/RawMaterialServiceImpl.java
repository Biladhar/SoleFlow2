package com.bilel.soleflow2.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilel.soleflow2.dto.RawMaterialDTO;
import com.bilel.soleflow2.models.RawMaterial;
import com.bilel.soleflow2.models.Unit;
import com.bilel.soleflow2.repositories.RawMaterialRepository;

@Service
public class RawMaterialServiceImpl implements RawMaterialService{
    

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

	@Autowired
	ModelMapper modelMapper;


	//create
	@Override
	public RawMaterialDTO saveRawMaterial(RawMaterialDTO rm) {
		return convertEntityToDto(rawMaterialRepository.save(convertDtoToEntity(rm)));
	}
	//update
	@Override
	public RawMaterialDTO updateRawMaterial(RawMaterialDTO rm) {
		return convertEntityToDto(rawMaterialRepository.save(convertDtoToEntity(rm)));
	}
	//delete
	@Override
	public void deleteRawMaterial(RawMaterial rm) {
		rawMaterialRepository.delete(rm);
		
	}
	//delete by id
	@Override
	public void deleteRawMaterialById(Long id) {
		rawMaterialRepository.deleteById(id);
		
	}

	//get a raw material
	@Override
	public RawMaterialDTO getRawMaterial(Long id) {
		return convertEntityToDto(rawMaterialRepository.findById(id).get());
	}

	//get all raw materials
	//^ functional programming java
	@Override
	public List<RawMaterialDTO> getAllRawMaterials() {
		return rawMaterialRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(java.util.stream.Collectors.toList());
	}
	//^ classic method
	// public List<RawMaterialDTO> getAllRawMaterials() {
	// 		List<RawMaterial> rms = rawMaterialRepository.findAll();
	// 		List<RawMaterialDTO> rawMaterialDTOs = new ArrayList<>(rms.size());
	// 		for (RawMaterial rm : rms) {
	// 			rawMaterialDTOs.add(convertEntityToDto(rm));
	// 		return rawMaterialDTOs;

	//find by reference
	@Override
	public RawMaterial findByReferenceRm(String referenceRm) {
		return rawMaterialRepository.findByReferenceRm(referenceRm);
	}
	//find by reference contains
	@Override
	public List<RawMaterial> findByReferenceRmContains(String referenceRm) {
		return rawMaterialRepository.findByReferenceRmContains(referenceRm);
	}
	//find by reference and price
	@Override
	public List<RawMaterial> findByReferenceRmPriceRm(String ref, Double prix) {
		return rawMaterialRepository.findByReferenceRmPriceRm(ref, prix);
	}
	//find by unit
	@Override
	public List<RawMaterial> findByUnit(Unit unit) {
		return rawMaterialRepository.findByUnit(unit);
	}
	//find by unit id
	@Override
	public List<RawMaterial> findByUnitIdUnit(Long id) {
		return rawMaterialRepository.findByUnitIdUnit(id);
	}
	//find by order by reference
	@Override
	public List<RawMaterial> findByOrderByReferenceRmAsc() {
		return rawMaterialRepository.findByOrderByReferenceRmAsc();
	}
	//find by order by reference and price
	@Override
	public List<RawMaterial> findByOrderByReferenceRmAscPriceRmDesc() {
		return rawMaterialRepository.findByOrderByReferenceRmAscPriceRmDesc();
	}

	//? create a DTO without .builder
	// @Override
	// public RawMaterialDTO convertEntityToDto(RawMaterial rm) {
	// 	RawMaterialDTO rawMaterialDTO = new RawMaterialDTO();
	// 	rawMaterialDTO.setIdRm(rm.getIdRm());
	// 	rawMaterialDTO.setReferenceRm(rm.getReferenceRm());
	// 	rawMaterialDTO.setDescriptionRm(rm.getDescriptionRm());
	// 	rawMaterialDTO.setPriceRm(rm.getPriceRm());
	// 	rawMaterialDTO.setStockRm(rm.getStockRm());
	// 	rawMaterialDTO.setAmountRm(rm.getAmountRm());
	// 	rawMaterialDTO.setUnit(rm.getUnit());
	// 	return rawMaterialDTO;
	// }

	//? create a DTO with .builder
//	@Override
//	public RawMaterialDTO convertEntityToDto(RawMaterial rm) {
//		return RawMaterialDTO.builder()
//		.idRm(rm.getIdRm())
//		.referenceRm(rm.getReferenceRm())
//		.descriptionRm(rm.getDescriptionRm())
//		.priceRm(rm.getPriceRm())
//		.stockRm(rm.getStockRm())
//		.amountRm(rm.getAmountRm())
//		.unit(rm.getUnit())
//		.build();
//	}
	
	//? create a DTO with .builder and modelMapper
	@Override
	public RawMaterialDTO convertEntityToDto(RawMaterial rm) {
		//? modelMapper configuration to loose matching strategy to get Unit name
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		RawMaterialDTO rawMaterialDTO = modelMapper.map(rm, RawMaterialDTO.class);
		return rawMaterialDTO;
	}
		
	@Override
	public RawMaterial convertDtoToEntity(RawMaterialDTO rmDTO) {
//		RawMaterial rawMaterial = new RawMaterial();
//		rawMaterial.setIdRm(rmDTO.getIdRm());
//		rawMaterial.setReferenceRm(rmDTO.getReferenceRm());
//		rawMaterial.setDescriptionRm(rmDTO.getDescriptionRm());
//		rawMaterial.setPriceRm(rmDTO.getPriceRm());
//		rawMaterial.setStockRm(rmDTO.getStockRm());
//		rawMaterial.setAmountRm(rmDTO.getAmountRm());
//		rawMaterial.setUnit(rmDTO.getUnit());
//		return rawMaterial;
		RawMaterial rawMaterial = new RawMaterial();
		rawMaterial = modelMapper.map(rmDTO, RawMaterial.class);
		return rawMaterial;
		
		
		
	}

		

}
