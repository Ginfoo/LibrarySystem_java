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
    <legend>添加图书</legend>
    <input id="hiddenField" name="hiddenField" type="hidden" value="hiddenvalue"/>
    <form action="${pageContext.request.contextPath}/book_saveBook.action" method="post">
        <label for="bookId">图书Id：</label>
        <input type="text" id="bookId" name="book.bookId" value="${resultBook.bookId}" readonly/>

        <label for="bookName">图书名称：</label>
        <input type="text" id="bookName" name="book.bookName" value="${resultBook.bookName}" readonly/>

        <label for="bookAuthor">图书作者</label>
        <input type="text" id="bookAuthor" name="book.bookAuthor" value="${resultBook.bookAuthor}" readonly/>

        <label for="select">选择图书类别</label>
        <select size="1" id="select" name="select">
        <s:iterator var="bookType" value="#request['resultBookTypes']">
        <c:if test="${resultBook.bookType.bookTypeId==bookType.bookTypeId}">
        <option selected>${var.bookTypeName}</option>
        </c:if>
        <c:if test="${resultBook.bookType.bookTypeId!=bookType.bookTypeId}">
        <option selected>${var.bookTypeName}</option>
        </c:if>
        </s:iterator>
        </select>
        <br/>
        <input type="submit" value="提交图书" >
        <font color="red">${error}</font>

    </form>
</fieldset>
</body>
</html>
