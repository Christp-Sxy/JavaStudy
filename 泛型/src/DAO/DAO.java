package DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Christp
 * @version 1.0
 * @ClassName DAO
 * @Description TODO
 * @date 2021/9/28 21:23
 */

/*
 * DAO:data(base) access object
 */

public class DAO<T> {
    //添
    public void add(T t) {

    }

//    public List<T> list(){
////        //错误的
////        Collection<T> values = map.values();
////        return (List<T>) values;
//
//        //正确的
//        ArrayList<T> list = new ArrayList<>();
//        Collection<T> values = map.values();
//        for (T t : values){
//            list.add(t);
//        }
//        return list;
//    }

    //删
    public boolean remove(T t) {
        return false;
    }

    //改
    public void update(T t) {

    }

    //查一
    public T getIndex(int index) {

        return null;
    }
    //查多

    public List<T> getForIndex(int index) {

        return null;
    }
}