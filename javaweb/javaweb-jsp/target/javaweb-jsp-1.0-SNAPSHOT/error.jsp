<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- <%@ page %>通常出现在JSP页面的顶部，用于配置JSP页面的各种属性和选项 --%>
<%-- 通过下面这种方式无法指定状态码，如果不同状态码需要跳转不同页面，那么需要修改web.xml --%>
<%--<%@ page errorPage="error/500.jsp" %>--%>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <%
            int a = 1/0;
        %>

    </body>
</html>