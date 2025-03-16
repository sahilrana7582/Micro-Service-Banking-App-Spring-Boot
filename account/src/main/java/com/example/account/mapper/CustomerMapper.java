package com.example.account.mapper;

import com.example.account.dto.CustomerDto;
import com.example.account.entity.Customer;

public class CustomerMapper {

    public static CustomerDto customerToCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setAge(customer.getAge());
        customerDto.setMobile(customer.getMobile());
        customerDto.setUsername(customer.getUsername());
        return customerDto;
    }


}
