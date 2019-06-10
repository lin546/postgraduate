<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>考研宝</title>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>

<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md10 layui-col-md-offset1">
            <h2 style="text-align: center">${page.title}</h2>
            <h3 style="text-align: center">
                <%
                    int userId = 0;
                    if (session.getAttribute("userId") != null) {
                        userId = (int) session.getAttribute("userId");
                        int i = (int) request.getAttribute("isfavorite");
                        if (i != 0) {
                %>
                    <form action="deletefavoritepage" method="post">
                <%} else {%>
                    <form action="addfavoritepage" method="post">
                <%}}else{%>
                    <form action="signinpage" method="post">
                 <%}%>
                        <button type="submit" style="background: none; border: none; font-size: 30px">
                            <%
                                    if (session.getAttribute("userId") != null) {
                                        userId = (int) session.getAttribute("userId");
                                        int i = (int) request.getAttribute("isfavorite");
                                        if (i != 0) {
                            %>
                                <i class="layui-icon layui-icon-star-fill"
                                   style="color: rgb(0,119,115);font-size: 20px"></i>
                                <input type="hidden" value="${page.ID}" id="PID" name="PID">
                                <input type="hidden" value="<%=userId%>" id="UID" name="UID">
                                <%
                                } else {
                                %>
                                <span style="color: #ff574d"><i class="layui-icon layui-icon-star"></i></span>
                                <input type="hidden" value="${page.ID}" id="PID" name="PID">
                                <input type="hidden" value="<%=userId%>" id="UID" name="UID">

                                <%
                                    }
                                } else {
                                %><span style="color: #FFD700">&#xf006;</span>
                                <%
                                    }
                                %>
                            </button>
                        </form>
            </h3>
            <div>
                ${page.content}
                原文链接：<a href="${page.link}">${page.link}</a>
            </div>
            <hr>
            <iframe src="reviewspage?PID=${page.ID}" id="iframepage" scrolling="no" frameborder="0"
                    width="100%" onLoad="iFrameHeight()">
            </iframe>

        </div>
    </div>

</div>

<div class="layui-bg-black" style="height: 30px;font-size: 15px">
    @2018-2019 版权所有 2019年毕业设计
</div>

<script type="text/javascript" language="javascript">
    function iFrameHeight() {
        var ifm = document.getElementById("iframepage");
        var subWeb = document.frames ? document.frames["iframepage"].document
            : ifm.contentDocument;
        if (ifm != null && subWeb != null) {
            ifm.height = subWeb.body.scrollHeight;
            ifm.width = subWeb.body.scrollWidth;
        }
    }
</script>
</body>
</html>