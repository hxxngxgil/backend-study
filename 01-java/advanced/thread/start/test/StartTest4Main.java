package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintWork("A", 1000), "Thread-A");
        Thread threadB = new Thread(new PrintWork("B", 1000), "Thread-B");
        threadA.start();
        threadB.start();
    }

    static class PrintWork implements Runnable {

        private String content;
        private int sleepMas;

        public PrintWork(String content, int sleepMas) {
            this.content = content;
            this.sleepMas = sleepMas;
        }

        @Override
        public void run() {
            while (true) {
                log(content);
                try {
                    Thread.sleep(sleepMas);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
