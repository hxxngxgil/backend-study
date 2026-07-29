package lambda.ex1;

import lambda.Procedure;

import java.util.Arrays;

public class M4MeasureTime {

    static void measure(Procedure procedure) {
        long startNs = System.nanoTime();
        procedure.run();
        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - startNs) + "ns");
    }

    static void main(String[] args) {
        measure(() -> {
                int num = 100;
                int sum = 0;
                for (int i = 0; i <= num; i++) {
                    sum += i;
                }
                System.out.println("[1부터 " + num + "까지 합] 결과: " + sum);
            });

        measure(() -> {
                int[] arr = {4, 3, 2, 1};
                System.out.println("원본 배열: " + Arrays.toString(arr));
                Arrays.sort(arr);
                 System.out.println("배열 정렬: " + Arrays.toString(arr));
            });
    }
}
