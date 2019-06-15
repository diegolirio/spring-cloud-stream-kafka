package io.github.diegolirio.springcloudstreamkafka.listener;

import io.github.diegolirio.springcloudstreamkafka.config.CustomerStreams;
import io.github.diegolirio.springcloudstreamkafka.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerListener {

    @StreamListener(CustomerStreams.INPUT)
    public void handle(@Payload Customer customer) {
        log.info("Received customer: {}", customer);
    }
}
