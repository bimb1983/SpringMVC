<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/styles/main.css"/>"  type="text/css" rel="stylesheet" />
    <title>产品管理</title>
</head>
<body>
<div class="main">
    <h2 class="title"><span>产品管理</span></h2>
    <form method="get">
        名称：<input type="text" name="searchKey" value="${searchKey}"/>
        <input type="submit"  value="搜索" class="btn out"/>
    </form>
    <form action="productcontroller/deletes" method="post">
        <table border="1" width="100%" class="tab">
            <tr>
                <th><input type="checkbox" id="chbAll"></th>
                <th>编号</th>
                <th>产品名</th>
                <th>价格</th>
                <th>类型</th>
                <th>操作</th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <th><input type="checkbox" name="id" value="${product.id}"></th>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.productType.name}</td>
                    <td>
                        <a href="productcontroller/delete/${product.id}" class="abtn">删除</a>
                        <a href="productcontroller/edit/${product.id}" class="abtn">编辑</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p style="color: red">${message}</p>
        <p>
            <a href="productcontroller/add" class="abtn out">添加</a>
            <input type="submit"  value="删除选择项" class="btn out"/>
        </p>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
    </form>
</div>
</body>
</html>