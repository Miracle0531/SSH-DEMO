package com.itheima.domain;

import javax.persistence.*;

/**
 * 用户信息的实体类
 *
 * @author TJR
 * @version 1.0, 2017-12-14 18:41
 */
@Entity
@Table(name = "t_user")
public class UserMessage {
    /**
     * 注入用户属性信息
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
