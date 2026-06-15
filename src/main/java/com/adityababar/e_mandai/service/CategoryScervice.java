package com.adityababar.e_mandai.service;
import com.adityababar.e_mandai.model.Category;

import java.util.List;


public interface CategoryScervice {
    List<Category> getAllCategories();
    void createCategory(Category category);
}
