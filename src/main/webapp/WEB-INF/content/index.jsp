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
</head>
<body>
	<div id="north" class="container-fluid site-north"></div>
	<div class="container-fluid" style="height: 92%;">
		<div class="row" style="height: 100%;">
			<div class="col-xs-2 cx2">

				<div id="accordion2" class="sidebar-menu">

					<div class="accord">
						<a data-toggle="collapse" data-parent="#accordion2"
							aria-expanded="false" class=" menu-first collapsed"
							href="#userMeun"><i class="icon-user-md "></i> <span>用户管理</span></a>
						<ul class=" menu-second collapse" id="userMeun"
							style="height: 0px;">
							<li><a href="#"><i class="icon-caret-right"></i> <span>增加用户</span></a></li>
							<li><a href="#"><i class="icon-caret-right"></i> <span>修改用户</span></a></li>
							<li><a href="#"><i class="icon-caret-right"></i> <span>删除用户</span></a></li>
							<li><a href="#"><i class="icon-caret-right"></i> <span>用户列表</span></a></li>

						</ul>
					</div>
					<div class="accord">
						<a data-toggle="collapse" data-parent="#accordion2"
							aria-expanded="false" class=" menu-first"
							href="#articleMenu"><i class="icon-book "></i> <span>文章管理</span></a>
						<ul class="menu-second collapse" id="articleMenu"
							style="height: auto;">
							<li><a href="#"><i class="icon-caret-right"></i> <span>添加文章</span></a></li>
							<li><a href="#"><i class="icon-caret-right"></i> <span>文章列表</span></a></li>
						</ul>

					</div>
				</div>



			</div>
			<div class="col-xs-10" >
				<div style="margin-left: -15px; margin-right: -15px;">
					sssssssss</div>

			</div>
		</div>
	</div>

	<%@include file="./include/foot.jsp"%>
</body>
<script type="text/javascript">
	$(function() {

	});
</script>
</html>