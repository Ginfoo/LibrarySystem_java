<%--
  Created by IntelliJ IDEA.
  User: infoo
  Date: 2017/2/13
  Time: 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<fieldset>
    <legend>个人信息</legend>
    <input id="hiddenField" name="hiddenField" type="hidden" value="hiddenvalue"/>
    <form action="${pageContext.request.contextPath}/user_saveUser.action" method="post">
        <label for="username">用户名:</label>
        <input type="text" id="username" name="user.userName"/>
        <label for="pass">密码:</label>
        <input type="password" id="pass" name="user.userPassword"/>
        <label>管理员用户</label>
        <input type="radio" value="0" name="user.userLevel"/>
        <label>普通用户</label>
        <input type="radio" value="1" name="user.userLevel" checked/>
        <input type="submit" value="提交添加">
        <font color="red">${error}</font>
    </form>
</fieldset>


</form>
</body>
</html>
