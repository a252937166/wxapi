<html>
<head>
    <title>测试页面</title>

</head>
<body>
<#list userList as user>
用户名：${user.username} <br>
性  别：${user.sex}<br>
年  龄: ${user.age}<br>
===================<br>
</#list>
<form action="/users/add" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="file">
    <input type="submit" value="提交">
</form>
</body>
</html>