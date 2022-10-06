<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/8/1
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table width="100%" height="700">
        <tr>
            <td width="200" style="border-right: #007FFF 2px solid">
                <ul>
                    <li><a href="book-add.jsp" target="mainFrame">添加图书</a></li>
                    <li><a href="list.jsp" target="mainFrame">文件列表</a></li>
                </ul>

            </td>
            <td>
                <iframe name="mainFrame" width="100%" height="700" frameborder="0"></iframe>
            </td>
        </tr>
    </table>
</body>
</html>
