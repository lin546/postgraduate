<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>updataadmin</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="main-content">
		<form class="form-horizontal" action="updataadmin" method="post">
					<input type="hidden" value="${admin.ID}" id="ID" name="ID" >
					<input type="hidden" value="${admin.account}" id="account" name="account" >
			<div class="form-group">
				<label class="col-sm-2 control-label">账号</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" value="${admin.account}" disabled="">
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">密码</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" value="${admin.password}"
						id="password" name="password" placeholder="密码">
				</div>
			</div>

			<div class="form-group">
				<label  class="col-sm-2 control-label">再次输入密码</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" value="${admin.password}"
						id="password_again" name="password_again" placeholder="再次输入密码">
				</div>
			</div>
			<tr>
				<div class="form-group">
					<label  class="col-sm-2 control-label">权限</label>
					<div class="col-sm-4">
						<select class="form-control" id="power" name="power">
							<option>用户管理员</option>
							<option>推送管理员</option>
							<option>数据管理员</option>
							<option>爬虫管理员</option>
							<option>最高管理员</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">保存</button>
					</div>
				</div>
		</form>
		<div align="center" style="color: red">
			<span style="font-size: 20px">${TEXT}</span>
		</div>
	</div>
</body>

</html>

