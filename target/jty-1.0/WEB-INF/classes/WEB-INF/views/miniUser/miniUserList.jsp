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
        	<form id="searchFrom" action="">
        		<input type="text" name="filter_LIKES_nickName" class="easyui-validatebox" data-options="width:150,prompt: '昵称'"/>
		        <span class="toolbar-item dialog-tool-separator"></span>
		        <a href="javascript(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="cx()">查询</a>
			</form>
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
    url:'${ctx}/business/miniUser/json',
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
        {field:'nickName',title:'昵称',sortable:true,width:10},
        {field:'openid',title:'openid',sortable:true},
        {field:'avatarUrl',title:'头像',sortable:true,width:10,
            formatter:function(value,row){
                return "<img style='width:80px;height:80px;' border='1' src='"+value+"' onclick='show(\""+value+"\")'/>";
            }
		},
        {field:'gender',title:'性别',sortable:true,width:8,
            formatter : function(value, row, index) {
                return value == 1?'男':'女';
            }
		},
        {field:'province',title:'省份',sortable:true,width:20},
        {field:'city',title:'城市',sortable:true,width:20},
        {field:'loginTime',title:'最近一次登录时间',sortable:true,width:8,
            formatter : function(value, row, index) {
                return formatDatebox(value);
            }
		},
    ]],
    enableHeaderClickMenu: true,
    enableHeaderContextMenu: true,
    enableRowContextMenu: false,
	rowTooltip: true,
    toolbar:'#tb'
	});
});

function show(src){
    var simg = src;
    window.open(simg);
}

//日期时间格式化
function formatDatebox(value) {
    if (value == null || value == '') {
        return '';
    }
    var dt;
    if (value instanceof Date) {
        dt = value;
    } else {
        dt = new Date(value);
    }

    return dt.format("yyyy-MM-dd HH:mm:ss"); //扩展的Date的format方法(上述插件实现)
}

//创建查询对象并查询
function cx(){
	var obj=$("#searchFrom").serializeObject();
	dg.datagrid('load',obj); 
}

</script>
</body>
</html>