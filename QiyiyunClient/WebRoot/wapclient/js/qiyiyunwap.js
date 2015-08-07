		
		$("#button1").bind("touchstart",function(){
			$("#button1").attr("src","images/button1_pre.png");
		});
		$("#button1").bind("touchend",function(){
			$("#button1").attr("src","images/button1.png");
		});
		$("#button2").bind("touchstart",function(){
			$("#button2").attr("src","images/button2_pre.png");
		});
		$("#button2").bind("touchend",function(){
			$("#button2").attr("src","images/button2.png");
		});
		$("#button3").bind("touchstart",function(){
			$("#button3").attr("src","images/button3_pre.png");
		});
		$("#button3").bind("touchend",function(){
			$("#button3").attr("src","images/button3.png");
		});
		$("#buttonsure").bind("touchstart",function(){
			$("#buttonsure").attr("src","images/buttonsure_pre.png");
		});
		$("#buttonsure").bind("touchend",function(){
			$("#buttonsure").attr("src","images/buttonsure.png");
		});

		 var picindex1 = 0;
		 var picindex2 = 0;
		 var picindex3 = 0;
		 var picindex4 = 0;
		 
		 var pictouchflag = true ;
		 $(".spacecontentimg").on("touchstart", function(e){
				picStartX = e.changedTouches[0].pageX;
			    picStartY = e.changedTouches[0].pageY;
			});
					 
		$(".spacecontentimg").on("touchmove", function(e){
		e.preventDefault();
		if(pictouchflag == true){
			var picDivId = $(this).parent().parent().parent().attr('id');
			
		    picMoveEndX = e.changedTouches[0].pageX;
		    picMoveEndY = e.changedTouches[0].pageY;
		    picX = picMoveEndX - picStartX;
		    picY = picMoveEndY - picStartY;
		    if ( Math.abs(picX) > Math.abs(picY) && picX < 0  ) {
			    var l = $("#"+picDivId).find("ul").css("left");
			    var lnumb = l.substring(0,l.indexOf("%"));
			    var lafter = lnumb - 100 + "%";
			    
			    var width = $("#"+picDivId).find("ul").css("width");
				var widthnumb = width.substring(0,width.indexOf("%"));
				var maxLeft = parseInt(widthnumb) * -1 + 100;

				
			    
			    if(parseInt(lnumb) % 100 == 0 && parseInt(lnumb) > maxLeft){
			    	$("#"+picDivId).find("ul").animate({Left:lafter});

			    	if(picDivId == "spacepic1"){
						picindex1 = picindex1 + 1;
						 
						$("#spacepic1number span").each(function(i){
						    if(i == picindex1){
								$(this).attr("class","point  selected ");
							}else{
								$(this).attr("class","point");
							}
						})
						
					}else if(picDivId == "spacepic2"){
						picindex2 = picindex2 + 1; 

						$("#spacepic2number span").each(function(i){
						    if(i == picindex2){
								$(this).attr("class","point  selected ");
							}else{
								$(this).attr("class","point");
							}
						})

					}else if(picDivId == "spacepic3"){
						picindex3 = picindex3 + 1; 
						
						$("#spacepic3number span").each(function(i){
						    if(i == picindex3){
								$(this).attr("class","point  selected ");
							}else{
								$(this).attr("class","point");
							}
						})

					}else if(picDivId == "spacepic4"){
						picindex4 = picindex4 + 1; 

						$("#spacepic4number span").each(function(i){
						    if(i == picindex4){
								$(this).attr("class","point  selected ");
							}else{
								$(this).attr("class","point");
							}
						})

					}
			    }
		    }
		    else if ( Math.abs(picX) > Math.abs(picY) && picX > 0  ) {
			    var l = $("#"+picDivId).find("ul").css("left");
			    var lnumb = l.substring(0,l.indexOf("%"));
			    var lafternumb =100 + parseInt(lnumb);
			    var lafter =lafternumb + "%";
			    
			    if(parseInt(lnumb) % 100 == 0 && parseInt(lnumb) < 0){
			    	$("#"+picDivId).find("ul").animate({Left:lafter});
			    	if(picDivId == "spacepic1"){
						picindex1 = picindex1 - 1;
						 
						$("#spacepic1number span").each(function(i){
						    if(i == picindex1){
								$(this).attr("class","point  selected ");
							}else{
								$(this).attr("class","point");
							}
						})
						
					}else if(picDivId == "spacepic2"){
						picindex2 = picindex2 - 1; 

						$("#spacepic2number span").each(function(i){
						    if(i == picindex2){
								$(this).attr("class","point  selected ");
							}else{
								$(this).attr("class","point");
							}
						})

					}else if(picDivId == "spacepic3"){
						picindex3 = picindex3 - 1; 
						
						$("#spacepic3number span").each(function(i){
						    if(i == picindex3){
								$(this).attr("class","point  selected ");
							}else{
								$(this).attr("class","point");
							}
						})

					}else if(picDivId == "spacepic4"){
						picindex4 = picindex4 - 1; 

						$("#spacepic4number span").each(function(i){
						    if(i == picindex4){
								$(this).attr("class","point  selected ");
							}else{
								$(this).attr("class","point");
							}
						})

					}
			    }
		    }
		    pictouchflag = false;
		}
		});

		 $(".spacecontentimg").on("touchend", function(e){
			 pictouchflag = true;
			});

		var isShow = false;
		
		$(document).on("touchstart",function(event){
			if(scrollY > 50){
				$("#indexToTop").css("visibility","visible");
			}else{
				$("#indexToTop").css("visibility","hidden");
			}
			
			if($(event.target).attr('id') == "qrcodebutton"){
				$("#qrcodecontent").animate({marginLeft:'0%',marginTop:'-100%',opacity:'1'});
				$("#qrcodecontent").find("img").animate({width:'60%',heigh:'60%'});
			}else if($(event.target).attr('class') == "spacebutton"){
				if($(event.target).attr('id') == "spacebutton1" && isShow == false){
					$(".spacebuttonclass").css("opacity",0);
					$(".spacebuttonclass").css("width",0);
					$("#spacepic1").animate({marginLeft:'8%',marginTop:'-30%',opacity:'1',width:'80%'});
					isShow = true;
					
				}
				if($(event.target).attr('id') == "spacebutton2" && isShow == false){
					$(".spacebuttonclass").css("opacity",0);
					$(".spacebuttonclass").css("width",0);
					$("#spacepic2").animate({marginLeft:'-42%',marginTop:'-30%',opacity:'1',width:'80%'});
					isShow = true;

				}
				if($(event.target).attr('id') == "spacebutton3" && isShow == false){
					$(".spacebuttonclass").css("opacity",0);
					$(".spacebuttonclass").css("width",0);
					$("#spacepic3").animate({marginLeft:'8%',marginTop:'-69%',opacity:'1',width:'80%'});
					isShow = true;
				}
				if($(event.target).attr('id') == "spacebutton4" && isShow == false){
					$(".spacebuttonclass").css("opacity",0);
					$(".spacebuttonclass").css("width",0);
					$("#spacepic4").animate({marginLeft:'-42%',marginTop:'-69%',opacity:'1',width:'80%'});
					isShow = true;

				}
			}else if($(event.target).attr('class') == "spacecontentimg"){
				
				
			}else if($("#qrcodecontent").css("opacity") == 1){
				$("#qrcodecontent").animate({marginLeft:'-43%',marginTop:'-30%',opacity:'0'});
				$("#qrcodecontent").find("img").animate({width:'10%',heigh:'10%'});
			}else {
				$(".spacepic").animate({marginLeft:'15%',marginTop:'-25%',opacity:'0',width:'0%'});
				$(".spacebuttonclass").animate({width:'40%'}).animate({opacity:'1'});
				isShow = false;

			}
		});

		
		var index2 = 0;
		
		$("#slider_touch").on("touchstart", function(e){
		    startX = e.changedTouches[0].pageX;
		    startY = e.changedTouches[0].pageY;
		});
		
		$("#slider_touch").on("touchmove", function(e){
		    moveEndX = e.changedTouches[0].pageX;
		    moveEndY = e.changedTouches[0].pageY;
		    X = moveEndX - startX;
		    Y = moveEndY - startY;
		    if ( Math.abs(X) > Math.abs(Y) && X < 0  ) {
		    	e.preventDefault();
			    var l = $("#slider_touch").css("left");
			    var lnumb = l.substring(0,l.indexOf("%"));
			    var lafter = lnumb - 100 + "%";
			    
			    if(lnumb % 100 == 0 && lnumb >= 0){
				    $("#slider_touch").animate({Left:lafter});
				    index2 = index2 + 1;
				    $("#serial-number2 span").each(function(i){
					    if(i == index2){
							$(this).attr("class","point  selected ");
						}else{
							$(this).attr("class","point");
						}
					})
			    }
		    }
		    else if ( Math.abs(X) > Math.abs(Y) && X > 0  ) {
		    	e.preventDefault();
			    var l = $("#slider_touch").css("left");
			    var lnumb = l.substring(0,l.indexOf("%"));
			    var lafternumb =100 + parseInt(lnumb);
			    var lafter =lafternumb + "%";
			    
			    if(lnumb % 100 == 0 && lnumb < 0){
				    $("#slider_touch").animate({Left:lafter});
				    index2 = index2 - 1;
				    $("#serial-number2 span").each(function(i){
					    if(i == index2){
							$(this).attr("class","point  selected ");
						}else{
							$(this).attr("class","point");
						}
					})
			    }
		    }else{

			}
		});
