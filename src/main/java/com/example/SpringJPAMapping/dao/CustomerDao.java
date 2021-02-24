package com.example.SpringJPAMapping.dao;

import com.example.SpringJPAMapping.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);
}
