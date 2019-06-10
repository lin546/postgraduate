
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>help</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
    <style>
        code{
            color: #942a25;
            font-weight: bolder;
            font-size: 15px;
        }
    </style>
</head>
<body>
<div class="layui-container">
    <div class="layui-row">
        <blockquote class="layui-elem-quote">
            HTML解析器Jsoup基本规则如下，更详细的请访问
            <a href="https://www.open-open.com/jsoup/"><u>Jsoup中文文档</u></a>
        </blockquote>
    </div>
    <div class="layui-row">
        <ul>
            <li><code>tagname</code>: 通过标签查找元素，比如：<code>a</code></li><br>
            <li><code>ns|tag</code>: 通过标签在命名空间查找元素，比如：可以用<code>fb|name</code> 语法来查找 <code>&lt;fb:name&gt;</code> 元素</li><br>
            <li><code>#id</code>: 通过ID查找元素，比如：<code>#logo</code></li><br>
            <li><code>.class</code>: 通过class名称查找元素，比如：<code>.masthead</code></li><br>
            <li><code>[attribute]</code>: 利用属性查找元素，比如：<code>[href]</code></li><br>
            <li><code>[^attr]</code>: 利用属性名前缀来查找元素，比如：可以用<code>[^data-]</code> 来查找带有HTML5 Dataset属性的元素</li><br>
            <li><code>[attr=value]</code>: 利用属性值来查找元素，比如：<code>[width=500]</code></li><br>
            <li><code>[attr^=value]</code>, <code>[attr$=value]</code>,<code>[attr*=value]</code>: 利用匹配属性值开头、结尾或包含属性值来查找元素，比如：<code>[href*=/path/]</code></li><br>
            <li><code>[attr~=regex]</code>: 利用属性值匹配正则表达式来查找元素，比如： <code>img[src~=(?i)\.(png|jpe?g)]</code></li><br>
            <li><code>*</code>: 这个符号将匹配所有元素</li>
        </ul>
    </div>
</div>
</body>
</html>
