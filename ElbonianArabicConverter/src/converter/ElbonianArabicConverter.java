package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static java.lang.Integer.parseInt;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;


    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        // TODO check to see if the number is valid, then set it equal to the string

        number = number.trim();
        check(number);

        this.number = number;
    }

    public void check(String number) throws MalformedNumberException, ValueOutOfBoundsException {
        int convertedNumber = 0;
        try {
            convertedNumber = parseInt(number);
            if(convertedNumber <= 0 || convertedNumber > 4332){
                throw new ValueOutOfBoundsException("the input Arabic number cannot be represented in the Elbonian number system");
            }
            //this.toElbonian();
        }catch (NumberFormatException e){
            if(number.equals("")){
                throw new MalformedNumberException("the input does not qualified as an Elbonian numebr");
            }
            boolean check1 = !number.matches("^M{0,3}D?e?C{0,3}L?m?X{0,3}V?w?I{0,3}$") && !number.matches("[1234567890]+");
            if(check1){
                throw new MalformedNumberException("the input does not qualified as an Elbonian numebr");
            }
            boolean check2 = number.matches("(.*)[MmCXDLeIVw]+(.*)") && number.matches("(.*)[1234567890]+(.*)");
            if(check2){
                throw new MalformedNumberException("the input cannot contain both Arabic numbers and Elbonian numbers") ;
            }
            //this.toArabic();
        }
    }


    /**
     *
     * @param s
     * @return
     */
    public HashMap<Character,Integer> getCharFreq(String s) {
        HashMap<Character,Integer> charFreq = new HashMap<Character,Integer>();
        if (s != null) {
            for (Character c : s.toCharArray()) {
                Integer count = charFreq.get(c);
                int newCount = (count==null ? 1 : count+1);
                charFreq.put(c, newCount);
            }
        }
        return charFreq;
    }

    /**
     *
     * @param c
     * @return
     */
    public int charFreq(char c){
        HashMap<Character,Integer> data = this.getCharFreq(this.number);
        if(data.containsKey(c)){
            return data.get(c);
        }
        return 0;
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        int result = charFreq('M')*1000 + charFreq('C')*100 + charFreq('D')*500 +
                charFreq('e')*400 + charFreq('X')*10 + charFreq('L')*50 +
                charFreq('m')*40 + charFreq('I') + charFreq('V')*5 + charFreq('w')*4;
        return result;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() throws ValueOutOfBoundsException {
        // TODO Fill in the method's body
        int numberAsInt = parseInt(number);
        String result = "";

        //make array of all possible ???
        int[] intArray = new int[]{1000,500,400,100,50,40,10,5,4,1};

        //iterate through array
        do {
            for(int i = 0; i< intArray.length; i++){
                result = createElbonianNumber(result,intArray[i],numberAsInt);
                int divider = numberAsInt/intArray[i];
                numberAsInt = numberAsInt - (divider*intArray[i]);
            }
        }while(numberAsInt > 0);
        return result;
    }

    /**
     * holds the hashmap which defines associations between elbonia number and arabic number conversion
     */
    public HashMap<Integer,String> elboniaLetterToValue(){
        HashMap<Integer,String> conversionKey = new HashMap<Integer, String>();
        conversionKey.put(1000, "M");
        conversionKey.put(500, "D");
        conversionKey.put(400, "e");
        conversionKey.put(100, "C");
        conversionKey.put(50, "L");
        conversionKey.put(40, "m");
        conversionKey.put(10, "X");
        conversionKey.put(5, "V");
        conversionKey.put(4, "w");
        conversionKey.put(1, "I");
        return conversionKey;
    }

    public String createElbonianNumber(String result, int key, int numberAsInt){
        //call function to create hashmap for elbonia-arabic associations
        HashMap<Integer, String> conversionKey = this.elboniaLetterToValue();

        int divider = numberAsInt/key;

        for(int i = 0; i < divider; i++){
            result = result + conversionKey.get(key);
            numberAsInt = numberAsInt - key;
        }

        return result;
    }
}
