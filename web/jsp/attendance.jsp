<%@ page import="com.show.Attendance" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<%
    String path=request.getContextPath();
    pageContext.setAttribute("path",path);
    String cookies = (String) session.getAttribute("cookies");
    List attendanceInfo = Attendance.getAttendanceInfo(cookies);
    List name = (List) attendanceInfo.get(0);
    List info = (List) attendanceInfo.get(1);
%>
<html>
<head>
    <title>考勤查询</title>
    <link href="${path}/jqm/jquery.mobile-1.4.5.min.css" rel="stylesheet">
    <script src="${path}/js/jquery-2.2.0.min.js"></script>
    <script src="${path}/js/jquery.mobile-1.4.5.min.js"></script>
    <link rel="stylesheet" href="${path}/jqm/jquery.mobile.theme-1.4.5.min.css">
</head>
<body>
<section id="home" data-role="page">
    <header data-role="header" data-theme="b">
        <h1>学生考勤信息查询</h1>
    </header>
    <div data-role="content" class="content">
        <table data-role="table" data-mode="reflow" class="ui-responsive"
        >
            <thead>
            <tr>
                <th>课程名称</th>
                <th>详细信息</th>
            </tr>
            </thead>
            <tbody>
                <%
                    for (int i = 0; i < name.size(); i++) {
                        out.write("<tr>"+name.get(i)+info.get(i)+"</tr>");
                    }
                %>
            </tbody>
        </table>
    </div>
    <footer data-role="footer" ><h1>©2016.5.20</h1></footer>
</section>

</body>
</html>
