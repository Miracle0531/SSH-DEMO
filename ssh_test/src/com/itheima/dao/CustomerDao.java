package com.itheima.dao;

import com.itheima.domain.Customer;

import java.util.List;

/**
 * 用户操作的业务逻辑接口
 *
 * @author TJR
 * @version 1.0, 2017-12-15 14:13
 */
public interface CustomerDao {

    /**
     * 添加用户信息
     *
     * @param customer
     */
    void addCustomer(Customer customer);

    /**
     * 查询所有用户的信息
     *
     * @return
     */
    List<Customer> findAllCustomer();

    /**
     * 根据用户ID查询用户信息
     *
     * @param id
     * @return
     */
    Customer findCustomerById(int id);

    /**
     * 删除指定用户信息
     *
     * @param customer
     */
    void deleteCustomer(Customer customer);
}
