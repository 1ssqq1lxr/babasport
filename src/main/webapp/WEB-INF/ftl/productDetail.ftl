<!DOCTYPE html>
<html>
<head>
<title>新巴巴运动网-商品详情页</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="/res/css/style.css" />
<script src="/res/js/jquery.js"></script>
<script type="text/javascript" src="/res/js/com.js"></script>
<style type="text/css">
.changToRed {
	border: 2px solid #e4393c;
	padding: 2px 4px;
	float: left;
	margin-right: 4px;
	text-decoration: none;
}
.changToWhite {
	border: 1px solid #ccc;
	padding: 2px 4px;
	float: left;
	margin-right: 4px;
	text-decoration: none;
}
.not-allow {
	cursor: not-allowed;
	color: #999;
	border: 1px dashed #ccc;
	padding: 2px 4px;
	float: left;
	margin-right: 4px;
	text-decoration: none;
}
</style>
<script type="text/javascript">
$(function(){
	$("#colors a:first").trigger("click") ;
	$("#sub").click(function(){
		//件数  1
		var num = $("#num").val();
		num--;
		if(num == 0){
			//alert();
			return;
		}
		//赋值
		$("#num").val(num);
	});
	//+
	$("#add").click(function(){
		//件数  8
		var num = $("#num").val();
		num++;
		//num 9      9
		if(num > buyLimit){
			alert("此商品只能买" + buyLimit + "件");
			return;
		}
		//赋值
		$("#num").val(num);
	});
	if(colorId_denmo==null){
		$("#hili1").hide();
		$("#hili2").hide();
	};
	$("#mybuy").click(function(){
		buy();
	})
	$("#mycart").click(function(){
		addCart();
	})
});
//全局变量
//颜色ID
var colorId_denmo;
//SkuId
var skuId;
var productId
var buyLimit;
//点击颜色按钮切换
function colorToRed(target,id){
	//赋值
	colorId = id;
	//先清理其它颜色
	$("#colors a").each(function(){
		$(this).attr("class","changToWhite");
		
	});
	//先清理尺码  都变成不可点
	$("#sizes a").each(function(){
		$(this).attr("class","not-allow");
	});
	
	$(target).attr("class","changToRed");
	//控制尺码 
	var flag = 0;
	//
		<#list skus as sku>
	  //判断SKu中与当前选择的颜色ID一样的,获取出所有尺码   
		if(id == '${sku.colorId}'){
			//四次  S  L  XL  XXL
			if(flag == 0){
				$("#" + '${sku.size}').attr("class","changToRed");
				flag = 1;
				//赋值
				//巴巴价
				$("#price").html("￥" + '${sku.skuPrice}');
				//市场价
				$("#mprice").html("￥" + '${sku.marketPrice}');
				//运费
				$("#fee").html('${sku.deliveFee}');
				//库存
				$("#stock").html('${sku.stockInventory}');
				//skuId
				skuId = '${sku.id}';
				colorId_denmo='${sku.colorId}';
				productId='${sku.productId}'
				//
				//限购
				buyLimit = '${sku.skuUpperLimit}';
				
			}else{
				$("#" + '${sku.size}').attr("class","changToWhite");
			}
		}
	</#list>
	
}
//点击尺寸
function sizeToRed(target,id){
	
	var cc = $(target).attr("class");
	if(cc == "not-allow"){
		return ;
	}
	//先清理尺码  都变成不可点
	$("#sizes a").each(function(){
		var c = $(this).attr("class");
		if(c != "not-allow"){
			$(this).attr("class","changToWhite");
		}
	});
	//尺码变红
	$(target).attr("class","changToRed");
	
	<#list skus as sku>
	  //判断SKu中与当前选择的颜色ID一样的,获取出所有尺码   
		if(colorId == '${sku.colorId}' && id == '${sku.size}'){
				//赋值
				//巴巴价
				$("#price").html("￥" + '${sku.skuPrice}');
				//市场价
				$("#mprice").html("￥" + '${sku.marketPrice}');
				//运费
				$("#fee").html('${sku.deliveFee}');
				//库存
				$("#stock").html('${sku.stockInventory}');
				//skuId
				skuId = '${sku.id}';
				//
				//限购
				buyLimit = '${sku.skuUpperLimit}';
		}
	</#list>
}
//加入购物车
function addCart(){
	alert("添加购物车成功!");
}

function logout(){
	window.location.href = "/logout/logout.shtml";
}
function login() {
	window.location.href = "/buyer/login.shtml";
}
function myOrder() {
	window.location.href = "/buyer/myOrder.shtml";
}
function myCart() {
	window.location.href = "/buyer/myCart.shtml";
}
$(function(){
	var url="/auth.shtml"
	$.get(url,function(data){
		if(data!=null){
			$("#di").html(data.name);
			$("#li1").hide();
		}else{
		$("#hili1").hide();
		$("#hili2").hide();
		};
		
	},"json");
})
function addCart(){
	var num=$("#num").val();
	url="/buyer/Addcart.shtml";
	data={"colorId":colorId_denmo,"skuId":skuId,"productId":productId,"quantity":num};
	$.post(url,data,function(){
		alert("添加购物车成功!");
	});
}
//立即购买
function buy(){
	var num=$("#num").val();
	window.location.href="/buyer/buy.shtml?skuId="+skuId+"&productId="+productId+"&quantity="+num+"&colorId="+colorId_denmo;
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
		<li  class="dev"><font size="2" color="red" id="di"></font></li>
		<li id="li1" class="dev"><a href="javascript:void(0)" onclick="login()"  title="登陆">[登陆]</a></li>
		<li id="li2" class="dev"><a href="javascript:void(0)" onclick="register()" title="免费注册">[免费注册]</a></li>
　
	
	<li class="dev"><a href="javascript:void(0)" onclick="logout()" title="退出">[退出]</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="myOrder()" title="我的订单">我的订单</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="myCart()" title="我的购物车">我的购物车</a></li>
	<li class="dev"><a href="#" title="在线客服">在线客服</a></li>
	<li class="dev after"><a href="#" title="English">English</a></li>
	</ul>
</div></div>

<div class="w ofc mt">
	<div class="l">
		<div class="showPro">
			<div class="big"><a id="showImg" class="cloud-zoom" href="http://localhost:8088/pic-web/${url }" rel="adjustX:10,adjustY:-1"><img alt="" src="http://localhost:8088/pic-web/${url }"></a></div>
		</div>
	</div>
	<div class="r" style="width: 640px">
	
		<ul class="uls form">
			<li><h2>依琦莲2014瑜伽服套装新款 瑜珈健身服三件套 广场舞蹈服装 性价比最高的瑜伽服 三件套 送胸垫 支持货到付款</h2></li>
			<li><label >巴  巴 价：</label><span class="word"><b class="f14 red mr" id="price">￥128.00</b>(市场价:<del  id="mprice">￥150.00</del>)</span></li>
			<li><label >商品评价：</label><span class="word"><span class="val_no val3d4" title="4分">4分</span><var class="blue">(已有888人评价)</var></span></li>
			<li><label>运　　费：</label><span class="word" id="fee">10元</span></li>
			<li><label >库　　存：</label><span class="word" id="stock">100</span><span class="word" >件</span></li>
			<li><label>选择颜色：</label>
				<div id="colors" class="pre spec">
					<#list colors as color>
					<a onclick="colorToRed(this,${color.colorId})" href="javascript:void(0)" title="${color.colorName}" class="changToWhite"><img width="25" height="25" data-img="1" src="/res/img/pic/ppp00.jpg" alt="${color.colorName} "><i>${color.colorName }</i></a>
					
					</#list>
				
				</div>
			</li>
			<li id="sizes"><label>尺　　码：</label>
						<a href="javascript:void(0)" class="not-allow"  id="S" onclick="sizeToRed(this,'S')">S</a>
						<a href="javascript:void(0)" class="not-allow"  id="M" onclick="sizeToRed(this,'M')">M</a>
						<a href="javascript:void(0)" class="not-allow"  id="L" onclick="sizeToRed(this,'L')">L</a>
						<a href="javascript:void(0)" class="not-allow"  id="XL" onclick="sizeToRed(this,'XL')">XL</a>
						<a href="javascript:void(0)" class="not-allow"  id="XXL" onclick="sizeToRed(this,'XXL')">XXL</a>
			</li>
			<li id="hili1"><label>我 要 买：</label>
				<a id="sub" class="inb arr" style="border: 1px solid #919191;width: 10px;height: 10px;line-height: 10px;text-align: center;" title="减" href="javascript:void(0);" >-</a>
				<input id="num" type="text" value="1" name="" size="1" readonly="readonly">
				<a id="add" class="inb arr" style="border: 1px solid #919191;width: 10px;height: 10px;line-height: 10px;text-align: center;" title="加" href="javascript:void(0);">+</a></li>
			<li id="hili2"><input type="button" id="mybuy"  class="hand btn138x40" /><input type="button" class="hand btn138x40b" id="mycart"/></li>
		</ul>
	</div>
</div>
<div class="w ofc mt">
<div class="l wl">
	<h2 class="h2 h2_l mt"><em title="销量排行榜">销量排行榜</em><cite></cite></h2>
	<div class="box bg_white">
		<ul class="uls x_50x50">
			<li>
				<var class="sfont">1</var>
				<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
				<dl>
					<!-- dt 8个文字+... -->
					<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
					<dd class="orange">￥120 ~ ￥150</dd>
				</dl>
			</li>
			<li>
				<var class="sfont">2</var>
				<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
				<dl>
					<!-- dt 8个文字+... -->
					<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
					<dd class="orange">￥120 ~ ￥150</dd>
				</dl>
			</li>
			<li>
				<var class="sfont">3</var>
				<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
				<dl>
					<!-- dt 8个文字+... -->
					<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
					<dd class="orange">￥120 ~ ￥150</dd>
				</dl>
			</li>
			<li>
				<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
				<dl>
					<!-- dt 8个文字+... -->
					<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
					<dd class="orange">￥120 ~ ￥150</dd>
				</dl>
			</li>
			<li>
				<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
				<dl>
					<!-- dt 8个文字+... -->
					<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
					<dd class="orange">￥120 ~ ￥150</dd>
				</dl>
			</li>
			<li>
				<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
				<dl>
					<!-- dt 8个文字+... -->
					<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
					<dd class="orange">￥120 ~ ￥150</dd>
				</dl>
			</li>
			<li>
				<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
				<dl>
					<!-- dt 8个文字+... -->
					<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
					<dd class="orange">￥120 ~ ￥150</dd>
				</dl>
			</li>
		</ul>
	</div>
	<h2 class="h2 h2_l mt"><em title="我的浏览记录">我的浏览记录</em><cite></cite></h2>
	<div class="box bg_white">
		<ul class="uls x_50x50">
			<li>
				<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
				<dl>
					<!-- dt 8个文字+... -->
					<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
					<dd class="orange">￥120 ~ ￥150</dd>
				</dl>
			</li>
			<li>
				<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
				<dl>
					<!-- dt 8个文字+... -->
					<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
					<dd class="orange">￥120 ~ ￥150</dd>
				</dl>
			</li>
			<li>
				<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
				<dl>
					<!-- dt 8个文字+... -->
					<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
					<dd class="orange">￥120 ~ ￥150</dd>
				</dl>
			</li>
			<li>
				<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
				<dl>
					<!-- dt 8个文字+... -->
					<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
					<dd class="orange">￥120 ~ ￥150</dd>
				</dl>
			</li>
			<li>
				<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
				<dl>
					<!-- dt 8个文字+... -->
					<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
					<dd class="orange">￥120 ~ ￥150</dd>
				</dl>
			</li>
			<li>
				<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
				<dl>
					<!-- dt 8个文字+... -->
					<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
					<dd class="orange">￥120 ~ ￥150</dd>
				</dl>
			</li>
		</ul>
	</div>
	
	<h2 class="h2 h2_l mt"><em title="商家精选">商家精选</em><cite></cite></h2>
	<img src="/res/img/pic/ad200x75.jpg" alt="" />
</div>
<div class="r wr">
		<h2 class="h2 h2_ch mt"><em>
			<a href="javascript:void(0);" title="商品介绍" rel="#detailTab1" class="here">商品介绍</a>
			<a href="javascript:void(0);" title="规格参数" rel="#detailTab2">规格参数</a>
			<a href="javascript:void(0);" title="包装清单" rel="#detailTab3">包装清单</a></em><cite></cite></h2>
		<div class="box bg_white ofc">
			<div id="detailTab1" class="detail">
				<img src="/res/img/pic/p800b.jpg" /><img src="/res/img/pic/p800a.jpg" /><img src="/res/img/pic/p800c.jpg" /><img src="/res/img/pic/p800d.jpg" />
			</div>
			
			<div id="detailTab2" style="display:none">
				<strong>服务承诺：</strong><br>
	京东向您保证所售商品均为正品行货，京东自营商品开具机打发票或电子发票。凭质保证书及京东发票，可享受全国联保服务（奢侈品、钟表除外；奢侈品、钟表由京东联系保修，享受法定三包售后服务），与您亲临商场选购的商品享受相同的质量保证。京东还为您提供具有竞争力的商品价格和<a target="_blank" href="http://www.jd.com/help/kdexpress.aspx">运费政策</a>，请您放心购买！
	<br><br>
	注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！ <br/>
		<strong>权利声明：</strong><br>京东上的所有商品信息、客户评价、商品咨询、网友讨论等内容，是京东重要的经营资源，未经许可，禁止非法转载使用。
	<p><b>注：</b>本站商品信息均来自于合作方，其真实性、准确性和合法性由信息拥有者（合作方）负责。本站不提供任何保证，并不承担任何法律责任。</p>	
				
			</div>

			<div id="detailTab3" class="detail" style="display:none">

	<pre class="f14">
		上衣*1 裤子*1 抹胸*1 包装*1 
	</pre>

			</div>
		</div>

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