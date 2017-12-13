package com.itheima.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 订单信息的实体类
 *
 * @author TJR
 * @version 1.0, 2017-12-13 21:01
 */
@Entity
@Table(name = "t_order")
public class Order {

    /**
     * 创建订单的属性信息
     */
    @Id
    @GenericGenerator(name = "myuuid", strategy = "uuid")
    @GeneratedValue(generator = "myuuid")
    /** 主键UUID */
    private String orderNum;

    /** 收获地址 */
    private String receiverInfo;

    /** 订单价格 */
    @Column(precision = 23, scale = 2)// 小数点后保留两位小数, 整体精度23位
    private BigDecimal price;

    /** 订单关联客户 */
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id")// 外键名称
    private Customer customer;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getReceiverInfo() {
        return receiverInfo;
    }

    public void setReceiverInfo(String receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
