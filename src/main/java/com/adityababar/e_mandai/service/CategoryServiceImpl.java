package com.adityababar.e_mandai.service;
import com.adityababar.e_mandai.model.Category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryScervice {

      private List<Category> categories = new ArrayList<>();


    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        categories.add(category);
    }
    
}
