<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>crawler</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css"/>
</head>
<body>
<br>
<div class="layui-row">
        <form class="layui-form layui-form-pane" action="getLinks">
            <div class="layui-form-item" pane>
                <label class="layui-form-label">链接地址</label>
                <div class="layui-input-block">
                    <input type="text" name="link" placeholder="url" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" pane>
                <label class="layui-form-label" >学校</label>
                <div class="layui-input-block">
                    <input type="text" name="source" placeholder="school" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" pane>
                <label class="layui-form-label">链接条件</label>
                <div class="layui-input-block">
                    <input type="text" name="linkcondition" placeholder="condition" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" pane>
                <label class="layui-form-label">正文条件</label>
                <div class="layui-input-block">
                    <input type="text" name="ctxtcondition" placeholder="condition" class="layui-input">
                </div>
            </div>
            <div style="text-align: center">
                <button type="submit" class="layui-btn">提交</button>
            </div>
        </form>
</div>
<div class="layui-row">
    <br>
    <table class="table table-hover table-bordered ">
        <thead>
        <tr>
            <th>链接名</th>
            <th>链接地址</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pages}" var="p" varStatus="st" begin="0">
            <tr>
                <td>${p.title}</td>
                <td>${p.link}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div style="text-align: center">
        <button class="layui-btn" onclick="window.location.href='webdatapage'">查看</button>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/layui.all.js"></script>
</body>
</html>