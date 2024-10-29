package com.proj;

public class Calculator {

    public static int add(String numbers){
        if(numbers.isBlank()){
            return  0;
        }else{
            return Integer.parseInt(numbers);
        }
    }
}
