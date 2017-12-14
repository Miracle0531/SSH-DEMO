package com.itheima.action;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.itheima.domain.Order;
import com.itheima.domain.PageBean;
import com.itheima.service.OrderService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 订单信息的实体类
 *
 * @author TJR
 * @version 1.0, 2017-12-13 21:13
 */
@ParentPackage("struts-default")
@Namespace("/order")
@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class OrderAction {
    /**
     * 注入OrderService属性
     */
    @Autowired
    private OrderService orderService;

    /**
     * 查询订单信息
     */
    @Action("findOrder")
    public void findOreder() {

        // 设置中文字符集
        ServletActionContext.getResponse().setCharacterEncoding("UTF-8");

        // 1:获取Customer的ID信息
        Integer customerId = Integer.parseInt((ServletActionContext.getRequest().getParameter("customerId")));

        // 2:获取当前页数
        int pageNum = Integer.parseInt((ServletActionContext.getRequest().getParameter("pageNum")));

        // 3:设置每页显示条数
        int currentCount = Integer.parseInt((ServletActionContext.getRequest().getParameter("currentCount")));

        // 封装查询数据
        PageBean<Order> pageBean = orderService.fingOrderByCustomerPage(customerId, pageNum, currentCount);

        // 将查询到的数据转化为json数据
        PropertyFilter filter = new PropertyFilter() {
            @Override
            public boolean apply(Object o, String fieldName, Object o1) {
                if ("cusPhone".equalsIgnoreCase(fieldName)) {
                    return false;
                }
                if ("id".equalsIgnoreCase(fieldName)) {
                    return false;
                }
                if ("orders".equalsIgnoreCase(fieldName)) {
                    return false;
                }
                return true;
            }
        };

        String json = JSONArray.toJSONString(pageBean, filter, SerializerFeature.DisableCircularReferenceDetect);

        // 4:将json数据相应到浏览器端
        try {
            ServletActionContext.getResponse().getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
