package com.itheima.action;

import com.itheima.domain.UserMessage;
import com.itheima.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 用户操作模块
 *
 * @author TJR
 * @version 1.0, 2017-12-14 18:46
 */
@ParentPackage("struts-default")
@Scope("prototype")
@Controller
@Namespace("/")
public class UserAction extends ActionSupport implements ModelDriven<UserMessage> {

    /**
     * 注入用户属性信息
     */
    private UserMessage userMessage = new UserMessage();

    @Override
    public UserMessage getModel() {
        return userMessage;
    }

    /**
     * 注入UserService属性
     */
    @Autowired
    private UserService userService;

    /**
     * 添加用户信息
     *
     * @return
     */
    @Action(value = "userAction_addUser", results = {@Result(name = "success", location = "userAction_findAllUser", type = "redirectAction")})
    public String addUser() {

        userService.addUser(userMessage);

        return SUCCESS;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Action(value = "userAction_findAllUser", results = {@Result(name = "success", location = "/userList.jsp")})
    public String findAllUser() {

        // 创建List集合存储数据
        List<UserMessage> userMessageList = userService.findAllUser();

        // 将查询结果存储到值栈中
        ActionContext.getContext().getValueStack().set("userMessageList", userMessageList);

        return SUCCESS;
    }

}
