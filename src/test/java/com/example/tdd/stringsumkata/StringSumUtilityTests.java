package com.example.tdd.stringsumkata;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringSumUtilityTests {

    @Test
    public void testHappyScenario() throws NotANaturalNumberException  {
        //GIVEN - Setup
        final String firstTestNumber="10";
        final String secondTestNumber="150";

        //When - Execution
        final Long actualResult=StringSumUtility.sum(firstTestNumber,secondTestNumber);

        //Then
        final Long expectedTestResult=160L;
        assertEquals(expectedTestResult,actualResult);
    }

    @Test
    public void testBoundaryScenario() throws NotANaturalNumberException {
        //GIVEN - Setup
        final String firstTestNumber="0";
        final String secondTestNumber="9223372036854775807";

        //When - Execution
        final Long actualResult=StringSumUtility.sum(firstTestNumber,secondTestNumber);

        //Then
        final Long expectedTestResult=9223372036854775807L;
        assertEquals(expectedTestResult,actualResult);
    }

    @Test
    public void testScenarioWhereFirstValueIsZero() throws NotANaturalNumberException {
        //GIVEN - Setup
        final String firstTestNumber="015";
        final String secondTestNumber="015";

        //When - Execution
        final Long actualResult=StringSumUtility.sum(firstTestNumber,secondTestNumber);

        //Then
        final Long expectedTestResult=30L;
        assertEquals(expectedTestResult,actualResult);
    }

    @Test
    public void testOneNegativeNumber()  {
        //THEN
        assertThrows(NotANaturalNumberException.class,()->{
            //GIVEN
            final String firstTestNumber="-1";
            final String secondTestNumber="15";

            //WHEN
            StringSumUtility.sum(firstTestNumber,secondTestNumber);

        });
    }

    @Test
    public void testOneADecimalNumber()  {
        //THEN
        assertThrows(NotANaturalNumberException.class,()->{
            //GIVEN
            final String firstTestNumber="0.5";
            final String secondTestNumber="15";

            //WHEN
            StringSumUtility.sum(firstTestNumber,secondTestNumber);

        });
    }

    @Test
    public void testCharacters()  {
        //THEN
        assertThrows(NotANaturalNumberException.class,()->{
            //GIVEN
            final String firstTestNumber="aaaaaa";
            final String secondTestNumber="15";

            //WHEN
            StringSumUtility.sum(firstTestNumber,secondTestNumber);

        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    public void useTestDataFromCSVFile(
            String firstNumber, String secondNumber,long expectedResult) throws NotANaturalNumberException {
        final Long actualResult=StringSumUtility.sum(firstNumber,secondNumber);
        assertEquals(expectedResult,actualResult);
    }

}
