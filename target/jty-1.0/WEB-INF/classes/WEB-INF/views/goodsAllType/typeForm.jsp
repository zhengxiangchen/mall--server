<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
</head>
<body>
<div>
	<form id="mainform" action="${ctx}/business/goodsAllType/${action}" method="post" enctype="multipart/form-data">
	<table  class="formTable">
		<tr>
			<td>类型名称：</td>
			<td>
				<input type="hidden" name="id" value="${goodsAllType.id }"/>
                <input type="hidden" name="banner" value="${goodsAllType.banner }"/>
                <input type="hidden" name="indexImg" value="${goodsAllType.indexImg }"/>
				<input id="name" name="name" type="text" value="${goodsAllType.name }" class="easyui-validatebox" data-options="width: 180,required:'required'"/>
			</td>
		</tr>
		<tr>
			<td>上级类型：</td>
			<td><input id="pid" name="pid" value="${goodsAllType.pid }" onchange="selectPid()"/></td>
		</tr>
		<tr>
			<td>banner图片：</td>
			<td id="file1_td">
				<input type="file" class="easyui-filebox" style="width:200px" onchange="PreviewImage(this,'imgHeadPhoto1','divPreview1')" id="file1" name="file1"/>
			</td>
			<td>
				<div id="divPreview1">
					<img id="imgHeadPhoto1" width="160"  height="80" src="${ctx}/static/images/noimg.jpg">
				</div>
			</td>
		</tr>
		<tr id = "indexImg">
			<td>二级类型图标：</td>
			<td id="file2_td">
				<input type="file" class="easyui-filebox" style="width:200px" onchange="PreviewImage(this,'imgHeadPhoto2','divPreview2')" id="file2" name="file2"/>
			</td>
			<td>
				<div id="divPreview2">
					<img id="imgHeadPhoto2" width="80" height="80" src="${ctx}/static/images/noimg.jpg">
				</div>
			</td>
		</tr>
	</table>
	</form>
	<%--<div id="divPreview">--%>
		<%--<img id="imgHeadPhoto" width="120"  height="120" src="">--%>
	<%--</div>--%>
</div> 
<script type="text/javascript">
//父级权限
var action="${action}";
if(action=='create'){
	// $('#pid').val(parentPermId);
}else if(action=='update'){
	$('#pid').val(parentPermId);
}else if(action == 'look'){
    $('#name').validatebox({disabled: true});
    $("#pid").combotree({disabled: true});

    $('#file1_td').hide();
    $('#file2_td').hide();

}

var pid = $('#pid').val();
if(pid == "" || pid.length <= 0){
    $('#indexImg').hide();
}

var banner = "${goodsAllType.banner}";
var indexImg = "${goodsAllType.indexImg}";
if(banner.length > 0){
    document.getElementById("imgHeadPhoto1").setAttribute("src",banner);
}

if(indexImg.length > 0){
    document.getElementById("imgHeadPhoto2").setAttribute("src",indexImg);
}

//上级菜单
$('#pid').combotree({
	width:180,
	method:'GET',
    url: '${ctx}/business/goodsAllType/list/firstTypeList',
    idField : 'id',
    textFiled : 'name',
	iconCls: 'icon',
    animate:true,
    onClick: function(node){
        $('#indexImg').show();
    }
});


$('#mainform').form({    
    onSubmit: function(){    
    	var isValid = $(this).form('validate');
		return isValid;	// 返回false终止表单提交
    },    
    success:function(data){   
    	if(successTip(data,dg,d))
    		dg.treegrid('reload');
    }    
});


function selectPid() {
    $('#indexImg').show();
}

function PreviewImage(fileObj,imgPreviewId,divPreviewId){
    var allowExtention=".jpg,.bmp,.gif,.png";//允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
    var extention=fileObj.value.substring(fileObj.value.lastIndexOf(".")+1).toLowerCase();
    var browserVersion= window.navigator.userAgent.toUpperCase();
    if(allowExtention.indexOf(extention)>-1){
        if(fileObj.files){//HTML5实现预览，兼容chrome、火狐7+等
            if(window.FileReader){
                var reader = new FileReader();
                reader.onload = function(e){
                    document.getElementById(imgPreviewId).setAttribute("src",e.target.result);
                }
                reader.readAsDataURL(fileObj.files[0]);
            }else if(browserVersion.indexOf("SAFARI")>-1){
                alert("不支持Safari6.0以下浏览器的图片预览!");
            }
        }else if (browserVersion.indexOf("MSIE")>-1){
            if(browserVersion.indexOf("MSIE 6")>-1){//ie6
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);
            }else{//ie[7-9]
                fileObj.select();
                if(browserVersion.indexOf("MSIE 9")>-1)
                    fileObj.blur();//不加上document.selection.createRange().text在ie9会拒绝访问
                var newPreview =document.getElementById(divPreviewId+"New");
                if(newPreview==null){
                    newPreview =document.createElement("div");
                    newPreview.setAttribute("id",divPreviewId+"New");
                    newPreview.style.width = document.getElementById(imgPreviewId).width+"px";
                    newPreview.style.height = document.getElementById(imgPreviewId).height+"px";
                    newPreview.style.border="solid 1px #d2e2e2";
                }
                newPreview.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";
                var tempDivPreview=document.getElementById(divPreviewId);
                tempDivPreview.parentNode.insertBefore(newPreview,tempDivPreview);
                tempDivPreview.style.display="none";
            }
        }else if(browserVersion.indexOf("FIREFOX")>-1){//firefox
            var firefoxVersion= parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
            if(firefoxVersion<7){//firefox7以下版本
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.files[0].getAsDataURL());
            }else{//firefox7.0+
                document.getElementById(imgPreviewId).setAttribute("src",window.URL.createObjectURL(fileObj.files[0]));
            }
        }else{
            document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);
        }
    }else{
        alert("仅支持"+allowExtention+"为后缀名的文件!");
        fileObj.value="";//清空选中文件
        if(browserVersion.indexOf("MSIE")>-1){
            fileObj.select();
            document.selection.clear();
        }
        fileObj.outerHTML=fileObj.outerHTML;
    }
}


</script>
</body>
</html>