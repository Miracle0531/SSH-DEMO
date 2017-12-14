package com.itheima.service.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.dao.OrderDao;
import com.itheima.domain.Customer;
import com.itheima.domain.Order;
import com.itheima.domain.PageBean;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单模块的业务实现类
 *
 * @author TJR
 * @version 1.0, 2017-12-13 21:28
 */
@Service
@Transactional
@SuppressWarnings("all")
public class OrderServiceImpl implements OrderService {

    /**
     * 注入OrderDao属性信息
     */
    @Autowired
    private OrderDao orderDao;

    /**
     * 注入CustomerDao属性信息
     */
    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据用户信息查询订单信息
     *
     * @param customerId
     * @param pageNum
     * @param currentCount
     * @return
     */
    @Override
    public PageBean<Order> fingOrderByCustomerPage(Integer customerId, int pageNum, int currentCount) {

        PageBean<Order> pageBean = new PageBean<Order>();
        // 封装每一页的条数
        pageBean.setCurrentCount(currentCount);
        // 封装当前页信息
        pageBean.setPageNum(pageNum);
        int totalCount = orderDao.findTotalCount();
        pageBean.setTotalCount(totalCount);

        // 设置总页数
        int totalPage = (int) Math.ceil(totalCount * 1.0 / currentCount);

        pageBean.setTotalCount(totalPage);

        // 查询当前页的所有信息
        Customer customer = customerDao.findCustomerById(customerId);
        List<Order> orders = orderDao.findOrderByCustomerPage(customer, pageNum, currentCount);
        // 封装分页信息
        pageBean.setCurrentContent(orders);

        return pageBean;
    }
}
