<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: handl
  Date: 2017/8/18
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SSE推送消息</title>
</head>
<body>

<div id="msgFromPush"></div>
<script type="text/javascript" src="<c:url value="../../js/jquery-3.2.1.min.js"/>" />
<script type="text/javascript">

    if (!!window.EventSource){
        var source = new EventSource("push");
        s = '';
        source.addEventListener('message',function(e) {
            s += e.data + "<br/>";
            $("#msgFromPush").html(s);
        });

        source.addEventListener('open',function(e) {
            console.log("连接打开。。。");
        },false);

        source.addEventListener('error',function(e){
            if (e.readyState == EventSource.CLOSED){
                console.log("连接关闭。。。");
            } else {
                console.log(e.readyState);
            }
        },false)
    } else {
        console.log("浏览器不支持SSE，请换个浏览器试试！！！");
    }
</script>
</body>
</html>