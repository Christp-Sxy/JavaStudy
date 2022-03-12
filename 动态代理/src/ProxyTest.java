import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Christp
 * @version 1.0
 * @ClassName ProxyTest
 * @Description TODO
 * @date 2021/11/1 19:26
 */

/*
 * 动态代理举例
 */

interface Human {
    String getBelief();

    void eat(String food);
}


//被代理类
class Superman implements Human {

    @Override
    public String getBelief() {
        return "老子他妈把把C";
    }

    @Override
    public void eat(String food) {
        System.out.println("爷喜欢吃" + food);
    }
}

/*
 * 要想实现动态代理，需要解决哪些问题？
 * 1.如何根据加载到内存中的被代理类，动态的创造一个代理类及其对象
 * 2.当通过代理类对象调用方法a时，如何动态地去调用被代理类中的同名方法a
 */

class ProxyFactory {
    //调用此方法，返回一个代理类的对象，解决问题1
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*
        * method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        * obj:被代理类对象
        */
        return method.invoke(obj, args);
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        Superman superman = new Superman();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superman);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("屎");
    }
}