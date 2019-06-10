<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>admin</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
</head>
<body>
<ul class="layui-nav">
    <li class="layui-nav-item" style="font-size: 25px">
        <a href="#" target="_parent" style="padding: 0px 10px;font-size: 19px"><b>后台管理系统</b>
        </a>
    </li>
    <div class="layui-layout-right layui-nav-item">
        <li class="layui-nav-item ">
            <a href="adminlogin" target="_parent" style="font-size: 15px">退出</a>
        </li>
    </div>

</ul>
<br>
    <div class="layui-container">
        <div class="layui-row">
            <div class="layui-col-md2">
                <ul class="layui-nav layui-nav-tree" style="width: 90%" lay-filter="test">
                    <li class="layui-nav-item"><a href="usermanagerpage" target="center">用户管理</a></li>
                    <li class="layui-nav-item"><a href="indexpushpage" target="center">首页推送管理</a></li>
                    <li class="layui-nav-item"><a href="webdatapage" target="center">数据统计</a></li>
                    <li class="layui-nav-item"><a href="crawlerpage" target="center">爬取文章</a></li>
                    <li class="layui-nav-item"><a href="adminmanagerpage" target="center">管理员管理</a></li>
                    <li class="layui-nav-item"><a href="help" target="center">Jsoup帮助</a></li>
                </ul>
            </div>
            <div class="layui-col-md10">
                        <iframe align="center" name="center" src="usermanagerpage" width="100%"
                                height="600" frameborder="0" border="0" scrolling="no"
                                onload="this.height=this.contentWindow.document.body.scrollHeight">
                        </iframe>
            </div>
        </div>
    </div>
<script src="${pageContext.request.contextPath}/static/layui.all.js"></script>
</body>
</html>