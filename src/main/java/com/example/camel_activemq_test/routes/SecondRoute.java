package com.example.camel_activemq_test.routes;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SecondRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:second-route-queue")
                .log("Message received from jms queue")
                .end();
    }
}
