<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>登录系统</title>
		<%@include file="/WEB-INF/content/include/head.jsp" %>
		<link href="resources/css/site.css" rel="stylesheet">
	</head>
	<body class="bg-color" >
		
		<div class="container login" style="width:400px;">
			<div class="row">
				<div class="col-md-12"> 
					<h4 class="text-left lead">欢迎登录系统</h4>
				</div>
				<div class="col-md-12">
					<form class="form-horizontal">
						<div class="form-group">
							<div class="col-sm-12">
								<input type="text" class="form-control" id="inputEmail3" placeholder="用户名">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<input type="password" class="form-control" id="inputPassword3" placeholder="密码">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10">
								<div class="checkbox">
									<label>
										<input type="checkbox"> 记住密码
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<input class="btn btn-info btn-block" type="submit" value="登录">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		
	</div>
	
	<%@include file="/WEB-INF/content/include/foot.jsp" %>
</body>
</html>
