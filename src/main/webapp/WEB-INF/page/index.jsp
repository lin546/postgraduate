<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>考研宝</title>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<br>
<div class="layui-container">

    <div class="layui-row layui-col-space15" style="height: 300px">
        <div class="layui-col-md4">
            <div class="layui-card">
                <div class="layui-card-header layui-bg-green">
                    <i class="layui-icon layui-icon-note"></i>
                    <b>学校选择</b>
                </div>
                <div class="layui-card-body">
                    <ul>
                        <c:forEach items="${XXXZ}" var="k" varStatus="st" begin="0">
                            <li>
                                <a href="resultpage?ID=${k.ID}" target="_blank">
                                    <span class="title">${k.title}</span><br>
                                    <span class="subtitle">${k.source}<fmt:formatDate value="${k.date}"
                                                                                      pattern='yyyy-MM-dd HH:mm:ss'/></span>
                                </a>
                            </li>
                            <hr>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="layui-col-md4">
            <div class="layui-card">
                <div class="layui-card-header layui-bg-green">
                    <i class="layui-icon layui-icon-note"></i>
                    <b>考研工具</b>
                </div>
                <div class="layui-card-body">
                    <ul class="tools">
                        <li>
                            <a href="http://yz.chsi.com.cn/sch/" target="_blank">
                                <span>院校库</span>中国研究生招生信息网
                            </a>
                        </li>
                        <hr>
                        <li>
                            <a href="http://yz.chsi.com.cn/zyk/" target="_blank">
                                <span>专业库</span>中国研究生招生信息网
                            </a>
                            <hr>
                        </li>
                        <li>
                            <a href="http://yz.chsi.com.cn/kyzx/zcdh/201709/20170901/1627013127.html#part04"
                               target="_blank"> <span>报名条件</span>中国研究生招生信息网
                            </a>
                            <hr>
                        </li>
                        <li>
                            <a href="http://yz.chsi.com.cn/yzwb/" target="_blank">
                                <span>报名平台</span>中国研究生招生信息网
                            </a>
                            <hr>
                        </li>
                        <li>
                            <a href="http://yz.chsi.com.cn/yzwb/#xcqr"
                               target="_blank"> <span>现场确认</span>中国研究生招生信息网
                            </a>
                            <hr>
                        </li>
                        <li>
                            <a href="http://yz.chsi.com.cn/yzwb/#zkzxz" target="_blank">
                                <span>下载准考证</span>中国研究生招生信息网
                            </a>
                            <hr>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="layui-col-md4">
            <div class="layui-tab">
                <ul class="layui-tab-title">
                    <li class="layui-this"><b>考研动态</b></li>
                    <li><b>考研热点</b></li>
                    <li><b>新闻资讯</b></li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-anim layui-anim-scaleSpring">
                        <c:forEach items="${KYDD}" var="k" varStatus="st" begin="0">
                            <li>
                                <a href="resultpage?ID=${k.ID}" target="_blank">
                                    <span>${k.title}</span><br>
                                    <span> ${k.source}<fmt:formatDate value="${k.date}"
                                                                      pattern='yyyy-MM-dd HH:mm:ss'/></span>
                                </a>
                            </li>
                            <hr>
                        </c:forEach></div>
                    <div class="layui-tab-item layui-show layui-anim layui-anim-scaleSpring">
                        <c:forEach items="${KYRD}" var="k" varStatus="st" begin="0">
                            <li>
                                <a href="resultpage?ID=${k.ID}" target="_blank">
                                    <span>${k.title}</span><br>
                                    <span> ${k.source}<fmt:formatDate value="${k.date}"
                                                                      pattern='yyyy-MM-dd HH:mm:ss'/></span>
                                </a>
                            </li>
                            <hr>
                        </c:forEach></div>
                    <div class="layui-tab-item layui-anim layui-anim-scaleSpring">
                        <c:forEach items="${XWZX}" var="k" varStatus="st" begin="0">
                            <li>
                                <a href="resultpage?ID=${k.ID}" target="_blank">
                                    <span>${k.title}</span><br>
                                    <span> ${k.source}<fmt:formatDate value="${k.date}"
                                                                      pattern='yyyy-MM-dd HH:mm:ss'/></span>
                                </a>
                            </li>
                            <hr>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- row2 -->
    <div class="layui-row layui-col-space15"  style="height: 350px">
        <div class="layui-col-md4">
            <div class="layui-card">
                <div class="layui-card-header layui-bg-green">
                    <i class="layui-icon layui-icon-note"></i>
                    <b>推荐免试</b>
                </div>
                <div class="layui-card-body">
                    <ul>
                        <c:forEach items="${TJMS}" var="k" varStatus="st" begin="0">
                            <li>
                                <a href="resultpage?ID=${t.ID}" target="_blank">
                                    <span>${k.title}</span><br>
                                    <span> ${k.source}<fmt:formatDate value="${k.date}"
                                                                      pattern='yyyy-MM-dd HH:mm:ss'/></span>
                                </a>
                            </li>
                            <hr>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="layui-col-md4">
            <div class="layui-card">
                <div class="layui-card-header layui-bg-green">
                    <i class="layui-icon layui-icon-note"></i>
                    <b>考研日程</b>
                </div>
                <div class="layui-card-body">
                    <ul class="comcategory">
                        <c:forEach items="${KYRC}" var="k" varStatus="st" begin="0">
                            <li>
                                <a href="resultpage?ID=${k.ID}" target="_blank">
                                    <span>${k.title}</span><br>
                                    <span> ${k.source}<fmt:formatDate value="${k.date}"
                                                                      pattern='yyyy-MM-dd HH:mm:ss'/></span>
                                </a>
                            </li>
                            <hr>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="layui-col-md4">
            <div class="layui-tab">
                <ul class="layui-tab-title">
                    <li class="layui-this"><b>考研政策</b></li>
                    <li><b>考研简章</b></li>
                    <li><b>国家政策</b></li>

                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-anim layui-anim-scaleSpring">
                        <c:forEach items="${KYZZ}" var="k" varStatus="st" begin="0">
                            <li>
                                <a href="resultpage?ID=${k.ID}" target="_blank">
                                    <span>${k.title}</span><br>
                                    <span> ${k.source}<fmt:formatDate value="${k.date}"
                                                                      pattern='yyyy-MM-dd HH:mm:ss'/></span>
                                </a>
                            </li>
                            <hr>
                        </c:forEach>
                    </div>
                    <div class="layui-tab-item layui-show layui-anim layui-anim-scaleSpring">
                        <c:forEach items="${KYJZ}" var="k" varStatus="st" begin="0">
                            <li>
                                <a href="resultpage?ID=${k.ID}" target="_blank">
                                    <span>${k.title}</span><br>
                                    <span> ${k.source}<fmt:formatDate value="${k.date}"
                                                                      pattern='yyyy-MM-dd HH:mm:ss'/></span>
                                </a>
                            </li>
                            <hr>
                        </c:forEach>
                    </div>
                    <div class="layui-tab-item layui-anim layui-anim-scaleSpring">
                        <c:forEach items="${GJZZ}" var="k" varStatus="st" begin="0">
                            <li>
                                <a href="resultpage?ID=${k.ID}" target="_blank">
                                    <span>${k.title}</span><br>
                                    <span> ${k.source}<fmt:formatDate value="${k.date}"
                                                                      pattern='yyyy-MM-dd HH:mm:ss'/></span>
                                </a>
                            </li>
                            <hr>
                        </c:forEach>
                    </div>
                    <div class="layui-tab-item">
                        <c:forEach items="${KYRC}" var="k" varStatus="st" begin="0">
                            <li>
                                <a href="resultpage?ID=${k.ID}" target="_blank">
                                    <span>${k.title}</span><br>
                                    <span> ${k.source}<fmt:formatDate value="${k.date}"
                                                                      pattern='yyyy-MM-dd HH:mm:ss'/></span>
                                </a>
                            </li>
                            <hr>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--row3 -->
    <div class="layui-row layui-col-space15" style="height: 350px">
        <div class="layui-col-md4">
            <div class="layui-card">
                <div class="layui-card-header layui-bg-green">
                    <i class="layui-icon layui-icon-note"></i>
                    <b>备考指南</b>
                </div>
                <div class="layui-card-body">
                    <ul class="comcategory">
                        <c:forEach items="${BKZN}" var="k" varStatus="st" begin="0">
                            <li>
                                <a href="resultpage?ID=${k.ID}" target="_blank">
                                    <span>${k.title}</span><br>
                                    <span> ${k.source}<fmt:formatDate value="${k.date}"
                                                                      pattern='yyyy-MM-dd HH:mm:ss'/></span>
                                </a>
                            </li>
                            <hr>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="layui-col-md4">
            <div class="layui-card">
                <div class="layui-card-header layui-bg-green">
                    <i class="layui-icon layui-icon-note"></i>
                    <b>考研资料</b>
                </div>
                <div class="layui-card-body">
                    <ul>
                        <c:forEach items="${KYZL}" var="k" varStatus="st" begin="0">
                            <li style="white-space:nowrap;">
                                <a href="resultpage?ID=${k.ID}" target="_blank">
                                    <span>${k.title}</span><br>
                                    <span> ${k.source}<fmt:formatDate value="${k.date}"
                                                                      pattern='yyyy-MM-dd HH:mm:ss'/></span>
                                </a>
                            </li>
                            <hr>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="layui-bg-black" style="height: 30px;font-size: 15px">
    @2018-2019 版权所有 2019年毕业设计
</div>
</body>
</html>