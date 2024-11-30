package Lotto;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        PurchaseLottoTicket purchase = new PurchaseLottoTicket();

        int[] playerLottoTicket = purchase.getLottoTicket();
        System.out.println(Arrays.toString(playerLottoTicket));
    }
}
