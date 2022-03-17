<%--
  User: Christp
  Date: 2022/3/17
  Time: 14:36
  Description: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>Title</title>
</head>
<body>
<%
    String cardName = request.getParameter("card");
    request.getSession().setAttribute("card",cardName);
    if (cardName.equals("123456")){
%>
<a href="food.jsp">这里是导购柜台，欢迎选购你想要的调料</a>
<p>欢迎修改会员卡号</p>
<%
    }else {
%>
<p>抱歉，您输入的卡号不正确</p>
<%
    }
%>
</body>
</html>
