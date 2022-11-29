package com.example.storeproject.service;


import com.example.storeproject.dto.customerDto.request.CustomerCreateRequestDto;
import com.example.storeproject.dto.customerDto.request.CustomerUpdateAddressRequestDto;
import com.example.storeproject.dto.customerDto.request.CustomerUpdateNameRequestDto;
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
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
@MockBean
    CustomerRepository customerRepository;
@Autowired
   CustomerService customerService;

    @Test
    public void testCreateCustomer() {
        // given
        Customer customer = new Customer("Имя", "Адрес");
        CustomerCreateRequestDto dto = new CustomerCreateRequestDto("Имя", "Адрес");
        Customer expectedCustomer = new Customer("Имя", "Адрес");
        expectedCustomer.setId(1L);
        when(customerRepository.save(customer)).thenReturn(expectedCustomer);
        //when
        Customer actualCustomer = customerService.createCustomer(dto);
        // then
        Assert.assertEquals(expectedCustomer, actualCustomer);
    }

    @Test
    public void testUpdateNameCustomerFromDBWhenCustomerFindById() {
        Customer customer = new Customer("Имя", "Адрес");
        customer.setId(1L);
        Optional<Customer> customerFromDB = Optional.of(customer);
        CustomerUpdateNameRequestDto dto = new CustomerUpdateNameRequestDto(1L, "Маша");
        Customer expectedCustomer = new Customer("Маша","Адрес");
        expectedCustomer.setId(1L);
        String expectedName = "Маша";
        when(customerRepository.findById(dto.getId())).thenReturn(customerFromDB);
        when(customerRepository.save(expectedCustomer)).thenReturn(expectedCustomer);
        //when
        String actualName = customerService.updateNameCustomer(dto);
        // then
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testUpdateNameCustomerThrowCustomerNotFoundExceptionIfCustomerIsNotExistInDB() {
        Optional<Customer> customerFromDB = Optional.ofNullable(null);
        CustomerUpdateNameRequestDto dto = new CustomerUpdateNameRequestDto(1L, "Маша");
        Customer expectedCustomer = new Customer("Маша","Адрес");
        expectedCustomer.setId(1L);
        String expectedName = "Маша";
        when(customerRepository.findById(dto.getId())).thenReturn(customerFromDB);
        when(customerRepository.save(expectedCustomer)).thenReturn(expectedCustomer);
        //when
        thrown.expect(CustomerNotFoundException.class);
        String actualName = customerService.updateNameCustomer(dto);
        // then
        Assert.assertEquals(expectedName, actualName);
    }
    @Test
    public void testUpdateAddressCustomerFromDBWhenCustomerFindById() {
        Customer customer = new Customer("Имя", "Адрес");
        customer.setId(1L);
        Optional<Customer> customerFromDB = Optional.of(customer);
        CustomerUpdateAddressRequestDto dto = new CustomerUpdateAddressRequestDto(1L, "Город");
        Customer expectedCustomer = new Customer("Имя","Город");
        expectedCustomer.setId(1L);
        String expectedAddress = "Город";
        when(customerRepository.findById(dto.getId())).thenReturn(customerFromDB);
        when(customerRepository.save(expectedCustomer)).thenReturn(expectedCustomer);
        //when
        String actualAddress = customerService.updateAddressCustomer(dto);
        // then
        Assert.assertEquals(expectedAddress, actualAddress);
    }

    @Test
    public void testUpdateAddressCustomerThrowCustomerNotFoundExceptionIfCustomerIsNotExistInDB() {
        Optional<Customer> customerFromDB = Optional.ofNullable(null);
        CustomerUpdateAddressRequestDto dto = new CustomerUpdateAddressRequestDto(1L, "Город");
        Customer expectedCustomer = new Customer("Имя","Город");
        expectedCustomer.setId(1L);
        String expectedAddress = "Город";
        when(customerRepository.findById(dto.getId())).thenReturn(customerFromDB);
        when(customerRepository.save(expectedCustomer)).thenReturn(expectedCustomer);
        //when
        thrown.expect(CustomerNotFoundException.class);
        String actualAddress = customerService.updateAddressCustomer(dto);
        // then
        Assert.assertEquals(expectedAddress, actualAddress);
    }

    @Test
    public void testDeleteCustomerById() {
        Long id = 1L;
        Customer customer = new Customer("Имя", "Адрес");
        customer.setId(1L);
        Optional<Customer> customerFromDB = Optional.of(customer);
        Long expectedId = 1L;
        when(customerRepository.findById(id)).thenReturn(customerFromDB);
        //when
        Long actualId = customerService.deleteCustomer(id);
        // then
        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void testDeleteCustomerByIdThrowCustomerNotFoundExceptionIfCustomerIsNotExistInDB() {
        Long id = 1L;
        Optional<Customer> customerFromDB = Optional.ofNullable(null);
        Long expectedId = 1L;
        when(customerRepository.findById(id)).thenReturn(customerFromDB);
        //when
        thrown.expect(CustomerNotFoundException.class);
        Long actualId = customerService.deleteCustomer(id);
        // then
        Assert.assertEquals(expectedId, actualId);
    }
}