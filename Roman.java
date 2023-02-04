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
    private int NUMBER = 0; /**Переменная для хранения римского числа в арабской форме исчисления*/
    private String SNUMBER = ""; /**Переменная для хранения римского числа в форме строки*/
    
    private static final Map<Character, Integer> map = new HashMap<>(); //хранение чисел (римские: обычные)
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
        String s;
        if(roman.charAt(0) == '-'){
            s = roman.replace("-", "");
        }
        else{
            s = roman;
        }
       
        for(int i = s.length() - 1, before = 0; i >= 0; i--){
            int current = map.get(s.charAt(i)); // текущеее число
            
            if(current < before){
                this.NUMBER -= current;
            }
            else{
                this.NUMBER += current;
            }
            
            before = current;
        }
        IntToRoman(this.NUMBER);
    }
    
    /**
     *Конструктор класса Roman принимает один аргумент типа int,
     * который представляет римскую цифру. Если аргумент меньше нуля,
     * то он будет преобразован в положительное число. Если аргумент равен нулю,
     * то он будет преобразован в единицу.
     */
    Roman(int roman){
        if(roman < 0){
            roman *= -1;
        }
        else if(roman == 0){
            roman = 1;
        }
        
        this.NUMBER = roman;
        IntToRoman(this.NUMBER);
    }

    /**
     *Метод RomanToInt преобразует римское число в арабское.
     */
    private void RomanToInt(String roman){
        String s = roman;
        int number = 0; // хранение числа в конструкторе
        int before = 0; // предыдущее число
        
        for(int i = s.length() - 1; i >= 0; i--){
            int current = map.get(s.charAt(i)); // текущеее число
            
            if(current < before){
                number -= current;
            }
            else{
                number += current;
            }
            
            before = current;
        }
        this.NUMBER = number;
    }
    
    /**
     *Метод IntToRoman преобразует арабское число в римское.
     */
    private void IntToRoman(int NUMBER){
        this.SNUMBER = "";
        
        if(NUMBER >= 1 && NUMBER <= 10){
            switch(NUMBER){
                case 1 -> this.SNUMBER += "I";
                case 2 -> this.SNUMBER += "II";
                case 3 -> this.SNUMBER += "III";
                case 4 -> this.SNUMBER += "IV";
                case 5 -> this.SNUMBER += "V";
                case 6 -> this.SNUMBER += "VI";
                case 7 -> this.SNUMBER += "VII";
                case 8 -> this.SNUMBER += "VIII";
                case 9 -> this.SNUMBER += "IX";
                case 10 -> this.SNUMBER += "X";
            }
        }
        else if(NUMBER >= 11 && NUMBER <= 99){
            int unit = NUMBER % 10;
            int dozens = (NUMBER / 10) % 10;
            
            switch(dozens){
                case 1 -> this.SNUMBER += "X";
                case 2 -> this.SNUMBER += "XX";
                case 3 -> this.SNUMBER += "XXX";
                case 4 -> this.SNUMBER += "XL";
                case 5 -> this.SNUMBER += "L";
                case 6 -> this.SNUMBER += "LX";
                case 7 -> this.SNUMBER += "LXX";
                case 8 -> this.SNUMBER += "LXXX";
                case 9 -> this.SNUMBER += "XC";
            }
            switch(unit){
                case 1 -> this.SNUMBER += "I";
                case 2 -> this.SNUMBER += "II";
                case 3 -> this.SNUMBER += "III";
                case 4 -> this.SNUMBER += "IV";
                case 5 -> this.SNUMBER += "V";
                case 6 -> this.SNUMBER += "VI";
                case 7 -> this.SNUMBER += "VII";
                case 8 -> this.SNUMBER += "VIII";
                case 9 -> this.SNUMBER += "IX";
            }
        }
        else if(NUMBER >= 100 && NUMBER <= 999){
            int unit = NUMBER % 10;
            int dozens = (NUMBER / 10) % 10;
            int hundreds = ((NUMBER / 10) / 10) % 10;
            
            switch(hundreds){
                case 1 -> this.SNUMBER += "C";
                case 2 -> this.SNUMBER += "CC";
                case 3 -> this.SNUMBER += "CCC";
                case 4 -> this.SNUMBER += "CD";
                case 5 -> this.SNUMBER += "D";
                case 6 -> this.SNUMBER += "DC";
                case 7 -> this.SNUMBER += "DCC";
                case 8 -> this.SNUMBER += "DCCC";
                case 9 -> this.SNUMBER += "CM";
            }
            switch(dozens){
                case 1 -> this.SNUMBER += "X";
                case 2 -> this.SNUMBER += "XX";
                case 3 -> this.SNUMBER += "XXX";
                case 4 -> this.SNUMBER += "XL";
                case 5 -> this.SNUMBER += "L";
                case 6 -> this.SNUMBER += "LX";
                case 7 -> this.SNUMBER += "LXX";
                case 8 -> this.SNUMBER += "LXXX";
                case 9 -> this.SNUMBER += "XC";
            }
            switch(unit){
                case 1 -> this.SNUMBER += "I";
                case 2 -> this.SNUMBER += "II";
                case 3 -> this.SNUMBER += "III";
                case 4 -> this.SNUMBER += "IV";
                case 5 -> this.SNUMBER += "V";
                case 6 -> this.SNUMBER += "VI";
                case 7 -> this.SNUMBER += "VII";
                case 8 -> this.SNUMBER += "VIII";
                case 9 -> this.SNUMBER += "IX";
            }
        }
        else if(NUMBER >= 1000 && NUMBER <= 10000){
            int unit = NUMBER % 10;
            int dozens = (NUMBER / 10) % 10;
            int hundreds = ((NUMBER / 10) / 10) % 10;
            int thousands = (((NUMBER / 10) / 10) / 10) % 10;
            
            
            switch(thousands){
                case 1 -> this.SNUMBER += "M";
                case 2 -> this.SNUMBER += "MM";
                case 3 -> this.SNUMBER += "MMM";
                case 4 -> this.SNUMBER += "MMMM";
                case 5 -> this.SNUMBER += "MMMMM";
                case 6 -> this.SNUMBER += "MMMMMM";
                case 7 -> this.SNUMBER += "MMMMMMM";
                case 8 -> this.SNUMBER += "MMMMMMMM";
                case 9 -> this.SNUMBER += "MMMMMMMMM";
                case 10 -> this.SNUMBER += "MMMMMMMMMM";
            }
            switch(hundreds){
                case 1 -> this.SNUMBER += "C";
                case 2 -> this.SNUMBER += "CC";
                case 3 -> this.SNUMBER += "CCC";
                case 4 -> this.SNUMBER += "CD";
                case 5 -> this.SNUMBER += "D";
                case 6 -> this.SNUMBER += "DC";
                case 7 -> this.SNUMBER += "DCC";
                case 8 -> this.SNUMBER += "DCCC";
                case 9 -> this.SNUMBER += "CM";
            }
            switch(dozens){
                case 1 -> this.SNUMBER += "X";
                case 2 -> this.SNUMBER += "XX";
                case 3 -> this.SNUMBER += "XXX";
                case 4 -> this.SNUMBER += "XL";
                case 5 -> this.SNUMBER += "L";
                case 6 -> this.SNUMBER += "LX";
                case 7 -> this.SNUMBER += "LXX";
                case 8 -> this.SNUMBER += "LXXX";
                case 9 -> this.SNUMBER += "XC";
            }
            switch(unit){
                case 1 -> this.SNUMBER += "I";
                case 2 -> this.SNUMBER += "II";
                case 3 -> this.SNUMBER += "III";
                case 4 -> this.SNUMBER += "IV";
                case 5 -> this.SNUMBER += "V";
                case 6 -> this.SNUMBER += "VI";
                case 7 -> this.SNUMBER += "VII";
                case 8 -> this.SNUMBER += "VIII";
                case 9 -> this.SNUMBER += "IX";
            }
        }
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
        RomanToInt(SNUMBER);
    }
    
    /**
     *Метод set принимает один аргумент типа int,
     *который представляет арабское число. Он устанавливает
     *значение поля NUMBER и вызывает метод IntToRoman для
     *преобразования арабского числа в римское.
     **/
    public void set(int n){
        IntToRoman(n);
        this.NUMBER = n;
    }
    
    /**
     *Метод add принимает два аргумента типа Roman
     *и возвращает результат сложения двух римских цифр.
     **/
    public String add(Roman other){
        
        this.NUMBER = this.NUMBER + other.NUMBER;
        IntToRoman(this.NUMBER);
        return this.SNUMBER;
    }

    /**
     *Метод sub принимает два аргумента типа Roman
     *и возвращает результат вычитания двух римских цифр.
     **/
    public String sub(Roman other){
        
        this.NUMBER = this.NUMBER - other.NUMBER;
        IntToRoman(this.NUMBER);
        return this.SNUMBER;
    }
    
    /**
     *Метод mul принимает два аргумента типа Roman
     *и возвращает результат умножения двух римских цифр.
     **/
    public String mul(Roman other){
        
        this.NUMBER = this.NUMBER * other.NUMBER;
        IntToRoman(this.NUMBER);
        return this.SNUMBER;
    }

    /**
     *Метод div принимает два аргумента типа Roman
     *и возвращает результат деления двух римских цифр.
     **/
    public String div(Roman other){
        this.NUMBER = this.NUMBER / other.NUMBER;
        IntToRoman(this.NUMBER);
        return this.SNUMBER;
    }
}