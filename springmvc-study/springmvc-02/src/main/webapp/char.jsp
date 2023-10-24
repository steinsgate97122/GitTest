<html>
<body>
    <h2>Hello World!</h2>

    <form action="${pageContext.request.contextPath}/char/show" method="post">
        name:<input type="text" name="name"> <br/>
        <input type="submit">
    </form>
</body>
</html>