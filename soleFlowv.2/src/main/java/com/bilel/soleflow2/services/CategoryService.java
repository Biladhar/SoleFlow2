package com.bilel.soleflow2.services;

import java.util.List;

import com.bilel.soleflow2.models.Category;

public interface CategoryService {

    Category saveCategory(Category c);
    Category updateCategory(Category c);
    void deleteCategory(Category c);
    void deleteCategoryById(Long id);
    Category getCategory(Long id);
    List<Category> getAllCategories();
    

}
