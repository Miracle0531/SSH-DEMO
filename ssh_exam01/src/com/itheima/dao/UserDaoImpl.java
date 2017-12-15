package com.itheima.dao;

import com.itheima.domain.UserMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户操作的逻辑实现类
 *
 * @author TJR
 * @version 1.0, 2017-12-14 18:46
 */
@Repository
@SuppressWarnings("all")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    /**
     * 注入SessionFactory
     */
    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    /**
     * 添加用户信息
     *
     * @param userMessage
     */
    @Override
    public void addUser(UserMessage userMessage) {
        // 保存用户信息
        this.getHibernateTemplate().save(userMessage);
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<UserMessage> findAllUser() {
        return (List<UserMessage>) this.getHibernateTemplate().find("from UserMessage");
    }
}
