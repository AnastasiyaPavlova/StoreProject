package com.example.storeproject.service;

import com.example.storeproject.dto.orderDto.request.OrderCreatRequestDto;
import com.example.storeproject.entity.Order;
import com.example.storeproject.exeption.OrderNotFoundException;
import com.example.storeproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductService orderProductService;


    public Long createOrder(OrderCreatRequestDto dto) {

        Order order = orderRepository.save(new Order(dto.getCustomerId(), dto.getDeliveryId(), 1L, LocalDate.now(), 0, null));
        Double costOrder = orderProductService.createOrderProduct(order.getId(), dto.orderProductRequestArray());
        order.setCost(costOrder);
        return (orderRepository.save(order)).getId();
           }

    public Order getOrderByOrderId(Long orderId) {
        Optional<Order> orderFromDB = orderRepository.findById(orderId);
        Order order = orderFromDB.orElseThrow(() -> new OrderNotFoundException("Order with id " + orderId + " not found"));
        return order;
    }
}
