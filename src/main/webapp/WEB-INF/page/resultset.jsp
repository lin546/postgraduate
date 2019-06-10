<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>考研宝</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
</head>
<body>
		<iframe name="" frameborder="0" scrolling="no" marginwidth="0"
		marginheight="0" width="100%" height="170" src="head"></iframe>
	<div class="comarticle">
		<div class="cg">
			<div class="am-u-sm-12">
				<div class="comarticle-right">
					<h1>${keyword} 查询结果 共${LP.total}</h1>
					<ul>
						<c:forEach items="${pages}" var="p" varStatus="st" begin="0">
							<li><a href="resultpage?ID=${p.ID}"> <strong>${p.source}-${p.title}</strong>
									<h1>
										<em>更新时间：${p.date}</em><em>浏览量：${p.view}</em><em>收藏量：${p.star}</em>
									</h1>
							</a></li>
						</c:forEach>
					</ul>
				</div>
				<div style="text-align: center">
					<a href="?start=0&keyword=${keyword}">首 页</a>
					<a href="?start=${LP.start-LP.count}&keyword=${keyword}">上一页</a>
					<a href="?start=${LP.start+LP.count}&keyword=${keyword}">下一页</a> <a
						href="?start=${LP.last}&keyword=${keyword}">末 页</a>
				</div>
			</div>
		</div>
	</div>
	<footer class="footer">
	<div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
		<h3>@2018-2019 版权所有 2019年毕业设计</h3>
	</div>
	</footer>
</body>
</html>