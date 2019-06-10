<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
</head>
<body>
<ul class="layui-nav">

    <li class="layui-nav-item" style="font-size: 25px">
        <a href="index" target="_parent" style="padding: 0px 10px;font-size: 19px">
            <i class="layui-icon layui-icon-template-1" style="font-size: 20px"></i> 研
        </a>
    </li>

    <%
        if (session.getAttribute("usernickname") != null) {
    %>
    <span class=" layui-layout-right">
    <li class="layui-nav-item">
        <a href="userinfopage" target="_parent" style="padding: 0px 10px;">个人中心</a>
    </li>
    <li class="layui-nav-item">
        <a href="userlogout" target="_parent" style="padding: 0px 10px;">退出</a>
    </li>
         </span>
    <%
    } else {
    %>
    <span class=" layui-layout-right">
    <li class="layui-nav-item">
        <a href="signuppage" target="_parent" style="padding: 0px 10px;">
           <i class="layui-icon layui-icon-edit" style="font-size: 15px"></i>注册
        </a>
    </li>
    <li class="layui-nav-item" style="padding: 0px 10px;">
        <a href="signinpage" target="_parent" style="padding: 0px 10px;">
            <i class="layui-icon layui-icon-username" style="font-size: 15px"></i>登录
        </a>
    </li>
        </span>
    <%
        }
    %>
</ul>

<script src="${pageContext.request.contextPath}/static/layui.all.js"></script>
</body>
</html>
