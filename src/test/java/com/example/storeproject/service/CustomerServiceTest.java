package com.example.storeproject.service;


import com.example.storeproject.dto.customerDto.Request.CustomerCreateRequestDto;
import com.example.storeproject.dto.customerDto.Request.CustomerDeleteRequestDto;
import com.example.storeproject.dto.customerDto.Request.CustomerEditNameRequestDto;

import com.example.storeproject.entity.Customer;
import com.example.storeproject.exeption.CustomerNotFoundException;
import com.example.storeproject.repository.CustomerRepository;
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

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @MockBean
    CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    @Test
    public void createCustomer() {
        // given
        CustomerCreateRequestDto dto = new CustomerCreateRequestDto("Имя", "Адрес");
        Customer expectedCustomer = new Customer("Имя", "Адрес");

        //when
        Customer actualCustomer = customerService.createCustomer(dto);
        // then
        Assert.assertEquals(expectedCustomer, actualCustomer);
    }

    @Test
    public void EditNameCustomerFromDBWhenCustomerFindById() {
        // given
        Customer customer = new Customer("Имя1", "адрес1");
        customer.setId(1L);
        Optional<Customer> customerFromDB = Optional.of(customer);
        CustomerEditNameRequestDto dto = new CustomerEditNameRequestDto(1L, "Маша");
        Customer expectedCustomer = new Customer("Маша", "адрес1");
        expectedCustomer.setId(1L);
        when(customerRepository.findById(dto.getId())).thenReturn(customerFromDB);

        //when
        Customer actualCustomer = customerService.editNameCustomer(dto);

        // then
        Assert.assertEquals(expectedCustomer, actualCustomer);
    }

    @Test
    public void editNameCustomerThrowCustomerNotFoundExceptionIfCustomerIsNotExistInDB() {
        // given
        Optional<Customer> customerFromDB = Optional.ofNullable(null);
        CustomerEditNameRequestDto dto = new CustomerEditNameRequestDto(1L, "Маша");
        Customer expectedCustomer = new Customer("Маша", "адрес1");
        expectedCustomer.setId(1L);

        when(customerRepository.findById(dto.getId())).thenReturn(customerFromDB);

        //when
        thrown.expect(CustomerNotFoundException.class);
        Customer actualCustomer = customerService.editNameCustomer(dto);

        // then
        Assert.assertEquals(expectedCustomer, actualCustomer);
    }

    @Test
    public void deleteCustomerById() {
        // given
        Customer customer = new Customer("Имя1", "адрес1");
        customer.setId(1L);
        Optional<Customer> customerFromDB = Optional.of(customer);

        CustomerDeleteRequestDto dto = new CustomerDeleteRequestDto(1L);


        when(customerRepository.findById(dto.getId())).thenReturn(customerFromDB);

        //when
        Customer actualCustomer = customerService.deleteCustomer(dto);

        // then
        assertNotNull(actualCustomer);

    }

    @Test
    public void deleteCustomerByIdThrowCustomerNotFoundExceptionIfCustomerIsNotExistInDB() {
        // given
        Optional<Customer> customerFromDB = Optional.ofNullable(null);

        CustomerDeleteRequestDto dto = new CustomerDeleteRequestDto(1L);

        when(customerRepository.findById(dto.getId())).thenReturn(customerFromDB);

        //when
        thrown.expect(CustomerNotFoundException.class);
        Customer actualCustomer = customerService.deleteCustomer(dto);

        // then
        assertNotNull(actualCustomer);
    }
}