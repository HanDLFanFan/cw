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
    <sf:form action="<%= request.getContextPath() %>/userhome/reg" method="get" >
        输入名称:<sf:input id="name" name="name" path="name" /><br/>
        输入密码:<sf:password d="password" name="password" path="password"/><br/>
        输入邮箱:<sf:input d="email" name="email" path="email"/><br/>
        <sf:button value="ok"/>
    </sf:form>

</body>
</html>
