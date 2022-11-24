package com.example.storeproject.controller;

import com.example.storeproject.dto.customerDto.Request.CustomerCreateRequestDto;
import com.example.storeproject.dto.customerDto.Request.CustomerDeleteRequestDto;
import com.example.storeproject.dto.customerDto.Request.CustomerEditNameRequestDto;
import com.example.storeproject.entity.Customer;
import com.example.storeproject.service.CustomerService;
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

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc(addFilters = false)

public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    @Test
    public void createPersonTest() throws Exception {
        // given
        CustomerCreateRequestDto dtoRequest = new CustomerCreateRequestDto("name", "address");
        Customer expectedCustomer = new Customer("name","address");
        expectedCustomer.setId(1L);

       when(customerService.createCustomer(dtoRequest)).thenReturn(expectedCustomer);

        ResultActions result = mockMvc.perform(post("/api/customer/createCustomer")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoRequest))
                .accept(APPLICATION_JSON));

        // then
        result
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("name"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("surname"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("email"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("phone"))
                                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void editNameCustomerTest() throws Exception {
        // given
        CustomerEditNameRequestDto dtoRequest = new CustomerEditNameRequestDto (1L,"name");
        Customer expectedCustomer = new Customer("name","address");
        expectedCustomer.setId(1L);

        when(customerService.editNameCustomer(dtoRequest)).thenReturn(expectedCustomer);

        ResultActions result = mockMvc.perform(post("/api/customer/editNameCustomer")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoRequest))
                .accept(APPLICATION_JSON));

        // then
        result
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("name"))

                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void deleteCustomerTest() throws Exception {
        // given
        CustomerDeleteRequestDto dtoRequest = new CustomerDeleteRequestDto(1L);
        Customer expectedCustomer = new Customer("name","address");
        expectedCustomer.setId(1L);

        when(customerService.deleteCustomer(dtoRequest)).thenReturn(expectedCustomer);

        ResultActions result = mockMvc.perform(post("/api/customer/deleteCustomer")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoRequest))
                .accept(APPLICATION_JSON));

        // then
        result
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    }
