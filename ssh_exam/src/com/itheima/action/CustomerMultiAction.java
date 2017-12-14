package com.itheima.action;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;

/**
 * 用户信息的Action
 *
 * @author TJR
 * @version 1.0, 2017-12-13 21:13
 */
@ParentPackage("struts-default")
@Namespace("/customer")
@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class CustomerMultiAction extends ActionSupport {

    /**
     * 注入Customer属性信息
     */
    @Autowired
    private CustomerService customerService;

    /**
     * 接受上传的文件
     */
    private File cusImg;
    /**
     * 接受上传文件的名称
     */
    private String cusImgFileName;
    private String cusName;
    private String cusPhone;

    public File getCusImg() {
        return cusImg;
    }

    public void setCusImg(File cusImg) {
        this.cusImg = cusImg;
    }

    public String getCusImgFileName() {
        return cusImgFileName;
    }

    public void setCusImgFileName(String cusImgFileName) {
        this.cusImgFileName = cusImgFileName;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    /**
     * 添加客户信息
     *
     * @return
     */
    @Action(value = "addCustomer", results = {@Result(name = "success", location = "findAllCustomer", type = "redirectAction"), @Result(name = "input", location = "/error.jsp")})
    public String addCustomer() {

        // 处理上传文件,保存到服务器端
        File destFile = new File(ServletActionContext.getServletContext().getRealPath("/upload"), cusImgFileName);
        try {
            FileUtils.copyFile(cusImg, destFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 完成添加客户的操作
        Customer customer = new Customer();
        customer.setCusName(cusName);
        customer.setCusPhone(cusPhone);
        String cusImgsrc = ServletActionContext.getRequest().getContextPath().concat("/upload").concat(cusImgFileName);
        customer.setCusImgsrc(cusImgsrc);
        customerService.addCustomer(customer);

        return SUCCESS;
    }
}
