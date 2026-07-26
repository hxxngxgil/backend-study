package lambda.start;

public class Ex0RefMain {

    public static void hello(String str) {
        System.out.println("프로그램 시작");
        System.out.println("hello " + str);
        System.out.println("프로그램 종료");
    }

    static void main(String[] args) {
        hello("Java");
        hello("Spring");
    }
}
