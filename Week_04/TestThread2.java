import java.util.concurrent.*;

/**
 * TestThread2
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/11 9:55 下午
 */
public class TestThread2 {
    /**
     * FutureTask 方式
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(() -> getStr());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }

    /**
     *
     * @return
     */
    private static String getStr() {
        return "hello world!";
    }
}
