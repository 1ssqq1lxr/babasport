<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>收货地址_用户中心</title>
<link rel="stylesheet" href="/res/css/style.css" />
<script src="/res/js/jquery.js"></script>
<script src="/res/js/com.js"></script>
<script type="text/javascript">
	$(function() {
		$
				.ajax({
					url : "loadProvince.shtml",
					type : "get",
					dataType : "json",
					success : function(data) {
						//$.get方法得到的是字符串 需要eval将字符串转换为对象 才能遍历
						//$.ajax方法得到的是对象（自动处理了） 不需要eval转换
						var list = data.list;
						for (var i = 0; i < list.length; i++) {
							var ss = $("<option/>").val(list[i].pid).text(
									list[i].name);
							$("#province").append(ss);
						}
					}
				});
	});
	function changeProvince() {
		var provinceid = $("#province").val();
		$.ajax({
			url : "loadCiry.shtml",
			type : "post",
			data : {
				"pid" : provinceid
			},
			dataType : "json",
			success : function(dat) {
				$("#city option").remove();
				var citys = dat.citys;
				for (var i = 0; i < citys.length; i++) {
					var ss = $("<option/>").val(citys[i].cid).text(
							citys[i].name);
					$("#city").append(ss);
				}
			}
		})
	};
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
	function del(id){

		window.location.href="/buyer/deleteAddress.shtml?id="+id;	
	}
	function setStatus(id){

		window.location.href="/buyer/setStatus.shtml?id="+id;	
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
			<dl id="cart" class="cart r">
			<c:if test="${not empty buyer.cart_infos  }">
			<dt>
				<a href="javascript:void(0);" onclick="myCart()" title="结算">结算</a>购物车:<b id="">${buyer.cart.total_quantity }</b>件
			</dt>
			<dd class="hidden">
			<c:if test="${empty buyer.cart_infos }">
				<h3 title="购物车中还没有商品，赶紧选购吧！">购物车中还没有商品，赶紧选购吧！ </h3>
			</c:if>	
			<c:if test="${not empty buyer.cart_infos }">
				<h3 title="最新加入的商品">最新加入的商品 </h3>
			</c:if>	
				<ul class="uls">
					<c:forEach items="${buyer.cart_infos }" var="cartInfo">
					<li><a href="#"
						title="${cartInfo.product.name }">
							<img src="http://localhost:8088/pic-web/${cartInfo.imgUrl }"
							alt="${cartInfo.product.name }" />
					</a>
						<p class="dt">
							<a href="javascript:void(0)"
								title="${cartInfo.product.name }">${cartInfo.product.name }</a>
						</p>
						<p class="dd">
							<b><var>¥${cartInfo.sku.skuPrice }</var><span>x${cartInfo.quantity }</span></b> <a
							href="javascript:void(0);" onclick="deletCartInfo(${cartInfo.id})" title="删除" class="del">删除</a>
						</p></li>
							</c:forEach>
				</ul>
		
				<div>
					<p>
						共<b>${buyer.cart.total_quantity }</b>件商品&nbsp;&nbsp;&nbsp;&nbsp;共计<b class="f20">¥${buyer.totalPrice }</b>
					</p>
					<a href="javascript:void(0);" title="去购物车结算" onclick="myCart()" class="inb btn120x30c">去购物车结算</a>
				</div>
			</dd></c:if>
		</dl>	
	</div>

	<div class="w mt ofc">
		<div class="l wl">

			<h2 class="h2 h2_l">
				<em title="交易管理">交易管理</em><cite>&nbsp;</cite>
			</h2>
			<div class="box bg_gray">
				<ul class="ul left_nav">
				<li><a href="../buyer/orders.jsp" title="我的订单">我的订单</a></li>
			<li><a href="../buyer/orders.jsp" title="退换货订单">退换货订单</a></li>
			<li><a href="../buyer/orders.jsp" title="我的收藏">我的收藏</a></li>
				</ul>
			</div>

			<h2 class="h2 h2_l mt">
				<em title="账户管理">账户管理</em><cite>&nbsp;</cite>
			</h2>
			<div class="box bg_gray">
				<ul class="ul left_nav">
				<li><a href="/buyer/myProfile.shtml" title="个人资料">个人资料</a></li>
			<li><a href="/buyer/deliver_address.shtml" title="收货地址">收货地址</a></li>
			<li><a href="/buyer/change_password.shtml" title="修改密码">修改密码</a></li>
				</ul>
			</div>
		</div>
		<div class="r wr profile">

			<div class="confirm">
				<div class="tl"></div>
				<div class="tr"></div>
				<div class="ofc">

					<h2 class="h2 h2_r2">
						<em title="个人资料">收货地址</em>
					</h2>

					<h3 class="h3_r">已存收货地址列表</h3>

					<table cellspacing="0" summary="" class="tab tab6">
						<thead>
							<tr>
								<th>收货人</th>
								<th>所在地区</th>
								<th>街道地址</th>
								<th>电话/手机</th>
								<th>默认地址</th>
								<th>操作</th>
							</tr>
						</thead>

						<tbody>
							<c:if test="${not empty addresses}">
								<c:forEach items="${addresses }" var="s">
									<tr>
										<td>${s.username}</td>
										<td>${s.provinceName}${s.cityName}</td>
										<td>${s.address}</td>
										<td>${s.phone}</td>
										<td>
										<c:choose>
												<c:when test="${s.statusAddr==1 }">
													默认地址
												</c:when>
												<c:otherwise>
													<a href="javascript:void(0);" title="设为默认地址" onclick="setStatus(${s.id})">[设为默认地址]</a>
												</c:otherwise>
											</c:choose>
										</td>
										<td><a
											href="javascript:void(0);" title="删除" onclick="del(${s.id})"
											class="blue">[删除]</a></td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>

					</table>

					<h3 class="h3_r">
						新增/修改收货地址<span>手机、固定电话选填一项，其余均为必填</span>
					</h3>

					<form id="jvForm" method="post" action="/buyer/addAddress.shtml">
						<ul class="uls form">
							<li id="errorName" class="errorTip" style="display: none">${error}</li>
							<li><label for="username"><samp>*</samp>收货人姓名：</label> <span
								class="bg_text"><input type="text" id="username"
									name="username" vld="{required:true}" maxLength="100" /></span></li>
							<li><label for="residence"><samp>*</samp>地 址：</label> <span
								class="word"> <select id="province" name="province"
									onchange="changeProvince()">
										<option value="" selected>省/直辖市</option>
								</select> <select id="city" name="city">
								</select></li>
							<li><label for="nick"><samp>*</samp>街道地址：</label> <span
								class="bg_text"><input type="text" id="nick"
									vld="{required:true}" name="address" maxLength="32" /></span></li>
							<li><label for="telphone"><samp>*</samp>联系电话：</label> <span
								class="bg_text"><input type="text" id="telphone"
									name="phone" vld="{required:true}" maxLength="32" /></span></li>
							<li><label for="statusAddr">&nbsp;</label> <span><input
									type="checkbox" name="statusAddr" value="1" />设为默认收货地址</span></li>
							<li><label for="">&nbsp;</label><input type="submit"
								value="保存" class="hand btn66x23" /></li>
						</ul>
					</form>
				</div>
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
