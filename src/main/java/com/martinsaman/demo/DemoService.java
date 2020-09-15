package com.martinsaman.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    DemoProducer producer;

    Flux<DemoModel> findAll() {
        return demoRepository.findAll();
    }

    Mono<DemoModel> findOne(String id) {
        return demoRepository.findById(id);
    }

    void save(DemoModel demoModel) {
        producer.send(DemoEvent.builder()
                .event(TypeEvent.CREATED)
                .model(demoModel).build());
    }

    String ipAdress() {
        InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();
            return "IP :" + ip.getHostAddress();
        } catch (UnknownHostException e) {

            e.printStackTrace();

        }
        return "IP :";
    }
}
