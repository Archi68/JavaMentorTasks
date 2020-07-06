package MyCalculator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RomanNumbers extends Numbers {

    public RomanNumbers(){//конструктор
        this.type = Numbers.numberType.ROMAN;
    } //конструктор

    public RomanNumbers(String strRomanNumber) {
        this.type = Numbers.numberType.ROMAN;
        this.value = romanToArabic(strRomanNumber);
    }

    public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<enumRomanNumber> romanNumerals = enumRomanNumber.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            enumRomanNumber symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;
    }

    public int convertRomanToArabic(RomanNumbers romanNumber) {
        this.setValue(romanNumber.value);
        return this.getValue();
    }
    enum enumRomanNumber {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10),
        XI(11), XII(12), XIII(13), XIV(14), XV(15), XVI(16), XVII(17), XVIII(18),
        XIX(19), XX(20), XXI(21), XXII(22), XXIII(23), XXIV(24), XXV(25), XXVI(26),
        XXVII(27), XXVIII(28), XXIX(29), XXX(30), XXXI(31), XXXII(32), XXXIII(33),
        XXXIV(34), XXXV(35), XXXVI(36), XXXVII(37), XXXVIII(38), XXXIX(39), XL(40),
        L(50), LX(60), LXX(70), LXXX(80), XC(90), C(100);

        private int ind;

        enumRomanNumber(int ind) {
            this.ind = ind;
        }

        public static enumRomanNumber get(int ind) { //get(ind)
            for (enumRomanNumber a : enumRomanNumber.values()) {
                if (a.ind==ind)
                    return a;
            }
            throw new IllegalArgumentException("Invalid ind");
        }

        public static List<enumRomanNumber> getReverseSortedValues() {
            return Arrays.stream(values())
                         .sorted(Comparator.comparing((enumRomanNumber e) -> e.ind).reversed())
                         .collect(Collectors.toList());
        }

        public int getValue() {
            return ind;
        }
    } //enum

    public static String convertArabicToRoman(int number) {
        if ((number % 10) == 0 && number <= 100) {
            return enumRomanNumber.get(number).toString();
        } else if (number < 10) {
            return enumRomanNumber.get(number).toString();
        } else if (number > 10 && number < 20) {
            return enumRomanNumber.get(10).toString().concat(enumRomanNumber.get(number % 10).toString());
        } else if (number > 20 && number < 30) {
            return enumRomanNumber.get(20).toString().concat(enumRomanNumber.get(number % 10).toString());
        } else if (number > 30 && number < 40) {
            return enumRomanNumber.get(30).toString().concat(enumRomanNumber.get(number % 10).toString());
        } else if (number > 40 && number < 50) {
            return enumRomanNumber.get(40).toString().concat(enumRomanNumber.get(number % 10).toString());
        } else if (number > 50 && number < 60) {
            return enumRomanNumber.get(50).toString().concat(enumRomanNumber.get(number % 10).toString());
        } else if (number > 60 && number < 70) {
            return enumRomanNumber.get(60).toString().concat(enumRomanNumber.get(number % 10).toString());
        } else if (number > 70 && number < 80) {
            return enumRomanNumber.get(70).toString().concat(enumRomanNumber.get(number % 10).toString());
        } else if (number > 80 && number < 90) {
            return enumRomanNumber.get(80).toString().concat(enumRomanNumber.get(number % 10).toString());
        } else if (number > 90 && number < 100) {
            return enumRomanNumber.get(90).toString().concat(enumRomanNumber.get(number % 10).toString());
        } else if (number > 100) {
            throw new NumberFormatException();
        }
        return null;
    }

    @Override
    int getValue() {
        return value;
    }

    @Override
    void setValue(int value) {
        this.value = value;
    }

    @Override
    numberType getNumberType() {
        return type;
    }

    @Override
    void setNumberType(numberType type) {
        this.type = type;
    }
}
