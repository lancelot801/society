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
	src="<%=request.getContextPath()%>/js/reset_pwd.js"></script>
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
<title>修改密码</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/jsp/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">修改密码</h1>
				<div id="contain" class="row placeholders">
					<form class="form-horizontal" id="passwordForm"  action="#">
						<table class="table table-hover table-bordered" style="margin-left: auto;margin-right: auto;">
							<input type="text"  class="form-control" id="studentId" style="width: 90%;display: none;" value="${userLogin.studentId}"
										name="studentId" />
				
							<tr>
							<td>
								<div class="form-group">
								<label for="prePwd"  style="padding-left:10px"
										class="col-sm-2 control-label mylabStyle">原密码</label>
									<div class="col-sm-10">
										<input type="password" class="form-control" id="prePwd" style="width:90%;"
										name="prePwd" placeholder="请输入原密码" />
									</div>
									</div>
								</td>
							</tr>
	
							<tr>
							<td>
								<div class="form-group">
								<label for="currentPwd"  style="padding-left:10px"
										class="col-sm-2 control-label mylabStyle">新密码</label>
									<div class="col-sm-10">
										<input type="password" class="form-control" id="currentPwd" style="width:90%;"
										name="currentPwd" placeholder="请输入新密码" />
									</div>
									</div>
								</td>
							</tr>
							
							<tr>
							<td>
								<div class="form-group">
								<label for="currentPwd2"  style="padding-left:10px"
										class="col-sm-2 control-label mylabStyle">确认密码</label>
									<div class="col-sm-10">
										<input type="password" class="form-control" id="currentPwd2" style="width:90%;"
										name="currentPwd2" placeholder="请输入再次新密码" />
									</div>
									</div>
								</td>
							</tr>
						</table>
						<button id="updateBtn"
							class="btn btn-info btn-sm glyphicon glyphicon-plus ">确认修改</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>