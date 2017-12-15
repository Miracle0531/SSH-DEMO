package com.itheima.action;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 用户操作的Action
 *
 * @author TJR
 * @version 1.0, 2017-12-15 9:12
 */
@ParentPackage("struts-default")
@Namespace("/")
@Scope("prototype")
@Controller
@SuppressWarnings("all")
public class UserAction extends ActionSupport implements ModelDriven<User> {

    /**
     * 注入用户的属性信息
     */
    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    /**
     * 注入UserService属性
     */
    @Autowired
    private UserService userService;


}
