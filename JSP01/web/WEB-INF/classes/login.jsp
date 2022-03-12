<%--
  User: Christp
  Date: 2022/3/12
  Time: 16:47
  Description: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="validate.jsp" method="post">
    <table border="0">
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="loginAct"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="loginPwd"></td>
        </tr>
    </table>
    <input type="submit" value="登录">
</form>
</body>
</html>
