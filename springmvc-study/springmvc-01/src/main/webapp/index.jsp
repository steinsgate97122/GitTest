<html>
<body>
    <h2>Hello World!</h2>

    <form action="${pageContext.request.contextPath}/login" method="post">
        Username:<input type="text" name="username"> <br/>
        Password:<input type="password" name="password"> <br/>
        Hobbies:
        <input type="checkbox" name="hobbies" value="music">music
        <input type="checkbox" name="hobbies" value="tennis">tennis
        <input type="checkbox" name="hobbies" value="photography">photography
        <br/>
        <input type="submit">
    </form>
</body>
</html>