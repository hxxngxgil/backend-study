package lambda.lambda1;

import lambda.MyFunction;

public class LambdaSimple4 {

    static void main(String[] args) {
        MyCall call1 = (int value) -> value * 2;    // 기본
        MyCall call2 = (num) -> num * 2;    // 타입 추론
        MyCall call3 = num -> num * 2;

        System.out.println("call3 = " + call3.call(10));
    }

    @FunctionalInterface
    interface MyCall {
        int call(int num);
    }
}
