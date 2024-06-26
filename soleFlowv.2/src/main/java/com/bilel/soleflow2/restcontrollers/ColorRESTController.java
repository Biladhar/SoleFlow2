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

import com.bilel.soleflow2.models.Color;
import com.bilel.soleflow2.services.ColorService;

@RestController
@RequestMapping("/api/colors")
@CrossOrigin
public class ColorRESTController {

    @Autowired
    private ColorService colorService;

    //GET all colors
    @GetMapping("/all")
    public List<Color> getAllColors() {
        return colorService.getAllColors();
    }

    //create a color
    @PostMapping("/create")
    public Color createColor(@RequestBody Color color) {
        return colorService.saveColor(color);
    }

    //get a color by id
    @GetMapping("/get/{id}")
    public Color getColor(@PathVariable("id") Long id) {
        return colorService.getColor(id);
    }

    //Update a color
    @PutMapping("/update")
    public Color updateColor(@RequestBody Color color) {
        return colorService.updateColor(color);
    }

    //delete a color
    @DeleteMapping("/delete/{id}")
    public void deleteColor(@PathVariable("id") Long id) {
        colorService.deleteColorById(id);
    }

    


}
