<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>addadmin</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
</head>
<body>
<div style="width: 500px;height: 800px">
    <form class="layui-form" action="addadmin" method="post">

        <div class="layui-form-item">
            <label class="layui-form-label"><b>账号</b></label>
            <div class="layui-input-block">
                <input type="text" class="layui-input" name="account"
                       placeholder="账户">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><b>密码</b></label>
            <div class="layui-input-block">
                <input type="password" class="layui-input" name="password"
                       placeholder="密码">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><b>再次输入</b></label>
            <div class="layui-input-block">
                <input type="password" class="layui-input" name="password_again"
                       placeholder="密码">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><b>权限</b></label>
            <div class="layui-input-block">
                <select name="power" lay-verify="required">
                    <option>用户管理员</option>
                    <option>推送管理员</option>
                    <option>数据管理员</option>
                    <option>爬虫管理员</option>
                    <option>最高管理员</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn">添加</button>
            </div>
        </div>
    </form>
    <div align="center" style="color: red">
        <span style="font-size: 20px">${TEXT}</span>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/layui.all.js"></script>
</body>

</html>

