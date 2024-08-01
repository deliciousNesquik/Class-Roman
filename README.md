# RomanNumeral <img src="https://github.com/user-attachments/assets/0de35ab3-9e32-4261-9dd8-b715dfe3d1d1" height="40"/> <br>Java Class <img src="https://github.com/user-attachments/assets/c1b0638f-718a-4e81-9c0b-0c8401b13df0" height="40"/>

**This Java application provides a comprehensive tool for working with Roman numerals. It allows users to convert between Roman and Arabic numerals, perform arithmetic operations such as addition, subtraction, multiplication, and division on Roman numerals, and retrieve the Roman numeral representation of an Arabic numeral stored within an instance of the Roman class.**


## Features
* Conversion: Convert Roman numerals to Arabic numerals and vice versa.
* Arithmetic Operations: Perform addition, subtraction, multiplication, and division on Roman numerals.
* Storage: Store the Arabic numeral equivalent of a Roman numeral within a Roman object instance.

## Usage
### Creating a Roman Object
There are three constructors available:
1. From an Arabic Numeral:<br>
```
Roman romanObject = new Roman("MMXXII");
```
3. From an Arabic Numeral:<br>
```
Roman romanObject = new Roman(2022);
```
5. From Another Roman Object:<br>
```
Roman original = new Roman("MMXXII");
Roman copy = new Roman(original);
```

## Conversion Methods
* Convert to Arabic Numeral:
```
int arabicNumeral = romanObject.toInt();
```
* Convert to Roman Numeral:
```
String romanNumeral = romanObject.toRoman();
```

## Arithmetic Operations
The Roman class provides methods for performing arithmetic operations on Roman numerals. These methods automatically handle the conversion between Roman and Arabic numerals as needed.
* Addition:
```
String result = romanObject.add(otherRomanObject);
```
* Subtraction:
```
String result = romanObject.sub(otherRomanObject);
```
* Multiplication:
```
String result = romanObject.mul(otherRomanObject);
```
* Division:
```
String result = romanObject.div(otherRomanObject);
```

These methods can also accept integers or strings representing Roman numerals as arguments.

## Example
```
public static void main(String[] args) {
    Roman roman1 = new Roman("MMXXII");
    Roman roman2 = new Roman("MDCCCXXXVII");

    System.out.println("Sum: " + roman1.add(roman2)); // Sum: MMXM
    System.out.println("Difference: " + roman1.sub(roman2)); // Difference: MMLXXXV
    System.out.println("Product: " + roman1.mul(roman2)); // Product: MMMMXCV
    System.out.println("Quotient: " + roman1.div(roman2)); // Quotient: MD
}
```

## Conclusion
The Roman class provides a robust framework for working with Roman numerals in Java, offering both conversion capabilities and support for basic arithmetic operations. This tool is ideal for educational purposes, historical studies, or any scenario where Roman numerals need to be manipulated programmatically.


