package Lotto;

public class Application {

    final int PRICE_OF_TICKET = 1000;

    public static void main(String[] args) {
        final int START_BUDGET = 10000;
        Application application = new Application();

        Budget budget = new Budget(START_BUDGET);
        int roundOfGame = 0;

        application.playGame(budget, roundOfGame);
    }

    private void playGame(Budget budget, int roundOfGame) {
        while (budget.getBudget() != 0) {
            roundOfGame++;
            start(budget, roundOfGame);
            budget.deductBudget(PRICE_OF_TICKET);

            WinningLevel level = lottoMachine(roundOfGame);

            budget.addPrize(level.getPrize());
            showRemainingBudget(budget);
        }
        System.out.println("예산을 모두 소진하여 게임을 종료합니다.");
    }

    private WinningLevel lottoMachine(int roundOfGame) {
        LottoGenerator generator = new LottoGenerator();
        LottoWinnerChecker checker = new LottoWinnerChecker();
        ResultPrinter printer = new ResultPrinter();

        int[] winningNumbers = generator.getWinningNumbers();
        int[] playerLottoTicket = generator.getLottoTicket();
        int bonusNumber = generator.getBonusNumber(winningNumbers);

        int countMatches = checker.countMatching(playerLottoTicket, winningNumbers);
        String matchingNumbers = checker.findMatchingNumbers(playerLottoTicket, winningNumbers);
        boolean hasBonus = checker.checkHasBonus(playerLottoTicket, bonusNumber);

        WinningLevel level = WinningLevel.findWinningLevel(countMatches, hasBonus);

        printer.printerController(winningNumbers, playerLottoTicket, bonusNumber, roundOfGame, countMatches, hasBonus, matchingNumbers, level);

        return level;
    }

    private void start(Budget budget, int roundOfGame) {
        System.out.println("플레이어 재산: " + budget.getFormattedBudget());
        System.out.println(roundOfGame + "회차 게임(-1,000원)");
    }

    private void showRemainingBudget(Budget budget) {
        System.out.println("플레이어 재산: " + budget.getFormattedBudget());
        System.out.println();
    }
}



