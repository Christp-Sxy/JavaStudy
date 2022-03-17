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
<form action="count.jsp" method="post">
    <p>这里是调料柜台，请选择您要购买的调料:</p>
    <input type="checkbox" name="source" value="调和油">调和油
    <input type="checkbox" name="source" value="强化盐">强化盐
    <input type="checkbox" name="source" value="多维醋">多维醋
    <input type="checkbox" name="source" value="绿色调料">绿色调料
    <br>
    <input type="submit" value="购物">
    <br>
</form>
<a href="loginID.jsp">欢迎修改会员卡号！欢迎查看购物车！</a>

</body>
</html>
