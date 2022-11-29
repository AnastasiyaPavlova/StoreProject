package com.example.storeproject.service;


import com.example.storeproject.dto.categoryDto.request.CategoryCreateRequestDto;
import com.example.storeproject.entity.Category;
import com.example.storeproject.exeption.ParentCategoryNotFoundException;
import com.example.storeproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
@Transactional
    public Category createCategory(CategoryCreateRequestDto dto) {
        if (dto.getParentCategoryId() != 0 && categoryRepository.findById(dto.getParentCategoryId()).isEmpty()) {
            throw new ParentCategoryNotFoundException("Parent category with id " + dto.getParentCategoryId() + " not found");
        }
        Category category = new Category(dto.getName(), dto.getParentCategoryId());
        return categoryRepository.save(category);
    }
}


