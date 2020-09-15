package com.martinsaman.demo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface DemoRepository extends ReactiveMongoRepository<DemoModel,String> {
    Mono<DemoModel> findByName(Mono<String> name);
}
