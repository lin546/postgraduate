<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>favorite</title>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md8 layui-col-md-offset2">
            <h2>我的评论</h2>
            <table class="layui-table">
                <thead>
                <tr>
                    <th>正文</th>
                    <th>发布时间</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${reviews}" var="r" varStatus="st" begin="0">
                    <tr>
                        <td><a href="resultpage?ID=${r.PID}" target="_blank">${r.content}</a></td>
                        <td><fmt:formatDate value="${r.date}" pattern='yyyy-MM-dd HH:mm:ss'/></td>
                        <td style="width: 30px">
                            <button class="layui-btn" onclick="window.location.href='deletereviewspage?ID=${r.ID}'">
                                <span class="layui-icon layui-icon-delete"></span>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

    <div style="text-align:center">
        <a href="?start=0">首 页</a>
        <a href="?start=${LP.start-LP.count}">上一页</a>
        <a href="?start=${LP.start+LP.count}">下一页</a>
        <a href="?start=${LP.last}">末 页</a>
    </div>

</body>
</html>
