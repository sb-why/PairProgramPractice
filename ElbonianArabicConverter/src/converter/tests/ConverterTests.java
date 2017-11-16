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



    //TEST CASES for toArabic

    //TEST CASES for toElbonian



}
