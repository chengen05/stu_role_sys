<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../common.jsp"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
</head>
<body class="gray-bg">
	<div class="container-div">
		<div class="row">
			<div class="col-sm-12 search-collapse">
				<form id="role-form">
					<div class="select-list">
						<ul>
							<li>
								角色名称：<input type="text" name="roleName"/>
							</li>
							<li>
								权限字符：<input type="text" name="roleKey"/>
							</li>
							<li>
								角色状态：<select name="status">
									<option value="">所有</option>
									
								</select>
							</li>
							<li>
								<a class="btn btn-primary btn-rounded btn-sm" onclick="search()"><i class="fa fa-search"></i>&nbsp;搜索</a>
							    <a class="btn btn-warning btn-rounded btn-sm" onclick="reset()"><i class="fa fa-refresh"></i>&nbsp;重置</a>
							</li>
						</ul>
					</div>
				</form>
			</div>
		
			<div class="btn-group-sm" id="toolbar" role="group">
				<a class="btn btn-success" onclick="add()" shiro:hasPermission="system:role:add">
	                <i class="fa fa-plus"></i> 新增
	            </a>
	            <a class="btn btn-primary single disabled" onclick="edit()" shiro:hasPermission="system:role:edit">
		            <i class="fa fa-edit"></i> 修改
		        </a>
				<a class="btn btn-danger multiple disabled" onclick="removeAll()" shiro:hasPermission="system:role:remove">
		            <i class="fa fa-remove"></i> 删除
		        </a>
	        </div>
	        
	        <div class="col-sm-12 select-table table-striped">
			    <table id="bootstrap-table" data-mobile-responsive="true"></table>
			</div>
		</div>
	</div>
	<script type="text/javascript" >
		
		var prefix ="/stu_work_sys/system/role";
		

		$(function() {
		    var options = {
		        url: prefix + "/list",
		        sortName: "roleSort",
		        modalName: "角色",
		        columns: [{
		            checkbox: true
		        },
		        {
		            field: 'roleId',
		            title: '角色编号'
		        },
		        {
		            field: 'roleName',
		            title: '角色名称',
		            sortable: true
		        },
		        {
		            field: 'roleKey',
		            title: '权限字符',
		            sortable: true
		        },
		        {
		            field: 'orderNum',
		            title: '显示顺序',
		            sortable: true
		        },
		        {
		        	
		        	title: '角色状态',
		        	align: 'center',
		        	formatter: function (value, row, index) {
		        		return statusTools(row);
		        	}
		        },
		        {
		            title: '操作',
		            align: 'center',
		            formatter: function(value, row, index) {
		                var actions = [];
		                actions.push('<a class="btn btn-success btn-xs" href="javascript:void(0)" onclick="$.operate.edit(\'' + row.roleId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
		                actions.push('<a class="btn btn-primary btn-xs" href="javascript:void(0)" onclick="authDataScope(\'' + row.roleId + '\')"><i class="fa fa-check-square-o"></i>数据权限</a> ');
		                actions.push('<a class="btn btn-info btn-xs" href="javascript:void(0)" onclick="authUser(\'' + row.roleId + '\')"><i class="fa fa-user"></i>分配用户</a> ');
		                actions.push('<a class="btn btn-danger btn-xs" href="javascript:void(0)" onclick="$.operate.remove(\'' + row.roleId + '\')"><i class="fa fa-remove"></i>删除</a> ');
		                return actions.join('');
		            }
		        }]
		    };
		    $.table.init(options);
		});
		
		/* 角色管理-分配数据权限 */
		function authDataScope(roleId) {
		    var url = prefix + '/authDataScope/' + roleId;
		    open("分配数据权限", url);
		}
		
		/* 角色管理-分配用户 */
		function authUser(roleId) {
		    var url = prefix + '/authUser/' + roleId;
		    $.modal.openTab("分配用户", url);
		}
		
		/* 角色状态显示 */
		function statusTools(row) {
		    if (row.status == 1) {
    			return '<i class=\"fa fa-toggle-off text-info fa-2x\" onclick="enable(\'' + row.roleId + '\')"></i> ';
    		} else {
    			return '<i class=\"fa fa-toggle-on text-info fa-2x\" onclick="disable(\'' + row.roleId + '\')"></i> ';
    		}
		}
		
		/* 角色管理-停用 */
		function disable(roleId) {
			$.modal.confirm("确认要停用角色吗？", function() {
				$.operate.post(prefix + "/changeStatus", { "roleId": roleId, "status": 1 });
		    })
		}

		/* 角色管理启用 */
		function enable(roleId) {
			$.modal.confirm("确认要启用角色吗？", function() {
				$.operate.post(prefix + "/changeStatus", { "roleId": roleId, "status": 0 });
		    })
		}
		/* 弹出添加模块*/
		function add(){
			open("添加角色",prefix + "/add");
		}
	</script>
</body>
