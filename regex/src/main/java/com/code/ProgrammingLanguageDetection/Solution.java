package com.code.ProgrammingLanguageDetection;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static final String javaRegex = "import\\s+[\\w\\.\\*]+;|(public|private|protected)\\s*";
    public static final String pythonRegex = "^\\bprint\\b\\s*\\\"?.*\\\"?$|^#\\s.*$|^\\bdef\\b\\s.*$|^if\\s[^()]+:";
    public static final String cRegex = "(#\\s*include\\s*(<\\s*[\\w]+(\\.\\w+)?\\s*>|\\\"[\\w]+(\\.\\w+)?\\\"\\s*))";

    public static final Pattern javaPattern = Pattern.compile(javaRegex, Pattern.MULTILINE);
    public static final Pattern pythonPattern = Pattern.compile(pythonRegex, Pattern.MULTILINE);
    public static final Pattern cPattern = Pattern.compile(cRegex, Pattern.MULTILINE);

    public static void main(String[] args) throws Exception {
        Scanner scanIn = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        while(scanIn.hasNext()){
            String line = scanIn.nextLine();
            builder.append(line.trim());
            builder.append("\n");
        }
        System.out.println(type(builder.toString()));
    }

    public static String type(String text) {
        Matcher matcher = javaPattern.matcher(text);
        if (matcher.find()) {
            return "Java";
        }
        matcher = pythonPattern.matcher(text);
        if (matcher.find()) {
            return "Python";
        }
        matcher = cPattern.matcher(text);
        if (matcher.find()) {
            return "C";
        }
        return "";
    }
}
