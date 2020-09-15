package com.martinsaman.demo;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoListener {
    @Autowired
    private DemoRepository demoRepository;

    @KafkaListener(topics = "${cloudkarafka.topic}")
    public void processMessage(String message,
                               @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics,
                               @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        Gson gson = new Gson();
        DemoEvent event = gson.fromJson(message, DemoEvent.class);
        if (event.getEvent() == TypeEvent.CREATED) {
            System.out.println("Saved: "+message);
            demoRepository.save(event.getModel()).subscribe();
        }
    }
}
