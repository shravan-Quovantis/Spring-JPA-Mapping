package com.example.SpringJPAMapping.dao;

import com.example.SpringJPAMapping.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
}
