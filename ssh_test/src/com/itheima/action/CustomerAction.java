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
 * 用户操作模块
 *
 * @author TJR
 * @version 1.0, 2017-12-15 14:14
 */
@ParentPackage("struts-default")
@Namespace("/")
@Controller
@Scope("ptototype")
@SuppressWarnings("all")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    /**
     * 创建Customer对象
     */
    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        return customer;
    }

    /**
     * 注入Customer属性信息
     */
    @Autowired
    private CustomerService customerService;

    /**
     * 删除用户信息(修改状态)
     *
     * @return
     */
    @Action(value = "customerAction_deleteCustomer", results = {@Result(name = "success", location = "customerAction_findAllCustomer", type = "redirectAction")})
    public String deleteCustomer() {

        customerService.deleteCustomer(customer);

        return SUCCESS;

    }

    @Action(value = "customerAction_findAllCustomer", results = {@Result(name = "success", location = "/customerList.jsp")})
    public String findAllCustomer(){

        // 创建List集合存储查询数据
        List<Customer> customers = customerService.findAllCustomer();

        // 将查询结果压入值栈
        ActionContext.getContext().getValueStack().set("customers", customers);

        return SUCCESS;
    }

}
