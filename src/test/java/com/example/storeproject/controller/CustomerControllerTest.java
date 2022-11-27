package com.example.storeproject.controller;

import com.example.storeproject.dto.customerDto.request.CustomerCreateRequestDto;
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

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void testCreateCustomer() throws Exception {
        // given
        CustomerCreateRequestDto dtoRequest = new CustomerCreateRequestDto("name", "address");
        Customer expectedCustomer = new Customer("name", "address");
        expectedCustomer.setId(1L);

        when(customerService.createCustomer(dtoRequest)).thenReturn(expectedCustomer);

        //when
        ResultActions result = mockMvc.perform(post("/api/customer/createCustomer")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoRequest))
                .accept(APPLICATION_JSON));

        // then
        result
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.address").value("address"))
                .andExpect(status().isOk());
    }
/*
  @Test
    public void testUpdateNameCustomer() throws Exception {
        // given
        CustomerUpdateNameRequestDto dtoRequest = new CustomerUpdateNameRequestDto (1L,"name");
        String expectedName = "neme";

        when(customerService.updateNameCustomer(dtoRequest)).thenReturn(expectedName);

      //when
        ResultActions result = mockMvc.perform(post("/api/customer/updateName")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dtoRequest))
                .accept(APPLICATION_JSON));

        // then
        result

    }



   @Test
    public void testDeleteCustomer() throws Exception {
        // given
        Long id = 1L;

        when(customerService.deleteCustomer(id)).thenReturn(id);

        ResultActions result = mockMvc.perform(delete("/api/customer/1")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(id))
                .accept(APPLICATION_JSON));

        // then
        result
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }*/

}
