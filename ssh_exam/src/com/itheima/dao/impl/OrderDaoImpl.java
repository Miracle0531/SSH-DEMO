package com.itheima.dao.impl;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Customer;
import com.itheima.domain.Order;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单模块的逻辑实现类
 *
 * @author TJR
 * @version 1.0, 2017-12-13 21:17
 */
@Repository
@SuppressWarnings("all")
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

    /**
     * 注入SessionFactory属性信息
     */
    @Autowired
    private void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    /**
     * 查询分页信息
     *
     * @return
     */
    @Override
    public int findTotalCount() {
        return ((Long) this.getHibernateTemplate().find("select count(*) from Order").iterator().next()).intValue();
    }

    /**
     * 根据客户查询所有订单
     *
     * @param customer
     * @param pageNum
     * @param currentCount
     * @return
     */
    @Override
    public List<Order> findOrderByCustomerPage(Customer customer, int pageNum, int currentCount) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Order.class);
        detachedCriteria.add(Restrictions.eq("customer", customer));
        return (List<Order>) this.getHibernateTemplate().findByCriteria(detachedCriteria, (pageNum - 1) * currentCount, currentCount);
    }

    /**
     * 根据用户信息查询订单信息
     *
     * @param customer
     * @return
     */
    @Override
    public List<Order> findByCustomer(Customer customer) {
        return (List<Order>) this.getHibernateTemplate().find("from Order o where o.customer = ?", customer);
    }
}
