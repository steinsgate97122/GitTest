<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%-- <%@ include %>用于在JSP页面中包含其他资源，例如其他的JSP页面，将指定的文件内容嵌入到当前JSP页面的位置
             是在页面编译时执行的，包含的内容在页面的生成阶段合并 --%>
        <%@ include file="common/header.jsp" %>
        <h3>我是Content<h3>
        <%@ include file="common/footer.jsp" %>

        <hr>

        <%-- <jsp:include>使用XML风格的语法，同样是将其他资源嵌入当前JSP页面
             是在页面运行时执行的，包含的内容在页面的执行阶段合并 --%>
        <jsp:include page="/common/header.jsp"></jsp:include>
        <h3>我是Content<h3>
        <jsp:include page="/common/footer.jsp"/>
    </body>
</html>