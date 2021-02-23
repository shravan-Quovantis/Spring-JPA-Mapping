package com.example.SpringJPAMapping.controller;

import com.example.SpringJPAMapping.entity.Address;
import com.example.SpringJPAMapping.entity.Customer;
import com.example.SpringJPAMapping.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private Services services;

    @PostMapping("/customers")
    private Customer saveCustomer(@RequestBody Customer customer) {
        return services.createCustomer(customer);
    }

    @GetMapping("/customers")
    private List<Customer> getCustomers() {
        return services.readCustomers();
    }

    @GetMapping("/customers/{id}")
    private Optional<Customer> getCustomerById(@PathVariable("id") int i) {
        return services.readCustomerById(i);
    }

    @PutMapping("/customers")
    private Customer changeCustomerInfo(@RequestBody Customer customer) {
        return services.update(customer);
    }

    @PostMapping("customers/{id}/addresses")
    private Optional<Customer> saveAddress(@RequestBody List<Address> newAddresses, @PathVariable int id){
        return services.createAddress(newAddresses, id);
    }

    @GetMapping("customers/{customerId}/addresses/{addressId}")
    private Optional<Address> getAddress(@PathVariable Integer customerId,
                                         @PathVariable Integer addressId){
        return services.readAddress(customerId, addressId);
    }

    @PutMapping("customers/{customerId}/addresses/{addressId}")
    private Address changeAddress(@PathVariable Integer customerId,
                                            @PathVariable Integer addressId,
                                            @RequestBody Address address){
        return services.updateAddress(customerId, addressId, address);
    }

    @DeleteMapping("customers/{customerId}")
    private void removeCustomer(@PathVariable Integer customerId){
        services.deleteCustomer(customerId);
    }

    @DeleteMapping("customers/{customerId}/addresses/{addressId}")
    private void removeAddress(@PathVariable Integer addressId){
        services.deleteAddress(addressId);
    }
}
