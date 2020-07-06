package MyCalculator;

class ArabicNumbers extends Numbers {

    public ArabicNumbers() {
        value = 0;
        this.type = numberType.ARABIC;
    }

    public ArabicNumbers(ArabicNumbers number) {
        value = number.value;
        this.type = numberType.ARABIC;
    }

    public ArabicNumbers(String value) {
        this.value = Integer.valueOf(value);
        this.type = numberType.ARABIC;
    }

    @Override
    numberType getNumberType() {
        return type;
    }

    public void setNumberType(numberType type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    @Override
    void setValue(int value) {
        this.value = value;
    }

}
