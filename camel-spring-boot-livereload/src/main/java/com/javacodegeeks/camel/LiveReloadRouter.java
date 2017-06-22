package com.javacodegeeks.camel;

import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that exposes a text/plain REST endpoint returning a simple message.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class LiveReloadRouter extends RouteBuilder {

    @Value("${port}")
    private Integer port;

    @Override
    public void configure() throws Exception {

        restConfiguration()
            .port(port);

        rest()
            .get("/").produces("text/plain")
            .route()
            .transform().constant("Change me");
        rest()
            .get("/hello").produces("text/plain")
            .route()
            .transform().constant("hello world");

    }

}
