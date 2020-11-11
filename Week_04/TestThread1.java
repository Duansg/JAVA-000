import java.util.concurrent.*;

/**
 * TestThread1
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/11 9:55 下午
 */
public class TestThread1 {

    /**
     * Future 方式
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future future = executor.submit((Callable) () -> getStr());
        System.out.println(future.get());
    }

    /**
     *
     * @return
     */
    private static String getStr() {
        return "hello world!";
    }
}
