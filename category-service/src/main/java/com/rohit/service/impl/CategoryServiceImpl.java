package com.rohit.service.impl;

import com.rohit.dto.SalonDto;
import com.rohit.model.Category;
import com.rohit.repository.CategoryRepository;
import com.rohit.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl (CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category, SalonDto salonDto) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setSalonId(salonDto.getId());
        newCategory.setImage(category.getImage());
        return categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getAllCategoriesBySalon(Long id) {
        return categoryRepository.findBySalonId(id);
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        Category category = categoryRepository.findById(id).orElse(null);

        if (category == null)
        {
            throw new Exception("category not exist with id" +id);
        }
        return category;
    }

    @Override
    public void deleteCategoryById(Long id , Long salonId) throws Exception {
        Category category = getCategoryById(id);
        if(!category.getSalonId().equals(salonId))
        {
            throw new Exception("You don`t have permission to delete this category");
        }
        categoryRepository.deleteById(id);

    }
}
