package io.github.diegolirio.springcloudstreamkafka.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface CustomerStreams {

    String INPUT = "customers-in";
    String OUTPUT = "customers-out";

    @Input(INPUT)
    SubscribableChannel inboundCustomers();

    @Output(OUTPUT)
    MessageChannel outboundCustomers();
}