<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/7/30
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h3>表单提交</h3>
<form action="test/add" method="post">
    <p>图书名称：<input type="text" name="bookName"></p>
    <p>图书作者：<input type="text" name="bookAuthor"></p>
    <p>图书价格：<input type="text" name="bookPrice"></p>
    <p>出版时间：<input type="text" name="publishTime"></p>
    <p><input type="submit" value="提交"></p>
</form>

<h3>超链接提交</h3>
<a href="/book/add?bookName=Java">超链接提交</a>

<h3>AJAX提交</h3>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<input type="button" value="ajax提交" id="btn1"/>
<script type="text/javascript">
    $('#btn1').click(function () {
        var obj = {};
        obj.bookName = "java";
        obj.bookAuthor = "张三";
        obj.bookPrice = 3.33;

        var s = JSON.stringify(obj); //将对象转成json格式
        $.ajax({
            url: "book/update",
            type: "post",
            data: s,
            contentType: "application/json", ////如果data的值为json格式字符串，contentType必须设置为"application/json"
            dataType:"json", //返回响应数据类型（res）（默认是字符串） 作用：在控制台可以展开查看
            success: function (res) {
                console.log(res);
            }
        })
    })
</script>

</body>
</html>
