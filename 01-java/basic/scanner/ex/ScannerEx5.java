package scanner.ex;

import java.util.Scanner;

public class ScannerEx5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요:");
        int num1 = scanner.nextInt();

        System.out.print("두 번째 숫자를 입력하세요:");
        int num2 = scanner.nextInt();

        /* 수업 정답
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
         */

        // 개인적으로 변수는 추후에 구분을 위해 정확한 명칭으로 구분해야한다고 생각해 max, min 변수를 선언했다.
        int max = num1 > num2 ? num1 : num2;
        int min = num1 < num2 ? num1 : num2;

        System.out.print("두 숫자 사이의 모든 정수:");

        //초기값을 주지않고 min에 증감연산자를 사용해도 좋지만 최소값과 최대값은 경험상 나중에도 사용하는 경우가 있어 이런 방식을 선호한다.
        for (int i = min; i <= max; i++) {
            System.out.print(i);

            if (i != max) {
                System.out.print(", ");
            }
        }
    }
}
