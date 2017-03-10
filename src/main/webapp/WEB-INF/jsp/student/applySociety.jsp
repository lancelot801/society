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
	src="<%=request.getContextPath()%>/js/applySociety.js"></script>
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
<title>申办社团</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/jsp/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">申办社团</h1>
				<div id="contain" class="row placeholders">
					<form class="form-horizontal" id="societyApply"
						enctype="multipart/form-data" action="#">
						<table class="table table-hover table-bordered"
							style="margin-left: auto; margin-right: auto;">
							<input type="text" class="form-control" id="applyerId"
								name="applyerId" style="display: none;"
								value="${userLogin.studentId}" />
							<tr>
								<td>
									<div class="form-group">
										<label for="instituteId" style="padding-left: 10px"
											class="col-sm-2 control-label mylabStyle">社团类别</label>
										<div class="col-sm-10">
											<select class="form-control " id="typeId" style="width: 90%"
												name="typeId">
												<c:forEach var="societyType" items="${societyTypes}">
													<option value="${societyType.typeId}">
														${societyType.typeName}</option>
												</c:forEach>

											</select>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="form-group">
										<label for="societyName" style="padding-left: 10px"
											class="col-sm-2 control-label mylabStyle">社团名称</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="societyName"
												style="width: 90%" name="societyName" placeholder="请输入社团名称" />
										</div>
									</div>
								</td>

							</tr>
							<tr>

								<td>
									<div class="form-group">
										<label for="logoUrl" style="padding-left: 10px"
											class="col-sm-2 control-label mylabStyle">社团logo</label>
										<div class="col-sm-10">
											<input style="display: inline;" type="file" class="file"
												name="logoUrl">
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="form-group">
										<label for="introduction" style="padding-left: 10px"
											class="col-sm-2 control-label mylabStyle">社团简介</label>
										<div class="col-sm-10">
											<textarea autofocus="autofocus" type="text"
												class="form-control" id="introduction" rows="10"
												style="width: 90%; height: 80px;" name="introduction"
												placeholder="请输入社团简介">
												</textarea>
										</div>
									</div>

								</td>
								</div>
							</tr>
						</table>

						<button id="applyBtn" class="btn btn-info btn-sm glyphicon glyphicon-plus ">确认申办</button>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>