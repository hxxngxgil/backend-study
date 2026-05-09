package lang.math.ex;

import java.util.Random;

public class LottoGenerator {
    private final Random random = new Random();
    private int[] lottoNumbers;
    private int count;

    public int[] generate() {
        lottoNumbers = new int[6];
        count = 0;

        // 1 ~ 45 번호 추첨
        while (count < 6) {
            int number = random.nextInt(45) + 1;

            // 중복이 아닐경우 번호 배열에 추가
            if (isUnique(number)) {
                lottoNumbers[count] = number;
                count++;
            }
        }
        return lottoNumbers;
    }

    //번호 중복검사
    private boolean isUnique(int number) {
        for (int i = 0; i < count; i++) {
            if (lottoNumbers[i] == number) {
                return false;
            }
        }
        return true;
    }
}
