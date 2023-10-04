<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <jsp:useBean id="people" class="com.zhehao.pojo.People" />

        <jsp:setProperty name="people" property="id" value="1" />
        <jsp:setProperty name="people" property="name" value="zhehao" />
        <jsp:setProperty name="people" property="age" value="26" />
        <jsp:setProperty name="people" property="address" value="shanghai" />

        <p>id: <jsp:getProperty name="people" property="id" /></p>
        <p>name: <jsp:getProperty name="people" property="name" /></p>
        <p>age: <jsp:getProperty name="people" property="age" /></p>
        <p>address: <jsp:getProperty name="people" property="address" /></p>

    </body>
</html>