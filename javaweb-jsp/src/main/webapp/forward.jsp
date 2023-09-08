<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <%--
            pageContext.forward()在当前JSP页面内执行请求转发
            request.getRequestDispatcher().forward()在Servlet中执行请求转发
        --%>
        <%
            pageContext.forward("/index.jsp");
        %>

    </body>
</html>