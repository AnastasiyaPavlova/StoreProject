package com.example.storeproject.controller;


import com.example.storeproject.dto.categoryDto.request.CategoryCreateRequestDto;
import com.example.storeproject.dto.categoryDto.response.CategoryCreateResponseDto;
import com.example.storeproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/createCategory")
    public CategoryCreateResponseDto createCategory(@RequestBody CategoryCreateRequestDto dto) {
        return new CategoryCreateResponseDto(categoryService.createCategory(dto));
    }
}



