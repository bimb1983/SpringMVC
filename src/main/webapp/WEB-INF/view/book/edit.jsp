<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/20
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑图书</title>
    <meta charset="UTF-8"/>
</head>
<body>
<h2>编辑图书</h2>
<form action="editSave" method="post">
    <fieldset>
        <legend>图书详细</legend>
        <p>
            <label for="title">书名：</label>
            <input type="text" name="title" id="title" value="${book.title}"/>
        </p>
        <p>
            <label for="typename">类型：</label>
            <select name="typename" id="typename">
                <option value="计算机" ${book.typename=="计算机"?"selected='selected'":""}>计算机</option>
                <option value="软件工程" ${book.typename=="软件工程"?"selected='selected'":""}>软件工程</option>
                <option value="神话" ${book.typename=="神话"?"selected='selected'":""}>神话</option>
                <option value="软件开发" ${book.typename=="软件开发"?"selected='selected'":""}>软件开发</option>
            </select>
        </p>
        <p>
            <label for="price">价格：</label>
            <input type="text" name="price" id="price" value="${book.price}"/>
        </p>
        <p>
            <label for="state2">状态：</label>
            <input type="radio" name="state" id="state1" value="已借出" ${book.state=="已借出"?"checked='checked'":""}/>已借出
            <input type="radio" name="state" id="state2" value="未借出" ${book.state=="未借出"?"checked='checked'":""}/>未借出
        </p>
        <p>
            <input type="hidden" name="id" value="${book.id}" />
            <input type="submit" value="保存"/>
        </p>
    </fieldset>
</form>
</body>
</html>