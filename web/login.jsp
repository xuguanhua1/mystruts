<%--
  Created by IntelliJ IDEA.
  User: cxspace
  Date: 16-6-21
  Time: 下午3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
   <form action="${pageContext.request.contextPath}/login.action" name="frmLogin" method="post">

       用户名:<input type="text" name="name"><br/>
       密码:<input type="password" name="pwd"> <br/>

       <input type="submit" value="登录">  <br/>

   </form>
</body>
</html>
