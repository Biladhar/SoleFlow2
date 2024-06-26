package com.bilel.soleflow2.services;

import java.util.List;

import com.bilel.soleflow2.models.Unit;

public interface UnitService {

    Unit saveUnit(Unit u);
    Unit updateUnit(Unit u);
    void deleteUnit(Unit u);
    void deleteUnitById(Long id);
    Unit getUnit(Long id);
    List<Unit> getAllUnits();

}
