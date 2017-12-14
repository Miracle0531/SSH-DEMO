package com.itheima.dao.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户模块的逻辑实现类
 *
 * @author TJR
 * @version 1.0, 2017-12-13 21:16
 */
@Repository
@SuppressWarnings("all")
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    /**
     * 注入一个SessionFactory
     */
    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<Customer> findAllCustomer() {
        return (List<Customer>) this.getHibernateTemplate().find("from Customer");
    }

    /**
     * 删除用户
     *
     * @param customer
     */
    @Override
    public void deleteCustomer(Customer customer) {
        this.getHibernateTemplate().delete(customer);
    }

    /**
     * 通过用户ID查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public Customer findCustomerById(Integer id) {
        return this.getHibernateTemplate().get(Customer.class, id);
    }

    /**
     * 添加用户
     *
     * @param customer
     */
    @Override
    public void addCustomer(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }
}
