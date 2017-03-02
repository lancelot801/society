<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>校园社团首页</title>
<head>
		<meta charset="utf-8" />
		<link rel="shortcut icon" href="img/my_ico.ico">
		<link rel="stylesheet" href="css/posterTvGrid.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="bootstrap/css/bootstrapValidator.min.css" />
		<link rel="stylesheet" href="css/normalize.css" />
		<link rel="stylesheet" href="css/jquery.skippr.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.mobile.touchsupport.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="bootstrap/js/bootstrapValidator.min.js" ></script>
		<script type="text/javascript" src="js/jquery-ui.min.js" ></script>
		<script type="text/javascript" src="js/index.js"></script>
		<script type="text/javascript" src="js/posterTvGrid.js"></script>
		<script type="text/javascript" src="js/texiao.js"></script>
		<script type="text/javascript" src="js/jquery.skippr.js"></script>
		<script type="text/javascript" src="bootstrap/js/zh_CN.js"></script>
		<title>徐州工程学院社团空间</title>
	</head>
</head>
<body>
	<div class="top">
			<div class="top-inner">
				<div class="logo">
					<!-- 网站logo图片地址请在本组件"内容配置-网站logo"处填写 -->
					<a href="index.html"><img src="img/logo.png" width="321" height="71" alt="logo"></a>
					<!--#endeditable-->

				</div>
				<div class="nav">
					<ul>
						<li><a href="http://www.club.sdu.edu.cn/stgk.htm">社团概况</a>
							<ol style="display:none;">

								<a href="http://www.club.sdu.edu.cn/stgk/stjj.htm">
									<li>社团简介</li>
								</a>

						
								<a href="http://www.club.sdu.edu.cn/stgk/gzzd.htm">
									<li>规章制度</li>
								</a>

								<a href="http://www.club.sdu.edu.cn/stgk/stjj.htm">
									<li>社团简介</li>
								</a>

						
								<a href="http://www.club.sdu.edu.cn/stgk/gzzd.htm">
									<li>规章制度</li>
								</a>
							</ol>

						</li>

						<li><a href="http://www.club.sdu.edu.cn/gzzn.htm">工作指南</a>
							<ol style="display: none; margin-left: -1px; width: 262px; height: 93px; background: url(&quot;img/xiaoxiala_03_011_02.png&quot;);">

								<a href="http://www.club.sdu.edu.cn/gzzn/gzlc.htm">
									<li>工作流程</li>
								</a>

								<a href="http://www.club.sdu.edu.cn/gzzn/bgxz.htm">
									<li>表格下载</li>
								</a>
							</ol>

						</li>

						<li><a href="http://www.club.sdu.edu.cn/xjpd.htm">星级评定</a>
							<ol style="display: none; margin-left: -1px; width: 262px; height: 93px; background: url(&quot;img/xiaoxiala_03_011_02.png&quot;);">

								<a href="http://www.club.sdu.edu.cn/xjpd/styp.htm">
									<li>社团月评</li>
								</a>

								<a href="http://www.club.sdu.edu.cn/xjpd/ndzp.htm">
									<li>年度总评</li>
								</a>
							</ol>

						</li>

						<li><a href="http://www.club.sdu.edu.cn/zjst.htm">走进社团</a>
							<ol style="display: none; margin-left: -1px; width: 262px; height: 241px; background: url(&quot;img/changxiala.png&quot;);">

								<a href="http://www.club.sdu.edu.cn/zjst/stfc.htm">
									<li>社团风采</li>
								</a>

								<a href="http://www.club.sdu.edu.cn/zjst/stmx.htm">
									<li>社团明星</li>
								</a>

								<a href="http://www.club.sdu.edu.cn/zjst/stfjx.htm">
									<li>社团风景线</li>
								</a>

								<a href="http://www.club.sdu.edu.cn/zjst/stwhj.htm">
									<li>社团文化节</li>
								</a>

								<a href="http://www.club.sdu.edu.cn/zjst/stgw.htm">
									<li>社团感悟</li>
								</a>

								<a href="http://www.club.sdu.edu.cn/zjst/szqc.htm">
									<li>视展青春</li>
								</a>
							</ol>

						</li>

						<li><a href="http://www.club.sdu.edu.cn/liuyanyemian.jsp?urltype=tree.TreeTempUrl&amp;wbtreeid=1005">在线留言</a>

						</li>

						<li>
							<button style="background-color: #9a0e14;border-color: #9a0e14;" class="btn btn-danger" id="userlogin"><span class="glyphicon glyphicon-user"></span>&nbsp;立即登录</button>
						</li>
					</ul>

				</div>

			</div>
		</div>
		<!--
	作者：offline
	时间：2017-01-11
	描述：首部
-->

		<!--
	作者：offline
	时间：2017-01-11
	描述：轮转图片
-->
		<div id="posterTvGrid" style="margin:0px auto 0 auto;"></div>
		<!--
        	作者：offline
        	时间：2017-01-16
        	描述：初始化上方轮转图片
        -->
		<script>
			var posterTvGrid = new posterTvGrid('posterTvGrid', {
				className: "posterTvGrid"
			}, [{
				"img": "img/zhongxin.jpg",
				"title": "中心校区",
				"url": "http://www.xzit.edu.cn/"
			}, {
				"img": "img/xiaoxun.jpg",
				"title": "格物致知,敬业乐群",
				"url": "http://www.xzit.edu.cn/"
			}, {
				"img": "img/banner1.jpg",
				"title": "社团工作，有你有我",
				"url": "http://www.xzit.edu.cn/"
			}, {
				"img": "img/chengnan.jpg",
				"title": "城南校区",
				"url": "http://www.xzit.edu.cn/"
			}, {
				"img": "img/student.jpg",
				"title": "社团学生",
				"url": "http://www.xzit.edu.cn//"
			}, ]);
		</script>

		<!--
    	作者：offline
    	时间：2017-01-11
    	描述：内容
    -->
		<div class="contain" style="zoom: 85%;">
			<div class="contain-inner">
				<div class="contain-inner-left">
					<div class="tittle">社团要闻</div>
					<span class=" right"> <a href="#" target="">more&gt;&gt;</a></span>
					<div style=" clear:both"></div>
					<div id="banner">

						<div id="theTarget">
							<div style="background-image: url(img/hjs.gif)"></div>
							<div style="background-image: url(img/xd2.png)"></div>
							<div style="background-image: url(img/xd3.jpg)"></div>
							<div style="background-image: url(img/rwxy.jpg)"></div>
						</div>

					</div>
					<ul class="shetuanyaowen">

						<a href="newsModel.html">
							<li>徐州工程学院第七届星光达人秀初赛举行<span style=" float:right">2016年11月14日</span></li>
						</a>
						<a href="newsModel.html">
							<li>徐州工程学院白杨社2016年度校区总结大会顺利召开<span style=" float:right">2016年06月13日</span></li>
						</a>
						<a href="newsModel.html">
							<li>茶文化协会举办第九届理事会换届竞选活动<span style=" float:right">2016年06月06日</span></li>
						</a>
						<a href="newsModel.html">
							<li>演讲协会南新校区部长团换届举行<span style=" float:right">2016年06月05日</span></li>
						</a>

						<!--#endeditable-->
					</ul>
					<div class="tittle margintop">社团风采</div>
					<span class=" right margintop"> <a href="#" target="">more&gt;&gt;</a></span>
					<div style=" clear:both"></div>
					<ul class="shetuanyaowen">
						<a href="styleModel.html">
							<li>中医协会包饺子聚餐活动顺利举行<span style=" float:right">2016年12月26日</span></li>
						</a>

						<a href="styleModel.html">
							<li>徐州工程学院城南校区社管会成功举办2016年度工作总结暨元旦晚会<span style=" float:right">2016年12月24日</span></li>
						</a>

						<a href="styleModel.html">
							<li>国学社成功举办“潇湘雅音古韵和鸣”古风歌会<span style=" float:right">2016年12月21日</span></li>
						</a>

						<a href="styleModel.html">
							<li>徐工马协冬季校园长跑赛创辉煌<span style=" float:right">2016年12月21日</span></li>
						</a>

						<a href="styleModel.html">
							<li>自行车协会举办冬至“饺子节”<span style=" float:right">2016年12月21日</span></li>
						</a>

						<a href="styleModel.html">
							<li>中医协会举办漱玉平民大药房认药活动<span style=" float:right">2016年12月21日</span></li>
						</a>

						<a href="styleModel.html">
							<li>徐州工程学院唐仲英爱心社开展环卫工子女课业辅导志愿活动<span style=" float:right">2016年12月21日</span></li>
						</a>

						<a href="styleModel.html">
							<li>“手语比划猜”比赛顺利举行<span style=" float:right">2016年12月18日</span></li>
						</a>

						<a href="styleModel.html">
							<li>书画协会受邀SICA之夜活动顺利举办<span style=" float:right">2016年12月17日</span></li>
						</a>

						<a href="styleModel.html">
							<li>中医协会举办大学生保健养生讲座<span style=" float:right">2016年12月16日</span></li>
						</a>

						<a href="styleModel.html">
							<li>爱心协会举办包饺子活动<span style=" float:right">2016年12月14日</span></li>
						</a>
						<!--#endeditable-->
					</ul>

				</div>
				<div class="contain-inner-right">
					<div class="tittle-right">重要通知<span><a href="#" target="">more&gt;&gt;</a></span></div>
					<div style=" clear:both"></div>
					<ul class="shetuanyaowen pad">

						<a href="notifyModel.html">
							<li>关于选拔徐州工程学院学生社团参评2...<span style=" float:right">2016年11月14日</span></li>
						</a>

						<a href="notifyModel.html">
							<li>徐州工程学院学生会及学生社团2016 ...<span style=" float:right">2016年11月11日</span></li>
						</a>

						<a href="notifyModel.html">
							<li>关于举办徐州工程学院第七届山东24 ...<span style=" float:right">2016年11月08日</span></li>
						</a>

						<a href="notifyModel.html">
							<li>关于开展徐州工程学院2016-2017年社...<span style=" float:right">2016年11月03日</span></li>
						</a>

						<a href="notifyModel.html">
							<li>关于选拔学生代表参加第十届高 ...<span style=" float:right">2016年10月11日</span></li>
						</a>

						<!--#endeditable-->
					</ul>

					<div class="tittle-right  margintop">活动预告<span><a href="#" target="">more&gt;&gt;</a></span></div>
					<div style=" clear:both"></div>
					<ul class="shetuanyaowen pad">

						<a href="activityModel.html">
							<li>关于徐州工程学院＂自强杯＂演讲比...<span style=" float:right">2016年12月01日</span></li>
						</a>

						<a href="activityModel.html">
							<li>文成学府、武动校园活动预告<span style=" float:right">2016年11月30日</span></li>
						</a>

						<a href="activityModel.html">
							<li>“印象——素食”素食摄影大赛<span style=" float:right">2016年11月26日</span></li>
						</a>

						<a href="activityModel.html">
							<li>关于扬帆服务社“同心协力职海...<span style=" float:right">2016年11月23日</span></li>
						</a>

						<a href="activityModel.html">
							<li>关于举办“徐州工程学院枯木逢春青...<span style=" float:right">2016年11月22日</span></li>
						</a>

						<!--#endeditable-->
					</ul>

					<div class="tittle-right  margintop">社团简介<span><a href="#" target="">more&gt;&gt;</a></span></div>
					<div style=" clear:both"></div>
					<ul class="shetuan pad">

						<script language="javascript" src="js/openlink.js"></script>
						<li>
							<a href="profileModel.html">
								<h1>理论学习类社团</h1>
							</a>
							<p><a href="profileModel.html">徐州工程学院共有八所校级理论学习类社团，各学院亦均设有院级理论学习类社团...</a></p>
						</li>

						<li>
							<a href="profileModel.html">
								<h1>社会服务类社团</h1>
							</a>
							<p><a href="profileModel.html">徐州工程学院共有十余所校级社会服务类社团，各学院亦均设有青年志愿者协会...</a></p>
						</li>

						<li>
							<a href="profileModel.html">
								<h1>学术科技类社团</h1>
							</a>
							<p><a href="profileModel.html">徐州工程学院共有二十余所校级学术科技类社团，各个社团在传播时尚文化、信息科技...</a></p>
						</li>

						<li>
							<a href="profileModel.html">
								<h1>文化艺术类社团</h1>
							</a>
							<p><a href="profileModel.html">徐州工程学院共有二十余所校级文化艺术类社团，各个社团在丰富学生课余生活...</a></p>
						</li>

						<li>
							<a href="profileModel.html">
								<h1>体育锻炼类社团</h1>
							</a>
							<p><a href="profileModel.html">徐州工程学院共有二十余所校级体育锻炼类社团，是各类社团中最活跃的一大元素...</a></p>
						</li>

						<!--#endeditable-->
					</ul>
					<ol class="shetuanicon">
						<li class="book"></li>
						<li class="people "></li>
						<li class="global "></li>
						<li class="huaban"></li>
						<li class="pingpang "></li>
					</ol>

				</div>
				<div style=" clear:both"></div>

				<!--
            	作者：offline
            	时间：2017-01-12
            	描述：底部
            -->
				<div class="bottom">
					<div class="bottom-inner">
						<div class="youqinglianjie">
							<ul>

								<li>友情链接:</li>

								<li><a href="http://www.xzit.edu.cn/">徐工官网</a></li>

								<li><a href="http://gh.xzit.edu.cn/">徐工工会</a></li>

								<li><a href="http://tw.xzit.edu.cn/">徐工团委</a></li>

								<li><a href="http://etc.xzit.edu.cn/">信息化中心</a></li>

								<li><a href="http://hqfwzx.xzit.edu.cn/">后勤服务中</a></li>
								<li><a href="http://jgdw.xzit.edu.cn/">机关党委</a></li>

								<li><a href="http://lib.xzit.edu.cn/">图书馆</a></li>

								<!--#endeditable-->
							</ul>
						</div>
						<div>
							<div class="bottom-logo">
								<img src="img/contactus_36.png" width="204" height="106" alt="联系我们">
							</div>
							<div class="shutiao"></div>
							<div class="telphone">

								<!-- 版权内容请在本组件"内容配置-版权"处填写 -->
								<ul>
									<li>办公室电话：0516-83105021</li>
									<li>微博:徐州工程学院</li>
									<li>微信公众号:徐州工程学院(微信)号:xzitfwh</li>
								</ul>
								<!--#endeditable-->
							</div>
							<div class="shutiao"></div>
							<div class="telphone">

								<ul class=" list-paddingleft-2">
									<li>
										<p>社团材料邮箱:office@xzit.edu.cn</p>
									</li>
									<li>
										<p>地址：江苏省徐州市云龙区丽水路2号</p>
									</li>
								</ul>
								<p></p>
								<!--#endeditable-->
							</div>
						</div>

					</div>

				</div>

			</div>
		</div>

		<!-- 登录模态框（Modal） -->
		<div class="modal  fade" id="mylogin">
			<div class="modal-dialog">
				<div class="modal-content" style="background-color：#9a0e14;">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title"><label class="label label-danger" style="background-color: #9a0e14;border-color: #9a0e14;"><span class="glyphicon glyphicon-user">用户登录</span></label></h4>
					</div>
					<div class="modal-body">
						<br />
						<br />
						<form role="form" class="form-horizontal" id="loginForm" action="/society_server/user/login" method="GET">
							<div class="form-group">
								<label for="loginToken" class="col-sm-2 control-label"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;账户</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="loginToken" name="token" placeholder="请输入您的账户号码/邮箱/手机">
								</div>
							</div>

							<div class="form-group">
								<label for="loginPassword" class="col-sm-2 control-label"><span class="glyphicon glyphicon-lock"></span>&nbsp;&nbsp;密码</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="loginPassword" name="password" placeholder="请输入您的密码">
								</div>
							</div>

							<div style="text-align: center;">
								<button type="submit" id="loginBtn" class="btn btn-primary" style="width:350px;background-color: #9a0e14;border-color: #9a0e14;margin-left:65px;"><span class=" glyphicon glyphicon-ok-sign"></span>&nbsp;登录</button>
							</div>
						</form>
					</div>
					<br />
					<br />
					<div class="modal-footer">
						<div class="container">
							<div class="pull-left">
								<a href="#" title="还没激活账号？赶紧用学号注册吧！" id="registAccount" data-dismiss="modal" style="color:#9a0e14;">注册账号</a>
								<span style="margin-left:120px;color:#9a0e14;">徐州工程学院社团管理平台</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 注册模态框  -->
		<div class="modal  fade" id="registerModal">
		<div class="modal-dialog">
			<form id="registerForm" action="" method="" enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title">
							<span class="glyphicon glyphicon-leaf"></span>&nbsp;用户注册
						</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<!-- 
								<div class="form-group">
									<label for="学院"  style="padding-left:10px" 
										class="col-sm-2 control-label mylabStyle">选择学院</label>
									<div class="col-sm-10">
									     <select class="form-control " id="instituteId"
											name="instituteId">
											 <c:forEach var="institute" items="${institutes}">
    										 <option value="${institute.instituteId}">${institute.instituteName}</option>
 										 </c:forEach>
										</select>
									</div>
								</div>
								<br /> <br />
							
						<!-- <div style="display:none;"><input id="courseId" name="courseId" /> </div> -->	
								<!--  
								<div class="form-group">
									<label for="班级"  style="padding-left:10px"
										class="col-sm-2 control-label mylabStyle">选择班级</label>
									<div class="col-sm-10">
									     <select class="form-control " id="classId"
											name="class">
											 <c:forEach var="class" items="${classes}">
    										 <option value="${class.classId}">${class.className}</option>
 										 </c:forEach>
										</select>
									</div>
								</div>
								<br /> <br />  -->
								
								<div class="form-group">
									<label for="studentId"
										class="col-sm-2 control-label mylabStyle">学号</label>
									<div class="col-sm-10">
										<input type="text" style="width:95%" id="studentId" name="studentId"
											class="form-control" placeholder="请输入学号" />
									</div>
								</div>
								<br /> <br />
								
								<div class="form-group">
									<label for="password"
										class="col-sm-2 control-label mylabStyle">密码</label>
									<div class="col-sm-10">
										<input type="password" style="width:95%" id="password" name="password"
											class="form-control" placeholder="请输入密码" />
									</div>
								</div>
								<br/> <br/>
								
								<div class="form-group">
									<label for="confirmPassword"  style="padding-left:10px"
										class="col-sm-2 control-label mylabStyle">确认密码</label>
									<div class="col-sm-10">
										<input type="password" style="width:95%" id="confirmPassword" name="confirmPassword"
											class="form-control" placeholder="请再输入密码" />
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button id="registerBtn" type="submit"  style="background-color: #9a0e14;border-color: #9a0e14;" class="btn btn-primary">提交</button>
						<button type="button" id="btnClose" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>