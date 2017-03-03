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
<link rel="shortcut icon" href="<%=request.getContextPath()%>/img/my_ico.ico">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/activity.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/society.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/kkpager.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/kkpager_blue.css" />
<title>课程管理</title>
</head>
<body>
<script type="text/javascript">
function getParameter(name) { 
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r!=null) return unescape(r[2]); return null;
}

function isContains(str, substr) {
    return new RegExp(substr).test(str);
}
//init
$(function(){
	var totalPage ;
	var totalRecords ;
	//获取当前的请求链接
	var url = window.location.href;
	var uri ;
	var courseStatus = getParameter('courseStauts');
	//获取uri
	if(url.indexOf("Status")>0){
		if(url.indexOf("&")>0){
			uri = url.substring(url.lastIndexOf("/")+1,url.indexOf("&"));
		}else{
			uri = url.substring(url.lastIndexOf("/")+1);
		}	
	}else{
		if(url.indexOf("?")>0)
		{
		  uri = url.substring(url.lastIndexOf("/")+1,url.indexOf("?"));
		}else{
		  uri = url.substring(url.lastIndexOf("/")+1);	
		}
	}

	$(document).ready(function() {
		$.ajax({
			url : "http://api.flyplus1.com/admin/course/queryToltalPageByCourseStatus?courseStatus="+courseStatus,
			type : "get",
			success : function(result) {
				totalPage = result.resultData.totalPage;
				totalRecords = result.resultData.totalRecords;
			},
			error : function(error) {
				alert(error.resultData);
			},
			async : false
		});
		var pageNo = getParameter('pNo');
		if(!pageNo){
			pageNo = 1;
		}	
		//生成分页
		//有些参数是可选的，比如lang，若不传有默认值
		kkpager.generPageHtml({
			pno : pageNo,
			//总页码
			total : totalPage,
			//总数据条数
			totalRecords : totalRecords,
			//链接前部
			hrefFormer : uri,
			//链接尾部
			//hrefLatter : '.html',
			getLink : function(n){
				if(uri.indexOf("Status")>0)
				{
					return this.hrefFormer + this.hrefLatter + "&pNo="+n
				}else{
					return this.hrefFormer + this.hrefLatter + "?pNo="+n;
				}
			}
		});
		
	});
	
});
</script>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/jsp/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">
					<c:if test="${not empty courseStauts}">
						${courseStauts}
					</c:if>
						所有课程
				</h1>
				<button class="btn btn-info btn-sm glyphicon glyphicon-plus addBtn">添加课程</button>
				<div id="contain" class="row placeholders">
					<table class='table table-responsive table-striped col-xs-12'>
						<thead>
							<tr>
								<th>课程图片</th>
								<th>课程名称</th>
								<th>课程描述</th>
								<th>价格</th>
								<th>课程状态</th>
								<th>开始时间</th>
								<th>课程人员</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${courses}" var="course">
								<tr>
									<td style="display: none;">${course.courseId }</td>
									<td><img style="width:50px" alt="课程图片" src="http://img.flyplus1.com/${course.imgUrl }"></td>
									<td>${course.courseName }</td>
									<td>${course.description}</td>
									<td>${course.price}</td>
									<td>${course.courseStatus }</td>
									<td><fmt:formatDate value="${course.startTime}"
											pattern="yyyy年MM月dd日" /></td>
									<td><a href="<%=request.getContextPath()%>/admin/courseUser/queryStudent?courseId=${course.courseId}">课程学生</a>/
									<a href="<%=request.getContextPath()%>/admin/courseTeacher/queryTeacher?courseId=${course.courseId}">课程老师</a></td>
									<td><label>
											<button
												class="btn btn-info btn-sm glyphicon glyphicon-search queryBtn">查看详情</button>
									</label> <c:if
											test="${!(course.courseStatus  eq '已删除'||course.courseStatus  eq '报名中'||course.courseStatus  eq '开课中' || course.courseStatus  eq '已结束')}">
								
									&nbsp;&nbsp;&nbsp;
									<span>
												<button
													class="btn btn-info btn-sm glyphicon glyphicon-remove deleteBtn">删除课程</button>
											</span>
										</c:if> <c:if test="${course.courseStatus eq '已结束'}">
									&nbsp;&nbsp;&nbsp;
									<span>
												<button
													class="btn btn-info btn-sm glyphicon glyphicon-ok deleteBtn">删除课程</button>
											</span>
										</c:if> <c:if test="${course.courseStatus eq '待审核'}">
									&nbsp;&nbsp;&nbsp;
									<span>
												<button
													class="btn btn-info btn-sm glyphicon glyphicon-ok checkedBtn">审核课程</button>
											</span>
										</c:if>
										&nbsp;&nbsp;&nbsp;
										<label>
											<a
												class="btn btn-info btn-sm glyphicon glyphicon-leaf lessonBtn"
												href="<%=request.getContextPath()%>/admin/lesson/listByCourseId?courseId=${course.courseId }">具体课堂</a>
									</label>
										</td>	
								</tr>
							</c:forEach>
							
						</tbody>
					</table>
					<div id="kkpager" style="width: 80%;height: 30px"></div>
				</div>
			</div>
		</div>
	</div>


	<!-- 修改模态框 -->
	<div class="modal  fade" id="courseModal">
		<div class="modal-dialog">
			<form id="updateCourse" action="" method="post" enctype="multipart/form-data">
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
								<div style="display:none;"><input id="courseId" name="courseId" /> </div> 	
								<div class="form-group">
									<label for="categoryId"
										class="col-sm-2 control-label mylabStyle">语种编号</label>
									<div class="col-sm-10">
										<input type="text" id="categoryId" name="categoryId" readonly="readonly"
											class="form-control" placeholder="请输入语种编号" />
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
									<label for="startTime" class="col-sm-2 control-label mylabStyle">开课时间</label>
									<div class="input-group date form_datetime col-sm-10"
										data-date="2016-10-12"
										data-date-format="yyyy-MM-dd"
										style="margin-left:105px;width:280px;"
										data-link-field="startTime">
										<input class="form-control" id="startTime" name="startTime" size="16"
											type="text" value="" placeholder="请选择开课时间" >
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-remove"></span></span> <span
											class="input-group-addon"><span
											class="glyphicon glyphicon-th"></span></span>
									</div>
								</div>
								<br/>
								
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
											<option  value="true">开启</option>
											<option  value="false">关闭</option>
										</select>
									</div>
								</div>
								<br /> <br />


								<div class="form-group">
									<label for="profilePictrue"
										class="col-sm-2 control-label mylabStyle">课程图片</label>
									   <div class="col-sm-10" style="display: inline;">
										<img id="courseImg" name="courseImg" style="width:40px;height:40px" />
										<input  style="width:80%;display:inline;" type="file" class="file" name="profilePictrue">
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
			<form id="course" action="http://api.flyplus1.com/admin/course/add" method="post"
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
									<label for="startTime2" class="col-sm-2 control-label mylabStyle">开课时间</label>
									<div class="input-group date form_datetime col-sm-10"
										data-date="2016-10-12"
										data-date-format="yyyy-MM-dd"
										style="margin-left:105px;width:280px;"
										data-link-field="startTime">
										<input class="form-control" id="startTime2" name="startTime" size="16"
											type="text" value="" placeholder="请选择开课时间" >
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-remove"></span></span> <span
											class="input-group-addon"><span
											class="glyphicon glyphicon-th"></span></span>
									</div>
								</div>
								<br/>
								
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
											<option  value="true">开启</option>
											<option  value="false">关闭</option>
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
									<label for="sequence2D" class="col-sm-2 control-label mylabStyle">课程顺序</label>
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