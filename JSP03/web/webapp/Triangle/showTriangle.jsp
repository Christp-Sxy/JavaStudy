<%--
  User: Christp
  Date: 2022/3/17
  Time: 15:54
  Description: 无法为JSP编译类:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Double a = Double.parseDouble(request.getParameter("a"));
    Double b = Double.parseDouble(request.getParameter("b"));
    Double c = Double.parseDouble(request.getParameter("c"));
%>
<div>
    <jsp:useBean id="triangle" class="bean.Triangle1" scope="application"/>
    <p>三角形的三边:</p>
    <br>
    <p>边A: <%=a%> 边B: <%=b%> 边C: <%=c%></p>
    <br>
    <p>这三个边能构成一个三角形吗? </p>
    <%=triangle.isTriangle(a, b, c)%>
    <br>
    <p>面积是: <%=triangle.calculateSquare(a, b, c)%></p>
    <br>
    <p>周长是: <%=triangle.calculatePerimeter(a, b, c)%></p>
</div>
</body>
</html>
