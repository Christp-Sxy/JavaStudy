package com.Christp.domain;

import java.sql.Date;

/**
 * @ClassName Order
 * @Description TODO
 * @Author Christp
 * @Date 2021/11/30 20:16
 * @Version 1.0
 **/

public class Order {
    private int uid;
    private Date ordertime;
    private int total;
    private Info info;

    @Override
    public String toString() {
        return "Order{" +
                "uid=" + uid +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", info=" + info +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    //当前订单属于哪一个用户


}
