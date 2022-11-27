package com.example.storeproject.service;

import com.example.storeproject.dto.customerDto.request.CustomerCreateRequestDto;
import com.example.storeproject.dto.customerDto.request.CustomerUpdateNameRequestDto;
import com.example.storeproject.dto.productDto.request.*;
import com.example.storeproject.entity.Customer;
import com.example.storeproject.entity.Product;
import com.example.storeproject.exeption.CategoryNotFoundException;
import com.example.storeproject.exeption.CustomerNotFoundException;
import com.example.storeproject.exeption.ProductNotFoundException;
import com.example.storeproject.repository.OrderRepository;
import com.example.storeproject.repository.ProductRepository;
import liquibase.pro.packaged.L;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @MockBean
    ProductRepository productRepository;
    @MockBean
    ProductService productService;


    @Test
    public void testCreateProduct() {
        // given
        ProductCreateRequestDto dto = new ProductCreateRequestDto(1L, "Машинка", true, 100.05, 10);
        Product expectedProduct = new Product(1L, "Машинка", true, 100.05, 10);
        expectedProduct.setId(1L);
        //when
        Product actualProduct = productService.createProduct(dto);
        // then
        Assert.assertEquals(expectedProduct, actualProduct);
    }


    public void testUpdateCategoryIdProduct() {
        // given
        Product product = new Product(1L, "Машинка", true, 100.05, 10);
        product.setId(1L);
        Optional<Product> productFromDB = Optional.of(product);
        ProductUpdateCategoryIdRequestDto dto = new ProductUpdateCategoryIdRequestDto(1L, 2L);
        Long expectedCategoryId = 2L;

        when(productRepository.findById(dto.getId())).thenReturn(productFromDB);

        //when
        Long actualCategoryId = productService.updateCategoryIdProduct(dto);

        // then
        Assert.assertEquals(expectedCategoryId, actualCategoryId);

    }

    public void testUpdateCategoryIdProductThrowProductNotFoundExceptionIfProductIsNotExistInDB() {
        // given
        Product product = new Product(1L, "Машинка", true, 100.05, 10);
        product.setId(1L);
        Optional<Product> productFromDB = Optional.of(product);
        ProductUpdateCategoryIdRequestDto dto = new ProductUpdateCategoryIdRequestDto(1L, 2L);
        Long expectedCategoryId = 2L;

        when(productRepository.findById(dto.getId())).thenReturn(productFromDB);

        //when
        thrown.expect(ProductNotFoundException.class);
        Long actualCategoryId = productService.updateCategoryIdProduct(dto);

        // then
        Assert.assertEquals(expectedCategoryId, actualCategoryId);
  /*

    public String updateNameProduct(ProductUpdateNameRequestDto dto) {
        Optional<Product> productFromDB = productRepository.findById(dto.getId());
        Product product = productFromDB.orElseThrow(() -> new CustomerNotFoundException("Product for update with id " + dto.getId() + " not found"));
        product.setName(dto.getName());
        productRepository.save(product);
        return product.getName();
    }

    public boolean updateVisibleProduct(ProductUpdateVisibleRequestDto dto) {
        Optional<Product> productFromDB = productRepository.findById(dto.getId());
        Product product = productFromDB.orElseThrow(() -> new CustomerNotFoundException("Product for update with id " + dto.getId() + " not found"));
        product.setVisible(dto.isVisible());
        productRepository.save(product);
        return product.getVisible();
    }

    public double updatePriceProduct(ProductUpdatePriceRequestDto dto) {
        Optional<Product> productFromDB = productRepository.findById(dto.getId());
        Product product = productFromDB.orElseThrow(() -> new CustomerNotFoundException("Product for update with id " + dto.getId() + " not found"));
        product.setPrice(dto.getPrice());
        productRepository.save(product);
        return product.getPrice();
    }

    public int updateCountProduct(ProductUpdateCountRequestDto dto) {
        Optional<Product> productFromDB = productRepository.findById(dto.getId());
        Product product = productFromDB.orElseThrow(() -> new CustomerNotFoundException("Product for update with id " + dto.getId() + " not found"));
        product.setCount(dto.getCount());
        productRepository.save(product);
        return product.getCount();
    }

    public Long deleteProduct(Long id) {
        Optional<Product> productFromDB = productRepository.findById(id);
        Product product = productFromDB.orElseThrow(() -> new CustomerNotFoundException("Product for delete with id " + id + " not found"));
        productRepository.deleteById(id);
        return product.getId();*/
    }
}