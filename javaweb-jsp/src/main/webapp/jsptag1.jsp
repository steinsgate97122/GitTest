<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%--
            <jsp:include>标签见include.jsp
            <jsp:forward>标签可以实现请求转发
            <jsp:param>标签通常包含在<jsp:forward>内部，将参数传递给被转发的页面
        --%>

        <jsp:forward page="/jsptag2.jsp">
            <jsp:param name="name" value="zhehao" />
            <jsp:param name="age" value="26" />
        </jsp:forward>

    </body>
</html>