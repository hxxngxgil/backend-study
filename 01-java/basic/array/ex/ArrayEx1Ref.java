package array.ex;

public class ArrayEx1Ref {

    public static void main(String[] args) {
        int[] students = {90, 80, 70, 60, 50};
        int total = 0;
        double average;

        for (int i = 0; i < students.length; i++) {
            total += students[i];
        }

        average = (double) total / students.length;
        System.out.println("점수 총합: " + total);
        System.out.println("점수 평균: " + average);
    }
}
