package com.bilel.soleflow2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilel.soleflow2.models.Category;
import com.bilel.soleflow2.repositories.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category c) {
		return categoryRepository.save(c);
	}

	@Override
	public Category updateCategory(Category c) {
		return categoryRepository.save(c);
	}

	@Override
	public void deleteCategory(Category c) {
		categoryRepository.delete(c);
		
	}

	@Override
	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public Category getCategory(Long id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

}
