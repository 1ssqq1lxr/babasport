<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录_新巴巴运动网</title>
<link rel="stylesheet" href="/res/css/style.css" />
<script src="/res/js/jquery.js"></script>
<script src="/res/js/com.js"></script>
<script type="text/javascript">
function randomcode_refresh(){
	$("#randomcode_img").attr("src","/validatecode.jsp?time="+new Date());
}
function check(){
	
	var code=$("#randomcode").val();
	if(code==""){
		$("#ss").text("请输入验证码").css("color","red");
		return;
	}
	else{
		$("#ss").text("");
	};
	if($("#username").val()==""){
		$("#s1").text("请输入用户名").css("color","red");
		return;
	}else{
		$("#s1").text("");
	};
	if($("#password").val()==""){
		$("#s2").text("请输入密码").css("color","red");
		return;
	}else{
		$("#s2").text("");
	}
	
	$("#jvForm").submit();
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
	<li class="dev">您好,欢迎来到新巴巴运动网！</li>
	<li class="dev"><a href="#" title="在线客服">在线客服</a></li>
	<li class="dev after"><a href="#" title="English">English</a></li>
	</ul>
</div></div>
<div class="w loc">
	<div class="h-title" id="logo">
		<div class="h-logo l"><img src="/res/img/pic/logo-1.png"/></div>
		<div class="l" style="margin: 13px 10px;font-size: 20px;font-family: '微软雅黑';letter-spacing: 2px">欢迎登录</div>
	</div>
</div>
<div class="sign">
	<div class="l ad420x205"><a href="#" title="title"><img src="/res/img/pic/ppp0.jpg" width="400" height="400"/></a></div>
	<div class="r">
		<h2 title="登录新巴巴运动网">登录新巴巴运动网</h2>
		<form id="jvForm" action="/buyer/login.shtml" method="post">
			<ul class="uls form">
			<c:if test="${not empty error }">
			<li id="errorName" class="errorTip" >${error}</li>
			</c:if>
			<li><label for="username">用户名：</label>
				<span class="bg_text">
					<input type="text" id="username" vld="{required:true}" value="${buyer.username }" name="username" maxLength="100" />
				</span>
			</li>
			<div id="s1" align="right" ></div>
			<li><label for="password">密　码：</label>
				<span class="bg_text">
					<input type="password" id="password" vld="{required:true}" value="${buyer.password }" name="password" maxLength="32" />
				</span>
			</li>
			<div id="s2" align="right" ></div>
		<!--  --><li><label for="captcha">验证码：</label>
				<span class="bg_text small">
					<input type="text" id="randomcode" name="randomcode" vld="{required:true}" maxLength="7"/>
				</span>
				<img id="randomcode_img" src="/validatecode.jsp" onclick="randomcode_refresh()" class="code" alt="换一张" /><a href="javascript:void(0);" onclick="randomcode_refresh()" title="换一张">换一张</a></li>
				<div id="ss" align="right" ></div>
			<li><label for="">&nbsp;</label><input type="button" value="登 录" onclick="check()" class="hand btn66x23"/><a href="#" title="忘记密码？">忘记密码？</a></li>
			</ul>
		</form>
	</div>
</div>
</body>
</html>