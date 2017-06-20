package me.jamesmcgarr.apache.camel.invoices;

/**
 * Created by jmcgarr on 20/06/17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {

    public void processPayment() {
        System.out.println("hello Processor");
    }
}
