package com.example.storeproject.controller;


import com.example.storeproject.dto.orderDto.request.OrderCreatRequestDto;
import com.example.storeproject.dto.orderProductDto.request.OrderProductCreatRequestDto;
import com.example.storeproject.service.OrderProductService;
import com.example.storeproject.service.OrderService;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
@AutoConfigureMockMvc(addFilters = false)

public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private OrderService orderService;
    @MockBean
    private OrderProductService orderProductService;

    @Test
    public void testCreateOrder() throws Exception {
        // given
        List<OrderProductCreatRequestDto> orderProductRequestArray = new ArrayList<>();
        orderProductRequestArray.add(new OrderProductCreatRequestDto(1L, 2));
        OrderCreatRequestDto dtoRequest = new OrderCreatRequestDto(1L, "address", 1L, orderProductRequestArray);
        Long expectedId = 1L;
        when(orderService.createOrder(dtoRequest)).thenReturn(expectedId);
        //when
        ResultActions result = mockMvc.perform(post("/api/order/createOrder")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoRequest))
                .accept(APPLICATION_JSON));
        // then
        result
                .andExpect(MockMvcResultMatchers.content().string("1"))
                .andExpect(status().isOk());
    }
}


