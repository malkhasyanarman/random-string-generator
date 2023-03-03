package com.malkhasyan.stringgenerator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.malkhasyan.stringgenerator.utils.RandomStringGenerator;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageCreatorService {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectNode objectNode = objectMapper.createObjectNode();

    private final RandomStringGenerator randomStringGenerator;

    public KafkaMessageCreatorService(RandomStringGenerator randomStringGenerator) {
        this.randomStringGenerator = randomStringGenerator;
    }

    public ObjectNode createMessage() {
        objectNode.removeAll();
        objectNode.put("word", randomStringGenerator.randomStringWithRandomLength());

        return objectNode;
    }
}
