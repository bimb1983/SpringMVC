<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书管理</title>
    <meta charset="UTF-8"/>
</head>
<body>
<h2>图书管理</h2>
<form action="dels" method="post">
    <table width="100%" id="tab" border="1">
        <tr>
            <td><input type="checkbox" id="chbAll" /></td>
            <td>编号</td>
            <td>书名</td>
            <td>类型</td>
            <td>价格</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td><input name="id" type="checkbox" value="${book.id}"/></td>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.typename}</td>
                <td>${book.price}</td>
                <td>${book.state}</td>
                <td><a href="del/${book.id}" class="del">删除</a> | <a href="<c:url value="/Book/edit?id=${book.id}"></c:url>">编辑</a></td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <input type="submit" value="删除选择项" class="del"/>
        <input type="button" value="添加" onclick="location.href='<c:url value="/Book/add"></c:url>'" />
    </p>
</form>

<p>
    ${msg}
</p>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
    $(".del").click(function(){
        return confirm("您确定要删除吗？");
    });

    //全选与反选
    $("#chbAll").change(function(){
        $("input[name=id]").prop("checked",$(this).prop("checked"));
    });

    var msg='${msg}';
    if(msg){
        alert(msg);
    }
</script>
</body>
</html>