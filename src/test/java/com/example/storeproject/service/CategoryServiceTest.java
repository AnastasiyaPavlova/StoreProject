package com.example.storeproject.service;

import com.example.storeproject.dto.categoryDto.request.CategoryCreateRequestDto;
import com.example.storeproject.entity.Category;
import com.example.storeproject.exeption.ParentCategoryNotFoundException;
import com.example.storeproject.repository.CategoryRepository;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

@MockBean
    CategoryRepository categoryRepository;
    @Autowired
CategoryService categoryService;

    @Test
    public void TestCreateCategory(){
        // given
        Optional<Category> categoryFromDB = Optional.of(new Category("Игрушки", 1));

        CategoryCreateRequestDto dto = new CategoryCreateRequestDto("Игрушки", 1);

        Category expectedCategory = new Category("Игрушки", 1);

        when(categoryRepository.findById(dto.getParentCategoryId())).thenReturn(categoryFromDB);

        //when
        Category actualCategory = categoryService.createCategory(dto);
        // then
        Assert.assertEquals(expectedCategory, actualCategory);
    }


    @Test
    public void TestCreateCategoryThrowParentCategoryNotFoundExceptionIfParentCategoryIdIsNotExistInDB() {
        // given
        Optional<Category> categoryFromDB = Optional.ofNullable(null);

        CategoryCreateRequestDto dto = new CategoryCreateRequestDto("Игрушки", 1);

        Category expectedCategory = new Category("Игрушки", 1);

        when(categoryRepository.findById(dto.getParentCategoryId())).thenReturn(categoryFromDB);

        //when
        thrown.expect(ParentCategoryNotFoundException.class);
        Category actualCategory = categoryService.createCategory(dto);
        // then
        Assert.assertEquals(expectedCategory, actualCategory);
    }
}