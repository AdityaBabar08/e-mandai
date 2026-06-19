package com.adityababar.e_mandai.service;

import com.adityababar.e_mandai.model.Category;
import com.adityababar.e_mandai.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoryServiceImpl implements CategoryScervice {

    // private List<Category> categories = new ArrayList<>();

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        // Category category = categories.stream()
        //                     .filter(c -> c.getCategoryId() == categoryId)
        //                     .findFirst().orElse(null);

        // if (category == null) {
        //     return "Category Not Found";
        // }
        
        // categories.remove(category);

        if(categoryRepository.findById(categoryId).isPresent())
            categoryRepository.deleteById(categoryId);

        
        return "Category " + categoryId + " deleted successfully";
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) {
        // Optional<Category> optionalCategory = categories.stream()
        //         .filter(c -> c.getCategoryId() == categoryId)
        //         .findFirst();

        // if (optionalCategory.isPresent()) {
        //     Category existingCategory = optionalCategory.get();
        //     existingCategory.setCategoryName(category.getCategoryName());
        //     return existingCategory;
        // }
        // else{
        //     throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        // }

        if (categoryRepository.findById(categoryId).isPresent()) {
            Category ct = categoryRepository.findById(categoryId).get();
            ct.setCategoryName(category.getCategoryName());
            categoryRepository.save(ct);
            return ct;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }

}
