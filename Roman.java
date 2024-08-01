package main.romancalc;

import java.util.HashMap;
import java.util.Map;

/**
 * The Roman class represents a class for working with Roman numerals. It provides methods for converting Roman numerals to Arabic and vice versa.
 * It also provides methods for adding and subtracting two Roman numerals.
 */
public class Roman {

    /** A variable of type Integer named NUMBER is intended for storing the value of a Roman numeral in Arabic representation for operations. */
    private int NUMBER;

    /** A variable of type String named SNUMBER is intended for storing the value of a Roman numeral in a string. */
    private String SNUMBER;

    /** A dictionary Map with types inside Character and Integer stores key-value pairs. In this case, the key in this dictionary is the character value of a single Roman digit, and the value is an integer value of a Roman digit. */
    private final Map<Character, Integer> map = new HashMap<>(); // Storing numbers (Roman: regular)
    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    /**
     * The Roman(String roman) constructor is intended for converting Roman numerals to Arabic and vice versa. In the method, the variable map, which contains the mapping of Roman digits to Arabic, is used.
     * Then comes a loop in which the conversion of Roman digits to Arabic takes place.
     * At the end of the method, the IntToRoman() method, which converts the Arabic number to Roman, is called.
     */
    Roman(String roman){
        this.NUMBER = toInt(roman);
        this.SNUMBER = roman;
    }

    /**
     * The Roman class constructor accepts one argument of type int, which represents a Roman numeral. If the argument is less than zero, it will be converted to a positive number. If the argument equals zero, it will be converted to one.
     */
    Roman(int roman){
        this.NUMBER = Math.abs(roman);
        this.SNUMBER = toRoman(roman);
    }

    /**
     * The Roman class constructor accepts one argument of type Roman, which represents a Roman numeral.
     */
    Roman(Roman other){
        this.NUMBER = other.NUMBER;
        this.SNUMBER = other.SNUMBER;
    }

    /**
     * The RomanToInt method converts a Roman numeral to an Arabic numeral.
     */
    private int toInt(String roman){
        int number = 0;
        int before = 0;
        roman = roman.charAt(0) == '-' ? roman.replace("-", "") : roman;

        if(!roman.isEmpty()){
            for(int i = roman.length() - 1; i >= 0; i--) {
                int current = map.get(roman.charAt(i));
                if (current < before) {
                    number -= current;
                } else {
                    number += current;
                }
                before = current;
            }
        }
        return number;
    }

    /**
     * The IntToRoman method converts an Arabic numeral to a Roman numeral.
     */
    private String toRoman(int number){
        String[] thousands = {"", "M", "MM", "MMM", "MMMM", "MMMMM",
                              "MMMMMM", "MMMMMMM", "MMMMMMMMM", "MMMMMMMMMM"};
        String[] hundreds =  {"", "C", "CC", "CCC", "CD", "D",
                              "DC", "DCC", "DCCC", "CM"};
        String[] dozens =    {"", "X", "XX", "XXX", "XL", "L",
                              "LX", "LXX", "LXXX", "XC"};
        String[] units =     {"", "I", "II", "III", "IV", "V",
                              "VI", "VII", "VIII", "IX"};

        return  thousands[number / 1000] +
                hundreds[(number % 1000) / 100] +
                dozens[(number % 100) / 10] +
                units[number % 10];
    }

    /**
     * The get method returns a string representing the Roman numeral corresponding to the Arabic number stored in the NUMBER field.
     **/
    public String get(){
        return this.SNUMBER;
    }

    /**
     * The set method accepts one argument of type String, which represents a Roman numeral.
     * It sets the value of the SNUMBER field and calls the RomanToInt method for converting the Roman numeral to Arabic.
     */
    public void set(String s){
        this.SNUMBER = s;
        this.NUMBER = toInt(s);
    }

    /**
     * The set method accepts one argument of type int, which represents an Arabic numeral. It sets the value of the NUMBER field and calls the IntToRoman method for converting the Arabic numeral to Roman.
     **/
    public void set(int n){
        this.NUMBER = n;
        this.SNUMBER = toRoman(n);
    }

    /** The hashCode method returns an integer that can be used for identifying the object */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * The add method accepts one argument of type Roman and returns the result of adding two Roman numerals.
     * And assigns this value to the first object of the Roman class
     **/
    public String add(Roman other){
        return toRoman(this.NUMBER + other.NUMBER);
    }

    public String add(int n){
        return toRoman(this.NUMBER + n);
    }

    public String add(String n){
        return toRoman(this.NUMBER + toInt(n));
    }

    /**
     * The sub method accepts one argument of type Roman and returns the result of subtracting two Roman numerals.
     * And assigns this value to the first object of the Roman class
     **/
    public String sub(Roman other){
        return toRoman(this.NUMBER - other.NUMBER);
    }

    public String sub(int n){
        return toRoman(this.NUMBER - n);
    }

    public String sub(String n){
        return toRoman(this.NUMBER - toInt(n));
    }

    /**
     * The mul method accepts one argument of type Roman and returns the result of multiplying two Roman numerals.
     * And assigns this value to the first object of the Roman class
     **/
    public String mul(Roman other){
        return toRoman(this.NUMBER * other.NUMBER);
    }

    public String mul(int n){
        return toRoman(this.NUMBER * n);
    }

    public String mul(String n){
        return toRoman(this.NUMBER * toInt(n));
    }

    /**
     * The div method accepts one argument of type Roman and returns the result of integer division of two Roman numerals.
     * And assigns this value to the first object of the Roman class
     **/
    public String div(Roman other){
        return toRoman(this.NUMBER / other.NUMBER);
    }

    public String div(int n){
        return toRoman(this.NUMBER / n);
    }

    public String div(String n){
        return toRoman(this.NUMBER / toInt(n));
    }
}
