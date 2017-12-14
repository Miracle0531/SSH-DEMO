package com.itheima.service;

import com.itheima.domain.UserMessage;

/**
 * 用户操作的逻辑接口
 *
 * @author TJR
 * @version 1.0, 2017-12-14 18:47
 */
public interface UserService {
    /**
     * 添加用户信息
     *
     * @param userMessage
     */
    public void addUser(UserMessage userMessage);
}