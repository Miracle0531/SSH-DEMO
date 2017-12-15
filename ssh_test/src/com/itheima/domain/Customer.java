package com.itheima.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户信息的实体类
 *
 * @author TJR
 * @version 1.0, 2017-12-15 13:49
 */
@Entity
@Table(name = "t_customer")
@SuppressWarnings("all")
public class Customer {
    /**
     * 注入用户属性信息
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cusName;
    private int age;
    private String imgPath;
    private int flag;

    // 客户关联订单
    @OneToMany(mappedBy = "customer", targetEntity = com.itheima.domain.Order.class)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private Set<Order> orders = new HashSet<Order>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
