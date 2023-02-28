package com.malkhasyan.stringgenerator.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.malkhasyan.stringgenerator.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    @Autowired
    private RandomStringGenerator randomStringGenerator;

    @Autowired
    private KafkaTemplate<String, ObjectNode> kafkaTemplate;

    @Scheduled(fixedRateString = "${schedule.interval}")
    public void sendString() {
        kafkaTemplate.send("wordTopic", randomStringGenerator.generateRandomStringVersionTwo());
    }
}
