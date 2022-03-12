package demo.microservice.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @KafkaListener(topics = "order-created")
    public void process(String content){
        System.out.println("------------ content -----------: "+ content);
    }
}
