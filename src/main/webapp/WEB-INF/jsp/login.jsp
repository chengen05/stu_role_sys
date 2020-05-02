<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录学生管理系统</title>
    <meta name="description" content="学生管理系统">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/login.min.css"  rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/ruoyi/css/ry-ui.css" rel="stylesheet"/>
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <link rel="shortcut icon" href="../static/favicon.ico" />
 	<script type="text/javascript">
 		if(window.top!==window.self){window.top.location=window.location};
 	</script>
</head>


<body class="signin">

    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1><img alt="[ 若依 ]" src="../static/ruoyi.png" ></h1>
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>学生管理系统</strong></h4>
                    <ul class="m-b">
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> SpringBoot</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> Mybatis</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> Shiro</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> Thymeleaf</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> Bootstrap</li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-5">
                <form id="signupForm">
                    <h4 class="no-margins">登录：</h4>
                    <input type="text"     name="username" class="form-control uname"     placeholder="用户名"    />
                    <input type="password" name="password" class="form-control pword"     placeholder="密码"   />
					<div class="row m-t" >
						<div class="col-xs-6">
						    <input type="text" name="validateCode" class="form-control code" placeholder="验证码" maxlength="5" autocomplete="off">
						</div>
						<div class="col-xs-6">
							<a href="javascript:void(0);" title="点击更换验证码">
								<img src="" class="imgcode" width="85%"/>
							</a>
						</div>
					</div>
                    <div class="checkbox-custom" >
				        <input type="checkbox" id="rememberme" name="rememberme"> <label for="rememberme">记住我</label>
				    </div>
                    <button class="btn btn-success btn-block" id="btnSubmit" data-loading="正在验证登录，请稍后...">登录</button>
                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2020 All Rights Reserved.智能制造陈根  <br>
            </div>
        </div>
    </div>
<!-- 全局js -->
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js" ></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" ></script>
<!-- 验证插件 -->
<script src="${pageContext.request.contextPath}/static/ajax/libs/validate/jquery.validate.min.js" ></script>
<script src="${pageContext.request.contextPath}/static/ajax/libs/validate/messages_zh.min.js" ></script>
<script src="${pageContext.request.contextPath}/static/ajax/libs/layer/layer.min.js"></script>
<script src="${pageContext.request.contextPath}/static/ajax/libs/blockUI/jquery.blockUI.js" ></script>
<script src="${pageContext.request.contextPath}/static/ruoyi/js/ry-ui.js"></script>
<script src="${pageContext.request.contextPath}/static/login.js" ></script>
</body>
</html>
    