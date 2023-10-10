<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/RegisterServlet.do" method="post">
            username:<input type="text" name="username" value="1251039098@139.com"><br/>
            password:<input type="password" name="password" value="f6946a549b9c1a3a4600"><br/>
            mail:<input type="text" name="email" value="1251039098@139.com"><br/>
            <input type="submit" value="login">
        </form>
    </body>
</html>