package cat.itacademy.s05.t01.enums;

public enum Suit {
    HEARTS("❤️"),
    DIAMONDS("♦️"),
    CLUBS("♣️"),
    SPADES("♠️");

    private final String emoji;

    Suit(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }
}