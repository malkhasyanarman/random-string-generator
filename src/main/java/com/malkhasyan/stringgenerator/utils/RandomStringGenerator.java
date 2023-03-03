package com.malkhasyan.stringgenerator.utils;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class RandomStringGenerator {

    private static final char[] subset = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final Random random = new Random();

    public String randomString(final int length) {
        char[] buf = new char[length];
        for (int i=0; i<buf.length; i++) {
            int index = random.nextInt(subset.length);
            buf[i] = subset[index];
        }

        return new String(buf);
    }

    public String randomStringWithRandomLength() {
        int length = random.nextInt(100);
        char[] buf = new char[length];
        for (int i=0; i<buf.length; i++) {
            int index = random.nextInt(subset.length);
            buf[i] = subset[index];
        }

        return new String(buf);
    }
}
