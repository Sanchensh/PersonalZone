<%--
  Created by IntelliJ IDEA.
  User: xjl19
  Date: 2017/8/11
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="row">
    <div class="col-md-offset-4">
        <form method="post" action="/login" enctype="multipart/form-data" >
            登陆账号:<input type="text" name="userAccount"/></br>
            密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="userPwd"/></br>
            <input type="submit" class="btn-success" value="登录"/>
            <a href="reg.jsp">没有注册？点击一下</a>
        </form>
    </div>
</div>
</body>
</html>
