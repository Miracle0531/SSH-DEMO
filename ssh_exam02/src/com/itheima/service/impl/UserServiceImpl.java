package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户操作的业务实现类
 *
 * @author TJR
 * @version 1.0, 2017-12-15 9:15
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

}
