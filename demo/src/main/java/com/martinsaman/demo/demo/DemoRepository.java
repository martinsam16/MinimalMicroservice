package com.martinsaman.demo.demo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends ReactiveMongoRepository<DemoModel,String> {

}
