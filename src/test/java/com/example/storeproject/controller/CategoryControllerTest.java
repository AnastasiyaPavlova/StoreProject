package com.example.storeproject.controller;

import com.example.storeproject.dto.categoryDto.request.CategoryCreateRequestDto;
import com.example.storeproject.entity.Category;
import com.example.storeproject.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
@AutoConfigureMockMvc(addFilters = false)
public class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void testCreateCategory() throws Exception {
        // given
        CategoryCreateRequestDto dtoRequest = new CategoryCreateRequestDto("Toy", 1L);
        Category expectedCategory = new Category("Toy", 1L);
        expectedCategory.setId(1L);

        when(categoryService.createCategory(dtoRequest)).thenReturn(expectedCategory);

        //when
        ResultActions result = mockMvc.perform(post("/api/category/createCategory")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoRequest))
                .accept(APPLICATION_JSON));

        // then
        result
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Toy"))
                .andExpect(jsonPath("$.parentCategoryId").value("1"))
                .andExpect(status().isOk());
    }
}
