package com.itheima.dao.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户操作的业务逻辑实现类
 *
 * @author TJR
 * @version 1.0, 2017-12-15 14:13
 */
@Repository
@SuppressWarnings("all")
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    /**
     * 注入SessionFactory属性信息
     *
     * @param sessionFactory
     */
    @Autowired
    private void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    /**
     * 添加用户信息
     *
     * @param customer
     */
    @Override
    public void addCustomer(Customer customer) {
        // 保存用户信息
        this.getHibernateTemplate().save(customer);
    }

    /**
     * 删除用户信息(修改状态)
     *
     * @param customer
     */
    @Override
    public void deleteCustomer(Customer customer) {
        Integer id = customer.getId();

    }

    /**
     * 查询所有用户的数据
     *
     * @return
     */
    @Override
    public List<Customer> findAllCustomer() {
        return (List<Customer>) this.getHibernateTemplate().find("from Customer");
    }

    /**
     * 根据ID查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public Customer findCustomerById(int id) {
        return this.getHibernateTemplate().get(Customer.class, id);
    }

}
