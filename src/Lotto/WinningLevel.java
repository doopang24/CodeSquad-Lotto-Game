package Lotto;

public enum WinningLevel {
    FIRST(6, "1등입니다."),
    SECOND(5, true, "2등입니다."),
    THIRD(5, "3등입니다."),
    FOURTH(4, "4등입니다."),
    FIFTH(3, "5등입니다."),
    NONE(0, "낙첨입니다.");

    private final int matchingNumber;
    private final boolean bonus;
    private final String description;

    WinningLevel(int matchingNumber, boolean bonus, String description) {
        this.matchingNumber = matchingNumber;
        this.bonus = bonus;
        this.description = description;
    }

    WinningLevel(int matchingNumber, String description) {
        this(matchingNumber, false, description);
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
}
