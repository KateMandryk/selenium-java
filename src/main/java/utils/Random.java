package utils;

import java.util.UUID;

public class Random {

    public static String randomString() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("_", "");
    }
}