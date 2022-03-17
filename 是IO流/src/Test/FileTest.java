package Test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Christp
 * @version 1.0
 * @ClassName FileTest
 * @Description TODO
 * @date 2021/10/1 18:01
 */

/*
 * File类的使用
 * 1、File类的一个对象，代表一个文件或一个文件录(俗称：文件夹)
 * 2、File类声明在java.io的一个包下
 * 3、File类中涉及到文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法
 *    并未涉及到写入或读取文件内容的操作。如果需要写入或读取文件内容，必须使用IO流来实现
 * 4、后续File类的对象常常会作为参数传递到流的构造器中，指明读取或写入的"终点"
 */

public class FileTest {
    /*
     * 1、如何创建一个File类的实例
     *   File(String Pathname);
     *   File(String ParentPath, String ChilePath);
     *   File(String ParentFile, String ChilePath);
     *
     * 2、相对路径：相较于某个路径下，指明的路径
     *    绝对路径：包含盘福在内的文件或文件目录的路径
     *
     * 3、路径分隔符：见IO流的笔记
     */

    @Test
    public void test01() throws Exception {
        //构造器1
        //相对于当前module的目录下(是IO流的目录下)
        File file1 = new File("Hello.txt");
        File file2 = new File("D:\\SXY\\学习\\是IO流\\Hello.txt");

        //构造器2
        File file3 = new File("D:\\SXY\\学习\\是IO流", "JavaSenior");

        //构造器3
        File file4 = new File(file3, "Hi.txt");

        File f = new File("E:/jee/Test5.txt");

        // getAbsolutePath():返回此抽象路径名的绝对路径名字符串
        System.out.println(f.getAbsolutePath());

        // getAbsoluteFile():返回此抽象路径名的绝对路径名形式。
        System.out.println(f.getAbsoluteFile());

        // getCanonicalFile()返回此抽象路径名的规范形式。
        System.out.println(f.getCanonicalFile());

        // getCanonicalPath()返回此抽象路径名的规范路径名字符串。
        System.out.println(f.getCanonicalPath());

        // getFreeSpace()返回此抽象路径名指定的分区中未分配的字节数。
        System.out.println(f.getFreeSpace());

        // getName()返回由此抽象路径名表示的文件或目录的名称。
        System.out.println(f.getName());

        // getParent()返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。
        System.out.println(f.getParent());

        // getParentFile()返回此抽象路径名父目录的抽象路径名；如果此路径名没有指定父目录，则返回 null。
        System.out.println(f.getParentFile());

        // getPath()将此抽象路径名转换为一个路径名字符串。
        System.out.println(f.getPath());

        // getTotalSpace()返回此抽象路径名指定的分区大小。
        System.out.println(f.getTotalSpace());

        // getUsableSpace()返回此抽象路径名指定的分区上可用于此虚拟机的字节数。
        System.out.println(f.getUsableSpace());

        // long lastModified()返回此抽象路径名表示的文件最后一次被修改的时间。
        System.out.println(f.lastModified());

        // long length()返回由此抽象路径名表示的文件的长度
        System.out.println(f.length());


    }

    @Test
    public void test02() {
        /*
         * 如下两个方法适用于文件目录操作
         * public String[] list()，获取指定目录下的所有文件或文件目录的名称数组
         * public File[] listFiles()，获取指定目录下的所有文件或文件目录的File数组
         */

        File file = new File("D:\\SXY\\学习");
        String[] list = file.list();
        assert list != null;
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println();

        File[] files = file.listFiles();
        assert files != null;
        for (File f : files) {
            System.out.println(f);
        }
    }

    @Test
    public void test03() {
        /*
         * public boolean renameTo(File dest):把文件重命名为指定的文件路径
         * 要想保证返回为true，需要file1在硬盘中存在，且file2在硬盘中不存在
         */

        File file1 = new File("Hello.txt");
        File file2 = new File("D:\\SXY\\学习\\111.txt");
        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }


    /*
     * A:判断功能
     * public boolean isDirectory():判断是否是目录
     * public boolean isFile():判断是否是文件
     * public boolean exists():判断是否存在
     * public boolean canRead():判断是否可读
     * public boolean canWrite():判断是否可写
     * public boolean isHidden():判断是否隐藏
     */

    @Test
    public void test04() {
        File file1 = new File("Hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }

    /*
     * 创建硬盘中对应的文件或文件目录
     * public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了
     * public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了
     * public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来
     *
     * 删除磁盘中的文件或文件目录
     * public boolean delete():删除文件或文件夹
     *   删除注意事项：
     *   Java中删除不走回收站
     */

    @Test
    public void test05() throws IOException {
        //文件的创建
        File file1 = new File("Hello.txt");
        if (!file1.exists()) {
            file1.createNewFile();
            System.out.println("创建成功");
        } else {//文件存在
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test06() throws IOException {
        //文件目录的创建
        File file = new File("D:\\SXY\\学习\\Chr\\2");

        boolean mkdir = file.mkdir();
        if (mkdir) {
            System.out.println("创建成功");
        }

        File file1 = new File("D:\\SXY\\学习\\Chr\\1");

        boolean mkdir1 = file.mkdirs();
        if (mkdir) {
            System.out.println("创建成功");
        }
    }
}