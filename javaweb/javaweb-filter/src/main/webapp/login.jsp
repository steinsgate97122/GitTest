<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/login" method="post">
            Username:<input type="text" name="username"> <br/>
            <input type="submit">
        </form>
    </body>
</html>