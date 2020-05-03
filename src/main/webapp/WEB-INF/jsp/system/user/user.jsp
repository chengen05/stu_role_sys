<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../common.jsp"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<script src="${pageContext.request.contextPath}/static/customize/table-custom.js"></script>
</head>
<body>
		<div class="ui-layout-center">
		<div class="container-div">
			<div class="row">
				<div class="col-sm-12 search-collapse">
					<form id="user-form">
						<div class="select-list">
							<ul>
								<li>
									登录名称：<input type="text" name="loginName"/>
								</li>
								<li>
									手机号码：<input type="text" name="phoneNumber"/>
								</li>
								
								<li>学院:<select name="departId">
											<option value="" selected></option>
											<c:forEach items="${departs}" var="de">
                            					<option value="${de.departId}">${de.departName}</option>
                            				</c:forEach>
												
										</select>
								</li>
								<li>
									用户状态：<select name="status">
										<option value="">所有</option>
										<option value="0">正常</option>
										<option value="1">停用</option>
									</select>
								</li>
								<li>
									<a class="btn btn-primary btn-rounded btn-sm" onclick="$.table.search()"><i class="fa fa-search"></i>&nbsp;搜索</a>
								    <a class="btn btn-warning btn-rounded btn-sm" onclick="reset()"><i class="fa fa-refresh"></i>&nbsp;重置</a>
								</li>
							</ul>
						</div>
					</form>
				</div>
				
		        <div class="btn-group-sm" id="toolbar" role="group">
		        	<a class="btn btn-success" onclick="add()" shiro:hasPermission="system:user:add">
		                <i class="fa fa-plus"></i> 新增
		            </a>
		            <a class="btn btn-danger multiple" onclick="removeAll()" shiro:hasPermission="system:user:remove">
		                <i class="fa fa-remove"></i> 删除
		            </a>
		            <a class="btn btn-info" onclick="$.table.importExcel()" shiro:hasPermission="system:user:import">
			            <i class="fa fa-upload"></i> 导入
			        </a>
		            <a class="btn btn-warning" onclick="$.table.exportExcel()" shiro:hasPermission="system:user:export">
			            <i class="fa fa-download"></i> 导出
			        </a>
		        </div>
		        
		        <div class="col-sm-12 select-table table-striped">
				    <table id="bootstrap-table"></table>
				</div>
			</div>
		</div>
	</div>
</body>

	<script type="text/javascript">
		

	/** dom后加载 */
	$(function(){
		inittable();
	});	
	
	
	function inittable(){
		var options = {
				url: "${pageContext.request.contextPath}/system/user/list",
				modalName: "用户",
				columns:[{
					checkbox:true
				},{
					field: 'userId',
					title: "用户ID"
				},{
					field:'loginName',
					title:'登录名',
					sortable: true
				},{
					field:"userName",
					title:"姓名"
				},{
					field:"depart.departName",
					title:"学院"
				},{
					field:"clazz.clazzName",
					title:"班级"
				},{
					field:"phoneNumber",
					title:"电话号码"
				},{
					
					title:'用户状态',
					align:'center',
					formatter: function(value, row, index){
						return statusTools(row);
					}
				},{
			        title: '操作',
			        align: 'center',
			        formatter: function(value, row, index) {
			             var actions = [];
			             actions.push('<a class="btn btn-success btn-xs " href="javascript:void(0)" onclick="edit(\'' + row.userId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
			             actions.push('<a class="btn btn-danger btn-xs " href="javascript:void(0)" onclick="$.operate.remove(\'' + row.userId + '\')"><i class="fa fa-remove"></i>删除</a> ');
			             actions.push('<a class="btn btn-info btn-xs " href="javascript:void(0)" onclick="resetPwd(\'' + row.userId + '\')"><i class="fa fa-key"></i>重置</a>');
			             return actions.join('');
			        }
				}]
			};
			$.table.init(options);
		}
    /**  重置表单刷新数据*/
    function reset(){
    	$("#user-form")[0].reset();
    	$("#bootstrap-table").bootstrapTable("destroy");
    	inittable();
    }
	/* 用户状态显示 */
	function statusTools(row) {
	    if (row.status == 1) {
			return '<i class=\"fa fa-toggle-off text-info fa-2x\" onclick="enable(\'' + row.userId + '\')"></i> ';
		} else {
			return '<i class=\"fa fa-toggle-on text-info fa-2x\" onclick="disable(\'' + row.userId + '\')"></i> ';
		}
	}
	/** 弹出添加模块 */
	function add(){
		 open("添加系统用户" , "/stu_work_sys/system/user/add");
	}
	
	/** 修改信息 */
	function edit(id){
		if(id != null && id != undefined){
			open("修改系统用户","/stu_work_sys/system/user/update?id="+id+"");
		}else{
			 msg("请选择一条记录","warning");
			 return;
		}
		
	}

	 /** 批量删除信息 */
     function removeAll() {
		var rows = $("#bootstrap-table").bootstrapTable("getAllSelections");
		if (rows.length == 0) {
			msg("请至少选择一条记录","warning");
			return;
		}
		layer.confirm("确认要删除选中的" + rows.length + "条数据吗?",{icon:3,title:"系统提示",btn:["确定","取消"]}, function(index) {
			var url = "/stu_work_sys/system/user/remove";
			var rowid = $.map(rows,function(item){
				return item.userId;
			}) ;
			rowid = {"ids":rowid.join()};
			layer.close(index);
			submit(url, "post", "json", rowid,0);
		}); 
		
    }
	</script>
</html>