<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--导航-->
	<div class="col-sm-3 col-md-2 sidebar">
		<ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
			<li class="active"><a href="#"> <i
					class="glyphicon glyphicon-th-large"></i> 首页
			</a></li>

			<c:if test="${(userLogin.role eq 'admin')}">
				<li><a href="#systemSetting" class="nav-header collapsed"
					data-toggle="collapse"> <i class="glyphicon glyphicon-cog"></i>
						基础信息 <span class="pull-right glyphicon glyphicon-chevron-down"></span>
				</a>
					<ul id="systemSetting" class="nav nav-list collapse secondmenu"
						style="height: 0px;">
						<li><a
							href="<%=request.getContextPath()%>/admin/institute/manage"><i
								class="glyphicon glyphicon-education"></i> 学院管理</a></li>
						<!-- <li><a href="#"><i class="glyphicon glyphicon-book"></i> 班级管理</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-user"></i> 用户管理</a></li>  -->
					
						<li><a
							href="<%=request.getContextPath()%>/admin/societyType/manage"><i
								class="glyphicon glyphicon-asterisk"></i> 社团类别</a></li>
					
					</ul></li>
					<li><a href="#systemSetting2" class="nav-header collapsed"
					data-toggle="collapse"> <i class="glyphicon glyphicon-fire"></i>
						公告管理<span class="pull-right glyphicon glyphicon-chevron-down"></span>
				</a>
				
					<ul id="systemSetting2" class="nav nav-list collapse secondmenu"
						style="height: 0px;">
						<li><a href="<%=request.getContextPath()%>/admin/notice/publishNotice"> <i class="glyphicon glyphicon-arrow-up"></i> 发布公告
						</a></li>
					<li><a href="<%=request.getContextPath()%>/admin/notice/noticeManage"><i class="glyphicon glyphicon-envelope"></i> 查看公告</a></li>  
					</ul></li>
					
					<li><a href="#systemSetting6" class="nav-header collapsed"
					data-toggle="collapse"> <i class="glyphicon glyphicon-tag"></i>
						审核管理<span class="pull-right glyphicon glyphicon-chevron-down"></span>
				</a>
				
					<ul id="systemSetting6" class="nav nav-list collapse secondmenu"
						style="height: 0px;">
							<li><a href="<%=request.getContextPath()%>/admin/activity_apply/manage"><i class="glyphicon glyphicon-ok"></i>
								活动审核</a></li>
					<li><a
							href="<%=request.getContextPath()%>/admin/society_apply/manage"><i
								class="glyphicon glyphicon-tint"></i> 社团审核</a></li>
					</ul></li>
					
			</c:if>
			<li><a href="#systemSetting3" class="nav-header collapsed"
				data-toggle="collapse"> <i class="glyphicon glyphicon-th-list"></i>
					信息管理 <span class="pull-right glyphicon glyphicon-chevron-down"></span>
			</a>
				<ul id="systemSetting3" class="nav nav-list collapse secondmenu"
					style="height: 0px;">
					
					<li><a
						href="<%=request.getContextPath()%>/student/showInfo?studentId=${userLogin.studentId}"><i
							class="glyphicon glyphicon-edit"></i> 个人信息</a></li>
					<li><a href="<%=request.getContextPath()%>/student/resetPassword"><i class="glyphicon glyphicon-edit"></i>
							修改密码</a></li>
				</ul></li>
				<c:if test="${(userLogin.role != 'admin')}">
			<li><a href="#systemSetting4" class="nav-header collapsed"
				data-toggle="collapse"> <i class="glyphicon glyphicon-leaf"></i>
					申请记录<span class="pull-right glyphicon glyphicon-chevron-down"></span>
			</a>
				<ul id="systemSetting4" class="nav nav-list collapse secondmenu"
					style="height: 0px;">
					<li><a
						href="<%=request.getContextPath()%>/student/activity_apply/listMyApply?studentId=${userLogin.studentId}&pNo=0"><i
							class="glyphicon glyphicon-flag"></i> 活动申请</a></li>
					<li><a
						href="<%=request.getContextPath()%>/societyApply/listMySocietyApply?studentId=${userLogin.studentId}&pNo=0"><i
							class="glyphicon glyphicon-link"></i> 社团申请</a></li>
				</ul></li>
				
					<li><a href="#systemSetting5" class="nav-header collapsed"
				data-toggle="collapse"> <i class="glyphicon glyphicon-music"></i>
					社团管理<span class="pull-right glyphicon glyphicon-chevron-down"></span>
			</a>
				<ul id="systemSetting5" class="nav nav-list collapse secondmenu"
					style="height: 0px;">
						<li><a
						href="<%=request.getContextPath()%>/societyApply/manage?studentId=${userLogin.studentId}"><i
							class="glyphicon glyphicon-heart"></i> 创办社团</a></li>
					<li><a
						href="<%=request.getContextPath()%>/student/societyInfo/manage?studentId=${userLogin.studentId}"><i
							class="glyphicon glyphicon-eye-open"></i> 我的社团</a></li>
				</ul></li>
				
				</c:if>
				
			<!--  
			<li><a href="./grid.html"> <i
					class="glyphicon glyphicon-globe"></i> 我的申请 <span
					class="label label-warning pull-right">5</span>
			</a></li>
			<li><a href="#"> <i class="glyphicon glyphicon-fire"></i>
					系统介绍
			</a></li>
			
			<li><a href="./charts.html"> <i
					class="glyphicon glyphicon-calendar"></i> 图表统计
			</a></li>
			-->

		</ul>
	</div>

</body>
</html>