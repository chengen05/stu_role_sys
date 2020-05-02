<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 <%@ include file="../../common.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编辑</title>
<link href="${pageContext.request.contextPath}/static/ajax/libs/select2/select2.min.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/static/ajax/libs/select2/select2-bootstrap.css" rel="stylesheet"/>
</head>
<script src="${pageContext.request.contextPath}/static/ajax/libs/select2/select2.min.js"></script>
<body>
    <div class="main-content">
        <form id="form-user-edit" class="form-horizontal">
        	<input name="userId" type="hidden" id="userId" value="${user.userId}"/>
            <h4 class="form-header h4">基本信息</h4>
            <div class="row">
            	<div class="col-sm-6">
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><span style="color: red; ">*</span>用户名称：</label>
                        <div class="col-sm-8">
                            <input name="userName" placeholder="请输入用户名称" class="form-control" type="text" maxlength="30" value="${user.userName}" required>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><span style="color: red; ">*</span>归属学院：</label>
                        <div class="col-sm-8">
                            <div class="input-group">
                            	<select id="depart" class="form-control" >
                            		<c:forEach items="${departs}" var="de">
                            			<c:if test="${user.departId == de.departId}">
                            				<option value="${de.departId}"  selected>${de.departName}</option>
                            			</c:if>
                            			<c:if test="${user.departId != de.departId}">
                            				<option value="${de.departId}" >${de.departName}</option>
                            			</c:if>
                            		</c:forEach>
								</select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><span style="color: red; ">*</span>手机号码：</label>
                        <div class="col-sm-8">
                            <input name="phoneNumber" placeholder="请输入手机号码" class="form-control" type="text" maxlength="11" value="${user.phoneNumber}" required>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><span style="color: red; ">*</span>邮箱：</label>
                        <div class="col-sm-8">
                            <input name="email" class="form-control email" type="text" maxlength="50" placeholder="请输入邮箱" value="${user.email}"required>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><span style="color: red; ">*</span>登录账号：</label>
                        <div class="col-sm-8">
                            <input name="loginName" placeholder="请输入登录账号" class="form-control" type="text" maxlength="30" value="${user.loginName}"required>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="col-sm-4 control-label"><span style="color: red; ">*</span>班级：</label>
                        <div class="col-sm-8">
                              <select id="choseclazz" class="form-control select2-multiple">
							</select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">用户性别：</label>
                        <div class="col-sm-8">
                            <select name="sex" class="form-control m-b" >
				               	<option value="1">女</option>
				               	<option value="0">男</option>
				            </select>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">用户状态：</label>
                        <div class="col-sm-8">
                            <label class="toggle-switch switch-solid">
	                            <input type="checkbox" id="status" checked>
	                            <span></span>
	                        </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
            	<div class="col-sm-12">
                    <div class="form-group">
                        <label class="col-xs-2 control-label">角色：</label>
                        <div class="col-xs-10">
                        
                          <c:forEach items="${roles}" var="roleitem">
                          		<c:if test="${user.roles[0].roleId == roleitem.roleId}">
		                            <label  class="check-box">
										<input name="role" type="radio"  value="${roleitem.roleId}" checked="checked"> ${roleitem.roleName}
									</label>
								</c:if>
								<c:if test="${user.roles[0].roleId != roleitem.roleId}">
		                            <label  class="check-box">
										<input name="role" type="radio"  value="${roleitem.roleId}"> ${roleitem.roleName}
									</label>
								</c:if>
							</c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
      
    <div class="row">
        <div class="col-sm-offset-5 col-sm-10">
            <button type="button" class="btn btn-sm btn-primary" onclick="submitHandler()"><i class="fa fa-check"></i>保 存</button>&nbsp;
            <button type="button" class="btn btn-sm btn-danger" onclick="closeItem()"><i class="fa fa-reply-all"></i>关 闭 </button>
        </div>
    </div>
	<script>
	    var prefix = "/stu_work_sys/system/user";
	
        $("#form-user-edit").validate({
        	onkeyup: false,
        	rules:{
        		loginName:{
        			minlength: 2,
        			maxlength: 20,
        			remote: {
                        url: prefix + "/checkLoginNameUnique",
                        type: "post",
                        dataType: "json",
                        data: {
                        	name : function() {
                                return $("#loginName").val();
                            }
                        },
                        dataFilter: function(data, type) {
                        	return data;
                        }
                    }
        		},
        		password:{
        			minlength: 5,
        			maxlength: 20
        		},
        		email:{
                    email:true,
                    remote: {
                        url: prefix + "/checkEmailUnique",
                        type: "post",
                        dataType: "json",
                        data: {
                            name: function () {
                                return $("#email").val();
                            }
                        },
                        dataFilter: function (data, type) {
                        	return data;
                        }
                    }
        		},
        		phoneNumber:{
        			isPhone:true,
                    remote: {
                        url: prefix + "/checkPhoneUnique",
                        type: "post",
                        dataType: "json",
                        data: {
                            name: function () {
                                return $("#phoneNumber").val();
                            }
                        },
                        dataFilter: function (data, type) {
                        	return data;
                        }
                    }
        		},
        	},
        	messages: {
                "loginName": {
                    remote: "用户已经存在"
                },
        		"email": {
                    remote: "Email已经存在"
                },
        		"phoneNumber":{
                	remote: "手机号码已经存在"
        		}
            },
            focusCleanup: true
        });
        
        function submitHandler() {
        	var checkform = $("#form-user-edit").validate().form();
	        if (checkform) {
	        	var data = $("#form-user-edit").serializeArray();
	        	var status = $("input[id='status']").is(':checked') == true ? 0 : 1;
	        	var roleIds = $("input[name='role']:checked").val();
	        	var clazzIds = $("#choseclazz option:selected").val();
	        	var departId = $("#depart option:selected").val();
	        	data.push({"name": "status", "value": status});
	        	data.push({"name": "roleIds", "value": roleIds});
	        	data.push({"name": "clazzId", "value": clazzIds});
	        	data.push({"name": "departId","value":departId});
	        	$.ajax({
	        		url:prefix + "/updatesave",
	        		type:"post",
	        		dateType:"json",
	        		data:data,
	        		beforeSend:function(){
	        			$.blockUI({ message: '<div class="loaderbox"><div class="loading-activity"></div>正在处理中，请稍后...</div>' });
	        		},
	        		success: function(result){
	        			if(result.code == 200){
	        				msgReload("保存成功,正在刷新数据请稍后……", "success");
	        			}else if(result.code == 301){
	        				 msg(result.msg,"warning");
	        			}else{
	        				msg(result.msg,"error");
	        			}
	        			closeblock();
	        		}
	        	})
	        }
	    }

		$(function() {
			/** 格式化数据clazzs */
			var datac = $.map(${clazzs},function(clazz){
				return {id:clazz.clazzId,text:clazz.clazzName}; 
				});
            $('#choseclazz').select2({
                placeholder:"请选择班级",
                allowClear: true,
                data:datac
            }).val("${user.clazzId}").trigger("change");
          
        });
    </script>
</body>
</html>
