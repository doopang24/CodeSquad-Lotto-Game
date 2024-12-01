package Lotto;

public enum WinningLevel {
    FIRST(6, "1등입니다.", 1000000),
    SECOND(5, true, "2등입니다.", 100000),
    THIRD(5, "3등입니다.", 10000),
    FOURTH(4, "4등입니다.", 5000),
    FIFTH(3, "5등입니다.", 1000),
    NONE(0, "낙첨입니다.", 0);

    private final int matchingNumber;
    private final boolean bonus;
    private final String description;
    private final int prize;

    WinningLevel(int matchingNumber, boolean bonus, String description, int prize) {
        this.matchingNumber = matchingNumber;
        this.bonus = bonus;
        this.description = description;
        this.prize = prize;
    }

    WinningLevel(int matchingNumber, String description, int prize) {
        this(matchingNumber, false, description, prize);
    }

    public static WinningLevel findWinningLevel(int matchingNumber, boolean hasBonus) {
        for(WinningLevel level : values()) {
            if(level.matchingNumber == matchingNumber && (!level.bonus || hasBonus)) {
                return level;
            }
        }
        return NONE;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }

    public String getFormattedPrize() {
        return String.format("%,d원", getPrize());
    }
}
