import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TestThread9
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/11 11:41 下午
 */
public class TestThread9 {

    static CyclicBarrier barrier = new CyclicBarrier(3);

    private static String str = null;

    /**
     * CyclicBarrier 方式
     * @param args
     * @throws BrokenBarrierException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(() -> {
            try {
                str = getStr();
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        barrier.await();
        System.out.println(str);
    }
    public static String getStr() {
        new Thread(() -> {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        return "hello world!";
    }
}
