<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.show.Course" %>
<%@ page import="java.util.List" %>
<!doctype html>
<%
    String path=request.getContextPath();
    pageContext.setAttribute("path",path);
    String cookies = (String) session.getAttribute("cookies");
    List elements = Course.CourseElements(cookies);
    List name = (List) elements.get(0);
    List fen = (List) elements.get(1);
    List way = (List) elements.get(2);
%>
<html>
<head>
    <title>查看开课信息</title>
    <link href="${path}/jqm/jquery.mobile-1.4.5.min.css" rel="stylesheet">
    <script src="${path}/js/jquery-2.2.0.min.js"></script>
    <script src="${path}/js/jquery.mobile-1.4.5.min.js"></script>
    <link rel="stylesheet" href="${path}/jqm/jquery.mobile.theme-1.4.5.min.css">
</head>
<body>
<section id="home" data-role="page">
    <header data-role="header" data-theme="b">
        <h1>查看开课信息</h1>
    </header>
    <div data-role="content" class="content">
        <table data-role="table" data-mode="reflow" class="ui-responsive">
            <tr>
                <th>课程名称</th>
                <th>学分</th>
                <th>考核方式</th>
            </tr>
            <%
                for (int i = 0; i < name.size(); i++) {
            %>
                <tr>
                    <%=name.get(i).toString()+fen.get(i).toString()+way.get(i).toString()%>
                </tr>
            <%
                }
            %>
        </table>
    </div>
    <footer data-role="footer" ><h1>©2016.5.20</h1></footer>
</section>

</body>
</html>