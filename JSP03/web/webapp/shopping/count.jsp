<%--
  User: Christp
  Date: 2022/3/17
  Time: 14:36
  Description: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>这里是结账柜台，请确认以下信息</p>
<br>
<br>
<%
    String cardID = (String) request.getSession().getAttribute("card");
    String[] source = request.getParameterValues("source");
%>
<p>您的会员卡号:</p><%=cardID%>

<br>
<p>购物车中的商品清单:</p>
<br>
<%
    for (int i = 0; i < source.length; i++) {
%>
<p>
    <%=source[i]%>
</p>
<%
    }
%>
<a href="loginID.jsp">欢迎修改会员卡号</a>
<a href="food.jsp">欢迎来到调料柜台</a>
</body>
</html>
