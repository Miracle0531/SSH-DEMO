package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户操作模块的逻辑实现类
 *
 * @author TJR
 * @version 1.0, 2017-12-14 18:47
 */
@Service
@Transactional
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {

    /**
     * 注入UserDao属性信息
     */
    @Autowired
    private UserDao userDao;

    /**
     * 添加用户信息
     *
     * @param userMessage
     */
    @Override
    public void addUser(UserMessage userMessage) {
        userDao.addUser(userMessage);
    }
}
