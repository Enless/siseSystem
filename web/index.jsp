<!doctype html>
<%--
  Created by IntelliJ IDEA.
  User: Jockey
  Date: 2016/5/19
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path=request.getContextPath();
  session.setAttribute("path",path);
%>
<html>
<head>
  <title>Title</title>
  <link href="${path}/jqm/jquery.mobile-1.4.5.min.css" rel="stylesheet">
  <script src="${path}/js/jquery-2.2.0.min.js"></script>
  <script src="${path}/js/jquery.mobile-1.4.5.min.js"></script>
  <link rel="stylesheet" href="${path}/jqm/jquery.mobile.theme-1.4.5.min.css">
</head>
<body>
<section id="home" data-role="page">
  <header data-role="header" data-theme="b">
    <h1>华软Mysise学生信息管理系统</h1>
  </header>
  <div data-role="content" class="content">
    <form method="post" action="${path}/Login">
      <input type="text" name="username" id="username" data-clear-btn="true" placeholder="用户名"/><br>
      <input type="password" name="password" id="password" data-clear-btn="true" placeholder="在这里输入你的密码"/>
      <button type="submit" data-role="button" data-theme="b">登陆</button>
    </form>
  </div>
  <footer data-role="footer" ><h1>©2016.5.20</h1></footer>
</section>

</body>
</html>
