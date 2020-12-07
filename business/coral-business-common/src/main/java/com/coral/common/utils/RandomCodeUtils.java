package com.coral.common.utils;

import java.util.Random;
import java.util.UUID;

/**
 * 随机数生成工具
 * @ClassName RandomCodeUtils
 * @Author sunyixing
 * @Date 2019-09-03 14:38
 * @Version 1.0
 */
public class RandomCodeUtils {

    public RandomCodeUtils() {
    }

    public static String randomCode6() {
        int code = (int)((Math.random() * 9.0D + 1.0D) * 100000.0D);
        return String.valueOf(code);
    }

    public static String uuid() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        return uuid;
    }

    public static String getStringRandom(int length) {
        StringBuilder val = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < length; ++i) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(charOrNum)) {
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val.append((char)(random.nextInt(26) + temp));
            } else {
                val.append(random.nextInt(10));
            }
        }

        return val.toString().toUpperCase();
    }
}
