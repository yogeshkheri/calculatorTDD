package com.proj;

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
                Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
                m.matches();
                String customDelimiter = m.group(1);
                String number = m.group(2);
                List<String> testList = Arrays.asList(numbers.split(customDelimiter));
                checkNegativeNumbers(testList);
                return testList.stream().mapToInt(Integer::valueOf).sum();
            }else {
                List<String> testList = Arrays.asList(numbers.split("[,\n" + "]"));
                checkNegativeNumbers(testList);
                return testList.stream().mapToInt(Integer::valueOf).sum();
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
