package com.example.storeproject.service;


import com.example.storeproject.dto.customerDto.request.CustomerUpdateAddressRequestDto;
import com.example.storeproject.dto.customerDto.request.CustomerUpdateNameRequestDto;
import com.example.storeproject.exeption.CustomerNotFoundException;
import com.example.storeproject.dto.customerDto.request.CustomerCreateRequestDto;
import com.example.storeproject.entity.Customer;
import com.example.storeproject.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public Customer createCustomer(CustomerCreateRequestDto dto) {
        Customer customer = new Customer(dto.getName(), dto.getAddress());
        return customerRepository.save(customer);
    }
    @Transactional
    public String updateNameCustomer(CustomerUpdateNameRequestDto dto) {
        Optional<Customer> customerFromDB = customerRepository.findById(dto.getId());
        Customer customer = customerFromDB.orElseThrow(() -> new CustomerNotFoundException("Customer for edit with id " + dto.getId() + " not found"));
        customer.setName(dto.getName());
        return (customerRepository.save(customer)).getName();
            }
    @Transactional
    public String updateAddressCustomer(CustomerUpdateAddressRequestDto dto) {
        Optional<Customer> customerFromDB = customerRepository.findById(dto.getId());
        Customer customer = customerFromDB.orElseThrow(() -> new CustomerNotFoundException("Customer for edit with id " + dto.getId() + " not found"));
        customer.setAddress(dto.getAddress());
        return (customerRepository.save(customer)).getAddress();
    }
    @Transactional
    public Long deleteCustomer(Long id) {
        Optional<Customer> customerFromDB = customerRepository.findById(id);
        Customer customer = customerFromDB.orElseThrow(() -> new CustomerNotFoundException("Customer for delete with id " + id + " not found"));
        customerRepository.delete(customer);
        return id;
    }
}

