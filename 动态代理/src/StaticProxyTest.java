/**
 * @author Christp
 * @version 1.0
 * @ClassName StaticProxyTest
 * @Description TODO
 * @date 2021/10/31 20:09
 */

/*
 * 静态代理举例
 * 特点：代理类和被代理类在编译期间就已经确定下来了
 */


interface ClothFactory {
    void produceCloth();
}

class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory;    // 将被代理对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备操作");
        factory.produceCloth();
        System.out.println("代理工厂做一些收尾工作");
    }
}


//被代理类
class ChristpClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Christp工厂制作");
    }
}


public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类对象
        ChristpClothFactory chirstp = new ChristpClothFactory();
        //创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(chirstp);

        proxyClothFactory.produceCloth();
    }
}