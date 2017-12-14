<%--
  Author: TJR
  Time: 2017-12-14 14:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>添加用户</title>

        <%-- 引入BootStrap核心的CSS文件 --%>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>

        <%-- 可选的BootStrap主题文件(一般不引入) --%>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css"/>

        <%-- jQuery文件;必须在bootStrap.min.js之前引入 --%>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"/>

        <%-- BootStrap核心JavaScript文件 --%>
        <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"/>

        <style type="text/css">
            body{
                padding-top: 40px;
                padding-bottom: 40px;
                background-color: #e0e0e0;
            }

            .bg{
                max-width: 550px;
                padding: 15px;
                margin: 0 auto;
            }
        </style>

    </head>
    <body>

        <center>
            <form role="form" class="bg" action="${pageContext.request.contextPath}/customer/addCustomer" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="exampleInputEmail">Customer Name</label>
                    <input type="text" class="form-control" name="cusName" placeholder="Enter Customer Name">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Customer Phone</label>
                    <input type="text" class="form-control" name="cusPhone" placeholder="Enter Customer Phone">
                </div>
                <div class="form-group">
                    <label for="exampleInputFile">Customer Image</label>
                    <input type="file" name="cusImg">
                </div>
                <div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </form>
        </center>

    </body>
</html>
