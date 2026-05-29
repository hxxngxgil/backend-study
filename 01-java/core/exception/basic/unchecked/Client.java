package exception.basic.unchecked;

public class Client {
    public void call() {

        //문제 발생
        throw new MyUncheckedException("ex");
    }
}
