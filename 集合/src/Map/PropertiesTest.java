package Map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @author Christp
 * @version 1.0
 * @ClassName PropertiesTest
 * @Description TODO
 * @date 2021/9/26 10:47
 */
public class PropertiesTest {
    //Properties常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();

        File file;
        FileInputStream fis = new FileInputStream("Test00001.properties");
        pros.load(fis);//加载对应的流文件

        //Property文件在定义常量时尽量不要在符号间加空格
        String name = pros.getProperty("name");
        String pwd = pros.getProperty("password");
        System.out.println("name: " + name + "\t" + "password: " + pwd);
    }

}