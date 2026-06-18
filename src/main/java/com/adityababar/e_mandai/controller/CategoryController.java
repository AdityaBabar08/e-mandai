package com.adityababar.e_mandai.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.adityababar.e_mandai.model.Category;
import com.adityababar.e_mandai.service.CategoryScervice;
import org.springframework.web.bind.annotation.PutMapping;


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
    public String createCategory(@RequestBody Category category) {
        categoryScervice.createCategory(category);
        return "Category Added Successfully";
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        try {

            String status = categoryScervice.deleteCategory(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body(status);

        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
    
    @PutMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> putMethodName(@PathVariable Long categoryId, @RequestBody Category category) {
        try {
            Category savedCategory = categoryScervice.updateCategory(categoryId, category);
            return new ResponseEntity<>("Category with ID " + categoryId + "Updated", HttpStatus.OK);

        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

}
