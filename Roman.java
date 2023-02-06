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
        this.NUMBER = roman;
        this.SNUMBER = toRoman(roman);
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
        String snumber = "";

        if(number < 0) number *= -1;
        else if(number == 0) number = 1;

        if(number >= 1 && number <= 10){
            switch(number){
                case 1 -> snumber += "I";
                case 2 -> snumber += "II";
                case 3 -> snumber += "III";
                case 4 -> snumber += "IV";
                case 5 -> snumber += "V";
                case 6 -> snumber += "VI";
                case 7 -> snumber += "VII";
                case 8 -> snumber += "VIII";
                case 9 -> snumber += "IX";
                case 10 -> snumber += "X";
            }
        }
        else if(number >= 11 && number <= 99){
            int unit = number % 10;
            int dozens = (number / 10) % 10;
            switch(dozens){
                case 1 -> snumber += "X";
                case 2 -> snumber += "XX";
                case 3 -> snumber += "XXX";
                case 4 -> snumber += "XL";
                case 5 -> snumber += "L";
                case 6 -> snumber += "LX";
                case 7 -> snumber += "LXX";
                case 8 -> snumber += "LXXX";
                case 9 -> snumber += "XC";
            }
            switch(unit){
                case 1 -> snumber += "I";
                case 2 -> snumber += "II";
                case 3 -> snumber += "III";
                case 4 -> snumber += "IV";
                case 5 -> snumber += "V";
                case 6 -> snumber += "VI";
                case 7 -> snumber += "VII";
                case 8 -> snumber += "VIII";
                case 9 -> snumber += "IX";
            }
        }
        else if(number >= 100 && number <= 999){
            int unit = number % 10;
            int dozens = (number / 10) % 10;
            int hundreds = ((number / 10) / 10) % 10;
            switch(hundreds){
                case 1 -> snumber += "C";
                case 2 -> snumber += "CC";
                case 3 -> snumber += "CCC";
                case 4 -> snumber += "CD";
                case 5 -> snumber += "D";
                case 6 -> snumber += "DC";
                case 7 -> snumber += "DCC";
                case 8 -> snumber += "DCCC";
                case 9 -> snumber += "CM";
            }
            switch(dozens){
                case 1 -> snumber += "X";
                case 2 -> snumber += "XX";
                case 3 -> snumber += "XXX";
                case 4 -> snumber += "XL";
                case 5 -> snumber += "L";
                case 6 -> snumber += "LX";
                case 7 -> snumber += "LXX";
                case 8 -> snumber += "LXXX";
                case 9 -> snumber += "XC";
            }
            switch(unit){
                case 1 -> snumber += "I";
                case 2 -> snumber += "II";
                case 3 -> snumber += "III";
                case 4 -> snumber += "IV";
                case 5 -> snumber += "V";
                case 6 -> snumber += "VI";
                case 7 -> snumber += "VII";
                case 8 -> snumber += "VIII";
                case 9 -> snumber += "IX";
            }
        }
        else if(number >= 1000 && number <= 10000){
            int unit = number % 10;
            int dozens = (number / 10) % 10;
            int hundreds = ((number / 10) / 10) % 10;
            int thousands = (((number / 10) / 10) / 10) % 10;
            switch(thousands){
                case 1 -> snumber += "M";
                case 2 -> snumber += "MM";
                case 3 -> snumber += "MMM";
                case 4 -> snumber += "MMMM";
                case 5 -> snumber += "MMMMM";
                case 6 -> snumber += "MMMMMM";
                case 7 -> snumber += "MMMMMMM";
                case 8 -> snumber += "MMMMMMMM";
                case 9 -> snumber += "MMMMMMMMM";
                case 10 -> snumber += "MMMMMMMMMM";
            }
            switch(hundreds){
                case 1 -> snumber += "C";
                case 2 -> snumber += "CC";
                case 3 -> snumber += "CCC";
                case 4 -> snumber += "CD";
                case 5 -> snumber += "D";
                case 6 -> snumber += "DC";
                case 7 -> snumber += "DCC";
                case 8 -> snumber += "DCCC";
                case 9 -> snumber += "CM";
            }
            switch(dozens){
                case 1 -> snumber += "X";
                case 2 -> snumber += "XX";
                case 3 -> snumber += "XXX";
                case 4 -> snumber += "XL";
                case 5 -> snumber += "L";
                case 6 -> snumber += "LX";
                case 7 -> snumber += "LXX";
                case 8 -> snumber += "LXXX";
                case 9 -> snumber += "XC";
            }
            switch(unit){
                case 1 -> snumber += "I";
                case 2 -> snumber += "II";
                case 3 -> snumber += "III";
                case 4 -> snumber += "IV";
                case 5 -> snumber += "V";
                case 6 -> snumber += "VI";
                case 7 -> snumber += "VII";
                case 8 -> snumber += "VIII";
                case 9 -> snumber += "IX";
            }
        }
        return snumber;
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

    /**
     *Метод sub принимает один аргумент типа Roman
     *и возвращает результат вычитания двух римских цифр.
     *И присваевает это значение первому обьекту класса Roman
     **/
    public String sub(Roman other){
        return toRoman(this.NUMBER - other.NUMBER);
    }

    /**
     *Метод mul принимает один аргумент типа Roman
     *и возвращает результат умножения двух римских цифр.
     *И присваевает это значение первому обьекту класса Roman
     **/
    public String mul(Roman other){
        return toRoman(this.NUMBER * other.NUMBER);
    }

    /**
     *Метод div принимает один аргумент типа Roman
     *и возвращает результат целочисленного деления двух римских цифр.
     *И присваевает это значение первому обьекту класса Roman
     **/
    public String div(Roman other){
        return toRoman(this.NUMBER / other.NUMBER);
    }
}