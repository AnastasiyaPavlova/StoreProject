package com.example.storeproject.controller;


import com.example.storeproject.dto.customerDto.Request.CustomerCreateRequestDto;
import com.example.storeproject.dto.customerDto.Request.CustomerDeleteRequestDto;
import com.example.storeproject.dto.customerDto.Request.CustomerEditNameRequestDto;
import com.example.storeproject.dto.customerDto.Response.CustomerCreatResponseDto;
import com.example.storeproject.dto.customerDto.Response.CustomerDeleteResponseDto;
import com.example.storeproject.dto.customerDto.Response.CustomerEditNameResponseDto;
import com.example.storeproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("createCustomer")
    public CustomerCreatResponseDto createCustomer (@RequestBody CustomerCreateRequestDto dto) throws Exception{
        return new CustomerCreatResponseDto(customerService.createCustomer(dto));
    }

    @PostMapping("editNameCustomer")
    public CustomerEditNameResponseDto editNameCustomer(@RequestBody CustomerEditNameRequestDto dto) {
            return new CustomerEditNameResponseDto(customerService.editNameCustomer(dto));
    }

    @PostMapping("deleteCustomer")
    public CustomerDeleteResponseDto deleteCustomer(@RequestBody CustomerDeleteRequestDto dto) {
        return new CustomerDeleteResponseDto(customerService.deleteCustomer(dto));
    }
}

