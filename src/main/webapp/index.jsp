<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-04-27
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index page</title>
</head>
<body>
<h1>index page</h1>
<form action="/user/signIn" method="post">
    <input name="username" placeholder="Username" value="Tom"><br>
    <input type="password" name="password" placeholder="Password" value="123"><br>
    <input type="submit" value="Sign in"><br>
</form>
${requestScope.message}
<p><a href="signUp.jsp">Sign up</a></p>
</body>
</html>
