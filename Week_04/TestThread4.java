/**
 * TestThread4
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/11 10:20 下午
 */
public class TestThread4 {

    private static String str = null;

    /**
     * join方式
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> str = getStr());
        thread.start();
        thread.join();
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
