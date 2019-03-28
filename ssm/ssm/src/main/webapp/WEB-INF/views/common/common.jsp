<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--定义每次访问都需要在前面拼接的路径，只有路径最前面不写/才有用--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<base href="<%=basePath%>">
<%--主题--%>
<link rel="stylesheet" type="text/css" href="static/js/easyui/themes/default/easyui.css">
<%--图标--%>
<link rel="stylesheet" type="text/css" href="static/js/easyui/themes/icon.css">
<%--颜色--%>
<link rel="stylesheet" type="text/css" href="static/js/easyui/themes/color.css">
<%--jquery--%>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
<%--easyui插件--%>
<script type="text/javascript" src="static/js/easyui/jquery.easyui.min.js"></script>
<%--IN18--%>
<script type="text/javascript" src="static/js/easyui/locale/easyui-lang-zh_CN.js"></script>

