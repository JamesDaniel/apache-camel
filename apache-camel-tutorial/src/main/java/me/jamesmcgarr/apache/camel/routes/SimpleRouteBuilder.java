package me.jamesmcgarr.apache.camel.routes;

/**
 * Created by jmcgarr on 20/06/17.
 */

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Scanner;

@Component
public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:///home/user/IdeaProjects/apache-camel/apache-camel-tutorial/data/")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("A new file has been dropped into directory /home/user/IdeaProjects/apache-camel/apache-camel-tutorial/data/");
                        System.out.println("    The file will be moved to /home/user/IdeaProjects/apache-camel/apache-camel-tutorial/data-out/");
                    }
                })
                .to("file:///home/user/IdeaProjects/apache-camel/apache-camel-tutorial/data-out/");
    }
}
