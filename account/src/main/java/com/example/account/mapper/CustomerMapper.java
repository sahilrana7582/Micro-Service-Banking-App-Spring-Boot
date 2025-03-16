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

    public static Customer customerDtoToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setAge(customerDto.getAge());
        customer.setAge(customerDto.getAge());
        customer.setMobile(customerDto.getMobile());
        customer.setUsername(customerDto.getUsername());
        return customer;
    }


}
