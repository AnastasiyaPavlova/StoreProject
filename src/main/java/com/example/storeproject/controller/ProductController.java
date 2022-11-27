package com.example.storeproject.controller;


import com.example.storeproject.dto.productDto.request.*;
import com.example.storeproject.dto.productDto.response.ProductCreateResponseDto;
import com.example.storeproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("createProduct")
    public ProductCreateResponseDto createProduct(@RequestBody ProductCreateRequestDto dto) {
        return new ProductCreateResponseDto(productService.createProduct(dto));
    }


    @PostMapping("updateCategoryId")
    public Long updateCategoryIdProduct(@RequestBody ProductUpdateCategoryIdRequestDto dto) {
        return productService.updateCategoryIdProduct(dto);
    }

    @PostMapping("updateName")
    public String updateNameProduct(@RequestBody ProductUpdateNameRequestDto dto) {
        return productService.updateNameProduct(dto);
    }

    @PostMapping("updateVisible")
    public boolean updateVisibleProduct(@RequestBody ProductUpdateVisibleRequestDto dto) {
        return productService.updateVisibleProduct(dto);
    }

    @PostMapping("updatePrice")
    public double updatePriceProduct(@RequestBody ProductUpdatePriceRequestDto dto) {
        return productService.updatePriceProduct(dto);
    }

    @PostMapping("updateCount")
    public int updateCountProduct(@RequestBody ProductUpdateCountRequestDto dto) {
        return productService.updateCountProduct(dto);
    }

    @DeleteMapping(value = "{id}")
    public Long deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}

