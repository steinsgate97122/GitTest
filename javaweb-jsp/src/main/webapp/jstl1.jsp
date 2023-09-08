<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <%--
            下面的form表单中，action为当前页面，因此点击提交后，param.username会传输到当前页面中
            value="${param.username}"将值自动填充到文本输入框，用于编辑或重新加载页面时显示之前输入的数据
            <c:if>标签对test的内容进行判断，test中包含一个EL表达式，判断结果传输给isAdmin，为true时执行其主体内容
        --%>

        <form action="jstl1.jsp" method="get">
            <input type="text" name="username" value="${param.username}">
            <input type="submit" value="login">
        </form>

        <p>username: ${param.username}</p>

        <c:if test="${param.username == 'admin'}" var="isAdmin">
            <c:out value="管理员" />
        </c:if>

        <c:out value="${isAdmin}" />
    </body>
</html>