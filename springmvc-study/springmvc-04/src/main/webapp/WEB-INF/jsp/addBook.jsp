<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addBook</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/addBook" method="post">

        <div class="form-group">
            <label for="bookName">书籍名称：</label>
            <input id="bookName" type="text"  class="form-control"   name="bookName" required>
        </div>
        <div class="form-group">
            <label for="bookCount">书籍数量：</label>
            <input id="bookCount" type="text" class="form-control"  name="bookCounts" required>
        </div>
        <div class="form-group">
            <label for="detail">书籍详情：</label>
            <input id="detail" type="text" class="form-control"  name="detail" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control"  value="添加">
        </div>

    </form>
</div>
</body>
</html>