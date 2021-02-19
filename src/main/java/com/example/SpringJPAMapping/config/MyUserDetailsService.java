package com.example.SpringJPAMapping.config;

import com.example.SpringJPAMapping.dao.CustomerDao;
import com.example.SpringJPAMapping.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerDao.findByEmail(email);

        MyUserDetails myUserDetails = null;
        if (customer != null) {
            myUserDetails = new MyUserDetails();
            myUserDetails.setCustomer(customer);

        } else {
            throw new UsernameNotFoundException(customer + " is not available in DataBase");
        }
        return myUserDetails;
    }
}
