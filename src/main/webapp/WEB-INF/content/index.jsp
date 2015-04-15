<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>登录系统</title>
<%@include file="./include/head.jsp"%>
<link href="resources/css/site.css" rel="stylesheet">
<style type="text/css">


</style>
</head>
<body class="bg-index-color">
	<div id="north" class="container-fluid"
		style="height: 60px; background-color: #3BAFDA;"></div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<div class="sidebar-menu">
					<a data-toggle="collapse" class="nav-header menu-first collapsed"
						href="#userMeun"><i class="icon-user-md icon-large"></i> 用户管理</a>
					<ul class="nav nav-list menu-second collapse" id="userMeun"
						style="height: 0px;">
						<li><a href="#"><i class="icon-user"></i> 增加用户</a></li>
						<li><a href="#"><i class="icon-edit"></i> 修改用户</a></li>
						<li><a href="#"><i class="icon-trash"></i> 删除用户</a></li>
						<li><a href="#"><i class="icon-list"></i> 用户列表</a></li>

					</ul>
					<a data-toggle="collapse" class="nav-header menu-first"
						href="#articleMenu"><i class="icon-book icon-large"></i> 文章管理</a>
					<ul class="nav nav-list menu-second in collapse" id="articleMenu"
						style="height: auto;">
						<li><a href="#"><i class="icon-pencil"></i> 添加文章</a></li>
						<li><a href="#"><i class="icon-list-alt"></i> 文章列表</a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-10"></div>
		</div>
	</div>




	</div>

	<%@include file="./include/foot.jsp"%>
</body>
</html>