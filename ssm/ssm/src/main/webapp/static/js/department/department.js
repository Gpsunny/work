$(function () {
    var departmentDatagrid= $("#departmentDatagrid");
    var departmentDialog=$("#departmentDialog");
    var departmentForm=$("#departmentForm");
    //显示
    departmentDatagrid.datagrid({
        url: 'department/page',
        fit:true,
        title:'部门管理',
        rownumbers:true,
        pagination:true,
        toolbar:"#toolbar",
        columns: [[
            {field: 'id', title: 'id', hidden: true},
            {field: 'sn', title: 'sn', width: '10%'},
            {field: 'name', title: '名称', width: '20%'},
            {field: 'dirpath', title: 'dirpath', width: '20%', align:  'center'},
            {field: 'state', title: 'state', width: '20%', align:  'center'},
            {field: 'managerId', title: 'managerId', width: '15%', align: 'center'},
            {field: 'parentId', title: 'parentId', width: '15%', align:  'center'}
        ]]
    });
    //事件集合
    var cmdCol={
        'add':function () {
            //弹窗
            departmentDialog.dialog("center").dialog("open").dialog("setTitle","添加部门")
            departmentForm.form("clear");
        },
        'edit':function () {
            //获取被选中的行
            var row=departmentDatagrid.datagrid("getSelected");
            if(row){
                //弹窗
                departmentDialog.dialog("center").dialog("open").dialog("setTitle","修改部门")
                departmentForm.form("clear");
                //会显数据
                departmentForm.form("load",row);
            }else{
                $.messager.alert("温馨提示","请先选中","warning")
            }
        },
        'delete':function () {
            var row = departmentDatagrid.datagrid('getSelected');
            if(row){
                $.messager.confirm("温馨提示","真的要删除吗",function (r) {
                    if(r){
                        //提交ajax请求删除数据
                        $.get("department/delete?id="+row.id,function (result) {
                            if(result.success){
                                $.messager.alert("操作提示","删除成功","info")
                                departmentDatagrid.datagrid("reload");
                            }else {
                                $.messager.alert("操作提示","删除失败","error")
                            }
                        },"json")
                    }
                });
            }else{
                $.messager.alert("温馨提示","请先选中","warning")
            }
        },
        'refresh':function () {
            //刷新方法
            departmentDatagrid.datagrid("reload");
        },
        'cancle':function () {
            //关闭departmentDialog
            departmentDialog.departmentDialog("close");
        },
        'submit':function () {
            departmentForm.form('submit', {
                url:"department/saveorupdate",
                onSubmit: function(){
                },
                success:function(data){
                    var $data=$.parseJSON(data);
                    if($data.success){
                        $.messager.alert("正确提示",$data.msg,"info")
                    }else{
                        $.messager.alert("错误提示",$data.msg,"error")
                    }
                    departmentDialog.dialog("close");
                    departmentDatagrid.datagrid("reload");
                }
            });
        }

    };
    //执行点击的方法
    $("a[data-cmd]").on('click',function () {
        var dataCmd=$(this).data('cmd');
        cmdCol[dataCmd]();
    });
})