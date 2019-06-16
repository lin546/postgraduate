<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updatapush</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
</head>
<body>
<div style="width: 500px;height: 800px">
		<form class="layui-form" action="updatapushwithtype" method="post">
			<!-- 水平表单 -->
			<div class="layui-form-item">
				<input type="hidden" value="${push.ID}" id="ID" name="ID">
				<label class="layui-form-label"><b>标题</b></label>
				<div class="layui-input-block">
					<input type="text" class="layui-input" name="title" value="${push.page.title}" disabled="disabled">
				</div>
			</div>
			<div class="layui-form-item">
				<label  class="layui-form-label"><b>链接</b></label>
				<div class="layui-input-block">
					<input type="text" class="layui-input" name="link" value="${push.page.link}" disabled>
				</div>
			</div>
			<div class="layui-form-item">
				<label  class="layui-form-label"><b>来源</b></label>
				<div class="layui-input-block">
					<input type="text" class="layui-input" name="source" value="${push.page.source}" disabled>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"><b>推送位置</b></label>
				<div class="layui-input-block">
					<select name="type" lay-verify="required">
						<option>学校选择</option>
						<option>考研工具</option>
						<option>考研动态</option>
						<option>考研热点</option>
						<option>推荐免试</option>
						<option>考研日程</option>
						<option>考研政策</option>
						<option>考研简章</option>
						<option>备考指南</option>
						<option>考研资料</option>
						<option>新闻资讯</option>
						<option>国家政策</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="submit" class="layui-btn">保存</button>
				</div>
			</div>
		</form>
	</div>
</div>
<script src="${pageContext.request.contextPath}/static/layui.all.js"></script>
</body>
</html>
