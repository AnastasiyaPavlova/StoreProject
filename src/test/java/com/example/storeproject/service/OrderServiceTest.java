package com.example.storeproject.service;

import com.example.storeproject.dto.orderDto.request.OrderCreatRequestDto;
import com.example.storeproject.dto.orderProductDto.request.OrderProductCreatRequestDto;
import com.example.storeproject.entity.Order;
import com.example.storeproject.repository.OrderRepository;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @MockBean
    OrderRepository orderRepository;
    @MockBean
    OrderProductService orderProductService;

    @Autowired
    OrderService orderService;


    @Test
    public void testCreateOrder() {
        List<OrderProductCreatRequestDto> orderProductRequestArray = new ArrayList<>();
        orderProductRequestArray.add(new OrderProductCreatRequestDto(1L, 2));
        OrderCreatRequestDto dto = new OrderCreatRequestDto(1L, "address", 1L, orderProductRequestArray);

        Order order = new Order(1L, 1L, 1L, LocalDate.now(), 200.00, "address");
        order.setId(1L);
        Long expectedId = 1L;

        when(orderRepository.save(any())).thenReturn(order);
        when(orderProductService.createOrderProduct(any(), any())).thenReturn(200.00);
        //when
        Long actualId = orderService.createOrder(dto);
        // then
        Assert.assertEquals(expectedId, actualId);
    }
}