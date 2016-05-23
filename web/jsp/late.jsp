<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.show.Late" %>
<%@ page import="org.jsoup.select.Elements" %>
<!doctype html>
<%
    String path=request.getContextPath();
    pageContext.setAttribute("path",path);
    String cookies = (String) session.getAttribute("cookies");
    Elements lateInfo = Late.getLateInfo(cookies);
%>
<html>
<head>
    <title>晚归、违规用电记录查询</title>
    <link href="${path}/jqm/jquery.mobile-1.4.5.min.css" rel="stylesheet">
    <script src="${path}/js/jquery-2.2.0.min.js"></script>
    <script src="${path}/js/jquery.mobile-1.4.5.min.js"></script>
    <link rel="stylesheet" href="${path}/jqm/jquery.mobile.theme-1.4.5.min.css">
</head>
<body>
<section id="home" data-role="page">
    <header data-role="header" data-theme="b">
        <h1>晚归、违规用电记录查询</h1>
    </header>
    <div data-role="content" class="content">
        <table data-role="table" data-mode="reflow" class="ui-responsive">
            <tbody>
            <%
                for (int i = 0; i < lateInfo.size(); i++) {
                    out.write(lateInfo.get(i).text()+"<br>");
                }
            %>
            </tbody>
        </table>
    </div>
    <footer data-role="footer" ><h1>©2016.5.20</h1></footer>
</section>

</body>
</html>