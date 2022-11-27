package com.example.storeproject.controller;


import com.example.storeproject.dto.customerDto.request.CustomerCreateRequestDto;
import com.example.storeproject.dto.customerDto.request.CustomerUpdateAddressRequestDto;
import com.example.storeproject.dto.customerDto.request.CustomerUpdateNameRequestDto;
import com.example.storeproject.dto.customerDto.response.CustomerCreateResponseDto;
import com.example.storeproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/createCustomer")
    public CustomerCreateResponseDto createCustomer (@RequestBody CustomerCreateRequestDto dto){
        return new CustomerCreateResponseDto(customerService.createCustomer(dto));
    }
    @PostMapping(value = "updateName")
    public String updateNameCustomer(@RequestBody CustomerUpdateNameRequestDto dto) {
            return customerService.updateNameCustomer(dto);
    }
    @PostMapping(value = "updateAddress")
    public String updateAddressCustomer(@RequestBody CustomerUpdateAddressRequestDto dto) {
        return customerService.updateAddressCustomer(dto);
    }
    @DeleteMapping(value ="{id}" )
    public Long deleteProduct(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }
}

