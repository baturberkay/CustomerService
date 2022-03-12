package demo.microservice.serviceImpl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @KafkaListener(topics = "order-created", groupId = "myGroup")
    public void process(String content){
        System.out.println("------------ content -----------: "+ content);
    }
}
