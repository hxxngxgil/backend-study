package method.ex;

public class MethodEx2Ref {

    public static void main(String[] args) {
        String message = "Hello, world!";

        printMeaags(message, 3);
        printMeaags(message, 5);
        printMeaags(message, 7);
    }

    public static void printMeaags(String message, int times) {
        for (int i = 0; i < times; i ++) {
            System.out.println(message);
        }
    }
}
