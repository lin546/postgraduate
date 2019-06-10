<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
</head>
<style>
</style>
<body>
<ul class="layui-nav" style="margin-left: 0px">
    <li class="layui-nav-item" style="font-size: 25px">
        <a href="index" target="_parent" style="padding: 0px 10px;font-size: 19px">
            <i class="layui-icon layui-icon-template-1" style="font-size: 20px"></i> 研
        </a>
    </li>

    <span class=" layui-layout-right">
    <li class="layui-nav-item">
        <a href="userinfopage" target="_parent" style="padding: 0px 10px;">个人中心</a>
    </li>
    <li class="layui-nav-item">
        <a href="userlogout" target="_parent" style="padding: 0px 10px;">退出</a>
    </li>
    </span>

</ul>

<div class="layui-container" style="margin-top: 60px">
    <div class="layui-row">
        <div class="layui-col-md6 layui-col-md-offset3">
            <table class="layui-table">
                <tr>
                    <td><img src="${user.image}"></td>
                    <td>用户名：</td>
                    <td>${user.nickname}</td>
                </tr>
                <tr>
                    <td></td>
                    <td>性别：</td>
                    <td>${user.sex}</td>
                </tr>
                <tr>
                    <td></td>
                    <td>电话:</td>
                    <td>${user.phone}</td>
                </tr>
                <tr>
                    <td></td>
                    <td>创建时间:</td>
                    <td><fmt:formatDate value="${user.date}" pattern='yyyy年MM月dd日 HH:mm:ss'/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>生日:</td>
                    <td><fmt:formatDate value="${user.birthday}" pattern='yyyy年MM月dd日'/></td>
                </tr>
                <tr>
                    <td>
                        <a href="favoritepage" target="left">
                            <button class="layui-btn">收藏了:${numF}</button>
                        </a>
                    </td>
                    <td>
                        <a href="reviewslist" target="left">
                            <button class="layui-btn">评论了:${numR}</button>
                        </a>
                    </td>
                    <td>
                        <button class="layui-btn"
                                onclick="window.location.href='updatauserpage'">编辑个人资料
                        </button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/layui.all.js"></script>
</body>
</html>