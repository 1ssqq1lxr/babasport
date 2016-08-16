<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<title>新巴巴运动网-电子商城</title>
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
			<c:if test="${not empty buyer.cart_infos  }">
		<dl id="cart" class="cart r">
		
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
			</dd>
		</dl>
			</c:if>
	</div>

	<div class="w ofc">
		<div class="l wl">
			<h2 class="h2 h2_l">
				<em title="销量排行榜">销量排行榜</em><cite></cite>
			</h2>
			<div class="box bg_white">
				<ul class="uls x_50x50">
					<li><var class="sfont">1</var> <a href="#" title="富一代"
						target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg"
							alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<!-- dt 8个文字+... -->
							<dt>
								<a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="orange">￥120 ~ ￥150</dd>
						</dl></li>
					<li><var class="sfont">2</var> <a href="#" title="富一代"
						target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg"
							alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<!-- dt 8个文字+... -->
							<dt>
								<a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="orange">￥120 ~ ￥150</dd>
						</dl></li>
					<li><var class="sfont">3</var> <a href="#" title="富一代"
						target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg"
							alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<!-- dt 8个文字+... -->
							<dt>
								<a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="orange">￥120 ~ ￥150</dd>
						</dl></li>
					<li><a href="#" title="富一代" target="_blank" class="pic"><img
							src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<!-- dt 8个文字+... -->
							<dt>
								<a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="orange">￥120 ~ ￥150</dd>
						</dl></li>
					<li><a href="#" title="富一代" target="_blank" class="pic"><img
							src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<!-- dt 8个文字+... -->
							<dt>
								<a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="orange">￥120 ~ ￥150</dd>
						</dl></li>
					<li><a href="#" title="富一代" target="_blank" class="pic"><img
							src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<!-- dt 8个文字+... -->
							<dt>
								<a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="orange">￥120 ~ ￥150</dd>
						</dl></li>
				</ul>
			</div>

			<h2 class="h2 h2_l mt">
				<em title="我的浏览记录">我的浏览记录</em><cite></cite>
			</h2>
			<div class="box bg_white">
				<ul class="uls x_50x50">
					<li><a href="#" title="富一代" target="_blank" class="pic"><img
							src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<!-- dt 8个文字+... -->
							<dt>
								<a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="orange">￥120 ~ ￥150</dd>
						</dl></li>
					<li><a href="#" title="富一代" target="_blank" class="pic"><img
							src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<!-- dt 8个文字+... -->
							<dt>
								<a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="orange">￥120 ~ ￥150</dd>
						</dl></li>
					<li><a href="#" title="富一代" target="_blank" class="pic"><img
							src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<!-- dt 8个文字+... -->
							<dt>
								<a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="orange">￥120 ~ ￥150</dd>
						</dl></li>
					<li><a href="#" title="富一代" target="_blank" class="pic"><img
							src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<!-- dt 8个文字+... -->
							<dt>
								<a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="orange">￥120 ~ ￥150</dd>
						</dl></li>
					<li><a href="#" title="富一代" target="_blank" class="pic"><img
							src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<!-- dt 8个文字+... -->
							<dt>
								<a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="orange">￥120 ~ ￥150</dd>
						</dl></li>
					<li><a href="#" title="富一代" target="_blank" class="pic"><img
							src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<!-- dt 8个文字+... -->
							<dt>
								<a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="orange">￥120 ~ ￥150</dd>
						</dl></li>
				</ul>
			</div>

			<h2 class="h2 h2_l mt">
				<em title="商家精选">商家精选</em><cite></cite>
			</h2>
			<img src="/res/img/pic/ad200x75.jpg" alt="" />
		</div>
		<div class="r wr">
			<h2 class="h2 h2_r rel">
				<samp></samp>
				<em title="热卖推荐">&nbsp;&nbsp;&nbsp;热卖推荐</em>
			</h2>
			<div class="box bg_white">
				<ul class="uls i_150x150 x4_150x150">
					<li><a href="productDetail.jsp" title="富一代" target="_blank"
						class="pic"><img src="	/res/img/pic/ppp.jpg"
							alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<dt>
								<a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新"
									target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="h40">依琦莲2014瑜伽服套装新！</dd>
							<dd class="orange">￥120 ~ ￥150</dd>
							<dd>
								<a href="productDetail.jsp" title="立即抢购" class="inb btn70x21 mr">立即抢购</a>
							</dd>
						</dl></li>
					<li><a href="productDetail.jsp" title="富一代" target="_blank"
						class="pic"><img src="	/res/img/pic/ppp.jpg"
							alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<dt>
								<a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新"
									target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="h40">依琦莲2014瑜伽服套装新！</dd>
							<dd class="orange">￥120 ~ ￥150</dd>
							<dd>
								<a href="productDetail.jsp" title="立即抢购" class="inb btn70x21 mr">立即抢购</a>
							</dd>
						</dl></li>
					<li><a href="productDetail.jsp" title="富一代" target="_blank"
						class="pic"><img src="	/res/img/pic/ppp.jpg"
							alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<dt>
								<a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新"
									target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="h40">依琦莲2014瑜伽服套装新！</dd>
							<dd class="orange">￥120 ~ ￥150</dd>
							<dd>
								<a href="productDetail.jsp" title="立即抢购" class="inb btn70x21 mr">立即抢购</a>
							</dd>
						</dl></li>
					<li><a href="productDetail.jsp" title="富一代" target="_blank"
						class="pic"><img src="	/res/img/pic/ppp.jpg"
							alt="依琦莲2014瑜伽服套装新" /></a>
						<dl>
							<dt>
								<a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新"
									target="_blank">依琦莲2014瑜伽服套装新</a>
							</dt>
							<dd class="h40">依琦莲2014瑜伽服套装新！</dd>
							<dd class="orange">￥120 ~ ￥150</dd>
							<dd>
								<a href="productDetail.jsp" title="立即抢购" class="inb btn70x21 mr">立即抢购</a>
							</dd>
						</dl></li>
				</ul>
			</div>

			<h2 class="h2 h2_filter mt">
				<em title="商品筛选">商品筛选</em><cite><a href="javascript:void(0);"
					id="filterRest" title="重置筛选条件">重置筛选条件</a></cite>
			</h2>
			<ul class="uls filter">
				<!-- 方式一动态遍历
				<c:if test="${flag}">
				<li><label>已选条件：</label>
				<p class="sel">
					<c:forEach items="${map}" var="entry">
					<a href="javascript:void(0);">
					<em>${entry.key }：</em>${entry.value }
					<cite title="关闭此筛选条件">X</cite></a>
					</c:forEach>
				</p>
				</li>
				</c:if> -->
				<c:if test="${flag }">
					<li><label>已选条件：</label>
				</c:if>
				<p class="sel">
					<c:if test="${not empty brandName }">
						<a href="javascript:void(0);"
							onclick="window.location.href='list.shtml?typeId=${typeId }&typeName=${typeName }&feature=${feature }&featureName=${featureName }'">
							<em>${s1 }：</em>${brandName } <cite title="关闭此筛选条件">X</cite>
						</a>
					</c:if>
					<c:if test="${not empty typeName }">
						<a href="javascript:void(0);"
							onclick="window.location.href='list.shtml?brandId=${brandId}&brandName=${brandName }&feature=${feature }&featureName=${featureName }'">
							<em>${s2 }：</em>${typeName } <cite title="关闭此筛选条件">X</cite>
						</a>
					</c:if>
					<c:if test="${not empty featureName }">
						<a href="javascript:void(0);"
							onclick="window.location.href='list.shtml?brandId=${brandId}&brandName=${brandName }&typeId=${typeId }&typeName=${typeName }'">
							<em>${s3 }：</em>${featureName } <cite title="关闭此筛选条件">X</cite>
						</a>
					</c:if>
				</p>
				</li>


				<li><b>品牌：</b>
				<p>
						<c:if test="${not empty brandName }">
							<a href="javascript:void(0);" title="不限" class="here"
								onclick="window.location.href='list.shtml?typeId=${typeId }&typeName=${typeName }&feature=${feature }&featureName=${featureName }'">不限</a>
						</c:if>
						<c:forEach items="${brands }" var="brand">
							<a href="javascript:void(0);" title="${brand.name }"
								onclick="window.location.href='list.shtml?brandId=${brand.id}&brandName=${brand.name }&typeId=${typeId }&typeName=${typeName }&feature=${feature }&featureName=${featureName }'">${brand.name }</a>
						</c:forEach>
					</p></li>

				<li><b>类型：</b>
				<p>
						<c:if test="${not empty typeName }">
							<a href="javascript:void(0);" title="不限" class="here"
								onclick="window.location.href='list.shtml?brandId=${brandId}&brandName=${brandName }&feature=${feature }&featureName=${featureName }'">不限</a>
						</c:if>
						<c:forEach items="${types }" var="type">
							<a href="javascript:void(0);" title="${type.name }"
								onclick="window.location.href='list.shtml?brandId=${brandId}&brandName=${brandName }&typeId=${type.tid }&typeName=${type.name }&feature=${feature }&featureName=${featureName }'">${type.name }</a>
						</c:forEach>
					</p></li>
				<li><b>材质：</b>
				<p>
						<c:if test="${not empty featureName }">
							<a href="javascript:void(0);" title="不限" class="here"
								onclick="window.location.href='list.shtml?brandId=${brandId}&brandName=${brandName }&typeId=${typeId }&typeName=${typeName }'">不限</a>
						</c:if>
						<c:forEach items="${features }" var="feature">
							<a href="javascript:void(0);" title="${feature.name }"
								onclick="window.location.href='list.shtml?brandId=${brandId}&brandName=${brandName }&typeId=${typeId }&typeName=${typeName }&feature=${feature.fid }&featureName=${feature.name}'">${feature.name }</a>
						</c:forEach>
					</p></li>

			</ul>
			<div class="sort_type">
			<shi
				<a href="javascript:void(0);" title="销量" class="sales">销量</a> <a
					href="javascript:void(0);" title="价格" class="price">价格</a> <a
					href="javascript:void(0);" title="上架时间" class="time">上架时间</a>
			</div>
			<div class="mt ofc">
				<ul class="uls i_150x150 x4_150x150b">
					<c:forEach items="${products }" var="entry">
						<li><a href="javascript:void(0)"
							onclick="window.open('/html/product/'+${entry.id }+'.html')"
							title="${entry.name }" class="pic"><img
								src="http://localhost:8088/pic-web/${entry.url}"
								alt="${entry.name }" /></a>
							<dl>
								<!-- dt 10个文字+... -->
								<dt>
									<a href="javascript:void(0)"
										onclick="window.open('/html/product/'+${entry.id }+'.html')"
										title="${entry.name }" target="_blank">${entry.name }</a>
								</dt>
								<!-- dt 25个文字+... -->
								<dd class="h40">${entry.name }</dd>
								<dd class="orange">￥128</dd>
							</dl> <img src="/res/img/pic/hot.gif" alt="热门" class="type" /></li>
					</c:forEach>
				</ul>
				<div class="page pb15">
					<span class="r inb_a page_b"> 共<var>${page.total}</var>记录 <a
						href="list.shtml?pageNum=1&brandId=${brandId }&typeId=${typeId }&feature=${feature}"><font
							size="2">首页</font></a> <c:if test="${page.pageNum==1 }">
						</c:if> <c:if test="${page.pageNum>1 }">
							<a
								href="list.shtml?pageNum=${page.pageNum-1 }&brandId=${brandId }&typeId=${typeId }&feature=${feature}"><font
								size="2">上一页</font></a>
						</c:if> <c:forEach var="s" begin="1" end="${page.pages }">
							<c:choose>
								<c:when test="${s == page.pageNum}">${s }&nbsp;&nbsp;</c:when>
								<c:otherwise>
									<a
										href="list.shtml?pageNum=${s }&brandId=${brandId }&typeId=${typeId }&feature=${feature}">${s }</a>
								</c:otherwise>
							</c:choose>
						</c:forEach> <%-- <a href="/product/list.do?&amp;isShow=0&amp;pageNo=3">3</a>
	
		<a href="/product/list.do?&amp;isShow=0&amp;pageNo=4">4</a>
	
		<a href="/product/list.do?&amp;isShow=0&amp;pageNo=5">5</a> amp;--%> <c:if
							test="${page.pageNum==page.pages }">
						</c:if> <c:if test="${page.pageNum<page.pages }">
							<a
								href="list.shtml?pageNum=${page.pageNum+1 }&brandId=${brandId }&typeId=${typeId }&feature=${feature}"><font
								size="2">下一页</font></a>
						</c:if> <a
						href="list.shtml?pageNum=${page.pages }&brandId=${brandId }&typeId=${typeId }&feature=${feature}"><font
							size="2">尾页</font></a> 共<var>${page.pages }</var>页 到第<input
						type="text" size="3" id="PAGENO" />页 <input type="button"
						onclick="javascript:window.location.href = 'list.shtml?&brandId=${brandId }&typeId=${typeId }&feature=${feature}&pageNum=' + $('#PAGENO').val() "
						value="确定" class="hand btn60x20" id="skip" />

					</span>
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