<%--
  Author: TJR
  Time: 2017-12-15 13:29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>用户注册</title>
    </head>
    <body>
        <center>
            <form action="${pageContext.request.contextPath}/customerAction_addCustomer.action" method="post" enctype="multipart/form-data">
                <table width="500px">
                    <tr>
                        <td align="right">用户名：</td>
                        <td align="left">
                            <input type="text" id="cusName" name="cusName">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">年龄:</td>
                        <td align="left">
                            <input type="text" id="age" name="age">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">头像:</td>
                        <td align="left">
                            <input type="file" name="cusImg">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Submit">
                        </td>
                    </tr>
                </table>
            </form>
        </center>
    </body>
</html>