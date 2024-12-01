package Lotto;

public class Application {
    public static void main(String[] args) {

        final int START_BUDGET = 10000;

        Budget budget = new Budget(START_BUDGET);
        Application application = new Application();

        int roundOfGame = 0;
        application.start(budget, roundOfGame);
    }

    private void start(Budget budget, int roundOfGame) {
        while (budget.getBudget()!=0) {

            final int PRICE_OF_TICKET = 1000;

            LottoGenerator generator = new LottoGenerator();
            LottoWinnerChecker checker = new LottoWinnerChecker();
            ResultPrinter printer = new ResultPrinter();

            System.out.println("플레이어 재산: " + budget.getFormattedBudget());
            roundOfGame++;
            System.out.println(roundOfGame + "회차 게임(-1000원)");
            budget.deductBudget(PRICE_OF_TICKET);

            int[] winningNumbers = generator.getWinningNumbers();
            int[] playerLottoTicket = generator.getLottoTicket();
            int bonusNumber = generator.getBonusNumber(winningNumbers);

            int countMatches = checker.countMatching(playerLottoTicket, winningNumbers);
            String matchingNumbers = checker.findMatchingNumbers(playerLottoTicket, winningNumbers);
            boolean hasBonus = checker.checkHasBonus(playerLottoTicket, bonusNumber);

            WinningLevel level = WinningLevel.findWinningLevel(countMatches, hasBonus);

            printer.printWinningNumbers(winningNumbers, bonusNumber, roundOfGame);
            printer.printPlayerLotto(playerLottoTicket);
            printer.printLotteryResult(countMatches, bonusNumber, hasBonus, matchingNumbers, level);

            budget.addPrize(level.getPrize());

            System.out.println("플레이어 재산: " + budget.getFormattedBudget());
            System.out.println();
        }
    }
}
