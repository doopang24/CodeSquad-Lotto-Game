package Lotto;

public class Application {
    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator();
        LottoWinnerChecker checker = new LottoWinnerChecker();
        ResultPrinter printer = new ResultPrinter();

        int[] winningNumbers = generator.getWinningNumbers();
        int[] playerLottoTicket = generator.getLottoTicket();
        int bonusNumber = generator.getBonusNumber(winningNumbers);

        int countMatch = checker.countMatching(playerLottoTicket, winningNumbers);
        boolean hasBonus = checker.checkHasBonus(playerLottoTicket, bonusNumber);

        printer.printWinningNumbers(winningNumbers, bonusNumber);
        printer.printPlayerLotto(playerLottoTicket);
        printer.printLotteryResult(countMatch, hasBonus);
    }
}
