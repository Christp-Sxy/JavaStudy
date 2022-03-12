package DAO;

import org.junit.Test;

import java.util.List;

/**
 * @author Christp
 * @version 1.0
 * @ClassName DAOTest
 * @Description TODO
 * @date 2021/9/28 21:36
 */
public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> list = dao1.getForIndex(10);
    }

}