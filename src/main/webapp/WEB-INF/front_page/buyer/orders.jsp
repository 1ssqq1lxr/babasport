<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>新巴巴运动网_用户中心</title>
<link rel="stylesheet" href="/res/css/style.css" />
<script src="/res/js/jquery.js"></script>
<script src="/res/js/com.js"></script>
<script type="text/javascript">
//登陆
function login() {
	window.location.href = "/buyer/login.shtml";
}
function logout(){
	window.location.href = "/logout/logout.shtml";
}
function myOrder() {
	window.location.href = "/buyer/myOrder.shtml";
}
function deletCartInfo(cartInfoId){
	url="/buyer/deleteCart.shtml";
	data={"id":cartInfoId};
	$.post(url,data,function(){
		alert("删除成功!");
	});
}
function myCart(){
	window.location.href = "/buyer/myCart.shtml";
}
</script>
</head>
<body>
<div class="bar">
		<div class="bar_w">
			<p class="l">
				<span class="l"> 收藏本网站！北京<a href="#" title="更换">[更换]</a>
				</span>
			</p>
			<ul class="r uls">
				<li class="dev">您好,欢迎来到新巴巴运动网！</li>
				<c:choose>
				<c:when test="${empty buyer}">
				<li class="dev"><a href="javascript:void(0)" onclick="login()"
					title="登陆">[登陆]</a></li>
				
				</c:when>
					<c:otherwise>
					<li class="dev"><font size="2" color="blue">${buyer.realName }</font></li>
					</c:otherwise>
				</c:choose>
				<li class="dev"><a href="javascript:void(0)"
					onclick="register()" title="免费注册">[免费注册]</a></li>
					<c:if test="${not empty buyer}">
				<li class="dev"><a href="javascript:void(0)" onclick="logout()"
					title="退出">[退出]</a></li>
					</c:if>
				<li class="dev"><a href="javascript:void(0)"
					onclick="myOrder()" title="我的订单">我的订单</a></li>
				<li class="dev"><a href="#" title="在线客服">在线客服</a></li>
				<li class="dev after"><a href="#" title="English">English</a></li>
			</ul>
		</div>
</div>
	<div class="w loc">
		<div class="h-title">
			<div class="h-logo">
				<a href="http://localhost:8080"><img
					src="/res/img/pic/logo-1.png" /></a>
			</div>
			<div class="h-search">
				<input type="text" />
				<div class="h-se-btn">
					<a href="#">搜索</a>
				</div>
			</div>
		</div>
	</div>

<div class="w mt ofc">
	<div class="l wl">
		
		<h2 class="h2 h2_l"><em title="交易管理">交易管理</em><cite>&nbsp;</cite></h2>
		<div class="box bg_gray">
			<ul class="ul left_nav">
			<li><a href="../buyer/orders.jsp" title="我的订单">我的订单</a></li>
			<li><a href="../buyer/orders.jsp" title="退换货订单">退换货订单</a></li>
			<li><a href="../buyer/orders.jsp" title="我的收藏">我的收藏</a></li>
			</ul>
		</div>

		<h2 class="h2 h2_l mt"><em title="账户管理">账户管理</em><cite>&nbsp;</cite></h2>
		<div class="box bg_gray">
			<ul class="ul left_nav">
			<li><a href="/buyer/myProfile.shtml" title="个人资料">个人资料</a></li>
			<li><a href="/buyer/deliver_address.shtml" title="收货地址">收货地址</a></li>
			<li><a href="/buyer/change_password.shtml" title="修改密码">修改密码</a></li>
			</ul>
		</div>

	</div>
	<div class="r wr profile">
		<h2 class="h2 h2_filter"><em style="color:red">全部订单</em></h2>
		<table cellspacing="0" summary="" class="tab tab4">
		<thead>
		<tr>
		<th width="12%">订单编号</th>
		<th width="10%">收货人</th>
		<th width="10%">总金额（元）</th>
		<th width="10%">下单时间</th>
		<th width="10%">订单状态</th>
		<th width="10%">操作</th>
		</tr>     
		</thead>
		<tbody>  
		<c:forEach items="${orders }" var="order">    
			<tr class="over">
				<td><a href="#" title="H7859454">${order.oid }</a></td>
			
				<td>${order.address.username }</td>
				<td>￥${order.amount_payable }</td>
				<td>${order.goTime }</td>
				<td>${order.isPaiyName }<br /></td>
				<td class="blue"><a href="javascript:void(0);" title="查看详情">查看详情</a><br /><a href="javascript:void(0);" title="跟踪物流">跟踪物流</a></td>
			</tr>
		</c:forEach>  
		</tbody>
		</table>
	</div>
</div>
<div class="mode">
	<div class="tl"></div><div class="tr"></div>
	<ul class="uls">
		<li class="first">
			<span class="guide"></span>
			<dl>
			<dt title="购物指南">购物指南</dt>
			<dd><a href="#" title="购物流程">购物流程</a></dd>
			<dd><a href="#" title="购物流程">购物流程</a></dd>
			<dd><a href="#" target="_blank" title="联系客服">联系客服</a></dd>
			<dd><a href="#" target="_blank" title="联系客服">联系客服</a></dd>
			</dl>
		</li>
		<li>
			<span class="way"></span>
			<dl>
			<dt title="支付方式">支付方式</dt>
			<dd><a href="#" title="货到付款">货到付款</a></dd>
			<dd><a href="#" title="在线支付">在线支付</a></dd>
			<dd><a href="#" title="分期付款">分期付款</a></dd>
			<dd><a href="#" title="分期付款">分期付款</a></dd>
			</dl>
		</li>
		<li>
			<span class="help"></span>
			<dl>
			<dt title="配送方式">配送方式</dt>
			<dd><a href="#" title="上门自提">上门自提</a></dd>
			<dd><a href="#" title="上门自提">上门自提</a></dd>
			<dd><a href="#" title="上门自提">上门自提</a></dd>
			<dd><a href="#" title="上门自提">上门自提</a></dd>
			</dl>
		</li>
		<li>
			<span class="service"></span>
			<dl>
			<dt title="售后服务">售后服务</dt>
			<dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
			<dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
			<dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
			<dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
			</dl>
		</li>
		<li>
			<span class="problem"></span>
			<dl>
			<dt title="特色服务">特色服务</dt>
			<dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
			<dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
			<dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
			<dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
			</dl>
		</li>
	</ul>
</div>
</body>
</html>