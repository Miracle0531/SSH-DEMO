package com.itheima.service;

import com.itheima.domain.Customer;

import java.util.List;

/**
 * 用户信息的业务接口
 *
 * @author TJR
 * @version 1.0, 2017-12-15 14:12
 */
public interface CustomerService {

    /**
     * 添加用户信息
     *
     * @param customer
     */
    void addCustomer(Customer customer);

    /**
     * 删除用户信息(修改状态)
     *
     * @param customer
     */
    void deleteCustomer(Customer customer);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<Customer> findAllCustomer();

}
