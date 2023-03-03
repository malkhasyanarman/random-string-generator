package com.malkhasyan.stringgenerator.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SenderService {
    @Value(value = "${spring.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, ObjectNode> kafkaTemplate;
    private final KafkaMessageCreatorService kafkaMessageCreatorService;

    public SenderService(KafkaTemplate<String, ObjectNode> kafkaTemplate, KafkaMessageCreatorService kafkaMessageCreatorService) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaMessageCreatorService = kafkaMessageCreatorService;
    }

    @Scheduled(fixedRateString = "${schedule.interval}")
    public void sendString() {
        kafkaTemplate.send(topic, kafkaMessageCreatorService.createMessage());
    }
}
