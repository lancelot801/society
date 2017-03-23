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
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/institutes.js"></script>
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
<title>学院管理</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/jsp/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">
					<c:if test="${not empty courseStauts}">
						${courseStauts}
					</c:if>
					学院管理
				</h1>
				<button class="btn btn-info btn-sm glyphicon glyphicon-plus addBtn">添加学院</button>
				<div id="contain" class="row placeholders">
					<table class='table table-responsive table-striped col-xs-12'>
						<thead>
							<tr>
								<th>学院名称</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${institutes}" var="institute">
								<tr>

									<td style="display: none;">${institute.instituteId }</td>
									<td>${institute.instituteName}</td>
									<td><label>
											<button
												class="btn btn-info btn-sm glyphicon glyphicon-search queryBtn">修改信息</button>
									</label> &nbsp;&nbsp;&nbsp; <span>
											<button
												class="btn btn-info btn-sm glyphicon glyphicon-remove deleteBtn">删除学院</button>
									</span> &nbsp;&nbsp;&nbsp; <label> <a
											class="btn btn-info btn-sm glyphicon glyphicon-leaf lessonBtn"
											href="<%=request.getContextPath()%>/admin/lesson/listByCourseId?courseId=${course.courseId }">所有班级</a>
									</label></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
					<div id="kkpager" style="width: 80%; height: 30px"></div>
				</div>
			</div>
		</div>
	</div>


	<!-- 修改模态框 -->
	<div class="modal  fade" id="instituteModal">
		<div class="modal-dialog">
			<form id="updateInstitute" action="" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title">
							<span class="glyphicon glyphicon-leaf"></span>&nbsp;学院信息
						</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<div style="display: none;">
									<input id="instituteId" name="instituteId" />
								</div>

								<div class="form-group">
									<label for="instituteName"
										class="col-sm-2 control-label mylabStyle">学院名称</label>
									<div class="col-sm-10">
										<input type="text" id="instituteName2" name="instituteName"
											style="width: 90%" class="form-control" placeholder="请输入学院名称" />
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
	<div class="modal  fade" id="addInstituteModal">
		<div class="modal-dialog">
			<form id="addInstituteForm" action="" method="">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title">
							<span class="glyphicon glyphicon-leaf"></span>&nbsp;添加学院
						</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">

								<div class="form-group">
									<label for="instituteName"
										class="col-sm-2 control-label mylabStyle">学院名称</label>
									<div class="col-sm-10">
										<input type="text" id="instituteName" name="instituteName"
											style="width: 90%" class="form-control" placeholder="请输入学院名称" />
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="btnClose" class="btn btn-default"
							data-dismiss="modal">关闭</button>
						<button id="addInstituteBtn" type="submit" class="btn btn-primary">提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>


</body>
</html>