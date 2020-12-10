package org.example;

import org.example.config.TransactionConfiguration;
import org.example.service.XAOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

/**
 * ServerApplication
 * @author Duansg
 * @version 1.0
 */
@SpringBootApplication
@Import(TransactionConfiguration.class)
public class ServerApplication {

    @Autowired
    private XAOrderService orderService;
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class);
    }

    @PostConstruct
    public void executeOrderService() {
       // orderService.init();
        //orderService.selectAll();
        orderService.insert(10);
        //orderService.selectAll();
        //orderService.cleanup();
    }
}
