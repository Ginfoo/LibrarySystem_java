<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="party.infoo.model.User" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="${path}/css/success_jsp.css" type="text/css"/>
    <script language="javascript" src="${path}/js/success_jsp.js"></script>
</head>
<body>
<div id="mainDiv">
    <div id="topDiv">
        <div id="tmenu">
            <ul>
            </ul>
        </div>
    </div>
    <div id="centerDiv">

        <div id="left">
            <div id="lhead">管理菜单</div>
            <%--使用struts2 标签获取当前用户--%>
            <s:if test="#session['currentUser'].userLevel==0">
                <ul>
                    <li><a href="/user_info_mine_jsp.action">个人信息</a></li>
                    <li><a href="/book_findAllBooks.action">图书管理</a></li>
                    <li><a href="/user_findAllUsers.action">用户管理</a></li>
                    <li><a href="/bookType_findAllBookTypes.action">图书类别</a></li>
                    <li><a href="/book_searchBook_jsp.action">查询图书</a></li>
                    <li><a href="/user_searchUser_jsp.action">查询用户</a></li>
                    <li><a href="/book_addBook_jsp.action">添加图书</a></li>
                    <li><a href="/user_addUser_jsp.action">添加用户</a></li>
                    <li><a href="/user_findAllBorrowInfos.action">借阅信息</a></li>
                    <li><a href="/user_findAllSellBoooks.action">销售信息</a></li>
                    <li><a href="/user_exit.action">退出登录</a></li>
                </ul>
            </s:if>
            <s:else>
                <ul>
                    <li><a href="/user_info_mine_jsp.action">个人信息</a></li>
                    <li><a href="/book_findAllBooks.action">搜索图书</a></li>
                    <li><a href="/bookType_findAllBookTypes.action">图书分类</a></li>
                    <li><a href="/user_findAllBorrowInfos.action">我的借阅</a></li>
                    <li><a href="/user_findAllBuyInfos.action">购买信息</a></li>
                    <li><a href="/user_exit.action">退出登录</a></li>
                </ul>
            </s:else>

        </div>
        <div id="right">
            <div id="current">
                <c:choose>
                    <c:when test="${currentUser.userLevel=='0'}">
                        管理员：${currentUser.userName}
                    </c:when>
                    <c:when test="${currentUser.userLevel!='0'}">
                        你好用户：${currentUser.userName}
                    </c:when>
                </c:choose>
            </div>
            <div id="form">
                <%--引用需要显示的界面，其中a b 在Action中定义--%>

                        <jsp:include page="/${a}/${b}.jsp"></jsp:include>


            </div>
        </div>
    </div>
    <div id="bottomDiv"></div>
</div>
<script language="javascript">
    $("#test1").toggle(function () {
        $("#test").slideDown()
    }, function () {
        $("#test").slideUp()
    })
</script>
<div style="text-align:center;">
</div>
</body>
</html>