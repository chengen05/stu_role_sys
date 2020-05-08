<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../common.jsp"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统菜单</title>
</head>
<body class="gray-bg">
    <div class="container-div">
		<div class="row">
			<div class="col-sm-12 search-collapse">
				<form id="menu-form">
					<div class="select-list">
						<ul>
							<li>
								菜单名称：<input type="text" name="menuName"/>
							</li>
							<li>
								菜单状态：<select name="visible">
									<option value="">所有</option>
									<option value="0">显示</option>
									<option value="1">隐藏</option>
								</select>
							</li>
							<li>
								<a class="btn btn-primary btn-rounded btn-sm" onclick="$.treeTable.search()"><i class="fa fa-search"></i>&nbsp;搜索</a>
								<a class="btn btn-warning btn-rounded btn-sm" onclick="reset()"><i class="fa fa-refresh"></i>&nbsp;重置</a>
							</li>
						</ul>
					</div>
				</form>
			</div>
                
            <div class="btn-group-sm" id="toolbar" role="group">
		        <a class="btn btn-success" onclick="add('x')" shiro:hasPermission="system:menu:add">
                    <i class="fa fa-plus"></i> 新增
                </a>
	        </div>
       		 <div class="col-sm-12 select-table table-striped">
	            <table id="bootstrap-tree-table"></table>
	        </div>
	    </div>
	</div>
	
	<script type="text/javascript">
	
		var prefix =  "/stu_work_sys/system/menu";

		$(function() {
		    var options = {
		        code: "menuId",
		        parentCode: "parentId",
		        uniqueId: "menuId",
		        expandAll: false,
		        expandFirst: false,
		        url: prefix + "/list",
		        modalName: "菜单",
		        columns: [{
                    field: 'selectItem', 
                    radio: true
                 },
                 {
		            title: '菜单名称',
		            field: 'menuName',
		            width: '20%',
		            formatter: function(value, row, index) {
		                if (row.icon != null) {
		                    return row.menuName;
		                } else {
		                    return '<i class="' + row.icon + '"></i> <span class="nav-label">' + row.menuName + '</span>';
		                }
		            }
		        },
		        {
		            field: 'orderNum',
		            title: '排序',
		            width: '10%',
		            align: "left"
		        },
		        {
		            field: 'url',
		            title: '请求地址',
		            width: '15%',
		            align: "left"
		        },
		        {
		            title: '类型',
		            field: 'menuType',
		            width: '10%',
		            align: "left",
		            formatter: function(value, item, index) {
		                if (item.menuType == 'M') {
		                    return '<span class="label label-success">目录</span>';
		                }
		                else if (item.menuType == 'C') {
		                    return '<span class="label label-primary">菜单</span>';
		                }
		                else if (item.menuType == 'F') {
		                    return '<span class="label label-warning">按钮</span>';
		                }
		            }
		        },
		        {
		            field: 'visible',
		            title: '可见',
		            width: '10%',
		            align: "left",
		            formatter: function(value, row, index) {
		            	return  visibleStatus(row.visible);
		            }
		        },
		        {
		            field: 'permsKey',
		            title: '权限标识',
		            width: '15%',
		            align: "left",
		        },
		        {
		            title: '操作',
		            width: '20%',
		            align: "left",
		            formatter: function(value, row, index) {
		                var actions = [];
		                actions.push('<a class="btn btn-success btn-xs " href="javascript:void(0)" onclick="edit(\'' + row.menuId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
		                actions.push('<a class="btn btn-info btn-xs " href="javascript:void(0)" onclick="add(\'' + row.menuId + '\')"><i class="fa fa-plus"></i>新增</a> ');
		                actions.push('<a class="btn btn-danger btn-xs " href="javascript:void(0)" onclick="remove(\'' + row.menuId + '\')"><i class="fa fa-trash"></i>删除</a>');
		                return actions.join('');
		            }
		        }]
		    };
		    $.treeTable.init(options);
		});
		
		function add(parentId){
			open("添加系统菜单",prefix + "/add/" + parentId);
		}
		
		function visibleStatus(vis){
			if(vis == 0){
				return  "<span class='badge badge-primary'>显示</span>";
			}else if(vis == 1){
				return "隐藏";
			}
			return false;
		}
		
	   	 function remove(id){
			 layer.confirm("确认要删除选中的这条数据吗?",{icon:3,title:"系统提示",btn:["确定","取消"]}, function(index) {
					var url = prefix + "/remove";
					rowid = {"ids":id};
					layer.close(index);
					submit(url, "post", "json", rowid,1);
				}); 
		 }
	   	 
	   	 function edit(id){
	   		if(id != null && id != undefined){
				open("修改菜单",prefix + "/update?menuId="+id+"");
			}else{
				 msg("请选择一条记录","warning");
				 return;
			}
	   	 }
	</script>
</body>
</html>