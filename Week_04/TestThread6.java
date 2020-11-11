import java.util.concurrent.Semaphore;

/**
 * TestThread6
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/11 10:41 下午
 */
public class TestThread6 {

    public static String str = null;

    public static final Semaphore s = new Semaphore(1);

    /**
     * Semaphore 方式
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        s.acquire();
        new Thread(() -> {
            str = getStr();
            s.release();
        }).start();
        s.acquire();
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
