package com.itheima.action;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.itheima.utils.UUIDUtils;
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
 * 用户头像上传的Action
 *
 * @author TJR
 * @version 1.0, 2017-12-15 15:04
 */
@ParentPackage("struts-default")
@Namespace("/")
@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class CustomerImageAction extends ActionSupport {

    /**
     * 注入CustomerService属性信息
     */
    @Autowired
    private CustomerService customerService;

    /**
     * 创建文件上传属性信息
     */
    private File cusImg;
    private String cusImgFileName;
    private String cusName;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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
        this.cusImgFileName = UUIDUtils.getUUID().concat(cusImgFileName);
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
    @Action(value = "customerAction_addCustomer", results = {
            @Result(name = "success", location = "customerAction_findAllCustomer", type = "redirectAction")})
    public String addCustomer() {

        File file = new File(ServletActionContext.getServletContext().getRealPath("/upload"), cusImgFileName);

        try {
            // 上传文件
            FileUtils.copyFile(cusImg, file);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 添加客户信息
        Customer customer = new Customer();
        customer.setCusName(cusName);
        customer.setAge(age);
        String cusImgPath = ServletActionContext.getRequest().getContextPath() + "/upload/" + cusImgFileName;
        customer.setFlag(1);

        customer.setImgPath(cusImgPath);

        customerService.addCustomer(customer);

        return SUCCESS;
    }

}
