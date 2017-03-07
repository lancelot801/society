<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="/jsp/header_nav.jsp"%>

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
<script
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/studentInfo.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/society.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/kkpager.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/kkpager_blue.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrapValidator.min.css" />
<title>基本信息</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/jsp/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">个人信息管理</h1>
				<div id="contain" class="row placeholders">
					<form class="form-horizontal" id="studentInfoForm"
						enctype="multipart/form-data" action="#">
						<table class="table table-hover table-bordered" style="margin-left: auto;margin-right: auto;">
							<tr>
								<td>
								<div class="form-group">
								<label for="studentId"  style="padding-left:10px"
										class="col-sm-2 control-label mylabStyle">学号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="sname" style="width: 90%" value="${userLogin.studentId}"
										name="sname" readonly="readonly"/>
									</div>
									</div>
								</td>
								<td>
								<div class="form-group">
								<label for="sname"  style="padding-left:10px"
										class="col-sm-2 control-label mylabStyle">姓名</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="sname" style="width: 90%" value="${studentInfo.sname}"
										name="sname" placeholder="请输入真实姓名" />
									</div>
									</div>
									</td>
							</tr>
							<tr>
								<td>
									<div class="form-group">
									<label for="institueId"  style="padding-left:10px"
										class="col-sm-2 control-label mylabStyle">学院</label>
									<div class="col-sm-10">
									<select class="form-control " id="institueId" style="width: 90%"
									name="institueId">
										<!--   <c:forEach var="category" items="${categories}">
    								<option value="${category.categoryId}">
    								${category.categoryName}</option>
    								</c:forEach>  -->
										<option value="">--请选择学院--</option>
										<option value="1">信电学院</option>
										<option value="2">人文学院</option>
										<option value="3">经济学院</option>
										<option value="4">艺术学院</option>
										<option value="5">体育学院</option>
									</select>
									</div>
									</div>
								</td>
								<td><div class="form-group">
									<label for="classId"  style="padding-left:10px"
										class="col-sm-2 control-label mylabStyle">班级</label>
									<div class="col-sm-10">
									<select class="form-control " id="classId" style="width: 90%"
									name="classId">
										<!--   <c:forEach var="category" items="${categories}">
    								<option value="${category.categoryId}">
    								${category.categoryName}</option>
    								</c:forEach>  -->
										<option value="">--请选择班级--</option>
										<option value="1">13计卓</option>
										<option value="2">13计1</option>
										<option value="3">13计2</option>
										<option value="4">13网单1</option>
										<option value="5">13网单2</option>
								</select>
									</div>
									</div>
								</td>
							</tr>
							<tr>
							<td>
								<div class="form-group">
								<label for="nickname"  style="padding-left:10px"
										class="col-sm-2 control-label mylabStyle">昵称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="nickname" style="width:90%" value="${studentInfo.nickname}"
										name="nickname" placeholder="请输入昵称" />
									</div>
									</div>
								</td>
							<td>
							<div class="form-group">
							<label for="sex"  style="padding-left:10px"
										class="col-sm-2 control-label mylabStyle">性别</label>
										<div class="col-sm-10">
									<select class="form-control " id="sex" style="width: 90%"
									name="sex">
								
										<option value="男">男</option>
										<option value="女">女</option>
									</select>
									</div>
									</div>
									</td>
							</tr>
	
							<tr>
							<td>
							<div class="form-group">
								<label for="email"  
										class="col-sm-2 control-label mylabStyle">邮箱</label>
									<div class="col-sm-10">
										<input type="email" style="width:90%" id="email" name="email"
											class="form-control" placeholder="请输入邮箱" />
									</div>
									</div>
								<!--  <input type="text" class="form-control" id="email"  value="${studentInfo.email}"
									name="email" placeholder="请输入电子邮箱" /> -->
							</td>
								<td><div class="form-group">
								<label for="mobile"  style="padding-left:10px"
										class="col-sm-2 control-label mylabStyle">手机</label>
										<div class="col-sm-10">
								<input type="text" class="form-control" id="mobile" value="${studentInfo.mobile}"
								    style="width: 90%"
									name="mobile" placeholder="请输入手机号" />
									</div>
									</div></td>
							</tr>
							<tr>
								<td>学生证封面</td>
								<td><input type="file" class="file" name="identityCard1">
								</td>
							</tr>
							<tr>
								<td>学生证内容</td>
								<td><input type="file" class="file" name="identityCard2">
								</td>
							</tr>
						</table>

				
								
						<button id="updateBtn"
							class="btn btn-info btn-sm glyphicon glyphicon-plus ">修改信息</button>
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- 修改模态框 -->
	<div class="modal  fade" id="courseModal">
		<div class="modal-dialog">
			<form id="updateCourse" action="" method="post"
				enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title">
							<span class="glyphicon glyphicon-leaf"></span>&nbsp;课程信息
						</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<div style="display: none;">
									<input id="courseId" name="courseId" />
								</div>
								<div class="form-group">
									<label for="categoryId"
										class="col-sm-2 control-label mylabStyle">语种编号</label>
									<div class="col-sm-10">
										<input type="text" id="categoryId" name="categoryId"
											readonly="readonly" class="form-control"
											placeholder="请输入语种编号" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="courseName"
										class="col-sm-2 control-label mylabStyle">课程名称</label>
									<div class="col-sm-10">
										<input type="text" id="courseName" name="courseName"
											class="form-control" placeholder="请输入课程名称" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="description"
										class="col-sm-2 control-label mylabStyle">课程描述</label>
									<div class="col-sm-10">
										<input type="text" id="description" name="description"
											class="form-control" placeholder="请输入课程描述" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="courseStatus"
										class="col-sm-2 control-label mylabStyle">课程状态</label>
									<div class="col-sm-10">
										<select class="form-control " id="courseStatus"
											name="courseStatus">
											<option value="">--请选择课程状态--</option>
											<option value="待审核">待审核</option>
											<option value="待发布">待发布</option>
											<option value="报名中">报名中</option>
											<option value="开课中">开课中</option>
											<option value="已结课">已结束</option>
										</select>
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="price" class="col-sm-2 control-label mylabStyle">课程价格</label>
									<div class="col-sm-10">
										<input type="text" id="price" name="price"
											class="form-control" placeholder="请输入课程价格" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="startTime"
										class="col-sm-2 control-label mylabStyle">开课时间</label>
									<div class="input-group date form_datetime col-sm-10"
										data-date="2016-10-12" data-date-format="yyyy-MM-dd"
										style="margin-left: 105px; width: 280px;"
										data-link-field="startTime">
										<input class="form-control" id="startTime" name="startTime"
											size="16" type="text" value="" placeholder="请选择开课时间">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-remove"></span></span> <span
											class="input-group-addon"><span
											class="glyphicon glyphicon-th"></span></span>
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="lessonNumber"
										class="col-sm-2 control-label mylabStyle">课程节数</label>
									<div class="col-sm-10">
										<input type="text" id="lessonNumber" name="lessonNumber"
											class="form-control" placeholder="请输入课程节数" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="openAudio"
										class="col-sm-2 control-label mylabStyle">音频状态</label>
									<div class="col-sm-10">
										<select class="form-control " id="openAudio" name="openAudio">
											<option value="">--是否开启音频--</option>
											<option value="true">开启</option>
											<option value="false">关闭</option>
										</select>
									</div>
								</div>
								<br /> <br />


								<div class="form-group">
									<label for="profilePictrue"
										class="col-sm-2 control-label mylabStyle">课程图片</label>
									<div class="col-sm-10" style="display: inline;">
										<img id="courseImg" name="courseImg"
											style="width: 40px; height: 40px" /> <input
											style="width: 80%; display: inline;" type="file" class="file"
											name="profilePictrue">
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="sequence" class="col-sm-2 control-label mylabStyle">课程顺序</label>
									<div class="col-sm-10">
										<input type="text" id="sequence" name="sequence"
											class="form-control" placeholder="请输入课程顺序" />
									</div>
								</div>


							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="btnClose" class="btn btn-default"
							data-dismiss="modal">关闭</button>
						<button id="submitBtn" type="submit" class="btn btn-primary">提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>


	<!-- 添加模态框 -->
	<div class="modal  fade" id="addCourseModal">
		<div class="modal-dialog">
			<form id="course" action="http://api.flyplus1.com/admin/course/add"
				method="post" enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title">
							<span class="glyphicon glyphicon-leaf"></span>&nbsp;课程信息
						</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">

								<div class="form-group">
									<label for="categoryId"
										class="col-sm-2 control-label mylabStyle">选择语种</label>
									<div class="col-sm-10">
										<select class="form-control " id="categoryId2"
											name="categoryId">
											<c:forEach var="category" items="${categories}">
												<option value="${category.categoryId}">${category.categoryName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<br /> <br />

								<!-- <div style="display:none;"><input id="courseId" name="courseId" /> </div> -->

								<div class="form-group">
									<label for="courseName2"
										class="col-sm-2 control-label mylabStyle">课程名称</label>
									<div class="col-sm-10">
										<input type="text" id="courseName2" name="courseName"
											class="form-control" placeholder="请输入课程名称" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="description2"
										class="col-sm-2 control-label mylabStyle">课程描述</label>
									<div class="col-sm-10">
										<input type="text" id="description2" name="description"
											class="form-control" placeholder="请输入课程描述" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="courseStatus2"
										class="col-sm-2 control-label mylabStyle">课程状态</label>
									<div class="col-sm-10">
										<select class="form-control " id="courseStatus2"
											name="courseStatus">
											<option value="">--请选择课程状态--</option>
											<option value="待审核">待审核</option>
											<option value="待发布">待发布</option>
											<option value="报名中">报名中</option>
											<option value="开课中">开课中</option>
											<option value="已结束">已结束</option>
										</select>
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="price2" class="col-sm-2 control-label mylabStyle">课程价格</label>
									<div class="col-sm-10">
										<input type="text" id="price2" name="price"
											class="form-control" placeholder="请输入课程价格" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="startTime2"
										class="col-sm-2 control-label mylabStyle">开课时间</label>
									<div class="input-group date form_datetime col-sm-10"
										data-date="2016-10-12" data-date-format="yyyy-MM-dd"
										style="margin-left: 105px; width: 280px;"
										data-link-field="startTime">
										<input class="form-control" id="startTime2" name="startTime"
											size="16" type="text" value="" placeholder="请选择开课时间">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-remove"></span></span> <span
											class="input-group-addon"><span
											class="glyphicon glyphicon-th"></span></span>
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="lessonNumber2"
										class="col-sm-2 control-label mylabStyle">课程节数</label>
									<div class="col-sm-10">
										<input type="text" id="lessonNumber2" name="lessonNumber"
											class="form-control" placeholder="请输入课程节数" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="openAudio2"
										class="col-sm-2 control-label mylabStyle">音频状态</label>
									<div class="col-sm-10">
										<select class="form-control " id="openAudio2" name="openAudio">
											<option value="">--是否开启音频--</option>
											<option value="true">开启</option>
											<option value="false">关闭</option>
										</select>
									</div>
								</div>
								<br /> <br />


								<div class="form-group">
									<label for="profilePictrue"
										class="col-sm-2 control-label mylabStyle">课程图片</label>
									<div class="col-sm-10">
										<input type="file" class="file" name="profilePictrue">
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="sequence2D"
										class="col-sm-2 control-label mylabStyle">课程顺序</label>
									<div class="col-sm-10">
										<input type="text" id="sequence2" name="sequence"
											class="form-control" placeholder="请输入课程顺序" />
									</div>
								</div>


							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="btnClose" class="btn btn-default"
							data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>


</body>
</html>