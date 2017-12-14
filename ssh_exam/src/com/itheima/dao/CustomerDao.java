package com.itheima.dao;

import com.itheima.domain.Customer;

import java.util.List;

/**
 * 用户模块的逻辑接口
 *
 * @author TJR
 * @version 1.0, 2017-12-13 21:15
 */
public interface CustomerDao {

    /**
     * 查询所有客户信息
     *
     * @return
     */
    public List<Customer> findAllCustomer();

    /**
     * 删除指定客户信息
     *
     * @param customer
     */
    public void deleteCustomer(Customer customer);

    /**
     * @param id
     * @return
     */
    public Customer findCustomerById(Integer id);

    /**
     * 添加客户信息
     *
     * @param customer
     */
    public void addCustomer(Customer customer);
}
