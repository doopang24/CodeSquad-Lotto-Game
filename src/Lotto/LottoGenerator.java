package Lotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class LottoGenerator {

    private final int RANDOM_BOUND = 45;
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public int[] getLottoTicket() {
        System.out.println("플레이어는 로또 번호 여섯개를 엔터키를 사용해서 입력하세요.");
        int[] lottoTicket = new int[6];
        for (int i = 0; i < lottoTicket.length; i++) {
            int lottoNumber = validateLottoNumbers(lottoTicket);
            lottoTicket[i] = lottoNumber;
        }
        Arrays.sort(lottoTicket);
        return lottoTicket;
    }

    private int validateLottoNumbers(int[] lottoTicket) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int inputNumber = Integer.parseInt(scanner.nextLine());
                if (isDuplicated(inputNumber, lottoTicket)) {
                    System.out.println("같은 번호 " + inputNumber + "이 이미 선택되었습니다. 다른 번호를 선택하세요.");
                    continue;
                } else if (inputNumber < 1 || inputNumber > 45) {
                    System.out.println("1부터 45 사이의 숫자를 입력해주세요.");
                    continue;
                }
                return inputNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("유효한 로또 번호를 입력해주세요.");
            }
        }
    }

    public int[] getWinningNumbers() {
        int[] winningNumbers = new int[6];
        for (int i = 0; i < winningNumbers.length; i++) {
            int winningNumber = validateWinningNumber(winningNumbers);
            winningNumbers[i] = winningNumber;
        }
        Arrays.sort(winningNumbers);
        return winningNumbers;
    }

    private int validateWinningNumber(int[] winningNumbers) {
        while (true) {
            int winningNumber = random.nextInt(RANDOM_BOUND) + 1;
            if (isDuplicated(winningNumber, winningNumbers)) {
                continue;
            }
            return winningNumber;
        }
    }

    public int getBonusNumber(int[] winningNumbers) {
        while (true) {
            int bonusNumber = random.nextInt(RANDOM_BOUND) + 1;
            if (isValidBonusNumber(winningNumbers, bonusNumber)) {
                return bonusNumber;
            }
        }
    }

    private boolean isDuplicated(int inputNumber, int[] lottoTicket) {
        for (int lottoNumber : lottoTicket) {
            if (lottoNumber == inputNumber) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidBonusNumber(int[] winningNumbers, int bonusNumber) {
        boolean check = true;
        for (int winningNumber : winningNumbers) {
            if (winningNumber == bonusNumber) {
                return false;
            }
        }
        return check;
    }
}
