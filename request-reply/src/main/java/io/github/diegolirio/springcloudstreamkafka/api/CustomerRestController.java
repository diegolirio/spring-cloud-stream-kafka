package io.github.diegolirio.springcloudstreamkafka.api;

import io.github.diegolirio.springcloudstreamkafka.model.Customer;
import io.github.diegolirio.springcloudstreamkafka.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public void send(String firstname) {
        Customer customer = new Customer(firstname);
        customerService.send(customer);
    }
}
