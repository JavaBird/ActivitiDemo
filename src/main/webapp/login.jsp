<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录系统</title>
<%@include file="./WEB-INF/content/include/head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top: 50px;">
			<div class="col-lg-6 col-lg-offset-3">
				<form class="form-horizontal" style="background-color: #37BC9B;">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-5">
							<input type="email" class="form-control" id="inputEmail3"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="inputPassword3"
								placeholder="Password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label> <input type="checkbox"> Remember me
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Sign in</button>
						</div>
					</div>
				</form>

			</div>

		</div>


	</div>
	<%@include file="./WEB-INF/content/include/foot.jsp"%>
</body>
</html>