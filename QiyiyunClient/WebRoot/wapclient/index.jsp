<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>企易云</title>
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="m.jd.com">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="format-detection" content="telephone=no">
		<meta http-equiv="Expires" content="-1">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Pragma" content="no-cache">
		<link rel="stylesheet" type="text/css"
			href="css/layout.css"
			charset="UTF-8" />
		<link rel="stylesheet" type="text/css"
			href="css/home.css"
			charset="UTF-8" />
		<style type="text/css">
			.seckill-item {
				padding: 8px 8px 0px 8px;
				border-left:0px;
			}
			
			body {
				background-color: #ffffff;
			}
			
			.activity-list li {
				margin-top:10px;
				margin-bottom:10px
			}
			a {
				text-decoration: none;
			}
			.point {
				background:#CCCCCC;
			}
			.point.selected {
				background:#777777;
			}
			.sapcecontentclass{
				
			}
			.spacebuttonclass{
				width: 40%;margin-left: 28%;margin-top:-12%;position: relative;
			}
			.spacepic{
				width:0%;overflow: hidden;margin-left: 15%;margin-top:-25%;position:absolute; display: block;opacity:0;
			}
		</style>
	</head>
	<body>
		<a id="layout_top" name="top"></a>
		<div class="viewport" style="max-width:480px">
			<header class="search-bar" style="">
				<img src="images/top.png" style="width:100%"/>
			</header>
			
			<div class="floor slider-floor" style="padding: 0">
				<div id="slider1" class="slider"
					style="overflow: hidden; width: 100%;">
					<ul style="font-size: 0; width: 100%; margin: 0; padding: 0; overflow: hidden; left: 0px; position: relative;">
						<li style="float: left; width: 100%;">
							<img src="images/banner.png" style="width:100%"/>
						</li>
					</ul>
				</div>
			</div>
			
			<div class="floor seckill-floor" style="background-color:#eeeeee;box-shadow:0 0 0 #ffffff;margin-bottom:8px">
				<ul class="seckill-list">
					<li class="seckill-item" style="margin-left:0px">
						<a href="#spaceicon1"><img id="button1" src="images/button1.png" style="width:100%"></img></a>
					</li>
					<li class="seckill-item" style="margin-left:0px">
						<a href="#spaceicon2"><img id="button2" src="images/button2.png" style="width:100%"></img></a>
					</li>
					<li class="seckill-item" style="margin-left:0px;margin-right:0px">
						<a href="#spaceicon3"><img id="button3" src="images/button3.png" style="width:100%"></img></a>
					</li>
				</ul>
				<span style="display: block;width:100%;height:13px;background-color:#ffffff; background-image: url(images/buttondecoration.png);background-repeat: no-repeat;">
				</span>
			</div>

			<div class="floor hot-floor" style="margin-bottom:15px">
				<img src="images/midbanner.png" style="width:100%"/>
			</div>
			
			<div id="spaceicon1" style="height:25px">
			</div>
			<div style="width: 100%;height:25px">
				<img   src="images/spaceicon1.png" style="float:left"/>
				<p style="float:left;color: red;margin-top:3px;font-size: 20px;font-weight: bold">&nbsp;场地展示</p>
			</div>
			<div id="space" class="floor activity-floor" style="width:100%;position: relative;height:350px">
				<div class="spacebackclass" style="width: 100%;position: absolute;height:350px">
					<table style="width: 100%;margin-left:1%">
						<tr style="width: 100%">
							<td style="width: 50%">
								<div style="width: 100%;position:;z-index:20;">
									<img src="images/spaceshow1.png" style="width:95%;";/>
									<img src="images/spacetitle1.png" style="width:95%; display: block;margin-top:-37%;"/>
									<div id="spacepic1" class="spacepic" style="">
										<ul style="text-align: center;width: 400%;padding: 0;left:0%;position: relative;">
											<li  style="width:25%;float: left;">
												<img id = "spacecontentimg1" class ="spacecontentimg" src="images/space11.jpg" style="width:100%;display: block;"  />
											</li>
											<li  style="width:25%;float: left;">
												<img class ="spacecontentimg" src="images/space12.jpg" style="width:100%;display: block"  />
											</li>
											<li  style="width:25%;float: left;">
												<img class ="spacecontentimg" src="images/space13.jpg" style="width:100%;display: block"  />
											</li>
											<li style="width:25%;float: left;">
												<img class ="spacecontentimg" src="images/space14.jpg" style="width:100%;display: block"  />
											</li>
										</ul>
										<div id="spacepic1number" class="serial-number" style="margin-top:10px;position: relative;opacity:1;">
											<span class="point  selected "></span>
											<span class="point "></span>
											<span class="point "></span>
											<span class="point "></span>
										</div>
									</div>
									<div class="spacebuttonclass" style="">
										<img  id="spacebutton1" class="spacebutton" src="images/spacebutton.png"  style="width: 100%"/>
									</div>
								</div>
							</td>
							<td style="width: 50%">
								<div >
									<img src="images/spaceshow2.png" style="width:95%;"/>
									<img src="images/spacetitle2.png" style="width:95%; display: block;margin-top:-37%"/>
									<div id="spacepic2" class="spacepic" style="">
										<ul  style="text-align: center;width: 200%;padding: 0;left:0%;position: relative;">
											<li  style="width:50%;float: left;display: block">
												<img class ="spacecontentimg" src="images/space21.jpg" style="width:100%;display: block"  />
											</li>
											<li  style="width:50%;float: left;display: block">
												<img class ="spacecontentimg" src="images/space22.jpg" style="width:100%;display: block"  />
											</li>
										</ul>
										<div id="spacepic2number" class="serial-number" style="margin-top:10px;position: relative;opacity:1;">
											<span class="point  selected "></span>
											<span class="point "></span>
										</div>
									</div>
									<div class="spacebuttonclass" style="">
										<img  id="spacebutton2" class="spacebutton" src="images/spacebutton.png"  style="width: 100%"/>
									</div>
								</div>
							</td>
						</tr>					
						<tr>
							<td>
								<div >
									<img src="images/spaceshow3.png" style="width:95%;"/>
									<img src="images/spacetitle3.png" style="width:95%; display: block;margin-top:-37%"/>
									<div id="spacepic3"  class="spacepic" style="">
										<ul style="text-align: center;width: 500%;padding: 0;left:0%;position: relative;">
											<li  style="width:20%;float: left;display: block">
												<img class ="spacecontentimg" src="images/space31.jpg" style="width:100%;display: block"  />
											</li>
											<li  style="width:20%;float: left;display: block">
												<img class ="spacecontentimg" src="images/space32.jpg" style="width:100%;display: block"  />
											</li>
											<li  style="width:20%;float: left;display: block">
												<img class ="spacecontentimg" src="images/space33.jpg" style="width:100%;display: block"  />
											</li>
											<li style="width:20%;float: left;display: block">
												<img class ="spacecontentimg" src="images/space34.jpg" style="width:100%;display: block"  />
											</li>
											<li style="width:20%;float: left;display: block">
												<img class ="spacecontentimg" src="images/space35.jpg" style="width:100%;display: block"  />
											</li>
										</ul>
										<div id="spacepic3number" class="serial-number" style="margin-top:10px;position: relative;opacity:1;">
											<span class="point  selected "></span>
											<span class="point "></span>
											<span class="point "></span>
											<span class="point "></span>
											<span class="point "></span>
										</div>
									</div>
									<div class="spacebuttonclass" style="">
										<img  id="spacebutton3" class="spacebutton" src="images/spacebutton.png"  style="width: 100%"/>
									</div>
								</div>	
							</td>
							<td>
								<div>
									<img src="images/spaceshow4.png" style="width:95%;"/>
									<img src="images/spacetitle4.png" style="width:95%; display: block;margin-top:-37%"/>
									<div id="spacepic4" class="spacepic" style="">
										<ul style="text-align: center;width: 500%;padding: 0;left:0%;position: relative;">
											<li  style="width:20%;float: left;display: block">
												<img class ="spacecontentimg" src="images/space41.jpg" style="width:100%;display: block"  />
											</li>
											<li  style="width:20%;float: left;display: block">
												<img class ="spacecontentimg" src="images/space42.jpg" style="width:100%;display: block"  />
											</li>
											<li  style="width:20%;float: left;display: block">
												<img class ="spacecontentimg" src="images/space43.jpg" style="width:100%;display: block"  />
											</li>
											<li style="width:20%;float: left;display: block">
												<img class ="spacecontentimg" src="images/space44.jpg" style="width:100%;display: block"  />
											</li>
											<li style="width:20%;float: left;display: block">
												<img class ="spacecontentimg" src="images/space45.jpg" style="width:100%;display: block"  />
											</li>
										</ul>
										<div id="spacepic4number" class="serial-number" style="margin-top:10px;position: relative;opacity:1;">
											<span class="point  selected "></span>
											<span class="point "></span>
											<span class="point "></span>
											<span class="point "></span>
											<span class="point "></span>
										</div>
									</div>
									<div class="spacebuttonclass" style="">
										<img  id="spacebutton4" class="spacebutton" src="images/spacebutton.png"  style="width: 100%"/>
									</div>
								</div>
							</td>
						</tr>					
					</table>
				</div>
			
			</div>
			
			<div id="spaceicon2" style="height:25px">
			</div>
			<div style="width: 100%;height:25px">
				<img   src="images/spaceicon2.png" style="float:left"/>
				<p style="float:left;color: red;margin-top:3px;font-size: 20px;font-weight: bold">&nbsp;预定工位</p>
			</div>
			<div class="floor activity-floor" style="width:100%">
				<div style="width: 100%; height: 230px">
				<form action="">
					<table style="height: 120px; margin: 10px auto 0 auto">
						<tr>
							<td style="height: 50px">
								场地选择:
							</td>
							<td style="height: 50px">
								<select name="space_choose" style="width: 100%"> 
									<option value="0" selected="selected">汇智大厦C区</option> 
									<option value="1">软件大道地铁口</option> 
								</select> 
							</td>
						</tr>
						<tr>
							<td style="height: 50px">
								姓名:
							</td>
							<td style="height: 50px">
								<input type="text" name="space_username" id="name" style="width: 100%"/>
							</td>
						</tr>
						<tr>
							<td style="height: 50px">
								电话:
							</td>
							<td style="height: 50px">
								<input type="text" name="space_phone" id ="phone" style="width: 100%"/>
							</td>
						</tr>
						<tr style="width: 100%">
							<td colspan="2" style="text-align: center">
								<img id="buttonsure" src="images/buttonsure.png" /> 
							</td>
						</tr>
					</table>
				</form>
			</div>

				<div class="activity-clear"></div>
			</div>
			
			<div id="spaceicon3" style="height:25px">
			</div>
			<div style="width: 100%;height:25px">
				<img   src="images/spaceicon3.png" style="float:left"/>
				<p style="float:left;color: red;margin-top:3px;font-size: 20px;font-weight: bold">&nbsp;入驻项目</p>
			</div>
			<div id="slider2" class="slider"
				style="overflow: hidden; width: 100%;">
				<ul id="slider_touch" style="font-size: 0; margin: 0; padding: 0; left: 0%; position: relative;width: 200%;overflow: hidden;">
						<li style="float:left; width: 50%">
							<ul class="activity-list" style="text-align: center;width: 100%;padding: 0">
								<li class="activity-item" style="width:50%;">
									<img src="images/registedprojects1.png" width="80%"
										style="padding:5px" />
								</li>
								<li class="activity-item" style="width:50%;">
									<img src="images/registedprojects2.png" width="80%"
										style="padding:5px" />
								</li>
								<li class="activity-item" style="width:50%;">
									<img src="images/registedprojects3.png" width="80%"
										style="padding:5px" />
								</li>
								<li class="activity-item" style="width:50%;">
									<img src="images/registedprojects4.png" width="80%"
										style="padding:5px" />
								</li>
							</ul>
						</li>
						<li style="float:left; width: 50%">
							<ul class="activity-list" style="text-align: center;width: 100%;padding: 0">
								<li class="activity-item" style="width:50%;">
									<img src="images/registedprojects5.png" width="80%"
										style="padding:5px" />
								</li>
								<li class="activity-item" style="width:50%;">
									<img src="images/registedprojects6.png" width="80%"
										style="padding:5px" />
								</li>
								<li class="activity-item" style="width:50%;">
									<img src="images/registedprojects7.png" width="80%"
										style="padding:5px" />
								</li>
							</ul>
						</li>
				</ul>
				<div id="serial-number2" class="serial-number" style="z-index: 1;margin-top:10px;position: relative;">
					<span class="point  selected "></span>
					<span class="point "></span>
				</div>
			</div>
				<div class="floor activity-floor" style="width:100%">
				<div style="width: 100%;padding-top: 10px">
					
					<table style="width: 80%;text-align: center;margin:0 auto">
						<tr style="width: 100%">
							<td style="width: 40%"><p id ="qrcodebutton" style="color: red;display: block">微信公众号</p></td>
							<td style="width: 30%"><a href="http://www.qiyiyun.cn" target="_blank" style="color: black">电脑版</a></td>
							<td style="width: 30%"><p style="color: gray">客户端</p></td>
						</tr>
					</table>
				</div>

				<div class="activity-clear"></div>
			</div>
			<div id="qrcodecontent" style="border: none;box-shadow:none;margin-top: -30%;margin-left:-43%;position: relative;opacity:0">
				<img src="images/qrcode.png" style="display: block;margin: 0 auto;width: 10%;height: 10%;"/>
			</div>
		</div>
		<div  class="bottom-to-top J_ping" id="indexToTop" style="display: block; -webkit-transform-origin: 0px 0px 0px; opacity: 1; -webkit-transform: scale(1, 1);"> 
			<a href="#"><img src="images/scroll-to-top-icon.png" style="width: 100%;"></a> 
		</div>

	</body>
	<script src="js/zepto.min.js"
		type="text/javascript"
		charset="UTF-8">
	</script>
		<script
		src="js/Mbase.js"
		type="text/javascript"
		charset="UTF-8"></script>
	
		<script type="text/javascript">
M.define("html5_2015",function(a){var b=function(c){this.init(c)};M.object.merge(b.prototype,{init:function(c){if(M.object.isObject(c)){if(c&&c.head){this.head=true}else{this.head=false}if(c&&c.footer){this.footer=true;this.footerInit(c.footer)}if(c&&c.appDown){this.appdownInit(c.appDown)}}},headRender:function(){var c=this;$("#layout_jdKey").on("click",function(){if($("#layout_jdBar").css("display")=="none"){$("#layout_jdBar").show()}else{$("#layout_jdBar").hide()}});$("#layout_urlblack").on("click",function(){c.pageBack()})},pageBack:function(){var c=window.location.href;if(/#top/.test(c)){window.history.go(-2);window.location.load(window.location.href)}else{window.history.back()}},footerInit:function(d){var c=this;if(d){if(M.object.isObject(d)){c.toPcHomeUrl=d.toPcHomeUrl?d.toPcHomeUrl:"http://www.jd.com/#m"}else{c.toPcHomeUrl="http://www.jd.com/#m"}}},footerRender:function(){var c=this;$("#layout_toPcHome").on("click",function(){c.toPcHome()})},toPcHome:function(){var c=this;M.cookie.setCookie("pcm","1",1,"",".jd.com");window.location.href=c.toPcHomeUrl},appdownInit:function(d){var c=this;if(d){if(M.object.isObject(d)){if(d.withScreen){c.appDownWithScreen=true}else{c.appDownWithScreen=false}}else{c.appDownWithScreen=false}c.appdownShow=true;c.hasAppDown=true;c.downloadHideTime=1;if(d.downloadHideTime){c.downloadHideTime=argObj.downloadHideTime}}else{c.hasAppDown=false}},appdownHtml:function(){var d=this;var c=[];c.push('<div id="layout_appdown" class="tryme'+(d.appDownWithScreen?" onfoot":"")+'">');c.push("<div>");c.push('<div id="layout_close_appdown" class="later"></div>');c.push('<a id="layout_open_app" class="trynow" href="javascript:void(0);"></a>');c.push("<span>客户端首单<br>满79元送79元</span>");c.push("</div>");c.push("</div>");return c.join("")},appdownBind:function(){var e=this;var d={openAppBtnId:"layout_open_app",closePanelBtnId:"layout_close_appdown",closePanelId:"layout_appdown",closeCallblack:function(){$("#layout_appdown").attr("search_land_searchTransformation_show","true")},closeCallblackSource:null};var c=$;c.downloadAppPlugIn(d)},appdownRender:function(){var d=this;var c=d.appdownHtml();$("#layout_top").after(c);d.appdownBind()},run:function(){if(this.footer){this.footerRender()}if(this.head){this.headRender()}if(this.hasAppDown){this.appdownRender()}}});a.clazz=b});(function(){var D=navigator.userAgent;var e=(D.match(/Chrome\/([\d.]+)/)||D.match(/CriOS\/([\d.]+)/))?true:false;var G=(D.match(/(Android);?[\s\/]+([\d.]+)?/))?true:false;var p=(D.match(/(iPad).*OS\s([\d_]+)/))?true:false;var x=(!p&&D.match(/(iPhone\sOS)\s([\d_]+)/))?true:false;var f=navigator.userAgent.indexOf("MicroMessenger")>=0;var t=false;var v="plugIn_downloadAppPlugIn_loadIframe";var k=false;var c=0;var b={};var o={};var A=null;var u={};var d=window.Zepto||window.jQuery?true:false;var n=[];function C(){WeixinJSBridge.invoke("getInstallState",{packageName:"com.jingdong.app.mall",packageUrl:"openApp.jdMobile://"},function(K){var L=K.err_msg,s=0;if(L.indexOf("get_install_state:yes")>-1){t=true}})}function J(L,K,s){if(d){A("#"+L).bind(K,s)}else{A("#"+L).addEventListener(K,s,!1)}}function h(s){var K=(s||"mGen")+(++c);return K}if(f){if(window.WeixinJSBridge&&WeixinJSBridge.invoke){C()}else{document.addEventListener("WeixinJSBridgeReady",C,!1)}}if(window.$LAB){$LAB.setOptions({AlwaysPreserveOrder:true}).script("http://h5.m.jd.com/active/track/mping.min.js")}else{var z=document.getElementsByTagName("script");var F=false;for(i=0;i<z.length;i++){if(z[i].src&&z[i].src.indexOf("/active/track/mping.min.js")!=-1){F=true;break}}if(!F){var q=document.createElement("script");q.type="text/javascript";q.src="http://h5.m.jd.com/active/track/mping.min.js";q.onerror=function(){l.removeChild(q)};var l=document.getElementsByTagName("head")[0];l.appendChild(q)}}if(d){A=window.$;u=window.$}else{A=function(s){if(typeof s=="object"){return s}return document.querySelector(s)};if(!window.$){window.$=u=A}else{u=window.$}}window.onblur=function(){for(var s=0;s<n.length;s++){clearTimeout(n[s])}};function E(L){var K=document.cookie.indexOf(L+"=");if(K==-1){return null}K=K+L.length+1;var s=document.cookie.indexOf(";",K);if(s==-1){s=document.cookie.length}return document.cookie.substring(K,s)}function r(L,O,s,P,N){var Q=L+"="+escape(O);if(s!=""){var K=new Date();K.setTime(K.getTime()+s*24*3600*1000);Q+=";expires="+K.toGMTString()}if(P!=""){Q+=";path="+P}if(N!=""){Q+=";domain="+N}document.cookie=Q}function g(s){var L={downAppURl:"http://h5.m.jd.com/active/download/download.html?channel=jd-m",downAppIos:"http://union.m.jd.com/download/go.action?to=http%3A%2F%2Fitunes.apple.com%2Fcn%2Fapp%2Fid414245413&client=apple&unionId=12532&subunionId=m-top&key=e4dd45c0f480d8a08c4621b4fff5de74",downWeixin:"http://a.app.qq.com/o/simple.jsp?pkgname=com.jingdong.app.mall&g_f=991850",downIpad:"https://itunes.apple.com/cn/app/jing-dong-hd/id434374726?mt=8",inteneUrl:"openApp.jdMobile://360buy?type=1",inteneUrlParams:null,openAppBtnId:"",closePanelBtnId:"",closePanelId:"",closeCallblack:null,closeCallblackSource:null,cookieFlag:null,noRecord:false};if(s){for(var K in s){if(K&&s[K]){L[K]=s[K]}}}return L}function w(N,s){var R=j(N);var O=null;if(f){var K=null;if(t){K=R}else{K=N.downWeixin}location.href=K;return}if(p){O=N.downIpad}else{if(x){O=N.downAppIos}else{O=N.downAppURl}}if(e){if(G){var Q=R;R=y(Q)}}document.querySelector("#"+v).src=R;var P=Date.now();if(s){var L=setTimeout(function(){I(P,O)},500);n.push(L)}}function I(L,K){var s=Date.now();if(L&&(s-L)<(500+200)){window.location.href=K}}function j(K){var S=[];var O=K.inteneUrlParams;var Q={category:"jump",des:"productDetail",sourceType:"JSHOP_SOURCE_TYPE",sourceValue:"JSHOP_SOURCE_VALUE"};if(O){for(var R in O){if(R&&O[R]){S.push('"'+R+'":"'+O[R]+'"')}}}else{for(var R in Q){if(R&&Q[R]){S.push('"'+R+'":"'+Q[R]+'"')}}}try{S.push('"m_param":'+MPing.EventSeries.getSeries())}catch(P){S.push('"m_param":null')}var L="{"+S.join(",")+"}";var N=K.inteneUrl.split("?");var s=null;if(N.length==2){s=N[0]+"?"+N[1]+"&params="+L}else{s=N[0]+"?params="+L}return s}function y(s){return"intent://m.jd.com/#Intent;scheme="+s+";package=com.jingdong.app.mall;end"}function H(s){if(s.openAppBtnId){b[s.openAppBtnId]=s;J(s.openAppBtnId,"click",function(){var O=this.getAttribute("id");var K=b[O];if(!k){var L=document.createElement("iframe");L.id=v;document.body.appendChild(L);document.getElementById(v).style.display="none";document.getElementById(v).style.width="0px";document.getElementById(v).style.height="0px";k=true}var N=K.cookieFlag?"downloadAppPlugIn_downCloseDate_"+K.cookieFlag:"downloadAppPlugIn_downCloseDate";r(N,Date.now()+"_2592000000",60,"/","m.jd.com");B("MDownLoadFloat_OpenNow");w(K,true)})}}function a(L){if(L.closePanelBtnId&&L.closePanelId){b[L.closePanelBtnId]=L;var Q=L.cookieFlag?"downloadAppPlugIn_downCloseDate_"+L.cookieFlag:"downloadAppPlugIn_downCloseDate";var O=E(Q);var P=null;if(O){P=O.split("_");if(P.length==2){P[0]=parseInt(P[0],10);P[1]=parseInt(P[1],10)}else{P=null}}var K=Date.now();if(!L.noRecord&&P&&P.length==2&&(K-P[0])<P[1]){document.querySelector("#"+L.closePanelId).style.display="none";if(L.closeCallblack){var N=L.closeCallblackSource?L.closeCallblackSource:null;L.closeCallblack.call(N)}return}else{document.querySelector("#"+L.closePanelId).style.display="block"}J(L.closePanelBtnId,"click",function(){B("MDownLoadFloat_Close");var U=this.getAttribute("id");var R=b[U];var T=R.cookieFlag?"downloadAppPlugIn_downCloseDate_"+R.cookieFlag:"downloadAppPlugIn_downCloseDate";if(!R.noRecord){r(T,Date.now()+"_259200000",60,"/","m.jd.com")}document.querySelector("#"+R.closePanelId).style.display="none";if(R.closeCallblack){var S=R.closeCallblackSource?R.closeCallblackSource:null;R.closeCallblack.call(S)}})}}function B(K){try{var L=new MPing.inputs.Click(K);L.event_param="";var s=new MPing();s.send(L)}catch(N){}}function m(s){var K=g(s);H(K);a(K)}u.downloadAppPlugIn=m;u.downloadAppPlugInOpenApp=function(s){var K=g(s);w(K)}})();
</script>
	<script type="text/javascript">
M.define("BuriedPoint",function(a){var b=function(c){this.init(c)};M.object.merge(b.prototype,{init:function(c){},run:function(){var c=this;M.require("http://h5.m.jd.com/active/track/mping.min.js",function(){try{var g=new MPing.inputs.PV();var f=new MPing();f.send(g);MPing.inputs.Click.attachEvent()}catch(h){M.log(d,"error")}})}});a.clazz=b});</script>
	
	<script type="text/javascript">
		$(function(){
			if(scrollY > 50){
				$("#indexToTop").css("visibility","visible");
			}else{
				$("#indexToTop").css("visibility","hidden");
			}
		});
	</script>
	<script type="text/javascript">
		$("#buttonsure").on("touchend",function(e){
				var name = $("#name").val();
		        var phone = $("#phone").val();
				alert("name"+name+"phone"+phone);
		       	var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/; //手机号码验证规则
		       	if(name==""){
		         	alert("姓名不能为空！");
		         	$("#name").focus();
		         	return;
		       	} 
		       	if(phone==""){
		       		alert("手机号码不能为空！");
		       		$("#phone").focus();
		       		return;
		     	}
		     	if(!phone.match(isMobile)){
		       		alert("手机格式不对！");
		       		$("#phone").focus();
		       		return;
		     	}
			    $.post("../servlet/NewBookStationUIServlet","name="+name+"&phone="+phone,function(){
			    	  alert("提交成功！");
			    });

			
		});
	
	
	</script>

	<script type="text/javascript"
		src="js/index.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="js/qiyiyunwap.js"
		charset="UTF-8"></script>
	
</html>
