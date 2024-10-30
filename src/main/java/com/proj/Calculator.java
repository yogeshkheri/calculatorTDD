package com.proj;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int add(String numbers){
        if(numbers.isBlank()){
            return  0;
        }else {
            if(numbers.startsWith("//")){
                Matcher m = Pattern.compile("^//((?:\\[([^\\]]+)\\])+|(.))\\n(.*?)$").matcher(numbers);
                m.matches();
                String delimiters;
                String numberString;
                if (m.group(1).startsWith("[")) {
                    // Multiple delimiters in square brackets
                    delimiters = m.group(1).replaceAll("\\[|\\]", "");
                    numberString = m.group(4);
                } else {
                    // Single character delimiter
                    delimiters = m.group(3);
                    numberString = m.group(4);
                }
                String delimiterPattern =  Pattern.quote(delimiters);
                List<String> testList = Arrays.asList(StringUtils.split(numberString,delimiterPattern));
                checkNegativeNumbers(testList);
                return testList.stream().mapToInt(Integer::valueOf).filter(value -> value<1000).sum();
            }else {
                List<String> testList = Arrays.asList(numbers.split("[,\n" + "]"));
                checkNegativeNumbers(testList);
                return testList.stream().mapToInt(Integer::valueOf).filter(value -> value<1000).sum();
            }
        }
    }

    private static void checkNegativeNumbers(List<String> data){
        int[] dataArray = data.stream().mapToInt(Integer::valueOf).toArray();
        List<Integer> negativeNumberList = new ArrayList<>();
        int count = 0;
        for (int j : dataArray) {
            if (j < 0) {
                negativeNumberList.add(j);
                count++;
            }
        }
        if(count > 0){
            throw new NumberFormatException("negative numbers not allowed "+negativeNumberList.toString());
        }
    }
}
