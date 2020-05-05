<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../../common.jsp"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色添加</title>
</head>
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-role-add">
			<div class="form-group">
				<label class="col-sm-3 control-label ">角色名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="roleName" id="roleName" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">权限字符：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="roleKey" id="roleKey" required>
					<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 控制器中定义的权限字符，如：@RequiresRoles("")</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">显示顺序：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="roleSort" id="roleSort" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">状态：</label>
				<div class="col-sm-8">
			        <label class="toggle-switch switch-solid">
                        <input type="checkbox" id="status" checked>
                        <span></span>
                    </label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">备注：</label>
				<div class="col-sm-8">
					<input id="remark" name="remark" class="form-control" type="text">
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
		var prefix = "/stu_work_sys/system/menu"
	    $(function() {
			var url = prefix + "/roleMenuTreeData";
			var options = {
				id: "menuTrees",
		        url: url,
		        check: { enable: true },
		        expandLevel: 0
		    };
			init(options);
		});
		
		$("#form-role-add").validate({
			rules:{
				onkeyup: false,
				roleName:{
					remote: {
		                url: prefix + "/checkRoleNameUnique",
		                type: "post",
		                dataType: "json",
		                data: {
		                	"roleName" : function() {
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
		                	"roleKey" : function() {
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
		
		function submitHandler() {
	        if ($("#form-role-add").validate.form()) {
	        	add();
	        }
	    }
	
		function add() {
			var roleName = $("input[name='roleName']").val();
			var roleKey = $("input[name='roleKey']").val();
			var roleSort = $("input[name='roleSort']").val();
			var status = $("input[id='status']").is(':checked') == true ? 0 : 1;
			var remark = $("input[name='remark']").val();
			var menuIds = $.tree.getCheckedNodes();
			$.ajax({
				cache : true,
				type : "POST",
				url : prefix + "/add",
				data : {
					"roleName": roleName,
					"roleKey": roleKey,
					"roleSort": roleSort,
					"status": status,
					"remark": remark,
					"menuIds": menuIds
				},
				async : false,
				error : function(request) {
					msg("系统错误","warning");
				},
				success : function(data) {
					$.operate.successCallback(data);
				}
			});
		}
	</script>
</body>
</html>
