<%--
  Author: TJR
  Time: 2017-12-14 19:22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>用户注册</title>
    </head>
    <body>
        <center>
            <form action="${pageContext.request.contextPath}/userAction_addUser" method="post">
                <table width="500px">
                    <tr>
                        <td align="right">用户名：</td>
                        <td align="left">
                            <input type="text" id="username" name="username">
                        </td>
                    </tr>
                    <tr>
                        <td align="right">用户名：</td>
                        <td align="left">
                            <input type="text" id="password" name="password">
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
