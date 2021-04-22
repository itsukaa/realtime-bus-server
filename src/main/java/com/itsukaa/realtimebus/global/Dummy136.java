package com.itsukaa.realtimebus.global;


import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class Dummy136 {

    public final static String username = "15997174691";
    public final static String userKey = "efc04c3165d2c271c5bd2cc0f47acc39";

    public static String keySecret(String optingType) {
        return new String(
                DigestUtils.md5Digest(((username + userKey + optingType)
                        .getBytes(StandardCharsets.UTF_8)))
        );
    }
}
