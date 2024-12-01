package Lotto;

public class ResultPrinter {

    public void printWinningNumbers(int[] winningNumbers, int bonusNumber) {
        System.out.print("로또 당첨 숫자: ");
        String lotto = joinArray(winningNumbers);
        System.out.print(lotto);
        System.out.println(" + 보너스 숫자 " + bonusNumber);
    }

    public void printPlayerLotto(int[] playerLottoTicket) {
        System.out.print("플레이어의 숫자: ");
        String lotto = joinArray(playerLottoTicket);
        System.out.println(lotto);
    }

    public void printLotteryResult(int match, boolean hasBonus) {
        WinningLevel level = WinningLevel.findWinningLevel(match, hasBonus);
        if (match == 5 && hasBonus) {
            System.out.print("결과: " + match + "개 일치, 보너스 번호 일치. ");
            System.out.println(level.getDescription());
            return;
        }
        System.out.print("결과: " + match + "개 일치. ");
        System.out.println(level.getDescription());
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
