<%--
  Created by IntelliJ IDEA.
  User: xjl19
  Date: 2017/8/16
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript" src="resources/app/js/UserJS.js"></script>
</head>
<body>

<form method="post" action="/reg" enctype="multipart/form-data" accept-charset="UTF-8" onsubmit="return checkPwd();">
    用户账号:<input type="text" name="userAccount" required/><br>
    用户密码:<input type="password" name="userPwd" id="pwd1" required/><br>
    确认密码:<input type="password" id="pwd2" required/><br>
    用户姓名:<input type="text" name="userName" required/><br>
    用户电话:<input type="text" name="userMobil" required/><br>
    用户性别:<input type="checkbox" id="check1" name="userSex" value="男" onclick="selectSex()"/>男
            <input type="checkbox" id="check2" name="userSex" value="女" onclick="selectSex()"/>女<br>
    用户头像:<input type="file" name="multipartFile"/><br>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
