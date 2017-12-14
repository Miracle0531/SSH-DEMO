package com.itheima.service;

import com.itheima.domain.Order;
import com.itheima.domain.PageBean;

/**
 * 订单模块的业务接口
 *
 * @author TJR
 * @version 1.0, 2017-12-13 21:27
 */
public interface OrderService {

    /**
     * 根据用户信息查询订单信息
     *
     * @param customerId
     * @param pageNum
     * @param currentCount
     * @return
     */
    public PageBean<Order> fingOrderByCustomerPage(Integer customerId, int pageNum, int currentCount);

}
