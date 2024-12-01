package Lotto;

public class Budget {

    private int budget;

    public Budget(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public String getFormattedBudget() {
        return String.format("%,d원", getBudget());
    }

    public int deductBudget(int ticketPrice) {
        budget = budget - ticketPrice;
        return budget;
    }

    public int addPrize(int prize) {
        budget = budget + prize;
        return budget;
    }
}
