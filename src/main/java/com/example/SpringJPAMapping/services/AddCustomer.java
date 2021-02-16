package com.example.SpringJPAMapping.services;

import com.example.SpringJPAMapping.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddCustomer {
    private Customer customer;
}
