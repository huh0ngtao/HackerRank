package com.code.DetectHTMLLinks;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        int cases = scanIn.nextInt();
        // 匹配<a></a>
        // (<[^>]+>)*[\s]*([^<]*)(<[^>]+>)* 匹配a标签的多个标签
        Pattern pattern = Pattern.compile("<a\\s+[^>]*\\s*href=\"([^\"]+)\"\\s*[^>]*\\s*>(<[^>]+>)*[\\s]*([^<]*)(<[^>]+>)*<\\s*/\\s*a\\s*>");
        while (cases > 0) {
            String line = scanIn.nextLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                System.out.println(matcher.group(1) + "," + matcher.group(3));
            }
            cases--;
        }
    }
}
