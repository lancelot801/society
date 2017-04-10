<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/img/my_ico.ico">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/notice_detail_texiao.js"></script>
<script
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/kkpager.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/kkpager_blue.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrapValidator.min.css" />
<title>活动预告</title>
</head>
<body>
<div class="top">
			<div class="top-inner">
				<div class="logo">
					<!-- 网站logo图片地址请在本组件"内容配置-网站logo"处填写 -->
					<a href="../index.jsp"><img src="<%=request.getContextPath()%>/img/logo.png" width="321" height="71" alt="logo"></a>
					<!--#endeditable-->

				</div>
				<div class="nav">
					<ul>
						<li><a href="#">社团概况</a>
							<ol style="display:none;">
								<a href="#">
									<li>社团简介</li></a>
								<a href="#">
									<li>规章制度</li></a>
								<a href="#">
									<li>社团简介</li></a>
								<a href="#">
									<li>规章制度</li>
								</a>
							</ol> 

						</li>

						<li><a href="#">工作指南</a>
						
							<ol style="display: none; margin-left: -1px; width: 262px; height: 93px; background: url(&quot;<%=request.getContextPath()%>/img/xiaoxiala_03_011_02.png&quot;);">

								<a href="#">
									<li>工作流程</li>
								</a>

								<a href="<%=request.getContextPath()%>/common/guidence">
									<li>使用指南</li>
								</a>
							</ol>

						</li>

						<li><a href="#">星级评定</a>
							<ol style="display: none; margin-left: -1px; width: 262px; height: 93px; background: url(&quot;<%=request.getContextPath()%>/img/xiaoxiala_03_011_02.png&quot;);">
								<a href="#">
									<li>社团月评</li>
								</a>

								<a href="#">
									<li>年度总评</li>
								</a>
							</ol>

						</li>

						<li><a href="#">走进社团</a>
							
							<ol style="display: none; margin-left: -1px; width: 262px; height: 241px; background: url(&quot;<%=request.getContextPath()%>/img/changxiala.png&quot;);">

								<a href="#">
									<li>社团风采</li>
								</a>

								<a href="#">
									<li>社团明星</li>
								</a>

								<a href="#">
									<li>社团风景线</li>
								</a>

								<a href="#">
									<li>社团文化节</li>
								</a>

								<a href="#">
									<li>社团感悟</li>
								</a>

								<a href="#">
									<li>视展青春</li>
								</a>
							</ol>

						</li>

						<li><a href="#">在线留言</a>

						</li>

						<li>
							<button style="background-color: #9a0e14;border-color: #9a0e14;" class="btn btn-danger" id="userlogin"><span class="glyphicon glyphicon-user"></span>&nbsp;立即登录</button>
						</li>
					</ul>

				</div>

			</div>
		</div>
		<!-- 首部 -->
		<!-- 
		<div class="weizhi">
			
			<div class="weizhi-inner">
				当前位置:
				<a href="http://127.0.0.1:8020/society/index.html" target="_top">首页</a> &gt;
				<a href="http://127.0.0.1:8020/society/index.html" target="_top">系统公告</a> &gt; 正文
			</div>
		</div> -->
		<div class="panel panel-default">
			<!-- 1175可能页面会变形<div class="panel-body" style="height:1175px;"> -->
			<div class="panel-body" style="height:100%;">
			<div class="list-contain">
			<div class="list-contain-inner">
				<div class="slide-guideline">
					<div class="tittle margintop">
						<!--#begineditable "栏目名称侧面" -->活动预告
						<!--#endeditable-->
					</div>
					<div style="clear:both"></div>
					<ul>
						<!--#begineditable "侧边导航" ->

						<!--#endeditable-->
					</ul>

				</div>
				<div class="slide-list">
					<!--#begineditable "栏目名称" -->
					<h1>活动预告</h1>
					<!--#endeditable-->
					<hr>
					<div class="neirong">
						<!--#begineditable "文章内容" -->

						<div>
							<h1  style="font-weight:bold;text-align: center;">${activity.theme}</h1>
								<div style="text-align: center;">
								发布时间:
								<fmt:formatDate value="${activity.checkedTime}" pattern="yyyy年MM月dd日" /> 
								</div>
							<div class="wenzi" id="vsb_content">
								${activity.content}
							</div>
							<div id="div_vote_id"></div>
						</div>
						<!--#endeditable-->
					</div>
					<hr>
				</div>			
			</div>
		</div>
			</div>
		</div>
		
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
						<img src="<%=request.getContextPath()%>/img/contactus_36.png" width="204" height="106" alt="联系我们">
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
						<form role="form" class="form-horizontal" id="loginForm" action="/society_server/user/login" method="post">
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