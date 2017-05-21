<%--
  Created by IntelliJ IDEA.
  User: handl
  Date: 2017/5/21
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户中心</title>
</head>
<body>
    <div>
        <span>${username}!欢迎回家</span><br>
        <span>已登入</span><br>
        <a href="<%= request.getContextPath()%>/userhome/hase?name=${username}">ok</a>
    </div>

</body>
</html>
