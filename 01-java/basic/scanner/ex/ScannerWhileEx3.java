package scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        int number = 0;
        double average;

        System.out.println("숫자를 입력하세요. 입력을 중단하려면 -1을 입력하세요:");

        /*
        while (true) {
            number = scanner.nextInt();

            if (number == -1) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            count++;
            sum += number;
        }
        */

        //코드 축소 버전
        while ((number = scanner.nextInt()) != -1) {
            sum += number;
            count++;
        }

        average = (double) sum / count;

        System.out.println("입력한 숫자들의 합계: " + sum);
        System.out.println("입력한 숫자들의 평균: " + average);
    }
}
