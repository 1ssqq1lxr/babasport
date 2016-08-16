<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>babasport-list</title>
<script type="text/javascript">
	$(function(){
		$("#check").click(function(){
			if($(this).attr("checked")){
				$(":checkbox[name='ids']").attr("checked",true);
			}
			else{
			
				$(":checkbox[name='ids']").attr("checked",false);
			
			};
		});
	})
	function optDelete(){
		//请选择一个
		var s = $("input[name='ids']:checked").size();
	 	if(s <= 0){
			alert("请至少选择一个!");
			return;
		}
	 	if(!confirm("你确定删除吗?")){
	 		return ;
	 	}
		$("#form2").attr("action","deleteAll.do");
		$("#form2").submit();
	}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='toAdd.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="/brand/list.do" method="post" style="padding-top:5px;" name="form1">
<input type="hidden" id="hidden" name=""/>
品牌名称: <input type="text" name="name" value="${name }"/>
	<select name="is_display">
		<option value="1" <c:if test="${is_display == 1 }">selected="selected"</c:if> >是</option>
		<option value="0" <c:if test="${is_display == 0 }">selected="selected"</c:if>>不是</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
	<form id="form2" method="post">
	<input type="hidden" name="name" value="${name }"/>
		<input type="hidden" name="is_display" value="${is_display }"/>
		<input type="hidden" name="pageNum" value="${page.pageNum }"/>
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" id="check"/></th>
			<th>品牌ID</th>
			<th>品牌名称</th>
			<th>品牌图片</th>
			<th>品牌描述</th>
			<th>排序</th>
			<th>是否可用</th>
			<th>操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		<c:forEach items="${list }" var="entry">
			<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
				<td><input type="checkbox" value="${entry.id }" name="ids" /></td>
				<td align="center">${entry.id }</td>
				<td align="center">${entry.name }</td>
				<td align="center"><img width="40" height="40" src="http://localhost:8088/pic-web/${entry.img_url}"/></td>
				<td align="center">${entry.description }</td>
				<td align="center">${entry.sort }</td>
				<td align="center"><c:if test="${entry.is_display == 1 }">是</c:if><c:if test="${entry.is_display == 0 }">不是</c:if></td>
				<td align="center">
				<a class="pn-opt" href="/brand/update.do?id=${entry.id }&name=${name}&is_display=${is_display}&pageNum=${page.pageNum }">修改</a> 
				| <a class="pn-opt"  href="/brand/delete.do?id=${entry.id }&name=${name}&is_display=${is_display}&pageNum=${page.pageNum }">删除</a> 
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</form>
<form name="form2" >
<div class="page">
   <tr>
      <td width="100%" height="1"  colspan="2">
        <table border="0" width="30%" cellspacing="0" cellpadding="0" align="right">
         		<tr>
		             <td  align="right">总记录数：${page.total} 条</td> 
		             <c:choose>
		             <c:when test="${page.pageNum==1 }">
		             	<td  align="right">首页&nbsp;</td>
		             	<!--  <td  align="center">上一页&nbsp;&nbsp;&nbsp;</td>-->
		             </c:when>   
		             <c:otherwise >
		             	<td align="right"><a href="${url }&pageNum=1" onClick="">首页&nbsp;</a></td>
		             	<td  align="right"><a href="${url }&pageNum=${page.pageNum-1}" onClick="">上一页&nbsp;</a></td>
		             </c:otherwise>
		             </c:choose>  
		             <c:choose>
		             <c:when test="${page.pageNum==page.pages }">
					 	<!--  <td  align="center">下一页&nbsp;</td>-->
		             	<td  align="right">末页</td>
		             </c:when>
		             <c:otherwise>
		             	<td  align="right"><a href="${url }&pageNum=${page.pageNum+1}" onClick="">下一页&nbsp;</a></td>
		             	<td  align="right"><a href="${url }&pageNum=${page.pages}" onClick="">末页</a></td>
		             </c:otherwise>
		             </c:choose>
		             <td  align="right">第${page.pageNum }页</td>
		             <td  align="right">共${page.pages }页</td>
	           </tr>
        </table>       
      </td>
    </tr> 
</div>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/></div>
</div>
</form>
</body>
</html>