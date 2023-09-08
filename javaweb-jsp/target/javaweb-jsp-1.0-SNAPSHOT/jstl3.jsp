<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <%--
            用 <c:forEach> 标签遍历，items属性指定要遍历的对象，var属性指定迭代过程中的变量名
        --%>

        <c:set var="fruits" value="${['Apple', 'Banana', 'Orange', 'Mango']}" />

        <h1>Fruits List:</h1>
        <ul>
            <c:forEach items="${fruits}" var="fruit">
                <li>${fruit}</li>
            </c:forEach>
        </ul>
    </body>
</html>