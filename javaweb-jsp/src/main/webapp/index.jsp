<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

    <%-- <%= %> 标签用于在JSP页面中嵌入一个表达式，这个表达式的值将被计算并输出到生成的HTML页面中。
         表达式可以是任何有效的Java表达式。通常用于在页面中输出动态内容，如变量的值 --%>
    <%= new java.util.Date() + "<br>"%>

    <%-- <% %> 标签用于在JSP页面中插入任意的Java代码块，这些代码将在服务器端执行，通常用于执行复杂的服务器端逻辑。 --%>
    <%
    for (int i = 0; i < 5; i++) {
        out.print("Iteration: " + i + "<br>");
    }
    %>

    <hr>

    <%-- <%! %> 用于在 JSP 页面中定义全局变量、方法或类 --%>

    <%!
      public int add(int a, int b) {
          return a + b;
      }
    %>
    <%
      out.print("1 + 2 = " + add(1, 2));
    %>

    <%-- 虽然允许在JSP页面中插入Java代码，但通常不鼓励在JSP中编写大量的Java代码，因为这可能会导致页面难以维护和理解。
         更好的做法是将业务逻辑封装到Servlet或其他Java类中，并在JSP中使用表达式和标签库来显示数据。
         这有助于实现MVC（模型-视图-控制器）的分离，提高代码的可维护性。 --%>

    </body>
</html>