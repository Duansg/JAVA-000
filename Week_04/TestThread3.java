import java.util.concurrent.*;

/**
 * TestThread3
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/11 9:55 下午
 */
public class TestThread3 {

    private static String str = null;

    /**
     * 普通方式
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new Thread(() -> str = getStr());
        thread.start();
        while (null==str||"".equals(str)){}
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
