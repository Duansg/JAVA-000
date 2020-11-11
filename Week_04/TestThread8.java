import java.util.concurrent.CountDownLatch;

/**
 * TestThread8
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/11 11:34 下午
 */
public class TestThread8 {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static String str = null;

    /**
     * countDownLatch 方式
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            countDownLatch.countDown();
            str = getStr();
        }).start();
        countDownLatch.await();
        System.out.println(str);
    }

    public static String getStr() {
        return "hello world!";
    }

}
