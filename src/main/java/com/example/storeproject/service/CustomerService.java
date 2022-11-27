package com.example.storeproject.service;


import com.example.storeproject.dto.customerDto.request.CustomerUpdateAddressRequestDto;
import com.example.storeproject.dto.customerDto.request.CustomerUpdateNameRequestDto;
import com.example.storeproject.exeption.CustomerNotFoundException;
import com.example.storeproject.dto.customerDto.request.CustomerCreateRequestDto;
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
        Customer customer = new Customer(dto.getName(), dto.getAddress());
        return customerRepository.save(customer);
    }

    public String updateNameCustomer(CustomerUpdateNameRequestDto dto) {
        Optional<Customer> customerFromDB = customerRepository.findById(dto.getId());
        Customer customer = customerFromDB.orElseThrow(() -> new CustomerNotFoundException("Customer for edit with id " + dto.getId() + " not found"));
        customer.setName(dto.getName());
        customerRepository.save(customer);
        return customer.getName();
    }

    public String updateAddressCustomer(CustomerUpdateAddressRequestDto dto) {
        Optional<Customer> customerFromDB = customerRepository.findById(dto.getId());
        Customer customer = customerFromDB.orElseThrow(() -> new CustomerNotFoundException("Customer for edit with id " + dto.getId() + " not found"));
        customer.setAddress(dto.getAddress());
        customerRepository.save(customer);
        return customer.getAddress();
    }

    public Long deleteCustomer(Long id) {
        Optional<Customer> customerFromDB = customerRepository.findById(id);
        Customer customer = customerFromDB.orElseThrow(() -> new CustomerNotFoundException("Customer for delete with id " + id + " not found"));
        customerRepository.delete(customer);
        return customer.getId();
    }
}

