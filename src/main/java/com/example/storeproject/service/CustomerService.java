package com.example.storeproject.service;


import com.example.storeproject.exeption.CustomerNotFoundException;
import com.example.storeproject.dto.customerDto.Request.CustomerCreateRequestDto;
import com.example.storeproject.dto.customerDto.Request.CustomerDeleteRequestDto;
import com.example.storeproject.dto.customerDto.Request.CustomerEditNameRequestDto;
import com.example.storeproject.entity.Customer;
import com.example.storeproject.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    public Customer createCustomer(CustomerCreateRequestDto dto) {
        return customerRepository.save(new Customer(dto.getName(), dto.getSurname(),
                dto.getEmail(), dto.getPhone(), dto.getAddress(), dto.getLogin(), dto.getPassword()));
    }

    public Customer editNameCustomer(CustomerEditNameRequestDto dto) {
        Optional<Customer> customerFromDB = customerRepository.findById(dto.getId());
        Customer customer = customerFromDB.orElseThrow(() -> new CustomerNotFoundException("Customer for edit with id " + dto.getId() + " not found"));
        customer.setName(dto.getName());
        customerRepository.save(customer);
        return customer;
    }
    public Customer deleteCustomer(CustomerDeleteRequestDto dto) {
        Optional<Customer> customerFromDB = customerRepository.findById(dto.getId());
        Customer customer = customerFromDB.orElseThrow(() -> new CustomerNotFoundException("Customer for delete with id " + dto.getId() + " not found"));
        customerRepository.delete(customer);
        return customer;
    }

}

