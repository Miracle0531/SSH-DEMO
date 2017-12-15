package com.itheima.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.naming.Name;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息的实体类
 *
 * @author TJR
 * @version 1.0, 2017-12-15 13:49
 */
@Entity
@Table(name = "t_order")
public class Order {
    /**
     * 注入订单属性信息
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    @Column(precision = 23, scale = 2)
    private BigDecimal count;
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    // 订单关联客户
    @ManyToOne(targetEntity = com.itheima.domain.Customer.class)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
