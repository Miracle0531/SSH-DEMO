package com.itheima.action;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
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
 * 账户信息的Action
 *
 * @author TJR
 * @version 1.0, 2017-12-13 20:51
 */
@ParentPackage("struts-default")
@Namespace("/customer")
@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    /**
     * 创建用户对象
     */
    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        return customer;
    }

    /**
     * 注入CustomerService属性
     */
    @Autowired
    private CustomerService customerService;

    /**
     * 删除用户的操作
     *
     * @return
     */
    @Action(value = "deleteCustomer", results = {@Result(name = "success", location = "findAllCustomer", type = "redirectAction")})
    public String deleteCustomer() {

        customerService.deleteCustomer(customer);

        return SUCCESS;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Action(value = "findAllCustomer", results = {@Result(name = "success", location = "/customerList.jsp")})
    public String findAllCustomer() {

        // 调用Service完成查询所有客户信息的操作
        List<Customer> customerList = customerService.findAllCustomer();

        // 将查询到的list集合中的数据手动存储到valueStack中
        ActionContext.getContext().getValueStack().set("customerList", customerList);

        return SUCCESS;
    }


}
