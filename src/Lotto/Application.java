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
        LottoGenerator generator = new LottoGenerator();
        LottoWinnerChecker checker = new LottoWinnerChecker();
        ResultPrinter printer = new ResultPrinter();
        while (budget.getBudget() != 0) {
            roundOfGame++;
            start(budget, roundOfGame);
            budget.deductBudget(PRICE_OF_TICKET);

            int[] winningNumbers = generator.getWinningNumbers();       // 당첨번호 생성
            int[] playerLottoTicket = generator.getLottoTicket();       // 플레이어의 로또 번호 셍상
            int bonusNumber = generator.getBonusNumber(winningNumbers); // 보너스 번호 생성

            int countMatches = checker.countMatching(playerLottoTicket, winningNumbers);    // 번호가 몇 개가 맞는지 카운트
            String matchingNumbers = checker.findMatchingNumbers(playerLottoTicket, winningNumbers);    // 맞는 번호들 배열로 반환
            boolean hasBonus = checker.checkHasBonus(playerLottoTicket, bonusNumber);       // 로또에 보너스 번호를 가지고 있는지 여부

            WinningLevel level = WinningLevel.findWinningLevel(countMatches, hasBonus);     // 로또가 어느 당첨 등수인지

            printer.printWinningNumbers(winningNumbers, bonusNumber, roundOfGame);                  // 당첨 번호 출력
            printer.printPlayerLotto(playerLottoTicket);                                            // 플레이어의 로또 출력
            printer.printLotteryResult(countMatches, bonusNumber, hasBonus, matchingNumbers, level);// 로또 게임의 결과 출력

            budget.addPrize(level.getPrize());  // 받은 상금을 재산에 추가
            showRemainingBudget(budget);
        }
        System.out.println("예산을 모두 소진하여 게임을 종료합니다.");
    }

    private void start(Budget budget, int roundOfGame) {
        System.out.println("플레이어 재산: " + budget.getFormattedBudget());
        System.out.println(roundOfGame + "회차 게임(-1000원)");
    }

    private void showRemainingBudget(Budget budget) {
        System.out.println("플레이어 재산: " + budget.getFormattedBudget());  //
        System.out.println();
    }
}



