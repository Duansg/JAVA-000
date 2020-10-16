import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Duansg
 * @desc CustomClassLoader
 * @date 2020/10/16 13:26
 */
public class CustomClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class<?> clazz = new CustomClassLoader().findClass("Hello");
            clazz.getMethod("hello").invoke(clazz.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(this.getClass().getResource("/Hello.xlass").getPath());
        byte[] bytes = new byte[(int) file.length()];
        int n = 0;
        int i = 0;
        try (FileInputStream fileInputStream = new FileInputStream(file)){
            while (n != -1 && i < file.length()){
                n = fileInputStream.read();
                bytes[i] = (byte)(255 - n);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

}