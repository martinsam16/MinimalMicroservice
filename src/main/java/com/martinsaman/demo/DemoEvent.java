package com.martinsaman.demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DemoEvent {
    private DemoModel model;
    private TypeEvent event;
}
