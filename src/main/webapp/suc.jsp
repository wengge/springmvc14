<%--
  Created by IntelliJ IDEA.
  User: fulia
  Date: 2018/3/20
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="commons/commons.jsp"%>



</head>
<body>
    <h2>${sessionScope.user1.userName}</h2>
    <div>
        <img src="images/${fileName}"><br>
        <a href="download?fileName=${fileName}">点击下载</a>
    </div>
</body>
</html>
