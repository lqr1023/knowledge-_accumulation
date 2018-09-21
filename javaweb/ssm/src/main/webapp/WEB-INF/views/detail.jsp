<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2018/9/17
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>单个书目信息</title>
</head>
<body>
    <table>
        <tr>
            <th>图书名称</th>
            <th>图书数量</th>
        </tr>
        <tr>
            <td>${book.name}</td>
            <td>${book.number}</td>
        </tr>
    </table>

</body>
</html>
