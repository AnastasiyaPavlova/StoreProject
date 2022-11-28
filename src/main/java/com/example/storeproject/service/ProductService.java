package com.example.storeproject.service;

import com.example.storeproject.dto.productDto.request.*;
import com.example.storeproject.entity.Product;
import com.example.storeproject.exeption.CategoryNotFoundException;
import com.example.storeproject.exeption.ProductNotFoundException;
import com.example.storeproject.repository.CategoryRepository;
import com.example.storeproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public Product createProduct(ProductCreateRequestDto dto) {
        Product product = new Product(dto.getCategoryId(), dto.getName(), dto.isVisible(), dto.getPrice(), dto.getCount());
        return productRepository.save(product);

    }

    public Long updateCategoryIdProduct(ProductUpdateCategoryIdRequestDto dto) {
        Optional<Product> productFromDB = productRepository.findById(dto.getId());
        Product product = productFromDB.orElseThrow(() -> new ProductNotFoundException("Product for update with id " + dto.getId() + " not found"));
        if (categoryRepository.findById(dto.getCategoryId()).isEmpty()){
            throw new CategoryNotFoundException("Category with id " + dto.getCategoryId() + " not found");}
        product.setCategoryId(dto.getCategoryId());
        return (productRepository.save(product)).getCategoryId();
           }

    public String updateNameProduct(ProductUpdateNameRequestDto dto) {
        Optional<Product> productFromDB = productRepository.findById(dto.getId());
        Product product = productFromDB.orElseThrow(() -> new ProductNotFoundException("Product for update with id " + dto.getId() + " not found"));
        product.setName(dto.getName());
        productRepository.save(product);
        return (productRepository.save(product)).getName();
    }

    public boolean updateVisibleProduct(ProductUpdateVisibleRequestDto dto) {
        Optional<Product> productFromDB = productRepository.findById(dto.getId());
        Product product = productFromDB.orElseThrow(() -> new ProductNotFoundException("Product for update with id " + dto.getId() + " not found"));
        product.setVisible(dto.isVisible());
        productRepository.save(product);
        return (productRepository.save(product)).getVisible();
    }

    public double updatePriceProduct(ProductUpdatePriceRequestDto dto) {
        Optional<Product> productFromDB = productRepository.findById(dto.getId());
        Product product = productFromDB.orElseThrow(() -> new ProductNotFoundException("Product for update with id " + dto.getId() + " not found"));
        product.setPrice(dto.getPrice());
        productRepository.save(product);
        return (productRepository.save(product)).getPrice();
    }

    public int updateCountProduct(ProductUpdateCountRequestDto dto) {
        Optional<Product> productFromDB = productRepository.findById(dto.getId());
        Product product = productFromDB.orElseThrow(() -> new ProductNotFoundException("Product for update with id " + dto.getId() + " not found"));
        product.setCount(dto.getCount());
        productRepository.save(product);
        return (productRepository.save(product)).getCount();
    }

    public Long deleteProduct(Long id) {
        Optional<Product> productFromDB = productRepository.findById(id);
        Product product = productFromDB.orElseThrow(() -> new ProductNotFoundException("Product for delete with id " + id + " not found"));
        productRepository.deleteById(id);
        return product.getId();
    }

}

