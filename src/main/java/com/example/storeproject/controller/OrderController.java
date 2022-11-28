package com.example.storeproject.controller;


import com.example.storeproject.dto.orderDto.request.OrderCreatRequestDto;
import com.example.storeproject.dto.orderDto.response.OrderGetByOrderIdResponseDto;
import com.example.storeproject.dto.orderProductDto.response.OrderProductGetByOrderIdResponseDto;
import com.example.storeproject.entity.Order;
import com.example.storeproject.entity.OrderProduct;
import com.example.storeproject.service.OrderProductService;
import com.example.storeproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

  @Autowired
   private OrderService orderService;
    @Autowired
    private OrderProductService orderProductService;


    @PostMapping("/createOrder")
    public Long createOrder(@RequestBody OrderCreatRequestDto dto) {
       return orderService.createOrder(dto);
    }

    @GetMapping(value = "{orderId}")
    public  OrderGetByOrderIdResponseDto getOrderStatusByOrderId(@PathVariable Long orderId) {
        List<OrderProduct> orderProduct= new ArrayList<>();
        orderProduct=orderProductService.getOrderProductByOrderId(orderId);
        List<OrderProductGetByOrderIdResponseDto> orderProductResponse = new ArrayList<>();
        for (OrderProduct op: orderProduct) {
            orderProductResponse.add(new OrderProductGetByOrderIdResponseDto(op));
        }
        Order order = orderService.getOrderByOrderId(orderId);
        OrderGetByOrderIdResponseDto ooo=new OrderGetByOrderIdResponseDto(order,orderProductResponse);
        return ooo;
    }
}



