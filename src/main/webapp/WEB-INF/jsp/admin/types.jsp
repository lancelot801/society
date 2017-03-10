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
	src="<%=request.getContextPath()%>/js/society_type.js"></script>
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
<title>社团类别管理</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/jsp/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">
					社团类别管理
				</h1>
				<button class="btn btn-info btn-sm glyphicon glyphicon-plus addBtn">添加类别</button>
				<div id="contain" class="row placeholders">
					<table class='table table-responsive table-striped col-xs-12'>
						<thead>
							<tr>
								<th style="text-align: center;">类别名称</th>
								<th style="text-align: center;">创建时间</th>
								<th style="text-align: center;">创建者</th>
								<th style="text-align: center;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${societyTypes}" var="societyType">
								<tr>

									<td style="display: none;">${societyType.typeId }</td>
									<td style="text-align: center;">${societyType.typeName}</td>
									<td style="text-align: center;"><fmt:formatDate value="${societyType.createdTime}"
											pattern="yyyy年MM月dd日" /></td>
									<td style="text-align: center;">${societyType.creater}</td>
									<td style="text-align: center;"><label>
											<button
												class="btn btn-info btn-sm glyphicon glyphicon-search queryBtn">修改信息</button>
									</label> &nbsp;&nbsp;&nbsp; <span>
											<button
												class="btn btn-info btn-sm glyphicon glyphicon-remove deleteBtn">删除信息</button>
									</span></td>
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
	<div class="modal  fade" id="societyTypeModal">
		<div class="modal-dialog">
			<form id="updatesocietyType" action="" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title">
							<span class="glyphicon glyphicon-leaf"></span>&nbsp;社团类别信息
						</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<div style="display: none;">
									<input id="societyTypeId" name="typeId" />
								</div>
								<input type="text" id="studentId2" name="creater" value="${userLogin.studentId}" style="display: none" />	
								<div class="form-group">
									<label for="societyTypeName"
										class="col-sm-2 control-label mylabStyle">类别名称</label>
									<div class="col-sm-10">
										<input type="text" id="societyTypeName2" name="societyTypeName"
											style="width: 90%" class="form-control" placeholder="请输入社团类别名称" />
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
	<div class="modal  fade" id="addsocietyTypeModal">
		<div class="modal-dialog">
			<form id="addsocietyTypeForm" action="" method="">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title">
							<span class="glyphicon glyphicon-leaf"></span>&nbsp;添加社团类别
						</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">

								<div class="form-group">
									<label for="societyTypeName"
										class="col-sm-2 control-label mylabStyle">类别名称</label>
									<input type="text" id="studentId" name="studentId" value="${userLogin.studentId}" style="display: none" />	
									<div class="col-sm-10">
										<input type="text" id="societyTypeName" name="societyTypeName"
											style="width: 90%" class="form-control" placeholder="请输入社团类别" />
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="btnClose" class="btn btn-default"
							data-dismiss="modal">关闭</button>
						<button id="addsocietyTypeBtn" type="submit" class="btn btn-primary">提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>


</body>
</html>