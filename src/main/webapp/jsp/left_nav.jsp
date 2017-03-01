<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
	<li>
		<dl>
			<dt>语种管理</dt>
			<dd>
				<a id="viewCategory"
					href="<%=request.getContextPath()%>/admin/category/findAll">所有语种</a>
			</dd>
			<dt>课程管理</dt>
			<dd>
				<a id="viewCourse"
					href="<%=request.getContextPath()%>/admin/course/list">所有课程</a>
					<br/>
				<a id="ViewChecking" href="<%=request.getContextPath()%>/admin/course/listByCourseStatus?courseStauts=待审核">待审核</a>
					<br/>
				<a id="ViewPublishing" href="<%=request.getContextPath()%>/admin/course/listByCourseStatus?courseStauts=待发布">待发布</a>
					<br/>
				<a id="ViewEnrolling" href="<%=request.getContextPath()%>/admin/course/listByCourseStatus?courseStauts=报名中">报名中</a>
					<br/>
				<a id="ViewStart" href="<%=request.getContextPath()%>/admin/course/listByCourseStatus?courseStauts=开课中">开课中</a>
					<br/>
				<a id="viewEnd" href="<%=request.getContextPath()%>/admin/course/listByCourseStatus?courseStauts=已结束">已结束</a>	
			</dd>
					
			<dt>微信接口</dt>
			<dd>
				<a href="<%=request.getContextPath() %>/admin/wechatMenu/queryPublishedMenu">查询微信菜单</a>
			</dd>
			<dt>订单管理</dt>
			<dd>
				<a href="<%=request.getContextPath() %>/admin/courseOrder/listOrderByStatus?orderStatus=待支付">未支付订单</a>
			</dd>
			<dd>
				<a href="<%=request.getContextPath() %>/admin/courseOrder/listOrderByStatus?orderStatus=已支付">已支付订单</a>
			</dd>
			<dt>教师管理</dt>
			<dd>
				<a href="<%=request.getContextPath() %>/admin/person/listApplyTeacher">审核教师</a>
			</dd>
			<dt>试听课</dt>
			<dd>
					<a href="<%=request.getContextPath()%>/admin/profile/profile">学生信息配置</a>
			</dd>
		</dl>
		</li>
	</ul>
</div>