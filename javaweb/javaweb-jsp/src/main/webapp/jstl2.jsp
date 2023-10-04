<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <%--
            <c:set>设置变量
            <c:choose>, <c:when>, <c:otherwise>的用法类似java的switch
        --%>

        <c:set var="age" value="66" />

        <c:choose>
            <c:when test="${age < 18}">
                <p>You are a minor.</p>
            </c:when>
            <c:when test="${age >= 18 and age <= 65}">
                <p>You are an adult.</p>
            </c:when>
            <c:otherwise>
                <p>You are a senior citizen.</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>