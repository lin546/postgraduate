<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
</head>
<body>
<jsp:include page="head.jsp"/>
<div style="height: 100px"></div>
<form action="userlogin" method="post" class="layui-form">
    <div class="layui-row">
        <div class="layui-col-md3 layui-col-md-offset4">
            <div class="layui-card">
                <div class="layui-card-header" style="font-size: 20px">用户登录</div>
                <div class="layui-card-body">
                    <label for="account" >账户</label>
                    <input type="text" class="layui-input" id="account" name="account" value="" placeholder="请输入账户"/>
                    <label for="password" >密码</label>
                    <input type="password" class="layui-input" id="password" name="password" value="" placeholder="请输入密码"/>

                    <input type="submit" class="layui-btn" value="确认" data-method="confirmTrans"/>
                    <a  type="submit" class="layui-btn" href="forgetpwdpage">忘记密码</a>
                    <b>${TEXT}</b>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>