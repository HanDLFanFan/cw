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
    <meta charset=UTF-8">
    <title>SSE推送消息</title>
</head>
<body>
<h1>获取服务端更新数据</h1>
<div id="result"></div>
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<script>
    alert("1");
    if (!!window.EventSource){
        alert("2");
        var  source = new EventSource('/push');
    }else{
        console.log("此浏览器不支持EventSource！！！")
    }

    s = '';
    alert("3");
    source.addEventListener("message",function (e) {
        alert("4");
        s += e.data + "<br />";
        $("#result").html(s);
    });

    alert("5");
    source.addEventListener("open",function (e) {
        console.log("连接打开");
    },false);

    alert("6");
    source.addEventListener("error",function (e) {
        if (e.readyState == EventSource.CLOSED){
            console.log("连接关闭")
        }else{
            console.log(e.readyState);
        }
    },false);

</script>
</body>
</html>