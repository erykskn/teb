package com.teb.job.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private KafkaTemplate<String, String> kafkaTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "server";
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @Scheduled(fixedRate = 100)
    public void sendMessage() throws JsonProcessingException {
        Log log = LogProducer.createLog();
        LOGGER.info(String.format("$$ -> Producing  Message --> %s", log.toString()));
        String jsonLog = objectMapper.writeValueAsString(log);
        this.kafkaTemplate.send(TOPIC, jsonLog);
    }

}
