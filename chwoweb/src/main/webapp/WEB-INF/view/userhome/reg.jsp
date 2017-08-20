<%--
  Created by IntelliJ IDEA.
  User: handl
  Date: 2017/5/22
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <form action="/userhome/regok" method="get" >
        输入名称:<input type="text" name="name" id="name" /><br/>
        输入密码:<input type="password" name="password" id="password" /><br/>
        输入邮箱:<input type="email" name="email" id="email" /><br/>
        <button type="submit">ok</button>
    </form>

</body>
</html>
