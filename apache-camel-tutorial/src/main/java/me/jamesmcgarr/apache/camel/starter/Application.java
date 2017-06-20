package me.jamesmcgarr.apache.camel.starter;

/**
 * Created by jmcgarr on 20/06/17.
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String args[]) {
        new ClassPathXmlApplicationContext("/application-context.xml");
        System.out.println("hello maven");
    }
}
