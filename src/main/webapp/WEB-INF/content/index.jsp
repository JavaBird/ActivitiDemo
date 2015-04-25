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

</head>
<body>
	 <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar" style="background-color: #656D78;">
        	
         <div class="loginInfo">
         		<div class="thumb">
         			<img class="img-circle" alt="" src="resources/image/128.jpg">
         		</div>
         		<div class="info">
                                <p>John Doe</p>
                                <ul class="list-inline list-unstyled">
                                    <li><a  data-toggle="tooltip" data-placement="top" title="个人信息"   href="extra-profile.html" ><i class="fa fa-user fa-lg"></i></a>
                                    </li>
                                    <li><a  data-toggle="tooltip" data-placement="top" title="邮箱" href="email-inbox.html" ><i class="fa fa-envelope fa-lg"></i></a>
                                    </li>
                                    <li><a data-toggle="tooltip" data-placement="top" title="设置" href="email-inbox.html"><i class="fa fa-cog fa-lg"></i></a>
                                    </li>
                                    <li><a data-toggle="tooltip" data-placement="top" title="退出" href="email-inbox.html"><i class="fa fa-sign-out fa-lg"></i></a>
                                    </li>
                                </ul>
                </div>
         </div>
        
        
          <div id="accordion2" class="sidebar-menu">
          			<div class="mainMenu">
          				<a class="">
          				  <i class="fa fa-tachometer fa-fw fa-lg"></i> <span>工作台</span>
          				</a>
          			</div>
					<div class="accord">
						<a data-toggle="collapse"  data-parent="#accordion2"
							aria-expanded="false" class=" menu-first collapsed"
							href="#userMeun"><i class="fa fa-cog fa-fw fa-lg" ></i> <span>系统设置</span><span class="icon"><i class="fa fa-angle-double-left fa-lg nicon"></i></span></a>
						<ul class="menu-second collapse" id="userMeun"
							style="height: 0px;">
							<li><a href="#"><i class="fa fa-arrow-circle-right fa-fw"></i> <span>用户管理</span></a></li>
							<li><a href="#"><i class="fa fa-arrow-circle-right fa-fw"></i> <span>角色管理</span></a></li>
							<li><a href="#"><i class="fa fa-arrow-circle-right fa-fw"></i> <span>权限管理</span></a></li>
							<li><a href="#"><i class="fa fa-arrow-circle-right fa-fw"></i> <span>菜单管理</span></a></li>
						</ul>
					</div>
					<div class="accord">
						<a data-toggle="collapse" data-parent="#accordion2"
							aria-expanded="false" class=" menu-first"
							href="#articleMenu"><i class="fa fa-random fa-fw fa-lg"></i> <span>流程管理</span><span class="icon"><i class="fa fa-angle-double-left fa-lg nicon"></i></span></a>
						<ul class="menu-second collapse" id="articleMenu"
							style="height: auto;">
							<li><a href="#"><i class="fa fa-arrow-circle-right fa-fw"></i> <span>部署流程</span></a></li>
							<li><a href="#"><i class="fa fa-arrow-circle-right fa-fw"></i> <span>流程管理</span></a></li>
						</ul>

					</div>
				</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          sssssss
        </div>
      </div>
    </div>

	<%@include file="./include/foot.jsp"%>
</body>
<script type="text/javascript">

		 $(function (){ 
			
			 $('[data-toggle="tooltip"]').tooltip();
			 
			 $('.accord > a').on('click',function(){
			
				 $('.accord > a').removeClass('menu-first-selected');
				 
				 $('.accord > a').find('.nicon').removeClass('fa-angle-double-down ').addClass('fa-angle-double-left');
				 
				 $(this).addClass('menu-first-selected');
				 
				 var flag = $(this).attr('aria-expanded');
				 if(flag == 'true'){
					 $(this).find('.nicon').removeClass('fa-angle-double-down').addClass('fa-angle-double-left');
				 }else {
					 $(this).find('.nicon').removeClass('fa-angle-double-left').addClass('fa-angle-double-down');
					 
				 }
				 
			 })
			 
		   });
		
		
		
</script>
</html>