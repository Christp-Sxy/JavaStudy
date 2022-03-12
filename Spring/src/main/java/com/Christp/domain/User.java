package com.Christp.domain;

/**
 * @ClassName User
 * @Description TODO
 * @Author Christp
 * @Date 2021/11/25 20:07
 * @Version 1.0
 **/

public class User {
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    private String addr;
}
