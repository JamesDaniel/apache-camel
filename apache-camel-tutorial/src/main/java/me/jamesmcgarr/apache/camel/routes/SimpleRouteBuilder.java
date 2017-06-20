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
        from("timer://foo?fixedRate=true&period=60000")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("This has been read: ");
                        File body = (File) exchange.getIn().getBody();
                        Scanner sc = new Scanner(body);
                        while (sc.hasNextLine()) {
                            System.out.println("This has been read: " + sc.nextLine());
                        }
                    }
                })
                .to("file://home/jmcgarr/apache-camel/apache-camel-tutorial/data-out");
    }
}
