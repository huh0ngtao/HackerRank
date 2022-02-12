package com.code.FindAWord;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder text = new StringBuilder();
        while (count > 0) {
            text.append(br.readLine()).append(" ");
            count--;
        }
        int wordCount = Integer.parseInt(br.readLine());
        while (wordCount > 0) {
            int matchCount = 0;
            StringBuilder regexBuilder = new StringBuilder();
            String line = br.readLine();
            regexBuilder.append("\\b").append(line).append("\\b");
            Pattern pattern = Pattern.compile(regexBuilder.toString());
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                matchCount++;
            }
            wordCount--;
            System.out.println(matchCount);
        }
    }
}
