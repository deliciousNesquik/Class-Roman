package main.romancalc;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс RomanNumeral представляет собой класс
 * для работы с римскими цифрами. Он предоставляет
 * методы для преобразования римских цифр в арабские и наоборот.
 * Также он предоставляет методы для сложения и вычитания двух
 * римских цифр.
 */
public class Roman {

    /**Переменная типа данных Integer с названием NUMBER
     * предназначена для хранения значения римского числа
     * в арабском представлении для операций.
     */
    private int NUMBER;

    /**Переменная типа данных String с названием SNUMBER
     * предназначена для хранения значения римского числа
     * в строке.
     */
    private String SNUMBER;

    /**Словарь Map с типами данных внутри Character и Integer
     * хранит ключ - значение. В данном случае ключом в этом
     * словаре выступает символьное значение римской цифры единичной
     * , а значением выступает целочисленное значение римской цифры
     */
    private final Map<Character, Integer> map = new HashMap<>(); //хранение чисел (римские: обычные)
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
     *Метод Roman(String roman) предназначен для преобразования
     * римских цифр в арабские и наоборот. В методе используется
     * переменная map, которая содержит отображение римских цифр на арабские.
     * Далее идет цикл, в котором происходит преобразование римских цифр в арабские.
     * В конце метода вызывается метод IntToRoman(), который преобразует арабское число в римское.
     */
    Roman(String roman){
        this.NUMBER = toInt(roman);
        this.SNUMBER = roman;
    }

    /**
     *Конструктор класса Roman принимает один аргумент типа int,
     * который представляет римскую цифру. Если аргумент меньше нуля,
     * то он будет преобразован в положительное число. Если аргумент равен нулю,
     * то он будет преобразован в единицу.
     */
    Roman(int roman){
        this.NUMBER = Math.abs(roman);
        this.SNUMBER = toRoman(roman);
    }

    /**
     *Конструктор класса Roman принимает один аргумент типа Roman,
     * который представляет римскую цифру.
     */
    Roman(Roman other){
        this.NUMBER = other.NUMBER;
        this.SNUMBER = other.SNUMBER;
    }

    /**
     *Метод RomanToInt преобразует римское число в арабское.
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
     *Метод IntToRoman преобразует арабское число в римское.
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
     *Метод get возвращает строку, представляющую римское число,
     *соответствующее арабскому числу, хранящемуся в поле NUMBER.
     **/
    public String get(){
        return this.SNUMBER;
    }

    /**
     *Метод set принимает один аргумент типа String,
     *который представляет римское число.
     *Он устанавливает значение поля SNUMBER и вызывает
     *метод RomanToInt для преобразования римского числа в арабское.
     */
    public void set(String s){
        this.SNUMBER = s;
        this.NUMBER = toInt(s);
    }

    /**
     *Метод set принимает один аргумент типа int,
     *который представляет арабское число. Он устанавливает
     *значение поля NUMBER и вызывает метод IntToRoman для
     *преобразования арабского числа в римское.
     **/
    public void set(int n){
        this.NUMBER = n;
        this.SNUMBER = toRoman(n);
    }

    /**Метод hashCode возращает целое число, которое может быть использовано
     *для индефикации объекта*/
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     *Метод add принимает один аргумент типа Roman
     *и возвращает результат сложения двух римских цифр.
     *И присваевает это значение первому обьекту класса Roman
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
     *Метод sub принимает один аргумент типа Roman
     *и возвращает результат вычитания двух римских цифр.
     *И присваевает это значение первому обьекту класса Roman
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
     *Метод mul принимает один аргумент типа Roman
     *и возвращает результат умножения двух римских цифр.
     *И присваевает это значение первому обьекту класса Roman
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
     *Метод div принимает один аргумент типа Roman
     *и возвращает результат целочисленного деления двух римских цифр.
     *И присваевает это значение первому обьекту класса Roman
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