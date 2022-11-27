package com.example.storeproject.service;

import com.example.storeproject.dto.orderProductDto.request.OrderProductCreatRequestDto;
import com.example.storeproject.entity.OrderProduct;
import com.example.storeproject.entity.Product;
import com.example.storeproject.exeption.CustomerNotFoundException;
import com.example.storeproject.exeption.OrderProductNotEnoughProductException;
import com.example.storeproject.repository.OrderProductRepository;
import com.example.storeproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderProductService {
    @Autowired
    OrderProductRepository orderProductRepository;
    @Autowired
    ProductRepository productRepository;

    public Double createOrderProduct(Long orderId, List<OrderProductCreatRequestDto> orderProductRequestArray) {
        List<OrderProduct> orderProductForDB = new ArrayList<>();
        List<Product> productForUpdateCount = new ArrayList<>();
        double countOrder = 0;

        List<Product> productFromDBArray = productRepository.findAll();
        for (OrderProductCreatRequestDto productRequest : orderProductRequestArray) {
            for (Product productFromDB : productFromDBArray) {
                if (productRequest.getProductId() == productFromDB.getId()) {
                    if (productFromDB.getCount() - productRequest.getCount() < 0) {
                        throw new OrderProductNotEnoughProductException("Not enough product with id " + productRequest.getProductId());
                    }
                    productFromDB.setCount(productFromDB.getCount() - productRequest.getCount());
                    productForUpdateCount.add(productFromDB);
                    orderProductForDB.add(new OrderProduct(orderId, productFromDB.getId(), productRequest.getCount(), productFromDB.getPrice(), productRequest.getCount() * productFromDB.getPrice()));
                    countOrder += productRequest.getCount() * productFromDB.getPrice();
                    break;
                }
            }
        }

        productRepository.saveAll(productForUpdateCount);
        orderProductRepository.saveAll(orderProductForDB);
        return countOrder;
    }

    public List<OrderProduct> getOrderProductByOrderId(long orderId) {
        List<OrderProduct> orderProductWithOrderId = new ArrayList<>();
        return orderProductWithOrderId = orderProductRepository.findOrderProductsByOrderId(orderId);
    }
}


