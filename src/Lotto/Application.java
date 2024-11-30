package Lotto;

public class Application {
    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator();
        LottoWinnerChecker checker = new LottoWinnerChecker();
        ResultPrinter printer = new ResultPrinter();

        int[] winningNumbers = generator.getWinningNumbers();
        int[] playerLottoTicket = generator.getLottoTicket();
        int countMatch = checker.countMatching(playerLottoTicket, winningNumbers);

        printer.printWinningNumbers(winningNumbers);
        printer.printPlayerLotto(playerLottoTicket);
        printer.printLotteryResult(countMatch);
    }
}
