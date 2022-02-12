package com.code.DetectTheEmailAddresses;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        int cases = scanIn.nextInt();
        scanIn.nextLine();
        // \b boundary
        String regex = "\\b[.\\w]+@[^.]+[.\\w]+\\b";
        Pattern pattern = Pattern.compile(regex);
        Set<String> resultList = new HashSet<>();
        while (cases > 0) {
            String line = scanIn.nextLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                resultList.add(matcher.group());
            }
            cases--;
        }
        List<String> list = new ArrayList<>(resultList);
        Collections.sort(list);
        StringJoiner joiner = new StringJoiner(";");
        for (String s : list) {
            joiner.add(s);
        }
        System.out.println(joiner.toString());
    }
}
