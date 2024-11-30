package Lotto;

public class Application {
    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator();

        int[] playerLottoTicket = generator.getLottoTicket();

        int[] winningNumbers = generator.getWinningNumbers();
    }
}
