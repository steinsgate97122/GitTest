<html>
<body>
    <h2>Hello World!</h2>

    <form action="${pageContext.request.contextPath}/hello/add2" method="post">
        a:<input type="text" name="a"> <br/>
        b:<input type="text" name="b"> <br/>
        <input type="submit">
    </form>
</body>
</html>