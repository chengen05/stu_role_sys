<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 <%@ include file="../../common.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色编辑</title>
</head>
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-role-edit" >
			<input id="roleId" name="roleId" type="hidden" value="${sysRole.roleId}"/>
			<div class="form-group">
				<label class="col-sm-3 control-label ">角色名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="roleName" id="roleName" value="${sysRole.roleName}" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">权限字符：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="roleKey" id="roleKey" value="${sysRole.roleKey}" required>
					<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 控制器中定义的权限字符，如：@RequiresRoles("")</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">显示顺序：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="roleSort" id="roleSort" value="${sysRole.orderNum}" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">状态：</label>
				<div class="col-sm-8">
					<label class="toggle-switch switch-solid">
                        <input type="checkbox" id="status" checked="${sysRole.status == '0' ? true : false}">
                        <span></span>
                    </label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">备注：</label>
				<div class="col-sm-8">
					<input id="remark" name="remark" class="form-control" type="text" value="${sysRole.remark}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单权限</label>
				<div class="col-sm-8">
					<div id="menuTrees" class="ztree"></div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	var prefix = "/stu_work_sys/system/role";
	     $(function() {
			var url = "/stu_work_sys/system/menu/roleMenuTree?roleId=" + $("#roleId").val();
			var options = {
				id: "menuTrees",
		        url: url,
		        check: { enable: true },
		        expandLevel: 0
		    };
			$.tree.init(options);
		});
	
		$("#form-role-edit").validate({
			onkeyup: false,
			rules:{
				roleName:{
					remote: {
		                url: prefix + "/checkRoleNameUnique",
		                type: "post",
		                dataType: "json",
		                data: {
							"roleId": function() {
							    return $("#roleId").val();
							},
							"roleName": function() {
							    return $("#roleName").val();
							}
		                },
		                dataFilter: function(data, type) {
		                	return data;
		                }
		            }
				},
				roleKey:{
					remote: {
		                url: prefix + "/checkRoleKeyUnique",
		                type: "post",
		                dataType: "json",
		                data: {
							"roleId": function() {
								return $("#roleId").val();
							},
							"roleKey": function() {
							    return $("#roleKey").val();
							}
		                },
		                dataFilter: function(data, type) {
		                	return data;
		                }
		            }
				},
				roleSort:{
					digits:true
				},
			},
			messages: {
		        "roleName": {
		            remote: "角色名称已经存在"
		        },
		        "roleKey": {
		            remote: "角色权限已经存在"
		        }
		    },
		    focusCleanup: true
		});

		function edit() {
			var roleId = $("input[name='roleId']").val();
			var roleName = $("input[name='roleName']").val();
			var roleKey = $("input[name='roleKey']").val();
			var roleSort = $("input[name='roleSort']").val();
			var status = $("input[id='status']").is(':checked') == true ? 0 : 1;
			var remark = $("input[name='remark']").val();
			var menuIds = $.tree.getCheckedNodes();
			$.ajax({
				cache : true,
				type : "POST",
				url : prefix + "system/role/edit",
				data : {
					"roleId": roleId,
					"roleName": roleName,
					"roleKey": roleKey,
					"roleSort": roleSort,
					"status": status,
					"remark": remark,
					"menuIds": menuIds
				},
				async : false,
				error : function(request) {
					msg("系统错误","error");
				},
				success : function(data) {
					if(result.code == 200){
        				msgReload("成功,正在刷新数据请稍后……", "success");
        			}else if(result.code == 301){
        				 msg(result.msg,"warning");
        			}else{
        				msg(result.msg,"error");
        			}
				}
			});
		}
		
		function submitHandler() {
	        if ($.validate.form()) {
	        	edit();
	        }
	    }
	</script>
</body>
</html>
