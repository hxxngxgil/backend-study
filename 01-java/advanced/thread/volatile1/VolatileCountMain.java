package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        t.start();

        sleep(1000);

        task.flage = false;
        log("flag = " + task.flage + ", count = " + task.count + " in main");
    }

    static class MyTask implements Runnable {
        //boolean flage = true;
        //long count;
        volatile boolean flage = true;
        volatile long count;

        @Override
        public void run() {
            log("task 시작");
            while (flage) {
                count++;
                // 1억번에에 한버씩 출력
                if (count % 100_000_000 == 0) {
                    log("flag = " + flage + ", count = " + count + " in while()");
                }
            }
            log("flag = " + flage + ", count = " + count + " 종료");
        }
    }
}
