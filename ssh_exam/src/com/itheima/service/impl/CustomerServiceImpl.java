package com.itheima.service.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户模块的业务实现类
 *
 * @author TJR
 * @version 1.0, 2017-12-13 21:28
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
     * 删除指定用户信息
     *
     * @param customer
     */
    @Override
    public void deleteCustomer(Customer customer) {

        customer = customerDao.findCustomerById(customer.getId());

        customerDao.deleteCustomer(customer);

    }

    /**
     * 查询所有的客户信息
     *
     * @return
     */
    @Override
    public List<Customer> findAllCustomer() {
        return customerDao.findAllCustomer();
    }
}
