package io.github.diegolirio.springcloudstreamkafka.service;

import io.github.diegolirio.springcloudstreamkafka.config.CustomerStreams;
import io.github.diegolirio.springcloudstreamkafka.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerStreams customerStreams;

    public void send(final Customer customer) {
        log.info("Sending customer {}", customer);

        // producer
        MessageChannel messageChannel = customerStreams.outboundCustomers();
        messageChannel.send(MessageBuilder.withPayload(customer)
                                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                                .build());

        System.out.println("Sended.... OK");
    }
}
