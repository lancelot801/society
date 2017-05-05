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
	src="<%=request.getContextPath()%>/js/activity_detail.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/sweetalert2.min.js"></script>
		<!-- for IE support -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/promise.min.js"></script>
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
<link rel="stylesheet" type="text/css" 
	href="<%=request.getContextPath()%>/css/sweetalert2.min.css">
<title>社团活动详情</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/jsp/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="detailForm">
				<input style="display: none;" id="activityId" name="activityId"/>
				<input style="display: none;" id="applyerId" name="applyerId"/>
				<input style="display: none;" id="operatorId" name="operatorId" value="${userLogin.studentId} "/>
				<h1 class="activity_title"></h1>
				
				<div id="content">
				 <h1 style="color: #9a0e14;text-align: center;">活动内容如下:</h1>
				</div>
					<div id="fb">
					<div class="form-group">
									<label for="feedBack" class="col-sm-2 control-label mylabStyle">审核意见反馈</label>
									<div class="col-sm-10">
										<input type="text" id="feedBack" placeholder="通过与否都需填写审核反馈"
											name="feedBack" style="width: 90%;" class="form-control" />
									</div>
					</div>
					<br/><br/>
				<div style="text-align: center;">
				<button id="submitBtn" type="submit" class="btn btn-primary">通过</button>
				<button id="notPassBtn" type="submit" class="btn btn-primary">不通过</button>
				</div>
				</div>
				</form>
				</div>
			</div>
		</div>
</body>
</html>