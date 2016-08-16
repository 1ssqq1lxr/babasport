<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>babasport-edit</title>
<script type="text/javascript">
//上传图片
function uploadPic(){
	//定义参数
	var options = {
			url : "/upload/uploadPic.do",
			type:"post",
			dataType : "json",
			success : function(data){
				//回调 二个路径  
				//url
				//path
			
				$("#allImgUrl").attr("src",data.url);
				$("#path").val(data.path);
			}
		};
		
		//jquery.form使用方式
		$("#jvForm").ajaxSubmit(options);
	
}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 添加</div>
	<form class="ropt">
		<input type="submit" onclick="this.form.action='v_list.shtml';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="float:right">
	<form id="jvForm" action="save.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${brand.id }"/>
		<input type="hidden" name="name1" value="${name1 }"/>
		<input type="hidden" name="is_display1" value="${is_display1 }"/>
		<input type="hidden" name="pageNum1" value="${pageNum1 }"/>
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						品牌名称:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="name" maxlength="100" value="${brand.name }"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						上传商品图片(90x150尺寸):</td>
						<td width="80%" class="pn-fcontent">
						注:该尺寸图片必须为90x150。
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h"></td>
						<td width="80%" class="pn-fcontent">
						<img width="100" height="100" id="allImgUrl" src="http://localhost:8088/pic-web/${brand.img_url }" />
						<input type="hidden" name="img_url" id="path" value="${brand.img_url }"/>
						<input type="file" onchange="uploadPic()" name="pic"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						品牌描述:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="description" value="${brand.description }" maxlength="80"  size="60"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						排序:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="sort" value="${brand.sort }" maxlength="80"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						是否可用:</td><td width="80%" class="pn-fcontent">
						<c:if test="">check</c:if>
						<input type="radio" name="is_display" value="1" checked=<c:if test="${brand.is_display == 1 }">checked="checked"</c:if> />可用
						<input type="radio" name="is_display"  value="0" <c:if test="${brand.is_display == 0 }">checked="checked"</c:if>/>不可用
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td class="pn-fbutton" colspan="2">
						<input type="submit" class="submit" value="提交"/> &nbsp; <input type="reset" class="reset" value="重置"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>