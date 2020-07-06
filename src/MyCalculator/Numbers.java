package MyCalculator;

abstract class Numbers {

    int value;

    static enum numberType {ARABIC, ROMAN};

    numberType type;

    abstract int getValue();

    abstract void setValue(int value);

    abstract numberType getNumberType();

    abstract void setNumberType(numberType type);

    static int calc(Numbers first, Numbers second, String operand) {
        switch (operand) {
            case "+": {
                return first.value + second.value;
            }
            case "-": {
                return first.value - second.value;
            }
            case "*": {
                return first.value * second.value;
            }
            case "/": {
                return first.value / second.value;
            }
            default:
                return 0;
        }
    }
}
