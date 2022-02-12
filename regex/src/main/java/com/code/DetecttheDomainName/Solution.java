package com.code.DetecttheDomainName;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        int cases = scanIn.nextInt();
        scanIn.nextLine();
        String regex = "\\bhttps?://([-\\w]+\\.[-.\\w]+)\\b";
        Pattern pattern = Pattern.compile(regex);
        Set<String> set = new HashSet<>();
        while (cases > 0) {
            String line = scanIn.nextLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String group = matcher.group(1);
                if (group.contains("www.")) {
                    group = group.replaceFirst("www.", "");
                } else if (group.startsWith("ww2.")) {
                    group = group.replaceFirst("ww2.", "");
                }
                set.add(group);
            }
            cases--;
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        StringJoiner joiner = new StringJoiner(";");
        for (String s : list) {
            joiner.add(s);
        }
        System.out.println(joiner.toString());
    }
}
