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
	src="<%=request.getContextPath()%>/js/editor.js"></script>
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrapValidator.min.css" />
<title>社团公告</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/jsp/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">社团公告</h1>
				<div id="contain" class="row placeholders">
					<form class="form-horizontal" id="noticeForm" action="#">
							<input type="text"  id="publisher"style="display: none;" value="${userLogin.studentId}"name="publisher"  />
							<div class="form-group">
								<label for="theme" style="padding-left: 10px"
									class="col-sm-2 control-label mylabStyle">公告主题</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="theme"
										style="width: 90%" 
										name="theme"  />
								</div>
							</div>

							<div class="form-group">
								<h3 style="margin-left: auto; margin-right: auto;">公告内容</h3>
							</div>
							<textarea id="textarea1" style="height: 200px;"></textarea>

							<button id="noticeBtn"
								class="btn btn-info btn-sm glyphicon glyphicon-plus ">发布公告</button>
					</form>
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