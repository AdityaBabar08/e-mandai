package com.adityababar.e_mandai.controller;
import com.adityababar.e_mandai.model.Category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class CategoryController {

    private List<Category> categories = new ArrayList<>();


    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
        return categories;
    }
    

    

}
