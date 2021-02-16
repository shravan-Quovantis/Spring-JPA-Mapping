package com.example.SpringJPAMapping.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.jni.Address;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddAddress {
    private Address address;
}
