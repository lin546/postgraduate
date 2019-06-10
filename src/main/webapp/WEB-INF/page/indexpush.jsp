<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>indexpush</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
</head>
<body>
<div class="layui-row">
    <form action="searchpush">
        <div class="layui-input-inline">
            <input type="text" name="keyword" placeholder="在此搜索" class="layui-input">
        </div>
        <button type="submit" class="layui-btn layui-btn-primary">搜索</button>
    </form>
    <form action="addpushpage" class="layui-layout-right">
        <button class="layui-btn"><i class="layui-icon-add-1 layui-icon"></i> New</button>
    </form>
</div>
<div class="layui-row">
    <table class="layui-table" lay-skin="line">
        <thead>
        <tr>
            <th>ID</th>
            <th>页面ID</th>
            <th>页面标题</th>
            <th>页面来源</th>
            <th>推送位置</th>
            <th>修改</th>
            <th style="width: 3.5em;">删除</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${pushs}" var="p" varStatus="st" begin="0">
            <tr>
                <td>${p.ID}</td>
                <td>${p.PID}</td>
                <td>${p.page.title}</td>
                <td>${p.page.source}</td>
                <td>${p.type}</td>
                <td>
                    <button class="layui-btn" onclick="window.location.href='updatatype?ID=${p.ID}'">修改</button>
                </td>
                <td>
                    <button class="layui-btn layui-btn-danger" onclick="window.location.href='deletepush?ID=${p.ID}'">删除
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div style="text-align: center">
        <a href="?start=0&keyword=${keyword}">首 页</a>
        <a href="?start=${LP.start-LP.count}&keyword=${keyword}">上一页</a>
        <a href="?start=${LP.start+LP.count}&keyword=${keyword}">下一页</a>
        <a href="?start=${LP.last}&keyword=${keyword}">末 页</a>
    </div>
</div>
<br>
</body>
</html>