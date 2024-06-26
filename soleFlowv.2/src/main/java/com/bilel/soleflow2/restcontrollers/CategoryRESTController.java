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

import com.bilel.soleflow2.models.Category;
import com.bilel.soleflow2.services.CategoryService;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryRESTController {

    @Autowired
    private CategoryService categoryService;

    //get all categories
    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    //create a category
    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    //get a category by id
    @GetMapping("/get/{id}")
    public Category getCategory(@PathVariable("id") Long id) {
        return categoryService.getCategory(id);
    }

    //Update a category
    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    //delete a category
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
    }



}
