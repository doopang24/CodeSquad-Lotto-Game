package Lotto;

public class Budget {

    private final int BUDGET;

    public Budget(int budget) {
        this.BUDGET = budget;
    }

    public int getBudget() {
        return BUDGET;
    }

    public String getFormattedBudget() {
        return String.format("%,d원", getBudget());
    }
}
