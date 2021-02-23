package com.example.SpringJPAMapping;

import com.example.SpringJPAMapping.dao.CustomerDao;
import com.example.SpringJPAMapping.entity.Address;
import com.example.SpringJPAMapping.entity.Customer;
import com.example.SpringJPAMapping.services.Services;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringJpaMappingApplicationTests {

    @Autowired
    private Services services;

    @MockBean
    private CustomerDao customerDao;

    //When Method Return an object
    @Test
    void createCustomerTest(){
        List<Address> addressList = Arrays.asList(new Address(78, "Jv Colony", "Hyderabad", "Telangana"));
        Customer customer = new Customer(52, "r@gmail.com", "Ravi", "Male", addressList);

        when(customerDao.save(customer)).thenReturn(customer);
        org.junit.Assert.assertEquals(customer, services.createCustomer(customer));
    }

    //When Method return a List
    @Test
    void readCustomersTest() {
        List<Address> addressListA = Arrays.asList(new Address(78, "Jv Colony", "Hyderabad", "Telangana"));
        List<Address> addressListB = Arrays.asList(new Address(78, "Jv Colony", "Hyderabad", "Telangana"));

        when(customerDao.findAll()).thenReturn(Stream.of
                (new Customer(52, "r@gmail.com", "Ravi", "Male", addressListA)
                     ,new Customer(87, "s@gmail.com", "Shubham", "Male", addressListB)
                ).collect(Collectors.toList()));

        org.junit.Assert.assertEquals(2, services.readCustomers().size());
    }

    @Test
    void readCustomerByIdTest(){
        List<Address> addressList = Arrays.asList(new Address(78, "Jv Colony", "Hyderabad", "Telangana"));
        Customer customer = new Customer(52, "r@gmail.com", "Ravi", "Male", addressList);

        when(customerDao.findById(1)).thenReturn(java.util.Optional.of(customer));
        org.junit.Assert.assertEquals(Optional.of(customer), services.readCustomerById(1));
    }

    //When Method returns Void
    @Test
    void deleteCustomer(){
        services.deleteCustomer(52);
        verify(customerDao, times(1)).deleteById(52);
    }
}
