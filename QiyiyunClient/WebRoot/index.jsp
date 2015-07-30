<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>企易云</title>
	 	<link rel="shortcut icon" href="<%=path%>/logo.png" type="image/x-icon">
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<link rel="stylesheet" type="text/css"
			href="css/bootstrap-responsive.min.css" />
		<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<!--[if lt IE 9]>
<script src="js/html5.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/ie9-style.css" />
<![endif]-->
	</head>
	<body>
		<div class="fixed_r">
			<ul>
				<li></li>
				<li style="margin-top: 10px"></li>
				<li style="margin-top: 10px"></li>
				<li style="margin-top: 10px"></li>
			</ul>
		</div>
		<div id="topmenu">
			<ul>
				<li>
					预定场地
				</li>
				<li>
					场地展示
				</li>
				<li>
					入驻项目
				</li>
			</ul>
		</div>
		<div class="num_box">
			<div class="num" id="num_0">
				<div class="wrapper">
					<div class="contentcontainer">
						<div>
							<table
								style="font-family: Microsoft YaHei; color: #ffffff; width: 900px; margin-top: 200px">
								<tr style="height: 94px">
									<td>
										<div style="font-size: 72px; margin-top: 0px">
											<span>企易云</span>
										</div>
									</td>
								</tr>
								<tr style="height: 62px">
									<td>
										<div style="font-size: 48px; margin-top: 0px">
											<span>易创空间</span>
										</div>
									</td>
								</tr>
								<tr style="height: 31px">
									<td>
										<div style="font-size: 24px; margin-top: 30px">
											<span>we make everything easier</span>
										</div>
									</td>
								</tr>
								<tr style="height: 31px">
									<td>
										<div style="font-size: 24px; margin-top: 10px">
											<span>企易简单，万事不难</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div style="margin-top: 100px">
											<img id="bookimg" style="cursor: pointer;"
												src="images/bookstation1.png">
										</div>
									</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="arrowdown" id="arrow1">
						<img src="images/arrowdown.png">
					</div>
				</div>
			</div>
			<div class="num" id="num_1">
				<div class="wrapper">
					<div class="contentcontainer">
						<div style="position: relative;">
							<table class="sectiontable" style="width: 900px; color: #ffffff">
								<tr>
									<td colspan="4" style="color: #000000; font-size: 50px;">
										预定场地
									</td>
								</tr>
								<tr>
									<td colspan="4" style="font-size: 40px">
										有限的场地 无限的可能
									</td>
								</tr>
								<tr>
									<td colspan="2" style="color: #000000; font-size: 30px;">
										场地选择
									</td>
									<td style="width: 300px; font-size: 28px">
										Just waitting for
									</td>
								</tr>
								<tr>
									<td style="width: 150px;">
										<img id="addressimg1" src="images/address11.png"
											style="width: 120px; height: 39px; cursor: pointer">
									</td>
									<td style="width: 150px;">
										<img id="addressimg2" src="images/address21.png"
											style="width: 120px; height: 39px; cursor: pointer">
									</td>
									<td style="color: #f2c812; font-size: 65px;">
										You.
									</td>
								</tr>
								<tr>
									<td colspan="2" rowspan="3">
										<div id="pictures">
											<img id="addressimgmap1" style="width: 300px; height: 302px"
												src="images/map1.png">
											<img id="addressimgmap2" style="width: 300px; height: 302px"
												src="images/map2.png">
										</div>
									</td>
									<td></td>
									<td rowspan="2">
										<form>
											<div class="control-group">
												<div class="controls">
													<input id="name" type="text" placeholder="姓名" name="name"
														style="width: 280px; height: 40px; font-size: 20px;">
												</div>
											</div>
											<div class="control-group" style="margin-top: 20px">
												<div class="controls">
													<input id="phone" name="phone" type="text"
														placeholder="手机号码"
														style="width: 280px; height: 40px; font-size: 20px">
												</div>
											</div>
										</form>
									</td>
								</tr>
								<tr></tr>
								<tr>
									<td>
										<img id="determineimg" style="cursor: pointer;"
											src="images/determine1.png">
									</td>
								</tr>
								<tr>
									<td id="addresstext" colspan="2"
										style="color: #000000; font-size: 18px;">
										雨花台区软件大道地铁口1号出口
									</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="arrowdown" id="arrow2">
						<span> <img src="images/arrowdown.png">
						</span>
					</div>
				</div>
			</div>
			<div class="num" id="num_2">
				<div class="wrapper">
					<div class="contentcontainer">
						<table class="sectiontable"
							style="width: 900px; height: 600px; text-align: center">
							<tbody style="width: 900px">
								<tr style="height: 350px; width: 900px">
									<td colspan="3"
										style="height: 350px; width: 900px; left: 0; top: 0">
										<div style="width: 900px; height: 350px; display: inline-block;">
											<div class="num2arrowleft"
												style="position: absolute; width: 20px; height: 26px; margin-left: 180px; margin-top: 162px;">
												<img src="images/numarrowleft.png">
											</div>
											<div class="num2arrowright"
												style="position: absolute; width: 20px; height: 26px; margin-left: 700px; margin-top: 162px;">
												<img src="images/numarrowright.png">
											</div>
											<div class="num2pictablewrapper"
												id="num2pictablewrapper_current">
												<table style="width: 100%; text-align: center ;margin-left:0px">
													<tbody style="width: 100%;">
														<tr style="width: 100%">
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle1pic1.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle1pic2.jpg">
																</div>
															</td>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="num2pictablewrapper" id="num2pictablewrapper"
												style="display: none">
												<table style="width: 100%; text-align: center ;margin-left:0px">
													<tbody style="width: 100%;">
														<tr style="width: 100%">
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle2pic1.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle2pic2.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle2pic3.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle2pic4.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle2pic5.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle2pic6.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle2pic7.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle2pic8.jpg">
																</div>
															</td>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="num2pictablewrapper" id="num2pictablewrapper"
												style="display: none">
												<table style="width: 100%; text-align: center ;margin-left:0px">
													<tbody style="width: 100%;">
														<tr style="width: 100%">
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle3pic1.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle3pic2.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle3pic3.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle3pic4.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle3pic5.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle3pic6.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle3pic7.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle3pic8.jpg">
																</div>
															</td>
															<td style="width: 400px; height: 270px">
																<div style="width:400px;height:270px">
																	<img class="num2pic" src="images/num2deskstyle3pic9.jpg">
																</div>
															</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</td>
								</tr>
								<tr style="height: 250px">
									<td style="width: 316px">
										<img class="num2desktypepic" id="num2desktypepic"
											src="images/num2deskstyle1.png">
									</td>
									<td style="width: 234px">
										<img class="num2desktypepic" id="num2desktypepic"
											src="images/num2deskstyle2.png">
									</td>
									<td style="width: 350px">
										<img class="num2desktypepic" id="num2desktypepic"
											src="images/num2deskstyle3.png">
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="arrowdown" id="arrow3">
						<img src="images/arrowdown.png">
					</div>
				</div>
			</div>


			<div class="num" id="num_3">
				<div class="wrapper">
					<div
						style="margin-top: 100px; color: #ecc311; font-size: 28px; text-align: center">
						<span>入驻项目</span>
					</div>
					<div id="num3middle"
						style="width: 100%; margin-top: 50px; background-color: #ffffff;">
						<div class="contentcontainer">
							<div id="num3contentcontainer" style="height: 0px"></div>
							<table class="num3table"
								style="width: 100%; margin-left: 0px; text-align: center;">
								<tbody style="width: 100%">
									<tr style="background-color: #ffffff; height: 300px">
										<td style="width: 225px; height: 260px">
											<div class="projectwrapper">
												<div class="front">
													<img style="width: 80%; height: 260px"
														src="images/project1.png">
												</div>
												<div class="behind">
													<img style="width: 80%; height: 260px"
														src="images/projectback1.png">
												</div>
											</div>
										</td>
										<td style="width: 225px; height: 260px">
											<div class="projectwrapper">
												<div class="front">
													<img style="width: 80%; height: 260px"
														src="images/project2.png">
												</div>
												<div class="behind">
													<img style="width: 80%; height: 260px"
														src="images/projectback2.png">
												</div>
											</div>
										</td>
										<td style="width: 225px; height: 260px">
											<div class="projectwrapper">
												<div class="front">
													<img style="width: 80%; height: 260px"
														src="images/project3.png">
												</div>
												<div class="behind">
													<img style="width: 80%; height: 260px"
														src="images/projectback3.png">
												</div>
											</div>
										</td>
										<td style="width: 225px; height: 260px">
											<div class="projectwrapper">
												<div class="front">
													<img style="width: 80%; height: 260px"
														src="images/project4.png">
												</div>
												<div class="behind">
													<img style="width: 80%; height: 260px"
														src="images/projectback4.png">
												</div>
											</div>
										</td>
										<td style="width: 225px; height: 260px">
											<div class="projectwrapper">
												<div class="front">
													<img style="width: 80%; height: 260px"
														src="images/project5.png">
												</div>
												<div class="behind">
													<img style="width: 80%; height: 260px"
														src="images/projectback5.png">
												</div>
											</div>
										</td>
										<td style="width: 225px; height: 260px">
											<div class="projectwrapper">
												<div class="front">
													<img style="width: 80%; height: 260px"
														src="images/project6.png">
												</div>
												<div class="behind">
													<img style="width: 80%; height: 260px"
														src="images/projectback6.png">
												</div>
											</div>
										</td>
										<td style="width: 225px; height: 260px">
											<div class="projectwrapper">
												<div class="front">
													<img style="width: 80%; height: 260px"
														src="images/project7.png">
												</div>
												<div class="behind">
													<img style="width: 80%; height: 260px"
														src="images/projectback7.png">
												</div>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>

					</div>
					<div class="num3arrowleft"
						style="position: absolute; top: 0; left: 0;">
						<img src="images/numarrowleft.png">
					</div>
					<div class="num3arrowright"
						style="position: absolute; top: 0; right: 0;">
						<img src="images/numarrowright.png">
					</div>
					<div class="arrowdown" id="arrow4">
						<img src="images/arrowup.png">
					</div>
				</div>
				<div
					style="position: absolute; text-align: center; color: #ecc311; font-size: 20px; bottom: 5%; width: 100%">
					<div style="position: absolute; left: 5%">
						<span>©2005-2015 qiyiyun.cn , all rights reserved</span>
					</div>
					<div style="position: absolute; right: 5%">
						<span>关于我们</span>
						<span>·</span>
						<span>免责申明</span>
						<span>·</span>
						<span>招聘信息</span>
						<span>·</span>
						<span>团队入驻</span>
						<span>·</span>
						<span>新手帮助</span>
					</div>
				</div>
			</div>
		</div>
		<input type="hidden" value="0" class="ddw" />
		<input type="hidden" value="0" class="ddw2" />
		<script type="text/javascript">
   $(document).ready(function(){
     var h = $(window).height();
     var hh = (h-600)/2;
     $(".sectiontable").css("margin-top",hh);
     var n3m = h*0.6;
     $("#num3middle").css("height",n3m);
     var n3con = (n3m-300)/2;
     $("#num3contentcontainer").css("height",n3con);
    
     var num3arrowtop = (h-26)/2 ;
     var num3arrowhorizontal = ($(window).width() - 900)/2 - 20 - 50;
     $('.num3arrowleft').css("top",num3arrowtop);
     $('.num3arrowleft').css("left",num3arrowhorizontal);
     $('.num3arrowright').css("top",num3arrowtop);
     $('.num3arrowright').css("right",num3arrowhorizontal);
     
     $(window).resize(function(){
       var h = $(window).height();
       var hh = (h-600)/2;
       $(".sectiontable").css("margin-top",hh);
       var n3m = h*0.6;
       $("#num3middle").css("height",n3m);
       var n3con = (n3m-300)/2;
       $("#num3contentcontainer").css("height",n3con);
      
       var num3arrowtop = (h-26)/2 ;
       var num3arrowhorizontal = ($(window).width() - 900)/2 - 20 - 50;
       $('.num3arrowleft').css("top",num3arrowtop);
       $('.num3arrowleft').css("left",num3arrowhorizontal);
       $('.num3arrowright').css("top",num3arrowtop);
       $('.num3arrowright').css("right",num3arrowhorizontal);
     });
    $('#topmenu ul li').mouseenter(function(){
      if($(this).index()==0){
        $(this).text("Reserve");
        $(this).css("color","#3bb878");
      }else if($(this).index()==1){
        $(this).text("Exhibition");
        $(this).css("color","#3bb878");
      }else if($(this).index()==2){
        $(this).text("Project");
        $(this).css("color","#3bb878");
      }
    });
     $('#topmenu ul li').mouseleave(function(){
       if($(this).index()==0){
         $(this).text("预定场地");
         $(this).css("color","#ffffff");
       }else if($(this).index()==1){
         $(this).text("场地展示");
         $(this).css("color","#ffffff");
       }else if($(this).index()==2){
         $(this).text("入驻项目");
         $(this).css("color","#ffffff");
       }
     });
     //num0
     $('#bookimg').mouseenter(function(){
       $(this).attr("src","images/bookstation2.png");
     });
     $('#bookimg').mouseleave(function(){
       $(this).attr("src","images/bookstation1.png");
     });
     //nu,1
     $('#determineimg').mouseenter(function(){
       $(this).attr("src","images/determine2.png");
     });
     $('#determineimg').mouseleave(function(){
       $(this).attr("src","images/determine1.png");
     });
     $('#addressimg1').click(function(){
       $(this).attr("src","images/address12.png");
       $('#addressimg2').attr("src","images/address21.png");
       $('#addresstext').text("雨花台区宁双路28号汇智大厦C区");
     });
     $('#addressimg2').click(function(){
       $(this).attr("src","images/address22.png");
       $('#addressimg1').attr("src","images/address11.png");
       $('#addresstext').text("雨花台区软件大道地铁口1号出口");
     });
     //num2
     $('.num2desktypepic').mouseenter(function(){
       var tempId = $(this).attr("id");
       if(tempId!="num2desktypepic_current"){
         var a = $(this).attr("src");
         if(a.indexOf('_pre') < 0){
           var b = a.substring(0,a.indexOf(".png")) + '_pre.png';
           $(this).attr("src",b);
         }
       }
     });
     $('.num2desktypepic').mouseleave(function(){
       var tempId = $(this).attr("id");
       if(tempId!="num2desktypepic_current"){
         var a = $(this).attr("src");
         if(a.indexOf('_pre') >= 0){
           var b = a.substring(0,a.indexOf("_pre.png")) + '.png';
           $(this).attr("src",b);
         }
       }
     });
     var index=-1;
     $('.num2desktypepic').click(function() {
      var tempId = $(this).attr("id");
      if(tempId!="num2desktypepic_current"){
    	  $(".num2desktypepic").each(function(){
	    	if($(this).attr("id")=="num2desktypepic_current"){
	    		var a = $(this).attr("src");
	            if(a.indexOf('_pre') >= 0){
	              var b = a.substring(0,a.indexOf("_pre.png")) + '.png';
	              $(this).attr("src",b);
	            }  		
		    	$(this).attr("id","num2desktypepic");
	    	}
    	  });
    	  $(this).attr("id","num2desktypepic_current");
    	  $(".num2desktypepic").each(function(i){
    		  if($(this).attr("id")=="num2desktypepic_current"){
    			index = i;
    		  }
    	  });
      
   		 $(".num2pictablewrapper").each(function(i){
    		 if($(this).attr("id")=="num2pictablewrapper_current"){
    			 $(this).attr("id","num2pictablewrapper");
    			 $(this).fadeOut(800);
    		 }
    	 });
   		$(".num2pictablewrapper").each(function(i){
   			 if($(this).attr("id")=="num2pictablewrapper"&&index==i){
   				 $(this).attr("id","num2pictablewrapper_current");
   				 $(this).fadeIn(800);
   			 }
   		 });
      } 
     });
     
   });
   //num2picsrcoll
  
   $(".num2arrowright").click(function(){
	   var num2tablewidth = $("#num2pictablewrapper_current").find("table").css("width");
	   var num2tablewidthnumb = num2tablewidth.substring(0,num2tablewidth.indexOf("px"));
	   var leftmin = 400 - num2tablewidthnumb;
	   var l = $("#num2pictablewrapper_current").find("table").css("margin-left");
	   var lnumb = l.substring(0,l.indexOf("px"));
	   var llnumb = parseInt(lnumb) - 400;
	   if(llnumb >= leftmin){
	   		ll = llnumb + "px";
	   		var mod = lnumb % 400 ;
	   		if(mod == 0){
	   			$("#num2pictablewrapper_current").find("table").animate({marginLeft:ll});
	   		}
   		}
   });
   $(".num2arrowleft").click(function(){
	   var leftmax = 0;
	   var l = $("#num2pictablewrapper_current").find("table").css("margin-left");
	   var lnumb = l.substring(0,l.indexOf("px"));
	   var llnumb = parseInt(lnumb) + 400;
	   if(llnumb <= leftmax){
		   ll = llnumb + "px";
		   var mod = lnumb % 400 ;
		   if(mod == 0){
	   		$("#num2pictablewrapper_current").find("table").animate({marginLeft:ll});
	   	   }
	   }
   });
  //num3
  $(".projectwrapper").mouseenter(function(){
    $(this).find(".front").animate({width:0,left:"112px"},80,function(){
      $(this).parent().find(".behind").animate({width:"225px",left:0},80);
    });
  });
   $(".projectwrapper").mouseleave(function(){
     $(this).find(".behind").animate({width:0,left:"112px"},80,function(){
       $(this).parent().find(".front").animate({width:"225px",left:0},80);
     });
   });
   
   var num3tablewidth = $(".num3table").css("width");
   var num3tablewidthnumb = num3tablewidth.substring(0,num3tablewidth.indexOf("px"));
   var leftmin = 900 - num3tablewidthnumb;
   $(".num3arrowright").click(function(){
	   var l = $(".num3table").css("margin-left");
	   var lnumb = l.substring(0,l.indexOf("px"));
	   var llnumb = parseInt(lnumb) - 225;
	   if(llnumb >= leftmin){
	   		ll = llnumb + "px";
	   		var mod = lnumb % 225 ;
	   		if(mod == 0){
	   			$(".num3table").animate({marginLeft:ll});
	   		}
   		}
   });
   var leftmax = 0;
   $(".num3arrowleft").click(function(){
	   var l = $(".num3table").css("margin-left");
	   var lnumb = l.substring(0,l.indexOf("px"));
	   var llnumb = parseInt(lnumb) + 225;
	   if(llnumb <= leftmax){
		   ll = llnumb + "px";
		   var mod = lnumb % 225 ;
		   if(mod == 0){
	   		$(".num3table").animate({marginLeft:ll});
	   	   }
	   }
   });
 </script>
		<script>
  function aa(){
    $(".arrowdown").fadeOut(800 ,function(){
      $(".arrowdown").fadeIn(800,aa());
    });
  };
  $(document).ready(function() {
    aa();
  });
</script>

		<script>
  //num1 address pic js
  $(document).ready(function() { //perform actions when DOM is ready
    var z = 0; //for setting the initial z-index's
    var inAnimation = false; //flag for testing if we are in a animation

    $('#pictures img').each(function() { //set the initial z-index's
      z++; //at the end we have the highest z-index value stored in the z variable
      $(this).css('z-index', z); //apply increased z-index to <img>
    });

    function swapFirstLast(isFirst) {
      if(inAnimation) return false; //if already swapping pictures just return
      else inAnimation = true; //set the flag that we process a image

      var processZindex, direction, newZindex, inDeCrease; //change for previous or next image

      if(isFirst) { processZindex = z; direction = '-'; newZindex = 1; inDeCrease = 1; } //set variables for "next" action
      else { processZindex = 1; direction = ''; newZindex = z; inDeCrease = -1; } //set variables for "previous" action

      $('#pictures img').each(function() { //process each image
        if($(this).css('z-index') == processZindex) { //if its the image we need to process
          $(this).animate({ 'top' : direction + $(this).height() + 'px' }, 'slow', function() { //animate the img above/under the gallery (assuming all pictures are equal height)
            $(this).css('z-index', newZindex) //set new z-index
                    .animate({ 'top' : '0' }, 'slow', function() { //animate the image back to its original position
                      inAnimation = false; //reset the flag
                    });
          });
        } else { //not the image we need to process, only in/de-crease z-index
          $(this).animate({ 'top' : '0' }, 'slow', function() { //make sure to wait swapping the z-index when image is above/under the gallery
            $(this).css('z-index', parseInt($(this).css('z-index')) + inDeCrease); //in/de-crease the z-index by one
          });
        }
      });

      return false; //don't follow the clicked link
    }

    $('#addressimg1').click(function() {
      var z1=$('#addressimgmap1').css('z-index');
      var z2=$('#addressimgmap2').css('z-index');
      if(z1<z2){
        return swapFirstLast(true); //swap first image to last position
      }
    });

    $('#addressimg2').click(function() {
      var z1=$('#addressimgmap1').css('z-index');
      var z2=$('#addressimgmap2').css('z-index');
      if(z1>z2){
        return swapFirstLast(true); //swap first image to first position
      }
    });
	//num1
    $("#determineimg").click(function(){
        var name = $("#name").val();
        var phone = $("#phone").val();
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
	      $.post("servlet/NewBookStationUIServlet","name="+name+"&phone="+phone,function(){
	    	  alert("提交成功！");
	      });
   });
  });
</script>
		<script src="js/index.js" type="text/javascript"></script>
		<script src="js/jquery.mousewheel.min.js" type="text/javascript"></script>
	</body>
</html>