package com.teb.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/monitor")
public class MonitoringAPI {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping
    public String list() {
        return null;
    }
}
