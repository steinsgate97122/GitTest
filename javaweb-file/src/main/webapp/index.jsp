<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <!--enctype设置为multipart的编码方式，这样表单才能上传文件-->
        <form action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data" method="post">
            <p><input type="file" name="file1"></p>
            <p><input type="submit"> | <input type="reset"></p>
        </form>

    </body>
</html>