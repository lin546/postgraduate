<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>adminsignin</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
<body>
<ul class="layui-nav" style="margin-left: 0px">

    <li class="layui-nav-item" style="font-size: 25px">
        <a href="#" target="_parent" style="padding: 0px 10px;font-size: 19px">
            <i class="layui-icon layui-icon-template-1" style="font-size: 20px"></i> 研
        </a>
    </li>
</ul>
<div style="height: 100px"></div>
<form action="adminlogin" method="post" class="layui-form">
    <div class="layui-row">
        <div class="layui-col-md3 layui-col-md-offset4">
            <div class="user-div">
                <h1>用户登录</h1>
                <input type="text" class="layui-input" name="account" value="" placeholder="请输入账户"/><br>
                <input type="password" class="layui-input" name="password" value="" placeholder="请输入密码"/>

                <input type="submit" class="layui-btn" value="Submit">
            </div>
        </div>
    </div>
</form>
<script src="${pageContext.request.contextPath}/static/js/layui.all.js"></script>
</body>  
</html>  