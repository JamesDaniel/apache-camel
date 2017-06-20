package me.jamesmcgarr.apache.camel.starter;

/**
 * Created by jmcgarr on 20/06/17.
 */

import me.jamesmcgarr.apache.camel.routes.SimpleRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String args[]) throws Exception {
        new ClassPathXmlApplicationContext("/application-context.xml");
        System.out.println("hello maven");

        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new SimpleRouteBuilder());
        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
