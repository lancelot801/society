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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/wangEditor.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/wangEditor.min.js"></script>
<!--引入jquery和wangEditor.js-->
<!--注意：javascript必须放在body最后，否则可能会出现问题-->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/student_activity_editor.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/society.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/kkpager.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/kkpager_blue.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrapValidator.min.css" />
<title>社团活动申请</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/jsp/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">社团活动申请</h1>
				<div id="contain" class="row placeholders">
					<form class="form-horizontal" id="activityApplyForm"
						enctype="multipart/form-data" action="#">
						<input id="activityId" name="activityId" style="display: none;"/>
							<div class="form-group">
								<label for="societyName" style="padding-left: 10px"
									class="col-sm-2 control-label mylabStyle">社团名称</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="societyName"
										style="width: 90%" value="${societyInfo.societyName}"
										name="societyName" readonly="readonly" />
								</div>
							</div>

							<div class="form-group">
								<label for="theme" style="padding-left: 10px"
									class="col-sm-2 control-label mylabStyle">活动主题</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="theme"
										style="width: 90%" 
										name="theme"  />
								</div>
							</div>


							<div class="form-group">
								<label for="holdTime"
									class="col-sm-2 control-label mylabStyle">活动时间</label>
								<div class="input-group date form_datetime col-sm-10"
									data-date="2016-10-12" data-date-format="yyyy-MM-dd"
									style="margin-left: 80px; width: 280px;"
									data-link-field="startTime">
									<input class="form-control" id="holdTime" name="holdTime"
										size="16" style="margin-left: 14px;" type="text" value=""
										placeholder="请选择活动时间"> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-remove"></span></span> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-th"></span></span>
								</div>
							</div>

							<div class="form-group">
								<h3 style="margin-left: auto; margin-right: auto;">活动内容</h3>
							</div>
							<textarea id="textarea1" style="height: 200px;"></textarea>

							<input id="applyUpdateBtn" type="button"  value="修改申请" style="display: none;"
								class="btn btn-info btn-sm glyphicon glyphicon-plus "/>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var editor = new wangEditor('textarea1');

		// 上传图片（举例）
		editor.config.uploadImgUrl = './uploadImg';
		editor.config.uploadImgFileName = 'myFileName';

		// 配置自定义参数（举例）
		editor.config.uploadParams = {
			token : 'abcdefg',
			user : 'wangfupeng1988'
		};

		// 设置 headers（举例）
		editor.config.uploadHeaders = {
			'Accept' : 'text/x-json',
		};

		// 隐藏掉插入网络图片功能。该配置，只有在你正确配置了图片上传功能之后才可用。
		editor.config.hideLinkImg = true;

		editor.create();
	</script>
</body>
</html>