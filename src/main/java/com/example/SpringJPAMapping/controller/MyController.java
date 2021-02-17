package com.example.SpringJPAMapping.controller;

import com.example.SpringJPAMapping.dao.AddressDao;
import com.example.SpringJPAMapping.dao.CustomerDao;
import com.example.SpringJPAMapping.entity.Address;
import com.example.SpringJPAMapping.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private AddressDao addressDao;

    @PostMapping("/customers")
    private Customer create(@RequestBody Customer customer) {
        return customerDao.save(customer);
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
    private Customer update(@RequestBody Customer customer) {
        return customerDao.save(customer);
    }

    @PostMapping("customers/{id}/addresses")
    private Optional<Customer> createAddress(@RequestBody List<Address> newAddresses, @PathVariable int id){
        final Optional<Customer> customerById = customerDao.findById(id);
        customerById.ifPresent(customer -> {
            List<Address> existingAddresses = customer.getAddresses();
            existingAddresses.addAll(newAddresses);
            customer.setAddresses(existingAddresses);
            customerDao.save(customer);
        });
        return customerDao.findById(id);
    }

    @GetMapping("customers/{customerId}/addresses/{addressId}")
    private Optional<Address> getAddress(@PathVariable Integer customerId,
                                         @PathVariable Integer addressId){
        return addressDao.findById(addressId);
    }

    @PutMapping("customers/{customerId}/addresses/{addressId}")
    private Address updateAddress(@PathVariable Integer customerId,
                                            @PathVariable Integer addressId,
                                            @RequestBody Address address){
        return addressDao.save(address);
    }

    @DeleteMapping("customers/{customerId}")
    private void deleteCustomer(@PathVariable Integer customerId){
        customerDao.deleteById(customerId);
    }

    @DeleteMapping("customers/{customerId}/addresses/{addressId}")
    private void deleteAddress(@PathVariable Integer addressId){
        addressDao.deleteById(addressId);
    }
}
