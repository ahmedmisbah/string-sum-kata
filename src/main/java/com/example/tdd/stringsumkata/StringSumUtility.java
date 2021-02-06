package com.example.tdd.stringsumkata;

public class StringSumUtility {

    public static Long sum(String firstTestNumber, String secondTestNumber) throws NotANaturalNumberException {
        String regex="^[0-9]\\d*\\.?[0]*$";

        Boolean firstNumberValid=firstTestNumber.matches(regex);
        Boolean secondNumberValid=secondTestNumber.matches(regex);

        if(!firstNumberValid||!secondNumberValid){
            throw new NotANaturalNumberException();
        }

        long firstNumber = Long.parseLong(firstTestNumber);
        long secondNumber = Long.parseLong(secondTestNumber);

        if(firstNumber<0 || secondNumber<0){
            throw new NotANaturalNumberException();
        }

        long sum=firstNumber + secondNumber;

        return sum;
    }
}
