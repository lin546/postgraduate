<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>考研信息平台</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
</head>
<body>

<div class="layui-row">
    <div class="layui-col-md12">
        <h3 style="text-align: center;background-color: aliceblue">Discuss</h3>
        <hr>
        <%
            int userId = 0;
            if (session.getAttribute("userId") != null) {
                userId = (int) session.getAttribute("userId");
            }
        %>
        <ul>
            <c:forEach items="${reviews}" var="r" varStatus="st" begin="0">
                <li><img src="${r.user.image}" width="45" height="45">
                    <span>第${LP.start+st.index+1}楼
                        ID:${r.user.nickname}
                        回复时间：<fmt:formatDate value="${r.date}" pattern='yyyy-MM-dd HH:mm:ss'/>&nbsp
                        <c:set var="uid" value="${r.UID}"/>
                        <c:set var="UID" value="<%=userId%>"/>
                        <c:if test="${uid==UID}">
                            <a href="deletereviews?ID=${r.ID}">删除</a>
                        </c:if>
                    </span> <br><br>
                    <span style="font-size: 16px">${r.content}</span>
                </li>
                <hr>
            </c:forEach>
            <li>
                <div style="text-align:center">
                    <a href="?start=0&PID=${PID}">首 页</a>
                    <a href="?start=${LP.start-LP.count}&PID=${PID}">上一页</a>
                    <a href="?start=${LP.start+LP.count}&PID=${PID}">下一页</a>
                    <a href="?start=${LP.last}&PID=${PID}">末 页</a>
                </div>
                <%
                    if (session.getAttribute("useraccount") != null) {
                %>
                <span style="float: left;">
                    <img src="<%=(String) session.getAttribute("userImg")%>" width="45" height="45" alt="头像">
								<span>
									ID:<%=(String) session.getAttribute("usernickname")%>
								</span>
                </span> &nbsp&nbsp
                <form method="post" action="addreviews" class="layui-form">
                    <input type="hidden"
                           value="<%=(userId)%>" id="UID" name="UID">
                    <input type="hidden" value="${PID}" id="PID" name="PID">
                    <textarea name="content" required lay-verify="required" placeholder="评论..." class="layui-textarea"></textarea>
                    <button type="submit" class="layui-btn ">发送
                    </button>
                </form>
            </li>
            <%
            } else {
            %>
            <span style="font-size: 20px"> 加入讨论需要 <a href="signinpage" target="_parent">登录</a></span>
            <%
                }
            %>
            <div style="clear: both;"></div>
        </ul>
    </div>
</div>
<br>
<script src="${pageContext.request.contextPath}/static/layui.all.js"/>
</body>
</html>