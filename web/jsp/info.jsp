<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.utils.Data" %>
<%@ page import="com.show.PersonInfo" %>
<%@ page import="java.util.List" %>
<!doctype html>
<%
    String path=request.getContextPath();
    pageContext.setAttribute("path",path);
    String cookies = (String) session.getAttribute("cookies");
    String url = Data.getUrlBySelector("tr [title~=个人信息]", cookies);
    List<String> compulsoryInfo = PersonInfo.getCompulsoryInfo(url, cookies);
    List personalInfo = PersonInfo.getPersonalInfo(url, cookies);
%>
<html>
<head>
    <title>个人信息查询</title>
    <link href="${path}/jqm/jquery.mobile-1.4.5.min.css" rel="stylesheet">
    <script src="${path}/js/jquery-2.2.0.min.js"></script>
    <script src="${path}/js/jquery.mobile-1.4.5.min.js"></script>
    <link rel="stylesheet" href="${path}/jqm/jquery.mobile.theme-1.4.5.min.css">
</head>
<body>
<section id="home" data-role="page">
    <header data-role="header" data-theme="b">
        <h1>学生个人信息查询</h1>
    </header>
    <div data-role="content" class="content">
        <table data-role="table" data-mode="reflow" class="ui-responsive">
            <thead>
            <tr>
                <th>学科名称</th>
                <th>学科成绩</th>
                <th>学分</th>
            </tr>
            </thead>
            <tbody>
            <% for (int i = 0; i <compulsoryInfo.size() ; i++) {
                out.write(compulsoryInfo.get(i));
            }
            %>
            </tbody>
        </table>
    </div>
    <footer data-role="footer" ><h1>©2016.5.20</h1></footer>
</section>

</body>
</html>