package Lotto;

public class ResultPrinter {

    public void printWinningNumbers(int[] winningNumbers, int bonusNumber, int roundOfGame) {
        System.out.print(roundOfGame + "회차 당첨번호: ");
        String lotto = joinArray(winningNumbers);
        System.out.print(lotto);
        System.out.println(" + 보너스 숫자 " + bonusNumber);
    }

    public void printPlayerLotto(int[] playerLottoTicket) {
        System.out.print("플레이어의 숫자: ");
        String lotto = joinArray(playerLottoTicket);
        System.out.println(lotto);
    }

    public void printLotteryResult(int countMatches, int bonusNumber, boolean hasBonus, String matchingNumbers, WinningLevel level) {
        if (countMatches == 5 && hasBonus) {
            System.out.println("결과: " + countMatches + "개 일치! 보너스 번호 일치! "
                    + "(" + matchingNumbers + " + " + bonusNumber + ")");
            System.out.println(level.getDescription() + " (+" + level.getFormattedPrize() + ")");
            return;
        } else if (countMatches == 0) {
            System.out.println("당첨번호 " + countMatches + "개 일치");
            System.out.println(level.getDescription() + " (+" + level.getFormattedPrize() + ")");
            return;
        }
        System.out.println("당첨번호 " + countMatches + "개 일치! " + "(" + matchingNumbers + ")");
        System.out.println(level.getDescription() + " (+" + level.getFormattedPrize() + ")");
    }

    private String joinArray(int[] lotto) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lotto.length; i++) {
            builder.append(lotto[i]);
            if (i < lotto.length - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }
}
