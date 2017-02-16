<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: infoo
  Date: 2017/2/12
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


</head>
<body>
<fieldset>
    <legend>图书信息</legend>
    <input id="hiddenField" name="hiddenField" type="hidden" value="hiddenvalue"/>
    <%--<s:form action="${pageContext.request.contextPath}/book_submit.action" method="post">--%>
    <form action="/book_deleteBook.action" method="post">
        <label for="bookId">图书Id：</label>
        <input type="text" id="bookId" name="book.bookId" value="${resultBook.bookId}" readonly/>

        <label for="bookName">图书名称：</label>
        <input type="text" id="bookName" name="book.bookName" value="${resultBook.bookName}" readonly/>

        <label for="bookAuthor">图书作者</label>
        <input type="text" id="bookAuthor" name="book.bookAuthor" value="${resultBook.bookAuthor}" readonly/>

        <%--<label for="select">图书类别</label>--%>
        <%--<select size="1" id="select" name="select">--%>
        <%--<s:iterator var="bookType" value="#request['resultBookTypes']">--%>
        <%--<c:if test="${resultBook.bookType.bookTypeId==bookType.bookTypeId}">--%>
        <%--<option selected>${var.bookTypeName}</option>--%>
        <%--</c:if>--%>
        <%--<c:if test="${resultBook.bookType.bookTypeId!=bookType.bookTypeId}">--%>
        <%--<option selected>${var.bookTypeName}</option>--%>
        <%--</c:if>--%>
        <%--</s:iterator>--%>
        <%--</select>--%>
        <br/>
        <s:if test="#session.currentUser.userLevel==0">
        <%--<input type="submit" value="提交修改" method="updateBook">--%>
        <input type="submit" value="删除图书" method="deleteBook">
        <%--<s:submit value="删除图书" method="deleteBook"/>--%>
        <font color="red">${error}</font>
        </s:if>
        <s:else>
        <%--<input type="submit" value="借阅" method="">--%>
        <%--<input type="submit" value="购买" method="">--%>
        <font color="red">${error}</font>
        </s:else>
    </form>
</fieldset>
</body>
</html>
