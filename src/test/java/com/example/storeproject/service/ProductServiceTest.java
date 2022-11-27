package com.example.storeproject.service;


import com.example.storeproject.dto.productDto.request.*;
import com.example.storeproject.entity.Product;
import com.example.storeproject.exeption.ProductNotFoundException;
import com.example.storeproject.repository.ProductRepository;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @MockBean
    ProductRepository productRepository;
    @Autowired
    ProductService productService;


    @Test
    public void testCreateProduct() {
        // given
        ProductCreateRequestDto dto = new ProductCreateRequestDto(1L, "Машинка", true, 100.05, 10);
        Product expectedProduct = new Product(1L, "Машинка", true, 100.05, 10);
        expectedProduct.setId(1L);

        when(productRepository.save(any())).thenReturn(expectedProduct);

        //when
        Product actualProduct = productService.createProduct(dto);
        // then
        Assert.assertEquals(expectedProduct, actualProduct);
    }

    @Test
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

    @Test
    public void testUpdateCategoryIdProductThrowProductNotFoundExceptionIfProductIsNotExistInDB() {
        // given
        Optional<Product> productFromDB = Optional.ofNullable(null);
        ProductUpdateCategoryIdRequestDto dto = new ProductUpdateCategoryIdRequestDto(1L, 2L);
        Long expectedCategoryId = 2L;

        when(productRepository.findById(dto.getId())).thenReturn(productFromDB);

        //when
        thrown.expect(ProductNotFoundException.class);
        Long actualCategoryId = productService.updateCategoryIdProduct(dto);

        // then
        Assert.assertEquals(expectedCategoryId, actualCategoryId);
    }

    @Test
    public void testUpdateNameProduct() {
        // given
        Product product = new Product(1L, "Машинка", true, 100.05, 10);
        product.setId(1L);
        Optional<Product> productFromDB = Optional.of(product);
        ProductUpdateNameRequestDto dto = new ProductUpdateNameRequestDto(1L, "Мячик");
        String expectedName = "Мячик";

        when(productRepository.findById(dto.getId())).thenReturn(productFromDB);

        //when
        String actualName = productService.updateNameProduct(dto);

        // then
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testUpdateNameProductThrowProductNotFoundExceptionIfProductIsNotExistInDB() {
        // given
        Optional<Product> productFromDB = Optional.ofNullable(null);
        ProductUpdateNameRequestDto dto = new ProductUpdateNameRequestDto(1L, "Мячик");
        String expectedName = "Мячик";

        when(productRepository.findById(dto.getId())).thenReturn(productFromDB);

        //when
        thrown.expect(ProductNotFoundException.class);
        String actualName = productService.updateNameProduct(dto);

        // then
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testUpdateVisibleProduct() {
        // given
        Product product = new Product(1L, "Машинка", true, 100.05, 10);
        product.setId(1L);
        Optional<Product> productFromDB = Optional.of(product);
        ProductUpdateVisibleRequestDto dto = new ProductUpdateVisibleRequestDto(1L, false);
        Boolean expectedVisible = false;

        when(productRepository.findById(dto.getId())).thenReturn(productFromDB);

        //when
        Boolean actualVisible = productService.updateVisibleProduct(dto);

        // then
        Assert.assertEquals(expectedVisible, actualVisible);
    }

    @Test
    public void testUpdateVisibleProductThrowProductNotFoundExceptionIfProductIsNotExistInDB() {
        // given
        Optional<Product> productFromDB = Optional.ofNullable(null);
        ProductUpdateVisibleRequestDto dto = new ProductUpdateVisibleRequestDto(1L, false);
        Boolean expectedVisible = false;

        when(productRepository.findById(dto.getId())).thenReturn(productFromDB);

        //when
        thrown.expect(ProductNotFoundException.class);
        Boolean actualVisible = productService.updateVisibleProduct(dto);

        // then
        Assert.assertEquals(expectedVisible, actualVisible);
    }

    @Test
    public void testUpdatePriceProduct() {
        // given
        Product product = new Product(1L, "Машинка", true, 100.05, 10);
        product.setId(1L);
        Optional<Product> productFromDB = Optional.of(product);
        ProductUpdatePriceRequestDto dto = new ProductUpdatePriceRequestDto(1L, 55.20);
        Double expectedPrice = 55.20;

        when(productRepository.findById(dto.getId())).thenReturn(productFromDB);

        //when
        Double actualPrice = productService.updatePriceProduct(dto);

        // then
        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testUpdatePriceProductThrowProductNotFoundExceptionIfProductIsNotExistInDB() {
        // given
        Optional<Product> productFromDB = Optional.ofNullable(null);
        ProductUpdatePriceRequestDto dto = new ProductUpdatePriceRequestDto(1L, 55.20);
        Double expectedPrice = 55.20;

        when(productRepository.findById(dto.getId())).thenReturn(productFromDB);

        //when
        thrown.expect(ProductNotFoundException.class);
        Double actualPrice = productService.updatePriceProduct(dto);

        // then
        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testUpdateCountProduct() {
        // given
        Product product = new Product(1L, "Машинка", true, 100.05, 10);
        product.setId(1L);
        Optional<Product> productFromDB = Optional.of(product);
        ProductUpdateCountRequestDto dto = new ProductUpdateCountRequestDto(1L, 5);
        int expectedCount = 5;

        when(productRepository.findById(dto.getId())).thenReturn(productFromDB);

        //when
        int actualCount = productService.updateCountProduct(dto);

        // then
        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testUpdateCountProductThrowProductNotFoundExceptionIfProductIsNotExistInDB() {
        // given
        Optional<Product> productFromDB = Optional.ofNullable(null);
        ProductUpdateCountRequestDto dto = new ProductUpdateCountRequestDto(1L, 5);
        int expectedCount = 5;

        when(productRepository.findById(dto.getId())).thenReturn(productFromDB);

        //when
        thrown.expect(ProductNotFoundException.class);
        int actualCount = productService.updateCountProduct(dto);

        // then
        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testDeleteProductById() {
        // given
        Long id = 1L;
        Product product = new Product(1L, "Машинка", true, 100.05, 10);
        product.setId(1L);
        Optional<Product> productFromDB = Optional.of(product);
        Long expectedId = 1L;

        when(productRepository.findById(id)).thenReturn(productFromDB);

        //when
        Long actualId = productService.deleteProduct(id);

        // then
        Assert.assertEquals(expectedId, actualId);
    }
    @Test
    public void testDeleteProductByIdThrowProductNotFoundExceptionIfProductIsNotExistInDB() {
        // given
        Long id = 1L;
        Optional<Product> productFromDB = Optional.ofNullable(null);
        Long expectedId = 1L;

        when(productRepository.findById(id)).thenReturn(productFromDB);

        //when
        thrown.expect(ProductNotFoundException.class);
        Long actualId = productService.deleteProduct(id);

        // then
        Assert.assertEquals(expectedId, actualId);
    }
}



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

