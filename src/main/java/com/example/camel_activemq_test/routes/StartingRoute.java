package com.example.camel_activemq_test.routes;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StartingRoute extends RouteBuilder {

    static Integer delayMs = 10_000;

    @Override
    public void configure() throws Exception {
        from("scheduler://outputFileScheduler?delay=" + delayMs)
                .log("Scheduler route executed. Sending message through activeMqJms")
                .to("jms:second-route-queue")
                .end();
    }
}
