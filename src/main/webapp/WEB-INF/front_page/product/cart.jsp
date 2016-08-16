<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>我的购物车</title>
<link rel="stylesheet" href="/res/css/style.css" />
<script src="/res/js/jquery.js"></script>
<script src="/res/js/com.js"></script>
<script type="text/javascript">
	//结算
	function trueBuy() {
		window.location.href = "/buyer/productOrder.shtml";
	}
	//登陆
	function login() {
		window.location.href = "/buyer/login.shtml";
	}
	function gocart() {
		window.location.href = "/buyer/cart.shtml";
	}
	function logout() {
		window.location.href = "/logout/logout.shtml";
	}
	function myOrder() {
		window.location.href = "/buyer/myOrder.shtml";
	}
	function clearCart(){
		window.location.href = "/buyer/clearCart.shtml";
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
				<li class="dev"><font size="2" color="blue">${buyer.realName }</font></li>
				<li class="dev"><a href="javascript:void(0)"
					onclick="register()" title="免费注册">[免费注册]</a></li>
				<li class="dev"><a href="javascript:void(0)" onclick="logout()"
					title="退出">[退出]</a></li>
				<li class="dev"><a href="javascript:void(0)"
					onclick="myOrder()" title="我的订单">我的订单</a></li>
				<li class="dev"><a href="#" title="在线客服">在线客服</a></li>
				<li class="dev after"><a href="#" title="English">English</a></li>

			</ul>
		</div>
	</div>
	
	<ul class="ul step st3_1">
		<li title="1.我的购物车" class="here">1.我的购物车</li>
		<li title="2.填写核对订单信息">2.填写核对订单信息</li>
		<li title="3.成功提交订单">3.成功提交订单</li>
	</ul>
	<div class="w ofc case">
		<div class="confirm">
			<div class="tl"></div>
			<div class="tr"></div>
			<div class="ofc pb40">

				<div class="page">
					<b class="l f14 blue pt48"> 我挑选的商品： </b>
				</div>
				<table cellspacing="0" class="tab tab4" summary="">
					<thead>
						<tr>
							<th class="wp">商品</th>
							<th>单价（元）</th>
							<th>颜色</th>
							<th>尺码</th>
							<th>运费</th>
							<th>数量</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${buyer.cart_infos }" var="cartInfo">
							<tr>
								<td class="nwp pic">
									<ul class="uls">
										<li><a class="pic" title="${cartInfo.product.name }"
											href="javascript:void(0)"><img
												alt="${cartInfo.product.name }" src="http://localhost:8088/pic-web/${cartInfo.imgUrl }"></a>
											<dl>
												<dt>
													<a title="${cartInfo.product.name }"
														href="javascript:void(0)">${cartInfo.product.name }</a>
												</dt>
												<dd>
													<span class="red">【赠品】</span>
													<p class="box_d bg_gray2 gray">
														<a title="瑜伽丝带" href="#">瑜伽丝带</a><br>
													</p>
												</dd>
											</dl></li>
									</ul>
								</td>
								<td>￥${cartInfo.sku.skuPrice }</td>
								<td>${cartInfo.colorName }</td>
								<td>${cartInfo.sku.size }</td>
								<td>￥${cartInfo.sku.deliveFee }</td>
		
								<td></a><input type="text" id="num492" readonly="readonly"
									value="${cartInfo.quantity }" name="quantity" size="1"
									class="txts"></td>
								<td class="blue"><a onclick="window.location.href='/buyer/deleteCart2.shtml?cartInfoId='+${cartInfo.id}" title="删除"
									href="javascript:void(0);">删除</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="page">
					<span class="l"> <input type="button"
						onclick="window.open('http://localhost:8080')"
						class="hand btn100x26c" title="继续购物" value="继续购物">
						<c:if test="${not empty buyer.cart_infos }">
						 <input
						type="button" onclick="clearCart()" class="hand btn100x26c"
						title="清空购物车" value="清空购物车">
						</c:if>
					</span> <span class="r box_gray">
						<dl class="total">
							<dt>
								购物车金额小计：${buyer.totalPrice+buyer.totalFee }<cite>(共<var id="productAmount">${buyer.cart.total_quantity }</var>个商品)
								</cite>
							</dt>
							<dd>
								<em class="l">商品金额：</em>￥
								<var id="productPrice">${buyer.totalPrice }</var>
								元
							</dd>
							<dd>
								<em class="l">运费：</em>￥
								<var id="fee">${buyer.totalFee }</var>
								元
							</dd>
							<dd class="orange">
								<em class="l">应付总额：</em>￥
								<var id="totalPrice">${buyer.totalPrice+buyer.totalFee }</var>
								元
							</dd>
							<dd class="alg_c">
								<c:if test="${not empty buyer.cart_infos }">
								<input type="button" onclick="trueBuy();"
									class="hand btn136x36a" value="结算" id="settleAccountId">
									</c:if>
							</dd>
						</dl>
					</span>
				</div>
			</div>
		</div>
	</div>
	<div class="w ofc case" style="display: none;">
		<div class="confirm">
			<div class="tl"></div>
			<div class="tr"></div>
			<div class="ofc pb40"
				style="text-align: center; height: 200px; margin-top: 80px">
				<a href="http://localhost:8080" style="color: red; font-size: 30px;">去首页</a>挑选喜欢的商品
			</div>
		</div>
	</div>
	<div class="mode">
		<div class="tl"></div>
		<div class="tr"></div>
		<ul class="uls">
			<li class="first"><span class="guide"></span>
				<dl>
					<dt title="购物指南">购物指南</dt>
					<dd>
						<a href="#" title="购物流程">购物流程</a>
					</dd>
					<dd>
						<a href="#" title="购物流程">购物流程</a>
					</dd>
					<dd>
						<a href="#" target="_blank" title="联系客服">联系客服</a>
					</dd>
					<dd>
						<a href="#" target="_blank" title="联系客服">联系客服</a>
					</dd>
				</dl></li>
			<li><span class="way"></span>
				<dl>
					<dt title="支付方式">支付方式</dt>
					<dd>
						<a href="#" title="货到付款">货到付款</a>
					</dd>
					<dd>
						<a href="#" title="在线支付">在线支付</a>
					</dd>
					<dd>
						<a href="#" title="分期付款">分期付款</a>
					</dd>
					<dd>
						<a href="#" title="分期付款">分期付款</a>
					</dd>
				</dl></li>
			<li><span class="help"></span>
				<dl>
					<dt title="配送方式">配送方式</dt>
					<dd>
						<a href="#" title="上门自提">上门自提</a>
					</dd>
					<dd>
						<a href="#" title="上门自提">上门自提</a>
					</dd>
					<dd>
						<a href="#" title="上门自提">上门自提</a>
					</dd>
					<dd>
						<a href="#" title="上门自提">上门自提</a>
					</dd>
				</dl></li>
			<li><span class="service"></span>
				<dl>
					<dt title="售后服务">售后服务</dt>
					<dd>
						<a href="#" target="_blank" title="售后策略">售后策略</a>
					</dd>
					<dd>
						<a href="#" target="_blank" title="售后策略">售后策略</a>
					</dd>
					<dd>
						<a href="#" target="_blank" title="售后策略">售后策略</a>
					</dd>
					<dd>
						<a href="#" target="_blank" title="售后策略">售后策略</a>
					</dd>
				</dl></li>
			<li><span class="problem"></span>
				<dl>
					<dt title="特色服务">特色服务</dt>
					<dd>
						<a href="#" target="_blank" title="夺宝岛">夺宝岛</a>
					</dd>
					<dd>
						<a href="#" target="_blank" title="夺宝岛">夺宝岛</a>
					</dd>
					<dd>
						<a href="#" target="_blank" title="夺宝岛">夺宝岛</a>
					</dd>
					<dd>
						<a href="#" target="_blank" title="夺宝岛">夺宝岛</a>
					</dd>
				</dl></li>
		</ul>
	</div>
</body>
</html>