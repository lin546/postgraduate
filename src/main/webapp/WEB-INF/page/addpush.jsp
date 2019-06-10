<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>addpush</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
</head>
<body>

    <div class="layui-row">
        <form  action="searchunpush">
            <div class="layui-input-inline">
                <input type="text" name="keyword" placeholder="在此搜索" class="layui-input">
            </div>
            <button type="submit" class="layui-btn layui-btn-primary">搜索</button>
        </form>
    </div>


    <div class="layui-row">
        <table class="layui-table" lay-skin="line">
            <thead>
            <tr>
                <th>ID</th><th>标题</th><th>学校</th><th>浏览量</th><th>收藏量</th><th>录入时间</th><th>添加</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pages}" var="p" varStatus="st" begin="0">
                <tr>
                    <td>${p.ID}</td>
                    <td><a href="resultpage?ID=${p.ID}">${p.title}</a></td>
                    <td>${p.source}</td>
                    <td>${p.view}</td>
                    <td>${p.star}</td>
                    <td><fmt:formatDate value="${p.date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>
                        <button type="button" class="layui-btn"
                                onclick="window.location.href='addpush?PID=${p.ID}'">添加
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
        <br>
    </div>
</body>
</html>