package Lotto;

public class ResultPrinter {

    public void printPlayerLotto(int[] playerLottoTicket) {
        System.out.print("플레이어의 숫자: ");
        String lotto = joinArray(playerLottoTicket);
        System.out.println(lotto);
    }

    public void printWinningNumbers(int[] winningNumbers) {
        System.out.print("로또 당첨 숫자: ");
        String lotto = joinArray(winningNumbers);
        System.out.println(lotto);
    }

    public void printLotteryResult(int match) {
        System.out.println("일치한 숫자 개수: " + match + "개");
    }

    private String joinArray(int[] lotto) {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<lotto.length; i++) {
            builder.append(lotto[i]);
            if(i<lotto.length-1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }
}
