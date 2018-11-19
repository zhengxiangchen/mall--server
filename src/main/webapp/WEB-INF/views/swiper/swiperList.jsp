<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
<script src="${ctx}/static/plugins/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
</head>
<body>
<div id="tb" style="padding:5px;height:auto">
        <div>
			<shiro:hasPermission name="bus:swiper:add">
				<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" onclick="add();">添加</a>
				<span class="toolbar-item dialog-tool-separator"></span>
			</shiro:hasPermission>
			<shiro:hasPermission name="bus:swiper:delete">
				<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-remove" onclick="del()">删除</a>
				<span class="toolbar-item dialog-tool-separator"></span>
			</shiro:hasPermission>
        </div>
        
  </div>
<table id="dg"></table> 
<div id="dlg"></div>  
<script type="text/javascript">
var dg;
var d;
$(function(){   
	dg=$('#dg').datagrid({    
	method: "get",
    url:'${ctx}/business/swiper/json',
    fit : true,
	fitColumns : true,
	border : false,
	idField : 'id',
	striped:true,
	pagination:true,
	rownumbers:true,
	pageNumber:1,
	pageSize : 20,
	pageList : [ 10, 20, 30, 40, 50 ],
	singleSelect:true,
    columns:[[
        {field:'id',title:'id',hidden:true},
        {field:'imgPath',title:'轮播图',sortable:true,width:10,align:'center',
            formatter:function(value,row){
                return "<img style='width:200px;height:100px;' border='1' src='"+value+"' onclick='show(\""+value+"\")'/>";
            }
		},
    ]],
    enableHeaderClickMenu: true,
    enableHeaderContextMenu: true,
    enableRowContextMenu: false,
    toolbar:'#tb'
	});
});

//弹窗增加
function add() {
    d=$('#dlg').dialog({
        title: '添加轮播图',
        width: 320,
        height: 200,
        closed: false,
        cache: false,
        maximizable:true,
        resizable:true,
        href:'${ctx}/business/swiper/create',
        modal: true,
        buttons:[{
            text:'确认',
            handler:function(){
                $("#mainform").submit();
            }
        },{
            text:'取消',
            handler:function(){
                d.panel('close');
            }
        }]
    });
}

//删除
function del(){
    var row = dg.datagrid('getSelected');
    if(rowIsNull(row)) return;
    parent.$.messager.confirm('提示', '删除后无法恢复您确定要删除？', function(data){
        if (data){
            $.ajax({
                type:'get',
                url:"${ctx}/business/swiper/delete/"+row.id,
                success: function(data){
                    successTip(data,dg);
                }
            });
        }
    });

}

function show(src){
    var simg = src;
    window.open(simg);
}

</script>
</body>
</html>