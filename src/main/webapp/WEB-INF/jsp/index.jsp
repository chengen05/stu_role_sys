<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>学工助手</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/jquery.contextMenu.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/animate.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/skins.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/ruoyi/css/ry-ui.css?v=3.4.0" rel="stylesheet"/>
</head>
<body class="fixed-sidebar full-height-layout gray-bg skin-blue" style="overflow: hidden">
<div id="wrapper">

    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close">
            <i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="logo">
				     <span class="logo-lg">智</span>
            	</li>
            	<li>
            		<div class="user-panel">
            			<a class="menuItem" title="个人中心" href="javascript:changeiframe('system/user/profile');"> 
            				
					        <div class="pull-left image">
					        <c:if test="${empty user.avatar}">
					      	  <img src="static/img/profile.jpg" class="img-circle" alt="User Image">
					        </c:if>
					        <c:if test="${not empty user.avatar}">
		                  		 <img src="${user.avatar}" class="img-circle" alt="User Image">
					        </c:if>
					        </div>
				        </a>
				        <div class="pull-left info">
				          <p>${user.userName}</p>
				          <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
				          <a href="logout" style="padding-left:5px;"><i class="fa fa-sign-out text-danger"></i> 注销</a>
				        </div>
				    </div>
            	</li>
                 <li class="active">
                    <a href="index"><i class="fa fa-home"></i> <span class="nav-label">&nbsp;主页</span> <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li class="active"><a class="menuItem" >通知通告</a></li>
                    </ul>
                </li>
              	<li>
              		<a href="#"><i class="fa fa-desktop"></i><span class="nav-label"> &nbsp;系统功能</span><span class="fa arrow"></span></a>
               	 	<ul class="nav nav-second-level">
               	 		<li> <a class="menuItem" href="javascript:changeiframe('system/user');">用户管理</a></li>
               	 		<li> <a class="menuItem" href="javascript:changeiframe('system/role')">角色管理</a></li>
               	 		<li> <a class="menuItem" href="javascript:changeiframe('system/menu')">菜单管理</a></li>
               	 		<li> <a class="menuItem" href="">院系管理</a></li>
               	 		<li> <a class="menuItem" href="">学生管理</a></li>
               	 	</ul>
              	</li>
                <li>
                    <a href="#"><i class="fa fa-desktop"></i><span class="nav-label">实例演示</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li> <a>弹框<span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
								<li><a class="menuItem" th:href="@{/demo/modal/dialog}">模态窗口</a></li>
								<li><a class="menuItem" th:href="@{/demo/modal/layer}">弹层组件</a></li>
								<li><a class="menuItem" th:href="@{/demo/modal/table}">弹层表格</a></li>
							</ul>
                        </li>
                        <li> <a>操作<span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
								<li><a class="menuItem" th:href="@{/demo/operate/table}">表格</a></li>
								<li><a class="menuItem" th:href="@{/demo/operate/other}">其他</a></li>
							</ul>
                        </li>
                        <li> <a>报表<span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
								<li><a class="menuItem" th:href="@{/demo/report/echarts}">百度ECharts</a></li>
								<li><a class="menuItem" th:href="@{/demo/report/peity}">peity</a></li>
								<li><a class="menuItem" th:href="@{/demo/report/sparkline}">sparkline</a></li>
								<li><a class="menuItem" th:href="@{/demo/report/metrics}">图表组合</a></li>
							</ul>
                        </li>
                        <li> <a>图标<span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
								<li><a class="menuItem" th:href="@{/demo/icon/fontawesome}">Font Awesome</a></li>
								<li><a class="menuItem" th:href="@{/demo/icon/glyphicons}">Glyphicons</a></li>
							</ul>
                        </li>
                        <li>
	                        <a href="#"><i class="fa fa-sitemap"></i> <span class="nav-label">四层菜单 </span><span class="fa arrow"></span></a>
	                        <ul class="nav nav-second-level collapse">
	                            <li>
	                                <a href="#" id="damian">三级菜单1<span class="fa arrow"></span></a>
	                                <ul class="nav nav-third-level">
	                                    <li>
	                                        <a href="#">四级菜单1</a>
	                                    </li>
	                                    <li>
	                                        <a href="#">四级菜单2</a>
	                                    </li>
	                                </ul>
	                            </li>
	                            <li><a href="#">三级菜单2</a></li>
	                        </ul>
	                    </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2" style="color:#FFF;" href="#" title="收起菜单">
                    	<i class="fa fa-bars"></i>
                    </a>
                </div>
                <ul class="nav navbar-top-links navbar-right welcome-message">
                 <li class="dropdown user-menu">
						<a href="javascript:void(0)" class="dropdown-toggle" data-hover="dropdown">
							您好:
							<span class="hidden-xs">${user.userName}</span>
						</a>
						<ul class="dropdown-menu">
							<li class="mt5">
								<a href="javascript:changeiframe('system/user/profile');" class="menuItem">
								<i class="fa fa-user"></i> 个人中心</a>
							</li>
							<li>
								<a onclick="resetPwd()" class="menuItem">
								<i class="fa fa-key"></i> 修改密码</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="logout">
								<i class="fa fa-sign-out"></i> 退出登录</a>
							</li>
						</ul>
					</li>
				   
                   
                </ul>
            </nav>
        </div>
     
                    
        <div class="row mainContent" id="content-main">
            <iframe class="iframe" name="iframe0" width="100%" height="100%" data-id="system/main"
                    src="system/main" frameborder="0" seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">© 2020 智能制造 Copyright </div>
        </div>
    </div>
    <!--右侧部分结束-->
</div>
<!-- js -->
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js" > </script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" /></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/metisMenu/jquery.metisMenu.js" /></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/slimscroll/jquery.slimscroll.min.js" /></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.contextMenu.min.js" /></script>
<script src="${pageContext.request.contextPath}/static/ajax/libs/blockUI/jquery.blockUI.js" /></script>
<script src="${pageContext.request.contextPath}/static/ajax/libs/fullscreen/jquery.fullscreen.js" /></script>
<script type="text/javascript"> 

/*用户管理-重置密码*/
function resetPwd() {
    var url =  'system/user/profile/resetPwd';
    $.modal.open("重置密码", url, '800', '500');
}

function changeiframe(url) {
	$(".iframe").attr("src",url);
}
</script>
</body>
</html>
