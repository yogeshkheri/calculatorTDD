package com.proj;

public class Calculator {

    public static int add(String numbers){
        if(numbers.isBlank()){
            return  0;
        }else if (numbers.contains(",")) { // condition for two values like 1,4
            String[] splitText = numbers.split(",");
            return convertToInt(splitText[0]) + convertToInt(splitText[1]);
        } else { // condition for other values
            return convertToInt(numbers);
        }
    }

    private static int convertToInt(String text) throws NumberFormatException{
        return Integer.parseInt(text);
    }
}
