package com.adityababar.e_mandai.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adityababar.e_mandai.model.Category;
import com.adityababar.e_mandai.service.CategoryScervice;

@RestController
public class CategoryController {


    private CategoryScervice categoryScervice;

    public CategoryController(CategoryScervice categoryScervice) {
        this.categoryScervice = categoryScervice;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
        return categoryScervice.getAllCategories();
    }
    
    @PostMapping("/api/admin/categories")
    public String postMethodName(@RequestBody Category category) {
        categoryScervice.createCategory(category);
        return "Category Added Successfully";
    }
    
    

}
