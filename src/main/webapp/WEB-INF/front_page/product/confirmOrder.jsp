<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>成功提交订单</title>
<link rel="stylesheet" href="/res/css/style.css" />
<script src="/res/js/jquery.js"></script>
<script src="/res/js/com.js"></script>
<script type="text/javascript">
function login() {
	window.location.href = "/buyer/login.shtml";
}
function logout(){
	window.location.href = "/logout/logout.shtml";
}
function myOrder() {
	window.location.href = "/buyer/myOrder.shtml";
}
</script>
</head>
<body>
<div class="bar"><div class="bar_w">
	<p class="l">
		<span class="l">
			收藏本网站！北京<a href="#" title="更换">[更换]</a>
		</span>
	</p>
	<ul class="r uls">
		<li class="dev">
			您好,欢迎来到新巴巴运动网！
		</li>
	<li class="dev"><a href="javascript:void(0)" onclick="login()"  title="登陆">[登陆]</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="register()" title="免费注册">[免费注册]</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="logout()" title="退出">[退出]</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="myOrder()" title="我的订单">我的订单</a></li>
	<li class="dev"><a href="#" title="在线客服">在线客服</a></li>
	<li class="dev after"><a href="#" title="English">English</a></li>
	</ul>
</div></div>

<ul class="ul step st3_3">
<li title="1.我的购物车">1.我的购物车</li>
<li title="2.填写核对订单信息">2.填写核对订单信息</li>
<li title="3.成功提交订单" class="here">3.成功提交订单</li>
</ul>

<div class="w ofc case">
	<c:choose>
	<c:when test="${empty order.oid }">
	<%response.sendRedirect("/product/display/list.shtml"); %>
	</c:when>
	<c:otherwise>
	<div class="confirm">
		<div class="tl"></div><div class="tr"></div>
		<div class="ofc">
			
			<p class="okMsg">您的订单已成功提交，完成支付后，我们将立即发货！</p>

			<table cellspacing="0" class="tab tab5" summary="">
			<tbody><tr>
			<th>您的订单号</th>
			<td><var class="blue"><b>${order.oid }</b></var></td>
			<th>应付现金</th>
			<td><var class="red"><b>￥${order.amount_payable }</b></var>&nbsp;元</td>
			<th>支付方式</th>
			<td>${order.paymentWayName }</td>
			</tr>
			<tr>
			<th>配送方式</th>
			<td>快递</td>
			<th>预计发货时间</th>
			<td>${order.goTime }</td>
			<th>状态</th>
			<td>${order.isPaiyName }</td>
			</tr>
			</table>
		</div>
	</div>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>