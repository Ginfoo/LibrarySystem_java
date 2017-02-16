<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: infoo
  Date: 2017/2/13
  Time: 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<fieldset>
    <legend>全部图书类别</legend>
    <table>
        <tr>
            <th>
                图书类别ID
            </th>
            <th>
                图书名称
            </th>
            <th>
                详情及修改
            </th>
        </tr>
        <s:iterator var="bookType" value="#request['resultBookTypes']">
            <tr>
                <form action="${pageContext.request.contextPath}/bookType_findBookTypeById.action" method="post">
                    <td>
                        <input type="text" readonly value="${bookType.bookTypeId}" name="bookType.bookTypeId">
                    </td>
                    <td>
                        <input type="text" readonly value="${bookType.bookTypeName}" name="bookType.bookTypeName">
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
