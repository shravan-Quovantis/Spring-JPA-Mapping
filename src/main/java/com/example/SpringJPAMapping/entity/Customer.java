package com.example.SpringJPAMapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String email;
    private String name;
    private String gender;
    private String password;

    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cpfk", referencedColumnName = "id")
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Customer_Role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roles;
}
