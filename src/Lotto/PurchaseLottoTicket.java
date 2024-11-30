package Lotto;

import java.util.Scanner;

public class PurchaseLottoTicket {

    public int[] getLottoTicket() {
        System.out.println("1~45 중 로또 번호를 여섯개 입력하세요.");
        int[] lottoTicket = new int[6];
        for (int i=0; i<lottoTicket.length; i++) {
            int lottoNumber = validateLottoNumbers(lottoTicket);
            lottoTicket[i] = lottoNumber;
        }
        return lottoTicket;
    }

    private int validateLottoNumbers(int[] lottoTicket) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int inputNumber = Integer.parseInt(scanner.nextLine());
                if (!isUnique(inputNumber, lottoTicket)) {
                    System.out.println("같은 번호 " + inputNumber + "이 이미 선택되었습니다. 다른 번호를 선택하세요.");
                    continue;
                }
                return inputNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("유효한 로또 번호를 입력해주세요.");
            }
        }
    }


    private boolean isUnique(int inputNumber, int[] lottoTicket) {
        for (int lottoNumber : lottoTicket) {
            if (lottoNumber == inputNumber) {
                return false;
            }
        }
        return true;
    }
}
