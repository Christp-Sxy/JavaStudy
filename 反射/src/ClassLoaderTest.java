import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author Christp
 * @version 1.0
 * @ClassName ClassLoaderTest
 * @Description TODO
 * @date 2021/10/13 19:56
 */

/*
 * 了解类的加载器
 */

public class ClassLoaderTest {
    @Test
    public void test01() {
        //对于自定义加载器，使用系统类加载器进行加载
        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();//系统类的加载器
        //调用系统类加载的getParent():获取扩展类加载器
        ClassLoader classLoader2 = classLoader1.getParent();
        //调用扩展类加载的getParent():无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类
        ClassLoader classLoader3 = classLoader2.getParent();
    }


    /*
     * Properties:用来读取配置文件
     */
    @Test
    public void test02() throws IOException {
        Properties pros = new Properties();
        //此时文件默认在当前的目录下
        //读取配置文件的方式一
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);


        //读取方式二：利用ClassLoader
        //配置文件默认识别为当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();//系统类的加载器
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");

        pros.load(is);

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");

        System.out.println("user" + name + "pwd" + password);
    }
}