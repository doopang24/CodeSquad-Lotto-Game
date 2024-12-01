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

    public void deductBudget(int ticketPrice) {
        budget = budget - ticketPrice;
    }

    public void addPrize(int prize) {
        budget = budget + prize;
    }
}
