package com.example.SpringJPAMapping.controller.services;

import com.example.SpringJPAMapping.dao.CustomerDao;
import com.example.SpringJPAMapping.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Services {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> readAll(){
        return customerDao.findAll();
    }
}