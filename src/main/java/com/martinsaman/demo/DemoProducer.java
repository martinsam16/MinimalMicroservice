package com.martinsaman.demo;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class DemoProducer {

    @Value("${cloudkarafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(DemoEvent event) {
        Gson gson = new Gson();
        String message = gson.toJson(event);
        kafkaTemplate.send(topic, message);
        System.out.println("Sent event [" + message + "] to " + topic);
    }
}
