<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>favorite</title>
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="head.jsp"/>

<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md8 layui-col-md-offset2">
            <h3>收藏夹</h3>
            <table class="layui-table">
                <thead>
                <tr>
                    <th>标题</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${favorites}" var="f" varStatus="st" begin="0">
                    <tr>
                        <td><a href="resultpage?ID=${f.PID}" target="_blank">${f.title}</a></td>
                        <td>
                            <button class="layui-btn" onclick="window.location.href='deletefavorite?ID=${f.ID}'">
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

<script src="lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
    $("[rel=tooltip]").tooltip();
    $(function () {
        $('.demo-cancel-click').click(function () {
            return false;
        });
    });
</script>
</body>
</html>
