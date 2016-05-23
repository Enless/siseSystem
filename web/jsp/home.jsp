<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    pageContext.setAttribute("path",path);
%>


<html>
<head>
    <title>主页</title>
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
       <div class="ui-grid-b">
           <div class="ui-block-a">
               <a href="${path}/jsp/info.jsp" class="ui-shadow ui-btn ui-corner-all ui-btn-icon-top ui-icon-info">个人信息</a>
           </div>
           <div class="ui-block-b">
               <a href="#" class="ui-shadow ui-btn ui-corner-all ui-btn-icon-top ui-icon-grid">课程表</a>
           </div>
           <div class="ui-block-c">
               <a href="${path}/jsp/info.jsp" class="ui-shadow ui-btn ui-corner-all ui-btn-icon-top ui-icon-grid">成绩查询</a>
           </div>

           <div class="ui-block-a">
               <a href="${path}/jsp/time.jsp" class="ui-shadow ui-btn ui-corner-all ui-btn-icon-top ui-icon-info">考试时间表</a>
           </div>
           <div class="ui-block-b">
               <a href="${path}/jsp/attendance.jsp" class="ui-shadow ui-btn ui-corner-all ui-btn-icon-top ui-icon-grid">考勤信息</a>
           </div>
           <div class="ui-block-c">
               <a href="${path}/jsp/ep.jsp" class="ui-shadow ui-btn ui-corner-all ui-btn-icon-top ui-icon-grid">奖惩记录</a>
           </div>

           <div class="ui-block-a">
               <a href="${path}/jsp/course.jsp" class="ui-shadow ui-btn ui-corner-all ui-btn-icon-top ui-icon-info">查看开设课程</a>
           </div>
           <div class="ui-block-b">
               <a href="${path}/jsp/late.jsp" class="ui-shadow ui-btn ui-corner-all ui-btn-icon-top ui-icon-grid">晚归，违规用电记录</a>
           </div>
           <div class="ui-block-c">
               <a href="#" class="ui-shadow ui-btn ui-corner-all ui-btn-icon-top ui-icon-delete">退出登录</a>
           </div>





       </div>
    </div>
    <footer data-role="footer" ><h1>©2016.5.20</h1></footer>
</section>

</body>
</html>
