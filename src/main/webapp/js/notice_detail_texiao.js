$(function() {
	//时间格式化函数
	Date.prototype.Format = function(fmt) 
	{ 
	  var o = { 
	    "M+" : this.getMonth()+1,                 //月份 
	    "d+" : this.getDate(),                    //日 
	    "h+" : this.getHours(),                   //小时 
	    "m+" : this.getMinutes(),                 //分 
	    "s+" : this.getSeconds(),                 //秒 
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度 
	    "S"  : this.getMilliseconds()             //毫秒 
	  }; 
	  if(/(y+)/.test(fmt)) 
	    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); //格式化年份
	  for(var k in o) //循环获取上面定义的月、日、小时等，格式化对应的数据。
	    if(new RegExp("("+ k +")").test(fmt)) 
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
	  return fmt; 
	}
	
$("document").ready(function(){

$(".nav ol:eq(3)").css({"background":"url(<%=request.getContextPath()%>/img/changxiala.png)","marginLeft":"-1px"})
$(".nav ol:eq(3)").width(262);
$(".nav ol:eq(3)").height(241);
	$(".nav ol:eq(1)").css({"background":"url(<%=request.getContextPath()%>/img/xiaoxiala_03_011_02.png)","marginLeft":"-1px"})
$(".nav ol:eq(1)").width(262);
$(".nav ol:eq(1)").height(93);
	$(".nav ol:eq(2)").css({"background":"url(<%=request.getContextPath()%>/img/xiaoxiala_03_011_02.png)","marginLeft":"-1px"})
$(".nav ol:eq(2)").width(262);
$(".nav ol:eq(2)").height(93);



$(".nav ul li:eq(0)  ").hover(
						 function(){
							
							
							$(".nav ol:eq(0)").show();
                                                               $(".nav ul li:eq(0) a ").css("color","#9a0e14")
							 
							 },function(){
								 
								$(".nav ol:eq(0)").hide()								 
								  $(".nav ul li:eq(0) a ").css("color","#fff")
								 
								 }
						 
			
						 )
 $(".nav ul li:eq(0) ol").mouseover(
							  function(){
								  
								  
								  $(this).show()
								  
								  }
							  
							  
							  
							  
							  )

$(".nav ul li:eq(5)  ").hover(
						 function(){
							
							$(".nav ul li:eq(5) a ").css("color","#9a0e14")
							$(".nav ol:eq(1)").show();
                         
							 
							 },function(){
								 
								$(".nav ol:eq(1)").hide()								 
								 							$(".nav ul li:eq(5) a ").css("color","#fff")
								 
								 }
						 
			
						 )
 $(".nav ol:eq(1)").mouseover(
							  function(){
								  
								  
								  $(this).show()
								  
								  }
							  
							  
							  
							  
							  )
$(".nav ul li:eq(0)  ").next().next().hover(
						 function(){
							
							
							$(".nav ol:eq(2)").show();
                         $(".nav ul li:eq(8) a").css("color","#9a0e14");

							 
							 },function(){
								 
								$(".nav ol:eq(2)").hide()								 
							 $(".nav ul li:eq(8) a").css("color","#fff");
								 
								 }
						 
			
						 )
 $(".nav ol:eq(2)").mouseover(
							  function(){
								  
								  
								  $(this).show()
								  
								  }
							  
							  
							  
							  
							  )
$(".nav ul li:eq(0)  ").next().next().next().hover(
						 function(){
							     $(".nav ul li:eq(11) a").css("color","#9a0e14");
							
							$(".nav ol:eq(3)").show();
                         
							 
							 },function(){
								 
								$(".nav ol:eq(3)").hide()								
								  $(".nav ul li:eq(11) a").css("color","#fff");
								 
								 }
						 
			
						 )
 $(".nav ol:eq(3)").mouseover(
							  function(){
								  
								  
								  $(this).show()
								  
								  }
							  
							  
							  
							  
							  )

$(".nav ul li:eq(0)  ").next().next().next().next().hover(
						 function(){
							
							$(".nav ul li:eq(18) a").css("color","#9a0e14");
							$(".nav ol:eq(4)").show();
                         
							 
							 },function(){
								 
								$(".nav ol:eq(3)").hide()								 
								 $(".nav ul li:eq(18) a").css("color","#fff");
								 
								 }
						 )
 $(".nav ol:eq(4)").mouseover(
							  function(){ 
								  $(this).show()
								  }
							  )
$("#search").hover(
				   
				   function(){
					   
					   $("#search img").attr("src","img/red-search_03.png");
					   $(".sousuo ").show();
					   
					   },function(){
						   
						   
						    $("#search img").attr("src","img/search_03.png");
						   
						   $(".sousuo ").hide();
						   }
				   )
 $(".sousuo").mouseover(
							  function(){	  
								 $(".sousuo ").show();			  
								  }  
							  )
	$(".shipintu li ").hover(
						   function(){
							 var ind=$(this).index();
							 $(".zhezhao").eq(ind).show();
							   },function(){ $(".zhezhao").hide();
							   }
						   )
	$(".shetuan li:eq(0)").hover(
						function(){
							$(this ).css("color","#f2980e")
                            $(".shetuan li:eq(0) a").css("color","#f2980e")
							$(".book").css("background","url(img/a0.jpg)")
							},function(){
							$(this).css("color","#000")
                            $(".shetuan li:eq(0) a").css("color","#000")
							$(".book").css("background","url(img/lilun.jpg)")
								}
						)
		$(".shetuan li:eq(1)").hover(
						function(){
							$(this).css("color","#f2980e")
							$(".shetuan li:eq(1) a").css("color","#f2980e")
							$(".people").css("background","url(img/a1.jpg)")
							},function(){
							$(this).css("color","#000")
							$(".shetuan li:eq(1) a").css("color","#000")
							$(".people").css("background","url(img/shehuifuwu.jpg)")
								}
						)
				$(".shetuan li:eq(2)").hover(
						function(){
						 $(".shetuan li:eq(2) a").css("color","#f2980e")
							$(this).css("color","#f2980e")
							$(".global	").css("background","url(img/a2.jpg)")
							},function(){
								 $(".shetuan li:eq(2) a").css("color","#000")
							$(this).css("color","#000")
							$(".global").css("background","url(img/xueshu.jpg)")
												
								}

						)
			
		$(".shetuan li:eq(3)").hover(
						function(){
						 $(".shetuan li:eq(3) a").css("color","#f2980e")

							$(this).css("color","#f2980e")
							$(".huaban	").css("background","url(img/a3.jpg)")
							
							
							
							},function(){
								
							$(this).css("color","#000")
 $(".shetuan li:eq(3) a").css("color","#000")

							$(".huaban").css("background","url(img/wenhua.png)")
							
								
								}
	
						
						
						)
	$(".shetuan li:eq(4)").hover(
						function(){
						
							$(this).css("color","#f2980e")
 $(".shetuan li:eq(4) a").css("color","#f2980e")

							$(".pingpang	").css("background","url(img/a4.jpg)")
			
							
							},function(){							
 $(".shetuan li:eq(4) a").css("color","#000")
							$(this).css("color","#000")
							$(".pingpang").css("background","url(img/tiyun.jpg)")
								}
							

											)
		
})

});