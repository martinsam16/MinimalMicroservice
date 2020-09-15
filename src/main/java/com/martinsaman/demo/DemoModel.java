package com.martinsaman.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class DemoModel {
    @Id
    private String _id;
    private String name;
    private String status;
}
