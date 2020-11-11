/**
 * TestThread5
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/11 10:24 下午
 */
public class TestThread5 {

    private volatile String str = null;

    /**
     * notifyAll 方式
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        TestThread5 testThread5 = new TestThread5();
        new Thread(() -> testThread5.getStr()).start();
        System.out.println(testThread5.getValue());

    }

    synchronized public void getStr() {
        str = "hello world!";
        notifyAll();
    }

    synchronized public String getValue() throws InterruptedException {
        while (null == str){
            wait();
        }
        return str;
    }


}
