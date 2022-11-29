package com.example.storeproject.service;

import com.example.storeproject.dto.orderDto.request.OrderCreatRequestDto;
import com.example.storeproject.dto.orderProductDto.request.OrderProductCreatRequestDto;
import com.example.storeproject.entity.Order;
import com.example.storeproject.exeption.OrderNotFoundException;
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
import java.util.Optional;
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

        Order order = new Order(1L, 1L, 1L, LocalDate.now(), 0, "address");
        order.setId(1L);

        Order expectedOrder = new Order(1L, 1L, 1L, LocalDate.now(), 200, "address");
        expectedOrder.setId(1L);
        Long expectedId = 1L;

        when(orderRepository.save(new Order(dto.getCustomerId(), dto.getDeliveryId(), 1L, LocalDate.now(), 0, dto.getAddress()))).thenReturn(order);
        when(orderProductService.createOrderProduct(1L, orderProductRequestArray)).thenReturn(200.00);
        when(orderRepository.save(expectedOrder)).thenReturn(expectedOrder);
        //when
        Long actualId = orderService.createOrder(dto);
        // then
        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void getOrderByOrderId() {
        Order order = new Order(1L, 1L, 1L, LocalDate.now(), 200, "address");
        order.setId(1L);
        Optional<Order> orderFromDB = Optional.of(order);
        Long id = 1L;
        Order expectedOrder = order;
        when(orderRepository.findById(id)).thenReturn(orderFromDB);
        //when
        Order actualOrder = orderService.getOrderByOrderId(1L);
        // then
        Assert.assertEquals(expectedOrder, actualOrder);
    }
    @Test
    public void getOrderByOrderIdThrowOrderNotFoundExceptionIfOrderIsNotExistInDB() {
        Optional<Order> orderFromDB = Optional.ofNullable(null);
        Order order = new Order(1L, 1L, 1L, LocalDate.now(), 200, "address");
        order.setId(1L);
         Long id = 1L;
        Order expectedOrder = order;
        when(orderRepository.findById(id)).thenReturn(orderFromDB);
        //when
        thrown.expect(OrderNotFoundException.class);
        Order actualOrder = orderService.getOrderByOrderId(1L);
        // then
        Assert.assertEquals(expectedOrder, actualOrder);
    }
}