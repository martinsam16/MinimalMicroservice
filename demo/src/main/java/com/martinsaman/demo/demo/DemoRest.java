package com.martinsaman.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@RequestMapping("/demo")
public class DemoRest {

    @Autowired
    private DemoService demoService;

    @GetMapping
    Flux<DemoModel> findAll() {
        return demoService.findAll();
    }

    @GetMapping("/one")
    Mono<DemoModel> findOne(@RequestParam("id") String id) {
        return demoService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Mono<DemoModel> save(@RequestBody DemoModel model) {
        return demoService.save(model);
    }
}
