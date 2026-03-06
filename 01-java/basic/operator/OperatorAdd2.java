package operator;

public class OperatorAdd2 {

    public static void main(String[] args) {
        // 전위 증감 연산자
        int a = 1;
        int b = 0;

        b = ++a;    // a값을 먼저 증가 후 b대입
        System.out.println("a = " + a + ", b = " + b);

        // 후위 증감 연산자
        a = 1;
        b = 0;

        b = a++;    // a의 현재 값을 b에 먼저 대입 후 a값 증가
        System.out.println("a = " + a + ", b = " + b);
    }
}
