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
<%@include file="/WEB-INF/content/include/head.jsp"%>
<link href="resources/css/site.css" rel="stylesheet">
</head>
<body class="bg-index-color">
	<div id="north" class="container-fluid"
		style="height: 60px; background-color: #3BAFDA;"></div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-3">
				<div class="panel-group panel-group-lists"  id="accordion2"
					style="margin-left: -15px;">
					<div class="panel"  >
						<div class="panel-heading" style="background-color: #4FC1E9;">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion2"
									href="#collapseFour">Collapsible Group Item #1</a>
							</h4>
						</div>
						<div id="collapseFour" class="panel-collapse collapse in">
							<div class="panel-body" style="background-color: #3BAFDA;">
								ssssssssssssss
							</div>
						</div>
					</div>
					<div class="panel">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion2"
									href="#collapseFive">Collapsible Group Item #2</a>
							</h4>
						</div>
						<div id="collapseFive" class="panel-collapse collapse">
							<div class="panel-body">aaaaaaaaaaa</div>
						</div>
					</div>
					
				</div>
			</div>
			<div class="col-lg-9"></div>
		</div>
	</div>




	</div>

	<%@include file="/WEB-INF/content/include/foot.jsp"%>
</body>
</html>