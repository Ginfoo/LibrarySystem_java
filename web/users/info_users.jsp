<%--
  Created by IntelliJ IDEA.
  User: infoo
  Date: 2017/2/12
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<fieldset>
    <legend>全部用户信息</legend>
    <table>
        <tr>
            <th>
                用户Id
            </th>
            <th>
                用户名
            </th>
            <th>
                用户类别
            </th>
            <th>
                详情及修改
            </th>
        </tr>
        <s:iterator var="user" value="#request['resultUsers']" >
            <s:if test="#user.userLevel==0">
                  <c:set var="userLevel2" value="管理员"></c:set>
            </s:if>
            <s:else>
                 <c:set var="userLevel2" value="普通用户"></c:set>
            </s:else>
            <tr>
                <form action="${pageContext.request.contextPath}/user_findUserById.action" method="post">
                    <td>
                        <input type="text" readonly value="${user.userId}" name="user.userId">
                    </td>
                    <td>
                        <input type="text" readonly value="${user.userName}">
                    </td>
                    <td>
                        <input type="text" readonly value="${userLevel2}">
                    </td>
                    <td>
                        <input type="submit" value="查看" >
                    </td>
                </form>
            </tr>
        </s:iterator>
    </table>

</fieldset>

</body>
</html>
