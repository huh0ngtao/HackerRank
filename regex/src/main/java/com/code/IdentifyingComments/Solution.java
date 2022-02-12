package com.code.IdentifyingComments;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        // 匹配// /***/
        String regex = "/\\*+[^*/]+\\*+/|//.+";
        Pattern pattern = Pattern.compile(regex);
        StringBuilder builder = new StringBuilder();
        while (scanIn.hasNextLine()) {
            builder.append(scanIn.nextLine().trim() + "\n");
        }
        Matcher matcher = pattern.matcher(builder.toString());
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
