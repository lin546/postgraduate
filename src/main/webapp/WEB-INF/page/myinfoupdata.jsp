<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title data-react-helmet="true">编辑个人资料</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
</head>
<body class="Entry-body" style="background-color: white;">
<jsp:include page="head.jsp"></jsp:include>

<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md7 layui-col-md-offset2">
            <form class="layui-form" action="updatauser" method="post">
                <table class="layui-table" lay-skin="line">
                    <tbody>
                    <tr>
                        <td><img class="th" src="${user.image}"></td>
                        <td>用户名：</td>
                        <td>
                            <input type="text" value="${user.account}" class="layui-input" disabled="disabled"/>
                        </td>
                        <td>
                            <a class="layui-btn" href="userinfopage">
                                返回我的主页
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>昵称：</td>
                        <td>
                            <input type="text" class="layui-input" id="nickname" name="nickname" value="${user.nickname}"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>性别:</td>
                        <td>
                            <div class="layui-form-item">
                                <input type="radio" name="sex" value="男" title="男">
                                <input type="radio" name="sex" value="女" title="女" checked>
                                <input type="radio" name="sex" value="保密" title="保密">
                            </div>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>原密码:</td>
                        <td>
                            <input type="password" class="layui-input" id="oldpassword" name="oldpassword"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>新密码:</td>
                        <td>
                            <input type="password" class="layui-input" id="newpassword" name="newpassword"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>再次输入:</td>
                        <td>
                            <input type="password" class="layui-input" id="newpasswordagain" name="newpasswordagain"/>
                        </td>
                        <td></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>生日:</td>
                        <td>
                            <div class="layui-form-item">
                                <input type="text" class="layui-input" name="birth" id="birth" />
                            </div>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>手机号:</td>
                        <td>
                            <input type="text" class="layui-input" id="phone" name="phone" value="${user.phone}"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>电子邮箱:</td>
                        <td>
                            <input type="text" class="layui-input" id="email" name="email" value="${user.email}"/>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                            <button type="submit" class="layui-btn">保存</button>
                            <button class="layui-btn" type="button">取消</button>
                        </td>
                        <td>
                        </td>

                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
<div style="height: 20%"></div>
<script src="${pageContext.request.contextPath}/static/layui.all.js"></script>
<script>
    !function () {
        var form = layui.form;
        form.render();
        var laydate = layui.laydate;
        laydate.render({
            elem: '#birth'
            , trigger: 'click'
        });
    }();
</script>
</body>
</html>