<%--
  Author: TJR
  Time: 2017-12-14 16:16
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <%-- 引入BootStrap核心CSS文件 --%>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">

        <%-- 可选择的BootStrap主题文件 --%>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css">

        <%-- jQuery文件,必须在bootstrap.min.js之前引入 --%>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"/>

        <%-- BootStrap核心的JavaScript文件 --%>
        <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"/>

        <title>客户列表信息</title>
        <style type="text/css">
            body {
                padding-top: 40px;
                padding-bottom: 40px;
                background-color: #eee;
            }

            .bg {
                max-width: 530px;
                padding: 15px;
                margin: 0 auto;
            }
        </style>
    </head>
    <body>

        <center>
            <table class="table table-hover table-bordered bg">
                <tr>
                    <td colspan="4">
                        <a href="${pageContext.request.contextPath}/addCustomer.jsp" class="btn bg-primary btn-lg active"
                           role="button">Add Customer</a>
                    </td>
                </tr>
                <tr>
                    <td>序号</td>
                    <td>客户</td>
                    <td>客户名称</td>
                    <td>联系电话</td>
                    <td>操作</td>
                </tr>
                <s:iterator value="cs" var="c" status="s">
                    <tr>
                        <td><s:property value="#vs.index+1"/></td>
                        <td><img src="<s:property value='#c.cusImg'/>" alt="img-circle"></td>
                        <td><s:property value="#c.cusName"/></td>
                        <td><s:property value="#c.cusPhone"/></td>
                        <td>
                            <a href="javascript:void(0)" class="btn btn-primary btn-sm"
                               onclick="deleteCustomer(<s:property value="#c.id"/>)">删除客户</a>
                            <a href="javascript:void(0)" onclick="findOrder(<s:property value="#c.id"/>)"
                               class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">订单详情</a>
                        </td>
                    </tr>
                </s:iterator>
            </table>

            <%-- model --%>
            <div class="model fade" id="myModel" tabindex="-1" role="dialog" aria-labelledby="myModelLabel" aria-hidden="true">
                <div class="model-dialog">
                    <div class="model-content">
                        <div class="model-header">
                            <button type="button" class="close" data-dismiss="model">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span>
                            </button>
                            <h4 class="model-title" id="myModelLabel">订单详情</h4>
                        </div>
                        <div class="modal-body">
                            <table class="table table-bordered .table-hover">
                                <tr>
                                    <td>订单编号</td>
                                    <td>收货地址</td>
                                    <td>订单价格</td>
                                    <td>客户名称</td>
                                    <td>操作</td>
                                </tr>
                                <tbody id="msg">

                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <nav id="page"> </nav>
                        </div>
                    </div>
                </div>
            </div>

        </center>

    </body>
</html>
