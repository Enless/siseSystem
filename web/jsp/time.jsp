<%@ page import="com.show.Time" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    pageContext.setAttribute("path",path);
    String cookies = (String) session.getAttribute("cookies");
    List time = Time.getTime(cookies);
    List title = (List) time.get(0);
    List date = (List) time.get(1);
    List place = (List) time.get(2);
%>
<!doctype html>
<html>
<head>
    <title>考试时间查看</title>
    <link href="${path}/jqm/jquery.mobile-1.4.5.min.css" rel="stylesheet">
    <script src="${path}/js/jquery-2.2.0.min.js"></script>
    <script src="${path}/js/jquery.mobile-1.4.5.min.js"></script>
    <link rel="stylesheet" href="${path}/jqm/jquery.mobile.theme-1.4.5.min.css">
</head>
<body>
<section id="home" data-role="page">
    <header data-role="header" data-theme="b">
        <h1>学生考试时间查看</h1>
    </header>
    <div data-role="content" class="content">
        <table data-role="table" data-mode="reflow" class="ui-responsive">
            <thead>
            <tr>
                <th>课程名称</th>
                <th>考试日期</th>
                <th>考场名称</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i <title.size() ; i++) {
                    out.write("<tr>" +title.get(i)+date.get(i)+place.get(i)+
                            "</tr>");
                }
            %>
            </tbody>
        </table>
    </div>
    <footer data-role="footer" ><h1>©2016.5.20</h1></footer>
</section>

</body>
</html>