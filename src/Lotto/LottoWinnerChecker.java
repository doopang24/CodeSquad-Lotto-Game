package Lotto;

public class LottoWinnerChecker {

    public int countMatching(int[] playerLottoTicket, int[] winningNumbers) {
        int count = 0;
        for (int target : playerLottoTicket) {
            for (int winningNumber : winningNumbers) {
                if (target == winningNumber) {
                    count++;
                }
            }
        }
        return count;
    }
}
