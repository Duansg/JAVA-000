import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Thread7
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/11 11:00 下午
 */
public class TestThread7 {

    private static Lock lock = new ReentrantLock();

    private static Condition calComplete = lock.newCondition();

    private static String str = null;

    /**
     * lock方式
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        try{
            lock.lock();
            new Thread(() -> {
                lock.lock();
                try {
                    str = getStr();
                    calComplete.signal();
                } finally {
                    lock.unlock();
                }
            }).start();
            while (null == str) {
                calComplete.await();
            }
        }finally {
            lock.unlock();
        }
        System.out.println(str);
    }

    /**
     *
     * @return
     */
    private static String getStr() {
        return "hello world!";
    }
}
