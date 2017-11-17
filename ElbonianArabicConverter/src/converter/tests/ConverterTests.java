package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("TEST");
    }

    // TODO Add more test cases

    //TEST CASES for ElbonianArabicConverter
    // input is not an Elbonian number
    @Test(expected = MalformedNumberException.class)
    public void checkMalformedNumber1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("A");
    }

    // part of input is not an Elbonian number
    @Test(expected = MalformedNumberException.class)
    public void checkMalformedNumber2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("Mb");
    }

    // input contains both Arabic numbers and Elbonian numbers
    @Test(expected = MalformedNumberException.class)
    public void checkMalformedNumber3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("X15");
    }

    // input has space in the middle of number
    //QUESTION is this the right type of exception
    @Test(expected = MalformedNumberException.class)
    public void checkMalformedNumber4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("X I");
    }

    // input has space in beginning of number (should be allowed)
    //QUESTION where do we write the code to catch this problem and what kind of exception is it
    @Test(expected = MalformedNumberException.class)
    public void checkMalformedNumber5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter(" XI");
    }

    // input is valid Arabic number but doesn't count as an Elbonian number
    //QUESTION do we factor in negative numbers
    //QUESTION d is multiple of 10, does it count for rule 1, for rule 2 does m count
    //QUESTION does IV count as a number
    @Test(expected = MalformedNumberException.class)
    public void checkMalformedNumber6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("");
    }



    //TEST CASES for toArabic
    //checks if it can change elbonian number to arabic
    @Test
    public void checkElbonianToArabicSampleTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MDXI");
        assertEquals(converter.toArabic(), 1511);
    }

    //TEST CASES for toElbonian
}
