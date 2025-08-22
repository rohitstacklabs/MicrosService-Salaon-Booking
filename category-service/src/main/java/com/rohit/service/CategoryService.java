package com.rohit.service;

import com.rohit.dto.SalonDto;
import com.rohit.model.Category;

import java.util.Set;

public interface CategoryService {

    Category saveCategory(Category category, SalonDto salonDto);
    Set<Category> getAllCategoriesBySalon(Long id);
    Category getCategoryById(Long id) throws Exception;
    void deleteCategoryById(Long id , Long salonId) throws Exception;

}
