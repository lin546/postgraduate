<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div style="height: 100px"></div>

<form action="usersignup" method="post">
    <div class="layui-row">
        <div class="layui-col-md3 layui-col-md-offset4">
            <h2>用户注册</h2>
            <label for="account">账号</label>
            <input type="text" class="layui-input" id="account" name="account" value="" placeholder="请输入账号"/>
            <label for="password">密码</label>
            <input type="password" class="layui-input" id="password" name="password" value="" placeholder="请输入密码"/>
            <label for="password_again">确认密码</label>
            <input type="password" class="layui-input" id="password_again" name="password_again" value="" placeholder="请输入确认密码"/>
            <label for="phone">电话</label>
            <input type="text" class="layui-input" id="phone" name="phone" value="" placeholder="请输入电话"/>
            <label for="email">邮箱</label>
            <input type="text" class="layui-input" id="email" name="email" value="" placeholder="请输入邮箱"/>
            <button class="layui-btn">立即注册</button>&nbsp
            <b>${TEXT}</b>
        </div>
    </div>
</form>
</body>
</html>