<%@page import="cn.joongky.society.UserLogin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<span class="navbar-brand">校园社团后台管理系统</span>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">管理员:${userLogin.nickname}</a></li>
				<li><a href="#">报表</a></li>
				<li><a href="#">设置</a></li>
				<li><a href="<%=request.getContextPath()%>/admin/change">修改密码</a></li>
				<li><a href="<%=request.getContextPath()%>/admin/quit" onclick="return confirm('确认退出？')">退出登录</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<!-- <input type="text" class="form-control" placeholder="搜索..."> -->
			</form>
		</div>
	</div>
</nav>