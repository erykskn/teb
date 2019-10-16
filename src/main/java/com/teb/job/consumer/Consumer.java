package com.teb.job.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teb.job.producer.Log;
import com.teb.job.repositories.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    @Autowired
    private LogRepository logRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "server", groupId = "teb")
    public void getMessage(String message) throws IOException {
        Log log = objectMapper.readValue(message, Log.class);
        LOGGER.info(String.format("$$ -> Consumeed  Message --? %s", message));
        logRepository.save(log);

    }

}
