package com.example.SpringJPAMapping;

import com.example.SpringJPAMapping.dao.CustomerDao;
import com.example.SpringJPAMapping.entity.Address;
import com.example.SpringJPAMapping.entity.Customer;
import com.example.SpringJPAMapping.services.Services;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringJpaMappingApplicationTests {

    @Autowired
    private Services services;

    @MockBean
    private CustomerDao customerDao;

    void createCustomerTest(){

    }

    @Test
    void readAllTest() {
        Address address = new Address(78, "Jv Colony", "Hyderabad", "Telangana");
        List<Address> list = new ArrayList();
        list.add(address);
        when(customerDao.findAll()).thenReturn(Stream.of
                (new Customer(52, "r@gmail.com", "Ravi", "Male", list)
                     ,new Customer(87, "s@gmail.com", "Shubham", "Male", list)
                ).collect(Collectors.toList()));
		Assert.assertEquals(2, services.readCustomers().size());
    }

}
