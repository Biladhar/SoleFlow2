package com.bilel.soleflow2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilel.soleflow2.models.Unit;
import com.bilel.soleflow2.repositories.UnitRepository;

@Service
public class UnitServiceImpl implements UnitService{

    @Autowired
    private UnitRepository unitRepository;

	@Override
	public Unit saveUnit(Unit u) {
		
		return unitRepository.save(u);
	}

	@Override
	public Unit updateUnit(Unit u) {
		
		return unitRepository.save(u);
	}

	@Override
	public void deleteUnit(Unit u) {
        unitRepository.delete(u);
		
		
	}

	@Override
	public void deleteUnitById(Long id) {
		unitRepository.deleteById(id);
		
	}

	@Override
	public Unit getUnit(Long id) {
		
		return unitRepository.findById(id).get();
	}

	@Override
	public List<Unit> getAllUnits() {
		
		return unitRepository.findAll();
	}

}
