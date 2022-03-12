import org.junit.Assert;
import org.junit.Test;

/**
 * @author Christp
 * @version 1.0
 * @ClassName DemoTest
 * @Description TODO
 * @date 2021/11/24 20:00
 */
public class DemoTest {
    @Test
    public void testSay(){
        Demo demo = new Demo();
        String ret = demo.say("帅逼");
        Assert.assertEquals("hello帅逼", ret);
    }
}