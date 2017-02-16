<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: infoo
  Date: 2017/2/12
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<fieldset>
    <legend>个人信息</legend>
    <input id="hiddenField" name="hiddenField" type="hidden" value="hiddenvalue"/>
    <form action="${pageContext.request.contextPath}/user_deleteUser.action" method="post">
        <label for="userId">用户名:</label>
        <input type="text" id="userId" name="user.userId" value="${resultUser.userId}" readonly/>
        <label for="username">用户名:</label>
        <input type="text" id="username" name="user.userName" value="${resultUser.userName}" readonly/>
        <label for="pass">密码:</label>
        <input type="password" id="pass" name="user.userPassword" value="${resultUser.userPassword}"/>
        <input type="submit" value="修改密码">
    </form>
</fieldset>
<fieldset>
    <legend>用户级别</legend>
    <label>管理员用户</label>
    <input type="radio"  value="1"  name="currentUserLevel" checked readonly/>
    <label>普通用户</label>
    <input type="radio"  value="2"  name="currentUserLevel" checked readonly/>
    <s:if test="#session.currentUser.userLevel==0">
        <%--<input type="submit" value="提交修改" method="updateBook">--%>
        <input type="submit" value="删除该用户" >
        <font color="red">${error}</font>
    </s:if>
</fieldset>
</body>
</html>
