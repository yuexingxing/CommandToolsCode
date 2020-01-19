package com.exam.tools;

import java.util.regex.Pattern;

/**
 * Function:
 * Author Name: yuexingxing
 * Date: 2020-01-17
 * Copyright © 2006-2018 高顿网校, All Rights Reserved.
 **/
public class StringUtil {


    /**
     * 为空判断
     * */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }


    /**
     * 手机号码判断
     * */
    public static boolean isPhoneNumber(String input) {// 判断手机号码是否规则
        String regex = "(1[0-9][0-9]|15[0-9]|18[0-9])\\d{8}";
        Pattern p = Pattern.compile(regex);
        return p.matches(regex, input);//如果不是号码，则返回false，是号码则返回true
    }
}
