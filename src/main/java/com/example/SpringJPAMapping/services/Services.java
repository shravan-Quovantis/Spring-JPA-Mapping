package com.example.SpringJPAMapping.services;

import com.example.SpringJPAMapping.dao.AddressDao;
import com.example.SpringJPAMapping.dao.CustomerDao;
import com.example.SpringJPAMapping.entity.Address;
import com.example.SpringJPAMapping.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Services {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private AddressDao addressDao;

    public Customer createCustomer(Customer customer){
        return customerDao.save(customer);
    }
    public List<Customer> readCustomers(){
        return customerDao.findAll();
    }

    public Optional<Customer> readCustomersById(int i){
        return customerDao.findById(i);
    }

    public Customer update(Customer customer){
        return customerDao.save(customer);
    }

    public Optional<Customer> createAddress(List<Address> newAddresses, int id){
        final Optional<Customer> customerById = customerDao.findById(id);
        customerById.ifPresent(customer -> {
            List<Address> existingAddresses = customer.getAddresses();
            existingAddresses.addAll(newAddresses);
            customer.setAddresses(existingAddresses);
            customerDao.save(customer);
        });
        return customerDao.findById(id);
    }

    public Optional<Address> readAddress(Integer customerId, Integer addressId){
        return addressDao.findById(addressId);
    }

    public Address updateAddress(Integer customerId, Integer addressId, Address address){
        return addressDao.save(address);
    }

    public void deleteCustomer(Integer customerId){
        customerDao.deleteById(customerId);
    }

    public void deleteAddress(Integer addressId){
        addressDao.deleteById(addressId);
    }
}