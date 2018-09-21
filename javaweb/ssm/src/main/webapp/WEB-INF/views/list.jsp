<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2018/9/17
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>返回所有图书列表</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script>

        function subscribe(bookId,count) {
            var a = 'studentID' + count;
            $.ajax({
                type:"POST",
                url: "/ssm/book/"+bookId+"/appoint",
                contentType : "application/x-www-form-urlencoded",
                dataType:"json",
                data:{'studentId':$("#"+a).val()},
                success:function (json) {
                    console.log(json);
                    if (json.flag == false){
                        alert(json.error)
                    } else{
                        var info = json.data;
                        alert(info.stateInfo);
                    }
                }
            });
        }
    </script>

</head>
<body>

<table>
    <tr>
        <th>图书id</th>
        <th>图书名称</th>
        <th>图书数量</th>
        <th>主要内容</th>
        <th>输入学号</th>
        <th>订阅</th>
    </tr>
<c:forEach items="${list}" var="book" varStatus="status">
    <tr>
        <td>${book.bookId}</td>
        <td>${book.name}</td>
        <td>${book.number}</td>
        <td>
            <form action="<c:url value='/book/${book.bookId}/detail'/>" method="get">
                <input type="submit" value="详情">
            </form>
        </td>
         <td>
             <input type="text" value="输入学号" id="studentID${status.count}" name="studentID">
         </td>
        <td>
             <input type="button" value="订阅" onclick="subscribe(${book.bookId},${status.count})">
        </td>
    </tr>
</c:forEach>
</table>
<div id="subRes"></div>
</body>
</html>
