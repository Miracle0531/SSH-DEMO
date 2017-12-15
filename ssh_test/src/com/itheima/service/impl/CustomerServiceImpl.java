package com.itheima.service.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户操作的业务实现类
 *
 * @author TJR
 * @version 1.0, 2017-12-15 14:12
 */
@Service
@Transactional
@SuppressWarnings("all")
public class CustomerServiceImpl implements CustomerService {

    /**
     * 注入CustomerDao属性
     */
    @Autowired
    private CustomerDao customerDao;

    /**
     * 添加用户信息
     *
     * @param customer
     */
    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    /**
     * 删除用户信息(修改状态)
     *
     * @param customer
     */
    @Override
    public void deleteCustomer(Customer customer) {
        // 获取传入用户的ID信息
        customer = customerDao.findCustomerById(customer.getId());

        // 删除指定ID的用户信息
        customerDao.deleteCustomer(customer);
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<Customer> findAllCustomer() {
        return customerDao.findAllCustomer();
    }

}
