<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-list</title>
<script type="text/javascript">
$(function(){
	
		$.ajax(
				{
			url:"loadBrand.do",
			type:"get",
			dataType:"json",
			success:function(data){
				var list=data.list;
				for(var i=0;i<list.length;i++){	
					var $li=$("<option/>").val(list[i].id).html(list[i].name);
					$("#brand").append($li);
				
				}
			}
	})
});
function getTableForm() {
	return document.getElementById('tableForm');
}
function optDelete() {
	if(Pn.checkedCount('ids')<=0) {
		alert("请至少选择一个!");
		return;
	}
	if(!confirm("确定删除吗?")) {
		return;
	}
	var f = getTableForm();
	f.action="o_delete.do";
	f.submit();
}
function opShow() {
	if(Pn.checkedCount('ids')<=0) {
		alert("请至少选择一个!");
		return;
	}
	
	var f = getTableForm();
	f.submit();
}
function opShow1() {
	if(Pn.checkedCount('ids')<=0) {
		alert("请至少选择一个!");
		return;
	}
	
	var f = getTableForm();
	f.action="/product/downShow.do";
	f.submit();
}

function changePageNo(){
	$("input[name='pageNo']").val(1);
}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 商品管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='add.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="/product/list.do" method="post" style="padding-top:5px;">
名称: <input type="text"  value="${name }" name="name"/>
	<select  name="brandId">
		<option value="">请选择品牌</option>
		<c:forEach items="${brands }" var="brand">
		<option value="${brand.id }" <c:if test="${brandId == brand.id }">selected="selected"</c:if>>${brand.name }</option>
		</c:forEach>
		
	</select>
	<select name="isShow">
		<option value="1" <c:if test="${isShow == 1 }">selected="selected"</c:if>>上架</option>
		<option  value="0" <c:if test="${isShow == 0 }">selected="selected"</c:if>>下架</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<form method="get" id="tableForm" action="/product/upShow.do">
<input type="hidden" value="${page.pageNum}" name="pageNum"/>
<input type="hidden" name="name" value="${name }"/>
<input type="hidden" value="${isShow }" name="isShow"/>
<input type="hidden" value="${brandId }" name="brandId"/>
<table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>图片</th>
			<th width="4%">新品</th>
			<th width="4%">热卖</th>
			<th width="4%">推荐</th>
			<th width="4%">上下架</th>
			<th width="12%">操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		<c:forEach items="${list }" var="pro">
		<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
			<td><input type="checkbox" name="ids" value="${pro.id }"/></td>
			<td>${pro.id }-${pro.no }</td>
			<td align="center">${pro.name }</td>
			<td align="center"><img width="50" height="50" src="http://localhost:8088/pic-web/${pro.url }"/></td>
			<td align="center"><c:if test="${pro.isNew==0 }">否</c:if> <c:if test="${pro.isNew==1 }">是</c:if> </td>
			<td align="center"><c:if test="${pro.isHot==0 }">否</c:if> <c:if test="${pro.isHot==1 }">是</c:if></td>
			<td align="center"><c:if test="${pro.isCommend==0 }">否</c:if> <c:if test="${pro.isCommend==1 }">是</c:if></td>
			<td align="center"><c:if test="${pro.isShow == 0 }">下架</c:if><c:if test="${pro.isShow ==1 }">上架</c:if></td>
			<td align="center">
			<c:if test="${pro.isShow ==1 }">
			<a href="/product/detail.shtml?productId=${pro.id}&productName=${pro.name }" class="pn-opt" >查看</a> | 
			</c:if><a href="#" class="pn-opt">修改</a> |
			 <a href="delete.do?pageNum=${page.pageNum }&name=${name}&brandId=${brandId}&id=${pro.id }&isShow=${isShow }" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt">删除</a> |
			 <a href="/sku/list.shtml?productId=${pro.id }&pno=${pro.no }" class="pn-opt">库存</a>
			</td>
		</tr>
	</c:forEach>
	
	</tbody>
</table>
<div class="page pb15"><span class="r inb_a page_b">
	
		<a href="list.do?pageNum=1&name=${name}&brandId=${brandId }&isShow=${isShow}"><font size="2">首页</font></a>
		<c:if test="${page.pageNum==1 }">
		</c:if>
		<c:if test="${page.pageNum>1 }">
		<a href="list.do?pageNum=${page.pageNum-1 }&name=${name}&brandId=${brandId }&isShow=${isShow}"><font size="2">上一页</font></a>
		</c:if>
		<c:forEach var="s" begin="1" end="${page.pages }">
			<c:choose>
				<c:when test="${s == page.pageNum}">${s }&nbsp;&nbsp;</c:when>
				<c:otherwise>
			<a href="list.do?pageNum=${s }&name=${name}&brandId=${brandId }&isShow=${isShow}">${s }</a>
			</c:otherwise>
			</c:choose>
		</c:forEach>

	<%-- <a href="/product/list.do?&amp;isShow=0&amp;pageNo=3">3</a>
	
		<a href="/product/list.do?&amp;isShow=0&amp;pageNo=4">4</a>
	
		<a href="/product/list.do?&amp;isShow=0&amp;pageNo=5">5</a> amp;--%>	
		<c:if test="${page.pageNum==page.pages }">
		</c:if>
		<c:if test="${page.pageNum<page.pages }">
		<a href="list.do?pageNum=${page.pageNum+1 }&name=${name}&brandId=${brandId }&isShow=${isShow}"><font size="2">下一页</font></a>
		</c:if>
		<a href="list.do?pageNum=${page.pages }&name=${name}&brandId=${brandId }&isShow=${isShow}"><font size="2">尾页</font></a>
		共<var>${page.pages }</var>页 到第<input type="text" size="3" id="PAGENO"/>页 <input type="button" onclick="javascript:window.location.href = 'list.do?&name=${name }&brandId=${brandId }&isShow=${isShow}&pageNum=' + $('#PAGENO').val() " value="确定" class="hand btn60x20" id="skip"/>
	
</span></div>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/>
<c:if test="${isShow==0 }">
<input class="add" type="button" onclick="opShow()" value="上架" />
</c:if>
<c:if test="${isShow==1 }">
<input class="del-button" onclick="opShow1()" type="button" value="下架" />
</c:if></div>
</form>
</div>
</body>
</html>