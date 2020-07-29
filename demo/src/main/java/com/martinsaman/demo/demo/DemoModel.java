package com.martinsaman.demo.demo;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class DemoModel {
    @Id
    private String _id;
    private String name;
    private String status;
}
