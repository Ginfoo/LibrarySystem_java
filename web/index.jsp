<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图书管理系统</title>
    <link rel="stylesheet" href="${path}/css/index_jsp.css" type="text/css"/>
    <script language="javascript" src="${path}/js/index_jsp.js"></script>
</head>
<body>
<%
    if (session.getAttribute("currentUser") != null) {
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
%>
<DIV class="top_div"></DIV>

<DIV
        style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">
    <DIV style="width: 165px; height: 96px; position: absolute;">
        <DIV class="tou"></DIV>
        <DIV class="initial_left_hand" id="left_hand"></DIV>
        <DIV class="initial_right_hand" id="right_hand"></DIV>
    </DIV>
    <form action="${pageContext.request.contextPath}/user_login.action" method="post">
        <P style="padding: 30px 0px 10px; position: relative;">
            <SPAN class="u_logo"></SPAN> <INPUT class="ipt" type="text"
                                                name="user.userName" placeholder="请输入用户名" value="">
        </P>
        <P style="position: relative;">
            <SPAN class="p_logo"></SPAN> <INPUT class="ipt" id="password"
                                                name="user.userPassword" type="password" placeholder="请输入密码" value="">
        </P>

        <DIV
                style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
            <P style="margin: 0px 35px 20px 45px;">
                <input value="登录" type="submit"
                       style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;"
                >

                <font color="red">${error}</font> </SPAN>
            </P>
        </DIV>
    </form>
</DIV>
</body>
</html>