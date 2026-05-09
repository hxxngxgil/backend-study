package lang.string.ex;

public class TestString04 {

    public static void main(String[] args) {
        String str = "hello.txt";

        String filename = str.substring(0, 5);
        String extName = str.substring(5, 9);

        System.out.println("filename = " + filename);
        System.out.println("extName = " + extName);

    }
}
