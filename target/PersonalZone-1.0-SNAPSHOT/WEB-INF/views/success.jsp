<%--
  Created by IntelliJ IDEA.
  User: xjl19
  Date: 2017/8/11
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>主页</title>
    <script type="text/javascript" src="../../resources/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../../resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../resources/app/js/UserJS.js"></script>
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet"/>
    <script>
        function updateUser() {
            var div = document.getElementById("div1");
            var button1 = document.getElementById("button1");
            alert(button1.value);
            div.style.display = 'block';
        }
        function cancleButton(){
            var div = document.getElementById("div1");
            var button2 = document.getElementById("button2");
            div.style.display = 'none';
        }
    </script>
    <style>
        td{
            text-align: center;
        }
        #div1{
            width: 480px;
            height: 250px;
            background-color: white;
            display: none;
            position: absolute;
        }
        div2{
            position: absolute;
        }
    </style>
</head>
<body>

<div id="div1" class="col-md-offset-4">
    <form action="/update" method="post" enctype="multipart/form-data">
        用户姓名:<input type="text" name="userName" required/>&nbsp;&nbsp;
        用户电话:<input type="text" name="userMobil" required/><br>
        用户网名:<input type="text" name="userSName" required/>&nbsp;&nbsp;
        用户年龄:<input type="text" name="userSex" required/><br>
        用户生日:<input type="text" name="userBirth" required/>&nbsp;&nbsp;
        用户性别:<input type="checkbox" id="check1" name="userSex" value="男" onclick="selectSex()"/>男
                <input type="checkbox" id="check2" name="userSex" value="女" onclick="selectSex()"/>女<br>
        <input type="submit" class="btn-success" value="提交"/>
        <button class="btn-danger" onclick="cancleButton()">取消</button>
    </form>
</div>

<div id="div2" class="container">
    <div class="col-md-offset-6">
        <form action="/find" method="post">
            <input type="text" name="userName"/>
            <input type="submit" class="btn-info" value="查询"/>
        </form>
    </div>
    <div class="col-md-offset-4">
        <button class="btn-success">新增</button>
        <button class="btn-primary">修改</button>
        <button class="btn-danger">删除</button>
    </div>
        <div class="col-md-offset-4">
            <table border="1px" cellpadding="0px">
                <thead>
                    <tr>
                        <td><button class="btn-info">全选</button></td>
                        <td>头像</td>
                        <td>姓名</td>
                        <td>网名</td>
                        <td>年龄</td>
                        <td>性别</td>
                        <td>电话</td>
                        <td>操作</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pageInfo.list}" var="user">
                        <tr>
                            <td><input type="checkbox" name="chooseAll"></td>
                            <td><img height="30px" width="35px" src="${user.userPhoto}"/></td>
                            <td>${user.userName}</td>
                            <td>${user.userSName}</td>
                            <td>${user.userAge}</td>
                            <td>${user.userSex}</td>
                            <td>${user.userMobil}</td>
                            <td>
                                <a href="/delete?userID=${user.userID}&start=${pageInfo.pageNum}">
                                    <button class="btn-danger">删除</button>
                                </a>
                                <button id="button1" class="btn-info" value="${user.userID}" onclick="updateUser()">修改</button>
                                <button style="display: none" id="button2" value="${pageInfo.pageNum}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    <div class="col-md-offset-4">
        当前第${pageInfo.pageNum}页，一共${pageInfo.pages}页，一共${pageInfo.total}条记录。
    </div>
    <%--导航条--%>
    <div class="col-md-offset-5">
        <nav aria-label="Page navigation">
            <ul class="Pagination">
                <li>
                    <a href="/page?start=1" aria-label="First">首页</a>
                </li>
                <c:if test="${pageInfo.pageNum>1}">
                    <li>
                        <a href="/page?start=${pageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach var="pages" items="${pageInfo.navigatepageNums}">
                    <%--如果当前页面正好是遍历时的页面，那么Li的显示变为active，并且无法点击--%>
                    <c:if test="${pages==pageInfo.pageNum}">
                        <li class="active"><a href="#">${pages}</a></li>
                    </c:if>
                    <%--如果当前页面不是遍历时的页面，点击按钮则会跳到当前页--%>
                    <c:if test="${pages!=pageInfo.pageNum}">
                        <li><a href="/page?start=${pages}">${pages}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${pageInfo.pageNum < pageInfo.pages}">
                    <li>
                        <a href="/page?start=${pageInfo.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <li>
                    <a href="/page?start=${pageInfo.pages}" aria-label="First">末页</a>
                </li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
