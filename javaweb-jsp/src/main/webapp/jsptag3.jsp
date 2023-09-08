<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <%--
            <jsp:useBean> <jsp:setProperty> <jsp:getProperty>用于在 JSP 页面中创建和操作 Java Bean 对象
            与直接在 Java 代码中使用 new 关键字创建对象的作用是一致的
            这样写的封装性更好，可以在不同的 JSP 页面中重复使用，保持页面简洁
        --%>

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