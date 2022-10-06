<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/8/1
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div id="container"></div>
<script type="text/javascript">
    $.ajax({
        url: 'book/listImgs',
        method: 'get',
        dataType: 'json',
        success: function (res) {
            console.log(res);
            for (let i = 0; i < res.length; i++) {
                var htmlStr = "<div class='card' style='width: 18rem;'><img  src='" + "imgs/" + res[i] + "' class='card-img-top'><div class='card-body'><a class='btn btn-primary' href='book/download?fileName=" + res[i] + "'>下载</a></div></div>";
                $("#container").append(htmlStr);
            }
        }
    });


</script>
</body>
<style>
    div{
        display: flex ;
        justify-content: space-between;
    }
    img{
        width: 200px;
        height: 200px;
    }
</style>
</html>
