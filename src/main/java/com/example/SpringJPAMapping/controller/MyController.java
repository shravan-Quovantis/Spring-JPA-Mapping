package com.example.SpringJPAMapping.controller;

import com.example.SpringJPAMapping.services.AddAddress;
import com.example.SpringJPAMapping.services.AddCustomer;
import com.example.SpringJPAMapping.entity.Customer;
import com.example.SpringJPAMapping.dao.CustomerDao;
import com.example.SpringJPAMapping.dao.AddressDao;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private AddressDao addressDao;

    @PostMapping("/customers")
    private Customer create(@RequestBody AddCustomer addCustomer) {
        return customerDao.save(addCustomer.getCustomer());
    }

    @GetMapping("/customers")
    private List<Customer> read() {
        return customerDao.findAll();
    }

    @GetMapping("/customers/{id}")
    private Optional<Customer> ReadById(@PathVariable("id") int i) {
        return customerDao.findById(i);
    }

    @PutMapping("/customers")
    private Customer update(@RequestBody AddCustomer addCustomer) {
        return customerDao.save(addCustomer.getCustomer());
    }
}
