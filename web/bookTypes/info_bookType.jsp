<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: infoo
  Date: 2017/2/13
  Time: 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<fieldset>
    <legend>图书类别信息</legend>
    <input id="hiddenField" name="hiddenField" type="hidden" value="hiddenvalue"/>
    <form action="${pageContext.request.contextPath}/bookType_updateBookType.action" method="post">
        <label for="bookId">图书类别Id：</label>
        <input type="text" id="bookId" name="bookType.bookTypeId" value="${resultBookType.bookTypeId}" readonly/>

        <label for="bookName">图书类别名称：</label>
        <input type="text" id="bookName" name="bookType.bookTypeName" value="${resultBookType.bookTypeName}" />

        <br/>
        <s:if test="#session.currentUser.userLevel==0">
        <%--<input type="submit" value="提交修改" method="updateBook">--%>
        <input type="submit" value="修改图书类别" >
        <font color="red">${error}</font>
        </s:if>
        <s:else>
        <input type="submit" value="查看类别下的图书" >
        <%--<input type="submit" value="购买" method="">--%>
        <%--<font color="red">${error}</font>--%>
        </s:else>
    </form>
</fieldset>
</body>
</html>
