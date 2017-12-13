package com.itheima.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 账户信息的实体类
 *
 * @author TJR
 * @version 1.0, 2017-12-13 20:52
 */
@Entity
@Table(name = "t_customer")
public class Customer {

    /**
     * 创建用户属性信息
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cusName;
    private String cusPhone;
    private String cusImgsrc;

    // 客户关联订单
    @OneToMany(mappedBy = "customer", targetEntity = com.itheima.domain.Order.class)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private Set<Order> orders = new HashSet<Order>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusImgsrc() {
        return cusImgsrc;
    }

    public void setCusImgsrc(String cusImgsrc) {
        this.cusImgsrc = cusImgsrc;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
