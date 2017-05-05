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
	src="<%=request.getContextPath()%>/js/my_society_apply.js"></script>
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
<title>社团申请记录</title>
</head>
<body>
	<input id="society_studentId" name="society_studentId" value="${userLogin.studentId}" style="display: none;">
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/jsp/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">审核社团申请</h1>
				<div id="contain" class="row placeholders">
					<table class='table table-responsive table-striped col-xs-12'>
						<thead>
							<tr>
								<th style="text-align: center;">社团名称</th>
								<th style="text-align: center;">社团图标</th>
								<th style="text-align: center;">申请者</th>
								<th style="text-align: center;">申请时间</th>
								<th style="text-align: center;">审核状态</th>
								<th style="text-align: center;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${societyApplies}" var="societyApply">
								<tr>

									<td style="display: none;">${societyApply.applyId }</td>
									<td style="text-align: center;">${societyApply.societyName}</td>
									<td style="text-align: center;"><img
										style="width: 30px; height: 30px;"
										src="/idCard/${societyApply.logoUrl}" /></td>
									<td style="text-align: center;">${societyApply.applyerId}</td>
									<td style="text-align: center;"><fmt:formatDate
											value="${societyApply.appliedTime}" pattern="yyyy年MM月dd日" /></td>
									<td style="text-align: center;">${societyApply.checkStatus}</td>
									<td style="text-align: center;"><label>
											<button
												class="btn btn-info btn-sm glyphicon glyphicon-search queryBtn">查看详情</button>
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


	<!-- 社团申请详情模态框 -->
	<div class="modal  fade" id="societyApplyModal">
		<div class="modal-dialog">
			<form id="societyApplyFrom" action="" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title">
							<span class="glyphicon glyphicon-leaf"></span>&nbsp;社团申请详情
						</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<div style="display: none;">
									<input id="societyApplyId" name="societyApplyId" />
								</div>
								<div style="display: none;">
									<input id="operatorId" name="operatorId" value="${userLogin.studentId}"/>
									<input id="applyerId" name="applyerId" />
								</div>	
								<div class="form-group">
									<label for="societyName"
										class="col-sm-2 control-label mylabStyle">社团名称</label>
									<div class="col-sm-10">
										<input type="text" id="societyName" 
											name="societyName" style="width: 90%;" class="form-control" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="societyType"
										class="col-sm-2 control-label mylabStyle">社团类别</label>
									<div class="col-sm-10">
										<input type="text" id="societyType" readonly="readonly"
											name="societyType" style="width: 90%;" class="form-control" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="logoUrl" class="col-sm-2 control-label mylabStyle">社团图标</label>
									<div class="col-sm-10">
										<img id="logoUrl" name="logoUrl"
											style="width: 40px; height: 40px;" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="introduction"
										class="col-sm-2 control-label mylabStyle">社团简介</label>
									<div class="col-sm-10">
										<textarea autofocus="autofocus" class="form-control" id="introduction"
											style="width: 90%;" name="introduction">
												</textarea>
									</div>
								</div>
								<br />
								<br />
								<br />

								<div class="form-group">
									<label for="applyerName"
										class="col-sm-2 control-label mylabStyle">申请者</label>
									<div class="col-sm-10">
										<input type="text" id="applyerName" readonly="readonly"
											name="applyerName" style="width: 90%;" class="form-control" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="idCardCover"
										class="col-sm-2 control-label mylabStyle">申请者学生证封面</label>
									<div class="col-sm-10">
										<img id="idCardCover" name="idCardCover"
											style="width: 40px; height: 40px;" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="idCardContent"
										class="col-sm-2 control-label mylabStyle">申请者学生证内容</label>
									<div class="col-sm-10">
										<img id="idCardContent" name="idCardContent"
											style="width: 40px; height: 40px;" />
									</div>
								</div>
								<br /> <br />

								<div class="form-group">
									<label for="checkStatus2"
										class="col-sm-2 control-label mylabStyle">审核状态</label>
									<div class="col-sm-10">
										<input type="text" id="checkStatus2" readonly="readonly"
											name="checkStatus" style="width: 90%;" class="form-control" />
									</div>
								</div>
								<br /> <br />
								
							</div>
						</div>
					</div>
					<div class="modal-footer">		
						<button style="display: none;" id="submitBtn" class="btn btn-primary">修改</button>
						<button type="button" id="btnClose" class="btn btn-default"
							data-dismiss="modal">关闭</button>		
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>