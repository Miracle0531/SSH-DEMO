package com.itheima.dao;

import com.itheima.domain.Customer;
import com.itheima.domain.Order;

import java.util.List;

/**
 * 订单模块的逻辑接口
 *
 * @author TJR
 * @version 1.0, 2017-12-13 21:16
 */
public interface OrderDao {

    /**
     * 查询总页数
     *
     * @return
     */
    public int findTotalCount();

    /**
     * 根据用户分页信息查询订单
     *
     * @param customer
     * @param pageNum
     * @param currentCount
     * @return
     */
    public List<Order> findOrderByCustomerPage(Customer customer, int pageNum, int currentCount);

    /**
     * 根据用户信息查询订单
     *
     * @param customer
     * @return
     */
    public List<Order> findByCustomer(Customer customer);
}
