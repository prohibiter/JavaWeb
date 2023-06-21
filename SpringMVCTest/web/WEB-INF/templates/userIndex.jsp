<%--
  Created by IntelliJ IDEA.
  User: cuihe
  Date: 2021/11/16
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>UserIndex</h1>
<a href="${pageContext.request.contextPath}/user/operation">获取所有用户</a> <br>
<a href="${pageContext.request.contextPath}/user/operation/1">获取指定用户</a> <br>
<%--<a href="${pageContext.request.contextPath}/user/operation" methods="PUT">修改用户</a>--%>
<%--<a href="${pageContext.request.contextPath}/user/operation/1" methods="DELETE">删除指定用户</a>--%>
<form action="${pageContext.request.contextPath}/user/operation" method="post">
    <input type="text" name="id">
    <input type="text" name="username">
    <input type="submit" value="添加用户">
</form>
<br>
<form action="${pageContext.request.contextPath}/user/operation" method="post">
    <input type="text" name="id">
    <input type="text" name="username">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="修改用户">
</form>
<br>
<form action="${pageContext.request.contextPath}/user/operation/1" method="DELETE">
    <input type="submit" value="删除用户">
</form>
<br>
</body>
</html>
