package com.coral.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 判断手机号
 * @ClassName PhoneUtils
 * @Author sunyixing
 * @Date 2019-09-03 14:43
 * @Version 1.0
 */
public class PhoneUtils {
    public PhoneUtils() {
    }

    public static boolean check(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            return isMatch;
        }
    }
}
