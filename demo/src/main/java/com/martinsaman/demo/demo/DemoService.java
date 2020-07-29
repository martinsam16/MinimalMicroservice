package com.martinsaman.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    Flux<DemoModel> findAll() {
        return demoRepository.findAll();
    }

    Mono<DemoModel> findOne(String id) {
        return demoRepository.findById(id);
    }

    Mono<DemoModel> save(DemoModel demo) {
        return demoRepository.save(demo);
    }
}
