<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书</title>
    <meta charset="UTF-8"/>
</head>
<body>
<h2>添加图书</h2>
<form action="addSave" method="post">
    <fieldset>
        <legend>图书详细</legend>
        <p>
            <label for="title">书名：</label>
            <input type="text" name="title" id="title" value="${book.title}"/>
        </p>
        <p>
            <label for="typename">类型：</label>
            <select name="typename" id="typename">
                <option value="经济">经济</option>
                <option value="文学">文学</option>
                <option value="天文">天文</option>
            </select>
        </p>
        <p>
            <label for="price">价格：</label>
            <input type="text" name="price" id="price" value="${book.price}"/>
        </p>
        <p>
            <label for="state2">状态：</label>
            <input type="radio" name="state" id="state1" value="已借出"/>已借出
            <input type="radio" name="state" id="state2" value="未借出"/>未借出
        </p>
        <p>
            <input type="submit" value="提交"/>
        </p>
    </fieldset>
</form>
</body>
</html>