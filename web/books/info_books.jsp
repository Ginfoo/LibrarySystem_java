<%--
  Created by IntelliJ IDEA.
  User: infoo
  Date: 2017/2/12
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<fieldset>
    <legend>全部图书信息</legend>
    <table>
        <tr>
            <th>
                图书ID
            </th>
            <th>
                图书名称
            </th>
            <th>
                图书作者
            </th>
            <th>
                图书价格
            </th>
            <th>
                详情及修改
            </th>
        </tr>
        <s:iterator var="book" value="#request['resultBooks']">
            <tr>
            <form action="${pageContext.request.contextPath}/book_findBookById.action" method="post">
                <td>
                <input type="text" readonly value="${book.bookId}" name="book.bookId">
                </td>
                <td>
                <input type="text" readonly value="${book.bookName}" name="book.bookName">
                </td>
                <td>
                <input type="text" readonly value="${book.bookAuthor}" name="book.bookAuthor">
                </td>
                <td>
                <input type="text" readonly value="${book.bookPrice}" name="book.boolPrice">
                </td>
                <td>
                    <input type="submit" value="查看">
                </td>
            </form>
            </tr>
        </s:iterator>
    </table>

</fieldset>

</body>
</html>
