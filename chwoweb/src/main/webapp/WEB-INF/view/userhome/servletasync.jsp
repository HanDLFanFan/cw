<%--
  Created by IntelliJ IDEA.
  User: handl
  Date: 2017/8/19
  Time: 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet Async</title>
</head>
<body>
<script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

    deferred();

    function deferred() {
        $.get('async',function (data)
        {
            console.log(data);
            deferred();
        });
    }

</script>
</body>
</html>
