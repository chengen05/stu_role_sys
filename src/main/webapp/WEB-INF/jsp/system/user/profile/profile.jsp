<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ include file="../../../common.jsp"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息</title>
</head>
<body class="gray-bg" style="font: 14px Helvetica Neue, Helvetica, PingFang SC, 微软雅黑, Tahoma, Arial, sans-serif !important;">
    <input id="userId" name="userId" type="hidden" value="${user.userId}" />
    <section class="section-content">
    <div class="row">
        <div class="col-sm-3 pr5">
            <div class="ibox float-e-margins">
                <div class="ibox-title ibox-title-gray dashboard-header gray-bg">
                    <h5>个人资料</h5>
                </div>
                <div class="ibox-content">
                    <div class="text-center">
                        <p><img class="img-circle img-lg" src="${user.avatar}"></p>
                        <p><a href="javascript:avatar()">修改头像</a></p>
                    </div>
                    <ul class="list-group list-group-striped">
                        <li class="list-group-item"><i class="fa fa-user"></i>
                            <b class="font-noraml">登录名称：</b>
                            <p class="pull-right">${user.loginName}</p>
                        </li>
                          <li class="list-group-item"><i class="fa fa-group"></i>
                            <b  class="font-noraml">所属学院：</b>
                            <p class="pull-right" >${depart}</p>
                        </li>
                          <li class="list-group-item"><i class="fa fa-group"></i>
                            <b  class="font-noraml">所属班级：</b>
                            <p class="pull-right" >${clazz}</p>
                        </li>
                        <li class="list-group-item"><i class="fa fa-phone"></i>
                            <b  class="font-noraml">手机号码：</b>
                            <p class="pull-right">${user.phoneNumber}</p>
                        </li>
                      
                        <li class="list-group-item"><i class="fa fa-envelope-o"></i>
                            <b  class="font-noraml">邮箱地址：</b>
                            <p class="pull-right" >${user.email}</p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        
        <div class="col-sm-9 about">
            <div class="ibox float-e-margins">
                <div class="ibox-title ibox-title-gray dashboard-header">
                    <h5>基本资料</h5>
                </div>
                <div class="ibox-content">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#user_info" data-toggle="tab" aria-expanded="true">基本资料</a></li>
                            <li><a href="#modify_password" data-toggle="tab" aria-expanded="false">修改密码</a></li>
                        </ul>
                        <div class="tab-content">
                            <!--用户信息-->
                            <div class="tab-pane active" id="user_info">
                                <form class="form-horizontal" id="form-user-edit">
                                    <!--隐藏ID-->
                                    <input name="userId" id="userId" value="${user.userId}" type="hidden">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">用户名称：</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="userName" value="${user.userName}" placeholder="请输入用户名称">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">手机号码：</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="phoneNumber" maxlength="11" value="${user.phoneNumber}" placeholder="请输入手机号码">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">邮箱：</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="email" value="${user.email}" placeholder="请输入邮箱">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">性别：</label>
                                        <div class="col-sm-10">
                                            <div class="radio-box">
                                            	<c:if test="${user.sex == '0'}">
                                            		<input type="radio" id="radio1" checked="checked"  name="sex" value="0">
                                            	</c:if>
												<c:if test="${user.sex != '0'}">
													<input type="radio" id="radio1"  name="sex" value="0">
												</c:if>
												<label for="radio1">男</label>
											</div>
											<div class="radio-box">
												<c:if test="${user.sex == '1'}">
													<input type="radio" id="radio2" checked="checked" name="sex" value="1">
												</c:if>
												<c:if test="${user.sex != '1'}">
													<input type="radio" id="radio2"  name="sex" value="1">
												</c:if>
												<label for="radio2">女</label>
											</div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="button" class="btn btn-sm btn-primary" onclick="submitUserInfo()"><i class="fa fa-check"></i>保 存</button>&nbsp;
                                            <button type="button" class="btn btn-sm btn-danger" onclick="closeItem()"><i class="fa fa-reply-all"></i>关 闭 </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            
                            <!--修改密码-->
                            <div class="tab-pane" id="modify_password">
                                <form class="form-horizontal" id="form-user-resetPwd">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">旧密码：</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="oldPassword" name="oldPassword" placeholder="请输入旧密码">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">新密码：</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" name="newPassword" id="newPassword" placeholder="请输入新密码">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">确认密码：</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" name="confirmPassword" placeholder="请确认密码">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="button" class="btn btn-sm btn-primary" onclick="submitChangPassword()"><i class="fa fa-check"></i>保 存</button>&nbsp;
                                            <button type="button" class="btn btn-sm btn-danger" onclick="closeItem()"><i class="fa fa-reply-all"></i>关 闭 </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	</section>
    
    <script>
    var prefix = "/stu_work_sys/system/user/profile";
	    /*用户管理-头像*/
	    function avatar() {
	        var url = 'system/user/profile/avatar';
	       open("修改头像", url);
	    }
	    
	    /*用户信息-修改*/
	    $("#form-user-edit").validate({
			onkeyup: false,
			rules:{
				userName:{
					required:true,
				},
				email:{
					required:true,
		            email:true,
		            remote: {
		                url:  prefix + "/checkEmailUnique",
		                type: "post",
		                dataType: "json",
		                data: {
		                	"userId": function() {
		                        return $("#userId").val();
		                    },
		        			"email": function() {
		                        return $(".email").val();
		                    }
		                },
		                dataFilter: function (data, type) {
		                	return data;
		                }
		            }
				},
				phonenumber:{
					required:true,
					isPhone:true,
		            remote: {
		                url: prefix + "/checkPhoneUnique",
		                type: "post",
		                dataType: "json",
		                data: {
		                	"userId": function() {
		                		return $("#userId").val();
		                    },
		        			"phonenumber": function() {
		                        return $("#phonenumber").val();
		                    }
		                },
		                dataFilter: function (data, type) {
		                	return data;
		                }
		            }
				},
			},
			messages: {
				"userName": {
	                required: "请输入用户名称",
	            },
				"email": {
					required: "请输入邮箱",
		            remote: "Email已经存在"
		        },
				"phonenumber":{
					required: "请输入手机号码",
		        	remote: "手机号码已经存在"
				}
		    },
		    focusCleanup: true
		});
		
		function submitUserInfo() {
			var checkform = $("#form-user-edit").validate().form();
			if(checkform){
				var data = $('#form-user-edit').serialize();
				submit(prefix + "/update","post","json",data,1);
			}
	    	   console.log();
	        //	$.operate.saveModal(ctx + "system/user/profile/update", $('#form-user-edit').serialize());
	        
	    }
	    
	    /*用户管理-修改密码*/
	    $("#form-user-resetPwd").validate({
	    	onkeyup: false,
			rules:{
				oldPassword:{
					required:true,
					remote: {
	                    url: "/checkPassword",
	                    type: "get",
	                    dataType: "json",
	                    data: {
	                        oldPassword: function() {
	                            return $("#oldPassword").val();
	                        }
	                    }
	                }
				},
				newPassword: {
	                required: true,
	                minlength: 6,
	    			maxlength: 20
	            },
	            confirmPassword: {
	                required: true,
	                equalTo: "#newPassword"
	            }
			},
			messages: {
	            oldPassword: {
	                required: "请输入原密码",
	                remote: "原密码错误"
	            },
	            newPassword: {
	                required: "请输入新密码",
	                minlength: "密码不能小于6个字符",
	                maxlength: "密码不能大于20个字符"
	            },
	            confirmPassword: {
	                required: "请再次输入新密码",
	                equalTo: "两次密码输入不一致"
	            }

	        },
	        focusCleanup: true
		});
		
		function submitChangPassword () {
			var check = $("#form-user-resetPwd").validate().form();
	        if (check) {
	        	var url = prefix + "/resetPwd";
	        	$.ajax({
					url: url,
					dataType:"json",
					method:"post",
					data:$("#form-user-resetPwd").serializeArray(),
					success: function(result){
						if(result.code == 200){
							layer.confirm('修改成功...请重新登录', {icon: 1, title:'提示',btn:["确定"]}, function(index){
							    layer.close(index);
							    window.location.href="/stu_work_sys/logout";
							});
							
						}else{
							msg("修改失败","error");
						}
					}
				});	
	        }
	    }
	</script>
</body>
</html>
