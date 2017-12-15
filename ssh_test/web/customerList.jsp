<%--
  Author: TJR
  Time: 2017-12-14 19:27
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>客户信息列表</title>
        <script type="text/javascript">
            function delCustomer(customerId){
                location.href = "${pageContext.request.contextPath}/customerAction_deleteCustomer?id="+customerId;
            }
        </script>
    </head>
    <body>
        <center>
            <table width="550px" border="2px">
                <tr>
                    <td colspan="5" align="center"><h3>客户信息</h3></td>
                </tr>
                <tr>
                    <td align="center">编号</td>
                    <td align="center">客户名称</td>
                    <td align="center">客户年龄</td>
                    <td align="center">客户头像</td>
                    <td align="center">操作</td>
                </tr>
                <s:iterator value="customers" var="c" status="s">
                    <tr>
                        <td align="center"><s:property value="#c.id"/></td>
                        <td align="center"><s:property value="#c.cusName"/></td>
                        <td align="center"><s:property value="#c.age"/></td>
                        <td align="center"><img src="<s:property value='#c.imgPath'/>"></td>
                        <td align="center">
                            <a href="${pageContext.request.contextPath}/error.jsp">修改</a>
                            &nbsp;|&nbsp;
                            <a href="javascript:void(0)" onclick="delCustomer(<s:property value="#c.id"/>)">删除</a>
                        </td>
                    </tr>
                </s:iterator>
                <tr>
                    <td align="center" colspan="2">
                        <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
                    </td>
                    <td></td>
                    <td align="center" colspan="2">
                        <a href="${pageContext.request.contextPath}/addUser.jsp">添加用户</a>
                    </td>
                </tr>
            </table>
        </center>
    </body>
</html>
