<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="0">
</head>
<body>
<link href="${ctx}/static/tags/tag.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/static/tags/tag.js"></script>
<div>
	<form id="mainform" action="${ctx}/business/goods/${action}" method="post" enctype="multipart/form-data">
	<table  class="formTable">
		<tr>
			<td>商品名称：</td>
			<td>
				<input type="hidden" name="id" value="${goods.id }"/>
                <input type="hidden" name="goodsImgs" value=${goods.goodsImgs } />
                <input type="hidden" name="goodsIndexImg" value="${goods.goodsIndexImg }"/>
				<input type="hidden" name="goodsIntroduce" value="${goods.goodsIntroduce }"/>
				<input type="hidden" name="goodsIntroduceImgs" value=${goods.goodsIntroduceImgs } />
				<input type="hidden" name="goodsRealImgs" value=${goods.goodsRealImgs } />
				<input id="name" name="goodsName" type="text" value="${goods.goodsName }" class="easyui-validatebox" data-options="width: 180,required:'required'"/>
			</td>
		</tr>
		<tr>
			<td>商品类型：</td>
			<td><input id="pid" name="goodsSecondTypeId" value="${goods.goodsSecondTypeId }"/></td>
		</tr>
		<tr>
			<td>商品图片：</td>
			<td id="file1_td">
				<input type="file" class="easyui-filebox" style="width:200px" onchange="PreviewImage(this,'imgHeadPhoto1','divPreview1')" id="file1" name="file1"/>
			</td>
			<td>
				<div id="divPreview1">
					<img id="imgHeadPhoto1" width="80"  height="80" src="${ctx}/static/images/noimg.jpg">
				</div>
			</td>
		</tr>
		<tr>
			<td>商品规格：</td>
			<td>
				<input id="goodsSpec" name="goodsSpec" type="text" value=${goods.goodsSpec } class="easyui-validatebox" data-options="width: 180,required:'required'"/>
			</td>
		</tr>
		<tr>
			<td>商品价格：</td>
			<td>
				<input id="goodsPrice" name="goodsPrice" type="text" value=${goods.goodsPrice } class="easyui-validatebox" data-options="width: 180,required:'required'"/>
			</td>
		</tr>
		<tr>
			<td>商品单位：</td>
			<td>
				<input id="goodsUnit" name="goodsUnit" type="text" value="${goods.goodsUnit }" class="easyui-validatebox" data-options="width: 180,required:'required'"/>
			</td>
		</tr>
		<tr>
			<td>商品轮播图：</td>
			<td>
				<input type="file" name="file2" id="file2" multiple="multiple" class="easyui-filebox" style="width:200px" onchange="javascript:setImagePreviews('file2','divPreview2','2');" accept="image/*" />
			</td>
			<td>
				<div id="divPreview2"></div>
			</td>
		</tr>
		<tr>
			<td>商品介绍图：</td>
			<td>
				<input type="file" class="easyui-filebox" style="width:200px" onchange="PreviewImage(this,'imgHeadPhoto3','divPreview3')" id="file3" name="file3"/>
			</td>
			<td>
				<div id="divPreview3">
					<img id="imgHeadPhoto3" width="80"  height="80" src="${ctx}/static/images/noimg.jpg">
				</div>
			</td>
		</tr>
		<tr>
			<td>商品详情图：</td>
			<td>
				<input type="file" name="file4" id="file4" multiple="multiple" class="easyui-filebox" style="width:200px" onchange="javascript:setImagePreviews('file4','divPreview4','4');" accept="image/*" />
			</td>
			<td>
				<div id="divPreview4"></div>
			</td>
		</tr>
		<tr>
			<td>商品实拍图：</td>
			<td>
				<input type="file" name="file5" id="file5" multiple="multiple" class="easyui-filebox" style="width:200px" onchange="javascript:setImagePreviews('file5','divPreview5','5');" accept="image/*" />
			</td>
			<td>
				<div id="divPreview5"></div>
			</td>
		</tr>
	</table>
	</form>
</div> 
<script type="text/javascript">

//父级权限
var action="${action}";
if(action=='create'){
    //添加标签
    var tag1 = new Tag("goodsSpec");
    tag1.initView();

    var tag2 = new Tag("goodsPrice");
    tag2.initView();

}else if(action=='update'){
	$('#pid').val(parentPermId);

    var goods_index_img = '${goods.goodsIndexImg }';
    var goods_introduce = "${goods.goodsIntroduce}";
    if(goods_index_img.length > 0){
        document.getElementById("imgHeadPhoto1").setAttribute("src",goods_index_img);
    }

    if(goods_introduce.length > 0){
        document.getElementById("imgHeadPhoto3").setAttribute("src",goods_introduce);
    }

    var goods_imgs = '${goods.goodsImgs }';
    var goods_introduce_imgs = '${goods.goodsIntroduceImgs }';
    var goods_real_imgs = '${goods.goodsRealImgs }';
    updateImageShow(goods_imgs,'divPreview2','2');
    updateImageShow(goods_introduce_imgs,'divPreview4','4');
    updateImageShow(goods_real_imgs,'divPreview5','5');
}else if(action == 'look'){
    // $('#name').validatebox({disabled: true});
    // $("#pid").combotree({disabled: true});
	//
    // $('#file1_td').hide();
    // $('#file2_td').hide();

}

//上级菜单
$('#pid').combotree({
	width:180,
	method:'GET',
    url: '${ctx}/business/goodsAllType/list/secondTypeList',
    idField : 'id',
    textFiled : 'name',
	iconCls: 'icon',
    animate:true,
});


$('#mainform').form({    
    onSubmit: function(){    
    	var isValid = $(this).form('validate');
		return isValid;	// 返回false终止表单提交
    },    
    success:function(data){   
    	if(successTip(data,dg,d))
    		dg.datagrid('reload');
    }    
});

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


//下面用于多图片上传预览功能

function setImagePreviews(fileid,divid,number) {

    var docObj = document.getElementById(fileid);

    var dd = document.getElementById(divid);

    dd.innerHTML = "";

    var fileList = docObj.files;

    for (var i = 0; i < fileList.length; i++) {

        dd.innerHTML += "<div style='float:left' > <img id='img" + number + i + "'  /> </div>";

        var imgObjPreview = document.getElementById("img"+ number + i);

        if (docObj.files && docObj.files[i]) {

            //火狐下，直接设img属性

            imgObjPreview.style.display = 'block';

            imgObjPreview.style.width = '80px';

            imgObjPreview.style.height = '80px';

            //imgObjPreview.src = docObj.files[0].getAsDataURL();

            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式

            imgObjPreview.src = window.URL.createObjectURL(docObj.files[i]);


        }

        else {

            //IE下，使用滤镜

            docObj.select();

            var imgSrc = document.selection.createRange().text;

            alert(imgSrc)

            var localImagId = document.getElementById("img" + number + i);

            //必须设置初始大小

            localImagId.style.width = "80px";

            localImagId.style.height = "80px";

            //图片异常的捕捉，防止用户修改后缀来伪造图片

            try {

                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";

                localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;

            }

            catch (e) {

                alert("您上传的图片格式不正确，请重新选择!");

                return false;

            }

            imgObjPreview.style.display = 'none';

            document.selection.empty();
        }

    }
    return true;
}


function updateImageShow(jsonString,divid,number) {

    var dd = document.getElementById(divid);

    dd.innerHTML = "";

    var fileList = JSON.parse(jsonString);

    for (var i = 0; i < fileList.length; i++) {

        dd.innerHTML += "<div style='float:left' > <img id='img" + number + i + "'  /> </div>";

        var imgObjPreview = document.getElementById("img"+ number + i);

        //火狐下，直接设img属性

        imgObjPreview.style.display = 'block';

        imgObjPreview.style.width = '80px';

        imgObjPreview.style.height = '80px';

        imgObjPreview.src = fileList[i];

    }
    return true;
}



</script>
</body>
</html>