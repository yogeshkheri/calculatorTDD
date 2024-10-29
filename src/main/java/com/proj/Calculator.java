package com.proj;

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
                return Arrays.stream(number.split(customDelimiter)).mapToInt(Integer::valueOf).sum();
            }else {
                List<String> testList = Arrays.asList(numbers.split("[,\n" +
                        "]"));
                return testList.stream().mapToInt(Integer::valueOf).sum();
            }
        }
    }
}
