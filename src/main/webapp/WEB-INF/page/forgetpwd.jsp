<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>忘记密码</title>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div style="height: 100px"></div>
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md3 layui-col-md-offset4">
            <form action="forgetpwd" method="post">

                <div class="user-div">
                    <h1>忘记密码</h1>

                        <input type="text" name="account" class="layui-input"
                                                         id="acount" value="" placeholder="原账户"/><br>
                        <input type="text" name="phone" class="layui-input"
                                                  id="phone" value="" placeholder="原手机号"/><br>
                        <input type="text" name="email" class="layui-input"
                                                  id="email" value="" placeholder="原邮箱"/><br>
                        <input type="password" name="password" class="layui-input"
                                                  id="password" value="" placeholder="新密码"/><br>
                        <input type="password" name="password_again" class="layui-input"
                                   id="password_again" value="" placeholder="再次输入新密码"/>

                    <button type="submit" class="layui-btn">修改密码</button>

                </div>
            </form>
        </div>
    </div>
</div>
<div align="center" style="color: red">
    <span style="font-size: 20px">${TEXT}</span>
</div>
</body>
</html>