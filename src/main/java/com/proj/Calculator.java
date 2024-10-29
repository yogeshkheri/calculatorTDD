package com.proj;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static int add(String numbers){
        if(numbers.isBlank()){
            return  0;
        }else if (numbers.contains(",")) { // condition for any number values with two delimiters like 1/n2,5
            List<String> testList = Arrays.asList(numbers.split("[,\n" + "]"));
            return testList.stream().mapToInt(Integer::valueOf).sum();
        } else { // condition for other values
            return convertToInt(numbers);
        }
    }

    private static int convertToInt(String text) throws NumberFormatException{
        return Integer.parseInt(text);
    }
}
