<%--
  User: Christp
  Date: 2022/3/12
  Time: 16:48
  Description: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        if("sxy".equals(loginAct) && "123".equals(loginPwd)){
    %>
    <jsp:forward page="success.jsp"></jsp:forward>

    <%}
    else{
    %>
    <jsp:forward page="login.jsp"></jsp:forward>
    <%
        }
    %>
</body>
</html>
