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
        assertEquals("I", converter.toElbonian());
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(1, converter.toArabic());
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
    @Test
    public void checkMalformedNumber5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter(" XI");
        assertEquals(11, test1.toArabic());
    }

    // input is valid Arabic number but doesn't count as an Elbonian number
    //QUESTION do we factor in negative numbers
    //QUESTION d is multiple of 10, does it count for rule 1, for rule 2 does m count
    //QUESTION does IV count as a number
    @Test(expected = MalformedNumberException.class)
    public void checkMalformedNumber6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("");
    }

    @Test(expected = MalformedNumberException.class)
    public void checkMalformedNumber7() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("$%^");
    }


    //TEST CASES for toArabic
    //checks if it can change elbonian number to arabic
    @Test
    public void checkElbonianToArabicSampleTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MDXI");
        assertEquals(1511, converter.toArabic());
    }

    // checks the max value
    @Test
    public void checkElbonianToArabicSampleTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMDeCCCLmXXXVwIII");
        assertEquals(4332, converter.toArabic());
    }
    

    //TEST CASES for toElbonian

    //checks if it can change arabic number to elbonian
    @Test
    public void checkArabictoElbonianSampleTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1511");
        assertEquals("MDXI", converter.toElbonian());
    }

    //checks if error is thrown when Arabic number is negative
    @Test(expected = ValueOutOfBoundsException.class)
    public void checkValueOutOfBounds0() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("-10");
        test1.toElbonian();
    }

    //checks if error is thrown when Arabic number too small to be in bounds of Elbonian
    @Test(expected = ValueOutOfBoundsException.class)
    public void checkValueOutOfBounds1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("0");
        test1.toElbonian();
    }

    //checks if error is thrown when Arabic number too big to be in bounds of Elbonian
    @Test(expected = ValueOutOfBoundsException.class)
    public void checkValueOutOfBounds2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("4333");
        test1.toElbonian();
    }





}
