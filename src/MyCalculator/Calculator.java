package MyCalculator;

import java.util.Scanner;
import java.util.regex.Pattern;

import static MyCalculator.RomanNumbers.convertArabicToRoman;


public class Calculator {
    public static <calcString> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String calcString; //= scanner.nextLine();
        System.out.println("Для завершения введите off");
        do {
            calcString = scanner.nextLine();
            if (calcString.equals("") || calcString.equals("off")) break;
            String operand = null;
            String[] oper = null;
            if (calcString.contains("+")) {
                oper = calcString.split("\\+");
                operand = "+";
            } else if (calcString.contains("-")) {
                oper = calcString.split("\\-");
                operand = "-";
            } else if (calcString.contains("*")) {
                oper = calcString.split("\\*");
                operand = "*";
            } else if (calcString.contains("/")) {
                oper = calcString.split("/");
                operand = "/";
            }

            Pattern pattern = Pattern.compile("[IVX]+");
            Numbers first = null, second = null;

            if (pattern.matcher(oper[0]).find()) {
                first = new RomanNumbers(oper[0].trim());
            }
            if (pattern.matcher(oper[1]).find()) {
                second = new RomanNumbers(oper[1].trim());
            }
            if (!pattern.matcher(oper[0]).find()) {
                first = new ArabicNumbers(oper[0].trim());
            }
            if (!pattern.matcher(oper[1]).find()) {
                second = new ArabicNumbers(oper[1].trim());
            }
            if ((first.getNumberType()==Numbers.numberType.ARABIC
                    && second.getNumberType()==Numbers.numberType.ARABIC)) {
                System.out.println(Numbers.calc(first, second, operand));
            }
            if ((first.getNumberType()==Numbers.numberType.ROMAN)
                    && (second.getNumberType()==Numbers.numberType.ROMAN)) {
                System.out.println(convertArabicToRoman(Numbers.calc(first, second, operand)));
            }
            if ((first.getNumberType()==Numbers.numberType.ARABIC
                    && second.getNumberType()==Numbers.numberType.ROMAN)
                    || (first.getNumberType()==Numbers.numberType.ROMAN
                    && second.getNumberType()==Numbers.numberType.ARABIC)) {
                throw new NumberFormatException();
            }
        } while (!calcString.equals("off"));
    }
}

