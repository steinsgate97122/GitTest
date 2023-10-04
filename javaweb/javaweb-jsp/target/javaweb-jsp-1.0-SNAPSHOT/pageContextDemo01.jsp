<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <%--
            pageContext request session application 都是不同作用域下用于存储数据的对象，它们之间的主要区别在于数据的生命周期和可见性
            pageContext的生命周期仅限于当前页面，适用于需要在页面的不同部分之间共享数据的情况
            request的生命周期与客户端发起的每个请求相关联，数据可以在同一次请求的不同页面之间共享
            session的生命周期与用户的会话（从登录到退出）相关联，在多个请求之间共享数据，存储用户登录信息
            application的生命周期与整个Web应用程序的生命周期相关联，通常在所有用户之间共享，存储全局配置
        --%>
        <%
            pageContext.setAttribute("pageTitle", "Welcome to my website!");
            request.setAttribute("username", "John");
            session.setAttribute("userId", 123);
            application.setAttribute("appName", "My Web App");
        %>

        <%-- getAttribute只能在当前作用域下查找属性
             findAttribute在多个作用域中查找属性，从底层到高层，page到application --%>

        <%
            String pageTitle = (String) pageContext.findAttribute("pageTitle");
            String username = (String) pageContext.findAttribute("username");
            int userId = (int) pageContext.findAttribute("userId");
            String appName = (String) pageContext.findAttribute("appName");
        %>

        <h1>取值</h1>
        <h3>${pageTitle}</h3>
        <p>Welcome, ${username}</p>
        <p>User ID: ${userId}</p>
        <p>APP Name: ${appName}</p>

    </body>
</html>