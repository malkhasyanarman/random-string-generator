package com.malkhasyan.stringgenerator.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomStringGenerator {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectNode objectNode = objectMapper.createObjectNode();

    private static final char[] subset = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final Random random = new Random();

    public ObjectNode generateRandomStringVersionTwo() {
        objectNode.removeAll();
        int wordMinimumLength = 2;
        int targetStringLength = random.nextInt(97) + wordMinimumLength;
        objectNode.put("word", randomString(targetStringLength));

        return objectNode;
    }

    public static String randomString(final int length) {
        char[] buf = new char[length];
        for (int i=0; i<buf.length; i++) {
            int index = random.nextInt(subset.length);
            buf[i] = subset[index];
        }

        return new String(buf);
    }


    public ObjectNode generateRandomString() {
        objectNode.removeAll();

        int targetStringLength = random.nextInt(100);
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        objectNode.put("word", generatedString);

        return objectNode;
    }
}
