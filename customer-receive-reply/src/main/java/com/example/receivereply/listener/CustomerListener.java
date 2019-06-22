package com.example.receivereply.listener;

import com.example.receivereply.config.CustomerStreams;
import com.example.receivereply.domain.Customer;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class CustomerListener {

    @StreamListener(CustomerStreams.INPUT)
    @SendTo(CustomerStreams.OUTPUT)
    public Customer transform(@Payload Customer customer) {
        customer.setFirstname(customer.getFirstname() + " Fernandes");
        System.out.println(customer);
        return customer;
    }
}
