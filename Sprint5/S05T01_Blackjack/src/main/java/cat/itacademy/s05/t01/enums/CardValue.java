package cat.itacademy.s05.t01.enums;

public enum CardValue {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
    JACK(10), QUEEN(10), KING(10), ACE(1);

    private final int value;

    CardValue(int value){
        this.value = value;
    }

    public int getCardValue(){
        return this.value;
    }
}
