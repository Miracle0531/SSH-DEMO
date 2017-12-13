package com.itheima.service;

import com.itheima.domain.Customer;

import java.util.List;

/**
 * 用户模块的业务接口
 *
 * @author TJR
 * @version 1.0, 2017-12-13 21:27
 */
public interface CustomerService {
    /**
     * 删除用户信息的操作
     *
     * @param customer
     */
    public void deleteCustomer(Customer customer);

    /**
     * 查询所有的用户信息
     *
     * @return
     */
    public List<Customer> findAllCustomer();
}
