<%--
  Created by IntelliJ IDEA.
  User: fulia
  Date: 2018/3/20
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="commons/commons.jsp"%>
    <title>Title</title>

    <script>


        $(function () {

            $("#username").blur(function () {

                $.ajax({
                    url:"user/checkName",
                    data:{"username":$("#username").val()},

                    success:function(data){
                        $("#msg").text(data);
                    }
                })
            });
            
            $("#btnFindAll").click(function () {
                $.ajax({
                   url:"test/allusers",
                   type:"GET",
                   dataType:"json",
                   success:function (data) {
                       $.each(data,function () {
                           alert(this.userName);
                       });
                   }
                })
            });
        });
    </script>
</head>
<body>
    <p>用户名:<input id="username">
    <span id="msg"></span>
    </p>
    <p>密码:<input type="password"></p>
    <hr>
    <form action="test/users" method="post">
        <input type="submit" value="查所有">
    </form>
    <hr>
    <p><input type="button" id="btnFindAll" value="查所有"></p>
    
</body>
</html>
