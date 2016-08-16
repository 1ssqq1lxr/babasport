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
};
$(function(){
	var id=${buyer.province };
	$.ajax(
			{
		url:"loadProvince.shtml",
		type:"get",
		dataType:"json",
		success:function(data){
	//$.get方法得到的是字符串 需要eval将字符串转换为对象 才能遍历
	//$.ajax方法得到的是对象（自动处理了） 不需要eval转换
			var list=data.list;
			for(var i=0;i<list.length;i++){
				if(list[i].pid==id){
					var ss=$("<option/>").attr("selected","selected").val(list[i].pid).text(list[i].name);
					$("#province").append(ss);
				}
				else{
					var ss=$("<option/>").val(list[i].pid).text(list[i].name);
					$("#province").append(ss);
				}
				
			
			}
		}
	});
	var cityid=${buyer.city};
	$.ajax({
		url:"loadCiry.shtml",
		type:"post",
		data:{"pid":id},
		dataType:"json",
		success:function(dat){
			$("#city option").remove();
			var citys=dat.citys;
			if(citys!=""){
				for(var i=0;i<citys.length;i++){
					if(citys[i].cid==cityid){
					var ss=$("<option/>").attr("selected","selected").val(citys[i].cid).text(citys[i].name);
					$("#city").append(ss);
					}
					else{
						var ss=$("<option/>").val(citys[i].cid).text(citys[i].name);
						$("#city").append(ss);
					}
					
				}
			}
		}
	})
});
function changeProvince(){
	var provinceid=$("#province").val();
	$.ajax({
		url:"loadCiry.shtml",
		type:"post",
		data:{"pid":provinceid},
		dataType:"json",
		success:function(dat){
			$("#city option").remove();
			var citys=dat.citys;
				for(var i=0;i<citys.length;i++){
						var ss=$("<option/>").val(citys[i].cid).text(citys[i].name);
						$("#city").append(ss);
			}
		}
	})
};
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
		</div></div>
<div class="w loc">
	<div class="h-title">
		<div class="h-logo"><a href="http://localhost:8080"><img src="/res/img/pic/logo-1.png" /></a></div>
	    <div class="h-search">
	      	<input type="text" />
	        <div class="h-se-btn"><a href="#">搜索</a></div>
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

		<div class="confirm">
			<div class="tl"></div><div class="tr"></div>
			<div class="ofc">
				<h2 class="h2 h2_r2"><em title="个人资料">个人资料</em></h2>
				<form id="jvForm" action="profile.shtml" method="post">
					
					<input type="hidden" name="id" value="${buyer.id}"/>
					<ul class="uls form">
					<li id="errorName" class="errorTip" style="display:none">${error}</li>
					<li>
						<label for="username">用 户 名：</label>
						<span class="word">${buyer.username }</span>
					</li>
					<li>
						<label for="username">邮　　箱：</label>
						<span class="word">${buyer.email }</span>
					</li>
					<li>
						<label for="realName">真实姓名：</label>
						<span class="bg_text"><input type="text" id="realName" name="realName" maxLength="32" value="${buyer.realName }"/></span>
						<span class="pos"><span class="tip okTip">&nbsp;</span></span>
					</li>
					<li>
						<label for="gender">性　　别：</label>
						
						<span class="word"><input type="radio" name="gender" value="SECRECY" <c:if test="${buyer.gender eq  'SECRECY'  }">checked="checked"</c:if>/>保密
						<input type="radio" name="gender" value="MAN" <c:if test="${buyer.gender eq  'MAN' }">checked="checked"</c:if>/>男
						<input type="radio" name="gender" value="WOMAN" <c:if test="${buyer.gender eq  'WOMAN' }">checked="checked"</c:if>/>女</span>
					</li>
					<li>
						<label for="residence">居 住 地：</label>
						<span class="word">
							<select name="province"  id="province" onchange="changeProvince()">
								<option value="" >省/直辖市</option>
							</select>
							<select name="city" id="city">
							</select>
						</span>
					</li>
					<li><label for="address">详细地址：</label>
						<span class="bg_text"><input type="text" id="addr" name="addr" maxLength="32" value="${buyer.addr }"/></span>
					</li>
					<li><label for="">&nbsp;</label><input type="submit" value="保存" class="hand btn66x23" /></li>
					</ul>
				</form>
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