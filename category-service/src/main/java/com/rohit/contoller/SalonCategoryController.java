package com.rohit.contoller;

import com.rohit.dto.SalonDto;
import com.rohit.model.Category;
import com.rohit.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/categories/salon-owner")
public class SalonCategoryController {

    private final CategoryService categoryService;

    // Constructor Injection
    public SalonCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    public ResponseEntity<Category> createCategory(
            @RequestBody Category category
    )
    {
        SalonDto salonDto = new SalonDto();
        salonDto.setId(1L);

        Category category1 = categoryService.saveCategory(category , salonDto);

        return ResponseEntity.ok(category1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws Exception {
        SalonDto salonDto = new SalonDto();
        salonDto.setId(1L);

        categoryService.deleteCategoryById(id, salonDto.getId());

        return ResponseEntity.ok("category deleted successfully");

    }
}
