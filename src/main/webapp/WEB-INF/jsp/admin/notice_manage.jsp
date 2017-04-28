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
<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrapValidator.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/wangEditor.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/notice.js"></script>
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
<title>公告管理</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/jsp/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">
					社团公告管理
				</h1>
				<div id="contain" class="row placeholders">
					<table class='table table-responsive table-striped col-xs-12'>
						<thead>
							<tr>
								<th>公告主题</th>
								<th>发布时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${notices}" var="notice">
								<tr>

									<td style="display: none;">${notice.noticeId}</td>
									<td>${notice.theme}</td>
									<td><fmt:formatDate
											value="${notice.publishedTime}" pattern="yyyy年MM月dd日" />
									</td>
									<td><label>
											<button
												class="btn btn-info btn-sm glyphicon glyphicon-search queryBtn">查看公告</button>
									</label> &nbsp;&nbsp;&nbsp; <span>
											<button
												class="btn btn-info btn-sm glyphicon glyphicon-remove deleteBtn">删除公告</button>
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
	<div class="modal  fade" id="noticeModal">
		<div class="modal-dialog">
			<form id="noticeForm" >
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title">
							<span class="glyphicon glyphicon-leaf"></span>&nbsp;公告信息
						</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<div style="display: none;">
									<input id="noticeId" name="noticeId" />
								</div>
								<div class="form-group">
									<label for="theme"
										class="col-sm-2 control-label mylabStyle">公告主题</label>
									<div class="col-sm-10">
										<input type="text" id="theme" name="theme"
											style="width: 90%;" class="form-control" placeholder="请输入公告主题" />
									</div>
								</div>
								<br/><br/>	
									<textarea id="textarea1" style="height: 400px;"></textarea>		
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="btnClose" class="btn btn-default"
							data-dismiss="modal">关闭</button>
						<button id="submitBtn" class="btn btn-primary">提交</button>
					</div>
				</div>
			</form>
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