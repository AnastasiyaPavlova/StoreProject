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
    public void TestCreateCategory() {
        // given
        Category category = new Category("Мячики", 1L);
        Category parentCategory = new Category("Игрушки", 0);
        parentCategory.setId(1L);
        CategoryCreateRequestDto dto = new CategoryCreateRequestDto("Мячики", 1L);
        Category expectedCategory = new Category("Мячики", 1L);
        expectedCategory.setId(1L);
when(categoryRepository.findById(dto.getParentCategoryId())).thenReturn(Optional.of(parentCategory));
        when(categoryRepository.save(category)).thenReturn(expectedCategory);

        //when
        Category actualCategory = categoryService.createCategory(dto);
        // then
        Assert.assertEquals(expectedCategory, actualCategory);
    }
    @Test
    public void TestCreateCategoryThrowParentCategoryNotFoundExceptionIfParentCategoryIdIsNotExistInDB() {
        // given
        Category category = new Category("Мячики", 1L);
        CategoryCreateRequestDto dto = new CategoryCreateRequestDto("Мячики", 1L);
        Category expectedCategory = new Category("Мячики", 1L);
        expectedCategory.setId(1L);
        when(categoryRepository.findById(dto.getParentCategoryId())).thenReturn(Optional.ofNullable(null));
        when(categoryRepository.save(category)).thenReturn(expectedCategory);
        //when
        thrown.expect(ParentCategoryNotFoundException.class);
        Category actualCategory = categoryService.createCategory(dto);
        // then
        Assert.assertEquals(expectedCategory, actualCategory);
    }


}