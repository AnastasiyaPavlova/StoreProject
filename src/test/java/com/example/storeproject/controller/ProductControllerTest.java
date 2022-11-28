package com.example.storeproject.controller;

import com.example.storeproject.dto.productDto.request.*;
import com.example.storeproject.entity.Product;
import com.example.storeproject.service.ProductService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc(addFilters = false)

public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    @Test
    public void testCreateProduct() throws Exception {
        // given
        ProductCreateRequestDto dtoRequest = new ProductCreateRequestDto(1L, "Toy", true, 22.50, 5);
        Product expectedProduct = new Product(1L, "Toy", true, 22.50, 5);
        expectedProduct.setId(1L);

        when(productService.createProduct(dtoRequest)).thenReturn(expectedProduct);

        //when
        ResultActions result = mockMvc.perform(post("/api/product/createProduct")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoRequest))
                .accept(APPLICATION_JSON));

        // then
        result
                .andExpect(jsonPath("$.categoryId").value(1))
                .andExpect(jsonPath("$.name").value("Toy"))
                .andExpect(jsonPath("$.visible").value(true))
                .andExpect(jsonPath("$.price").value("22.5"))
                .andExpect(jsonPath("$.count").value(5))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateCategoryIdProduct() throws Exception {
        // given
        ProductUpdateCategoryIdRequestDto dtoRequest = new ProductUpdateCategoryIdRequestDto(1L, 2L);
        Long expectedCategoryId = 2L;

        when(productService.updateCategoryIdProduct(dtoRequest)).thenReturn(expectedCategoryId);

        //when
        ResultActions result = mockMvc.perform(post("/api/product/updateCategoryId")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoRequest))
                .accept(APPLICATION_JSON));

        // then
        result
                .andExpect(MockMvcResultMatchers.content().string("2"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateNameProduct() throws Exception {
        // given
        ProductUpdateNameRequestDto dtoRequest = new ProductUpdateNameRequestDto(1L, "car");
        String expectedName = "car";

        when(productService.updateNameProduct(dtoRequest)).thenReturn(expectedName);

        //when
        ResultActions result = mockMvc.perform(post("/api/product/updateName")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoRequest))
                .accept(APPLICATION_JSON));

        // then
        result
                .andExpect(MockMvcResultMatchers.content().string("car"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateVisibleProduct() throws Exception {
        // given
        ProductUpdateVisibleRequestDto dtoRequest = new ProductUpdateVisibleRequestDto(1L, false);
        Boolean expectedVisible = false;

        when(productService.updateVisibleProduct(dtoRequest)).thenReturn(expectedVisible);

        //when
        ResultActions result = mockMvc.perform(post("/api/product/updateVisible")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoRequest))
                .accept(APPLICATION_JSON));

        // then
        result
                .andExpect(MockMvcResultMatchers.content().string("false"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdatePriceProduct() throws Exception {
        // given
        ProductUpdatePriceRequestDto dtoRequest = new ProductUpdatePriceRequestDto(1L, 50.22);
        Double expectedPrice = 50.22;

        when(productService.updatePriceProduct(dtoRequest)).thenReturn(expectedPrice);

        //when
        ResultActions result = mockMvc.perform(post("/api/product/updatePrice")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoRequest))
                .accept(APPLICATION_JSON));

        // then
        result
                .andExpect(MockMvcResultMatchers.content().string("50.22"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateCountProduct() throws Exception {
        // given
        ProductUpdateCountRequestDto dtoRequest = new ProductUpdateCountRequestDto(1L, 7);
        int expectedCount = 7;

        when(productService.updateCountProduct(dtoRequest)).thenReturn(expectedCount);

        //when
        ResultActions result = mockMvc.perform(post("/api/product/updateCount")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoRequest))
                .accept(APPLICATION_JSON));

        // then
        result
                .andExpect(MockMvcResultMatchers.content().string("7"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteProduct() throws Exception {
        // given
        Long id = 1L;

        when(productService.deleteProduct(id)).thenReturn(id);

        ResultActions result = mockMvc.perform(delete("/api/product/1")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(id))
                .accept(APPLICATION_JSON));

        // then
        result
                .andExpect(MockMvcResultMatchers.content().string("1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}


