<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="0">
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
<script src="${ctx}/static/plugins/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
</head>
<body>
<div id="tb" style="padding:5px;height:auto">
        <div>
			<form id="searchFrom" action="">
				<input type="text" name="filter_LIKES_goodsName" class="easyui-validatebox" data-options="width:150,prompt: '商品名称'"/>
				<input id="goodsSecondTypeId" name="filter_EQS_goodsSecondTypeId" class="easyui-validatebox" data-options="width:150,prompt: '商品类型'"/>
				<a href="javascript(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="cx()">查询</a>
			</form>

			<shiro:hasPermission name="bus:goods:add">
				<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" onclick="add();">添加</a>
				<span class="toolbar-item dialog-tool-separator"></span>
			</shiro:hasPermission>
			<shiro:hasPermission name="bus:goods:delete">
				<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-remove" onclick="del()">删除</a>
				<span class="toolbar-item dialog-tool-separator"></span>
			</shiro:hasPermission>
			<shiro:hasPermission name="bus:goods:update">
				<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit" onclick="upd()">修改</a>
			</shiro:hasPermission>
        </div>
        
  </div>
<table id="dg"></table> 
<div id="dlg"></div>  
<script type="text/javascript">

$('#goodsSecondTypeId').combotree({
    width:150,
    editable:true,
	method:'GET',
	url: '${ctx}/business/goodsAllType/list/secondTypeList',
	idField : 'id',
	textFiled : 'name',
	iconCls: 'icon',
	animate:true,
});

var dg;
var d;
$(function(){   
	dg=$('#dg').datagrid({    
	method: "get",
    url:'${ctx}/business/goods/json',
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
        {field:'id',title:'id',hidden:true,align:'center'},
        {field:'goodsIndexImg',title:'商品首页图',sortable:true,align:'center',width:3,
            formatter:function(value,row){
                return "<img style='width:80px;height:80px;' src='"+value+"' onclick='show(\""+value+"\")'/>";
            }
		},
        {field:'goodsName',title:'商品名称',sortable:true,align:'center',width:3},
        {field:'goodsSecondTypeId',title:'商品类型',sortable:true,align:'center',width:3,
            formatter:function(value,row){
                return getSecondTypeName(value);
            }
		},
        {field:'goodsImgs',title:'商品轮播图',sortable:true,align:'center',width:5,
            formatter:function(value,row){
            	var json = JSON.parse(value);
            	var ret = "";
				for(var i = 0; i < json.length; i++){
                    ret += "<img style='width:80px;height:80px;' border='1' src='" + json[i];
                    ret += "' onclick='show(\"" + json[i];
                    ret += "\")'/>";
				}
                return ret;
            }
        },
        {field:'goodsIntroduce',title:'商品介绍图',sortable:true,align:'center',width:2,
            formatter:function(value,row){
                return "<img style='width:80px;height:80px;' src='"+value+"' onclick='show(\""+value+"\")'/>";
            }
        },
        {field:'goodsIntroduceImgs',title:'商品详情图',sortable:true,align:'center',width:5,
            formatter:function(value,row){
                var json = JSON.parse(value);
                var ret = "";
                for(var i = 0; i < json.length; i++){
                    ret += "<img style='width:80px;height:80px;' border='1' src='" + json[i];
                    ret += "' onclick='show(\"" + json[i];
                    ret += "\")'/>";
                }
                return ret;
            }
        },
        {field:'goodsRealImgs',title:'商品实拍图',sortable:true,align:'center',width:5,
            formatter:function(value,row){
                var json = JSON.parse(value);
                var ret = "";
                for(var i = 0; i < json.length; i++){
                    ret += "<img style='width:80px;height:80px;' border='1' src='" + json[i];
                    ret += "' onclick='show(\"" + json[i];
                    ret += "\")'/>";
                }
                return ret;
            }
        },
        {field:'goodsSpec',title:'商品规格',sortable:true,align:'center',width:2},
        {field:'goodsPrice',title:'商品价格',sortable:true,align:'center',width:2},
        {field:'goodsUnit',title:'单位',sortable:true,align:'center',width:2},

    ]],
    enableHeaderClickMenu: true,
    enableHeaderContextMenu: true,
    enableRowContextMenu: false,
    toolbar:'#tb'
	});
});

//根据id取二级类型名称
function getSecondTypeName(value) {
    var name = "";
    $.ajax({
        async:false,
        type:'get',
        url:"${ctx}/business/goodsAllType/getSecondTypeName/"+value,
        success: function(data){
            name = data;
        }
    });
    return name;
}

//弹窗增加
function add() {
    d=$('#dlg').dialog({
        title: '添加商品',
        width: 800,
        height: 680,
        closed: false,
        cache: false,
        maximizable:true,
        resizable:true,
        href:'${ctx}/business/goods/create',
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
                url:"${ctx}/business/goods/delete/"+row.id,
                success: function(data){
                    successTip(data,dg);
                }
            });
        }
    });
}


//修改
function upd(){
    var row = dg.treegrid('getSelected');
    if(rowIsNull(row)) return;
    //父级权限
    parentPermId=row.goodsSecondTypeId;
    d=$("#dlg").dialog({
        title: '修改商品',
        width: 800,
        height: 680,
        href:'${ctx}/business/goods/update/'+row.id,
        maximizable:true,
        modal:true,
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

function show(src){
    var simg = src;
    window.open(simg);
}

//创建查询对象并查询
function cx(){
    var obj=$("#searchFrom").serializeObject();
    dg.datagrid('load',obj);
}


</script>
</body>
</html>