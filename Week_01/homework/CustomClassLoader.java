import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *  自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内 容是一个 Hello.class 文件所有字节(x=255-x)处理后的文件。
 * @author ohYoung
 */
public class CustomClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            CustomClassLoader customClassLoader = new CustomClassLoader();
            Class<?> hello = customClassLoader.findClass("Hello");
            Object o = hello.newInstance();
            Method method = hello.getMethod("hello");
            method.invoke(o);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] bytes = new byte[0];
        try {
            bytes = readBytes(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return defineClass(name, bytes, 0,bytes.length);
    }

    private byte[] readBytes(String name) throws Exception {
        String filePath = getClass().getClassLoader().getResource(name + ".xlass").getFile();
        File file = new File(filePath);
        InputStream input = new FileInputStream(file);
        byte[] bytes = new byte[input.available()];
        input.read(bytes);
        return bytes;
    }
}
