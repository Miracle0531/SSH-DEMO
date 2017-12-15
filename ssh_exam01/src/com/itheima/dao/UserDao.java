package com.itheima.dao;

import com.itheima.domain.UserMessage;

import java.util.List;

/**
 * 用户操作的逻辑接口
 *
 * @author TJR
 * @version 1.0, 2017-12-14 18:45
 */
public interface UserDao {

    /**
     * 添加用户信息
     *
     * @param userMessage
     */
    void addUser(UserMessage userMessage);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<UserMessage> findAllUser();
}
