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

    //test constructor for malformed number exceptions:


    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    // input is not an Elbonian number
    @Test(expected = MalformedNumberException.class)
    public void checkMalformedTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("A");
    }

    // part of input is not an Elbonian number
    @Test(expected = MalformedNumberException.class)
    public void checkMalformedTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("Mb");
    }

    // input contains both Arabic numbers and Elbonian numbers
    @Test(expected = MalformedNumberException.class)
    public void checkMalformedTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("X15");
    }

    // input has space in the middle of number
    @Test(expected = MalformedNumberException.class)
    public void checkMalformedTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("X I");
    }

    // input has space in beginning of number (should be allowed)
    @Test
    public void checkMalformedTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter(" XI");
        assertEquals(11, test1.toArabic());
    }

    @Test(expected = MalformedNumberException.class)
    public void checkMalformedNumber6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("");
    }

    @Test(expected = MalformedNumberException.class)
    public void checkMalformedNumber7() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("$%^");
    }

    // input has space in the middle of number
    @Test(expected = MalformedNumberException.class)
    public void checkMalformedTest8() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("1 0");
    }




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //tests constructor for value out of bounds exceptions:
    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("TEST");
    }

    //checks if error is thrown when Arabic number is negative
    @Test(expected = ValueOutOfBoundsException.class)
    public void checkValueOutOfBounds1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("-10");
        test1.toElbonian();
    }

    //checks if error is thrown when Arabic number too small to be in bounds of Elbonian
    @Test(expected = ValueOutOfBoundsException.class)
    public void checkValueOutOfBounds2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("0");
        test1.toElbonian();
    }

    //checks if error is thrown when Arabic number too big to be in bounds of Elbonian
    @Test(expected = ValueOutOfBoundsException.class)
    public void checkValueOutOfBounds3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter test1 = new ElbonianArabicConverter("4333");
        test1.toElbonian();
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //test toArabic()

    @Test
    public void ElboniantoArabicTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(1, converter.toArabic());
    }

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
    

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //TEST CASES for toElbonian

    //checks if it can change arabic number to elbonian
    @Test
    public void checkArabictoElbonianTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1511");
        assertEquals("MDXI", converter.toElbonian());
    }

    @Test
    public void checkArabictoElbonianTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals("I", converter.toElbonian());
    }

    @Test
    public void checkArabictoElbonianTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("4332");
        assertEquals("MMMDeCCCLmXXXVwIII", converter.toElbonian());
    }
}
