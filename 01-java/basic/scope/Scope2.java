package scope;

public class Scope2 {

    public static void main(String[] args) {
        int m = 10;

        for (int i = 0; i < 2; i++) {   //for문 블록 내부
            System.out.println("for m = " + m);
            System.out.println("for i = " + i);
        }   //i 생존 종료

        System.out.println("for m = " + m);
        //System.out.println("for i = " + i); //i 접근 불가
    }
}
