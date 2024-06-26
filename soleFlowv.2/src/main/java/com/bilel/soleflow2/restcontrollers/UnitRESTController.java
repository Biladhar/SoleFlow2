package com.bilel.soleflow2.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bilel.soleflow2.models.Unit;
import com.bilel.soleflow2.services.UnitService;

@RestController
@RequestMapping("/api/units")
@CrossOrigin
public class UnitRESTController {

    @Autowired
    private UnitService unitService;

    //GET all units
    @GetMapping("/all")
    public List<Unit> getAllColors() {
        return unitService.getAllUnits();
    }


    //create a unit
    @PostMapping("/create")
    public Unit createUnit(@RequestBody Unit unit) {
        return unitService.saveUnit(unit);
    }

    //get a unit by id
    @GetMapping("/{id}")
    public Unit getUnit(@PathVariable("id") Long id) {
        return unitService.getUnit(id);
    }






}