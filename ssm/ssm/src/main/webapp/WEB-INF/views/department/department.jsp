<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Title</title>
    <%@include file="/WEB-INF/views/common/common.jsp" %>
    <script src="static/js/department/department.js"></script>
</head>
<body>
<%--datagrid--%>
<table id="departmentDatagrid"></table>
<%--toolbar--%>
<div id="toolbar">
    <a data-cmd="add" href="javascript:void(0)" class="easyui-linkbutton c1" iconCls="icon-add" plain="true">添加</a>
    <a data-cmd="edit" href="javascript:void(0)" class="easyui-linkbutton c2" iconCls="icon-edit" plain="true">编辑</a>
    <a data-cmd="delete" href="javascript:void(0)" class="easyui-linkbutton c3" iconCls="icon-remove"
       plain="true">删除</a>
    <a data-cmd="refresh" href="javascript:void(0)" class="easyui-linkbutton c4" iconCls="icon-reload"
       plain="true">刷新</a>
</div>
<%--dialog--%>
<div id="departmentDialog" class="easyui-dialog" style="width:400px;"
     closed="true" buttons="#dialog-buttons"
     data-options="resizable:true,modal:true">
    <%--弹出的form--%>
    <form id="departmentForm" method="post" style="margin:0;padding:20px 50px">
        <input type="hidden" name="id" value="id"/>
        <table>
            <tr>
                <td>
                    编号:<input type="text" name="sn">
                </td>
            </tr>
            <tr>
                <td>
                    名称:<input type="text" name="name">
                </td>
            </tr>
        </table>
    </form>
</div>
<%--dialog的提交和取消--%>
<div id="dialog-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" data-cmd="submit" style="width:90px">提交</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c8" iconCls="icon-cancel" data-cmd="cancel" style="width:90px">取消</a>
</div>
</body>
</html>
