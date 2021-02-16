package com.example.SpringJPAMapping.dao;

import com.example.SpringJPAMapping.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Integer> {
}
