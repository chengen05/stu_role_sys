$.extend({
	btTable: {},
	bttTable: {},
	table: {
            _option: {},
            // 初始化表格参数
            init: function(options) {
            	var defaults = {
            		id: "bootstrap-table",
            		type: 0, // 0 代表bootstrapTable 1代表bootstrapTreeTable
        		    height: undefined,
        		    sidePagination: "server",
        		    sortName: "",
        		    sortOrder: "asc",
        		    pagination: true,
        		    pageSize: 10,
        		    pageList: [10, 25, 50],
        		    toolbar: "toolbar",
        		    striped: false,
        		    escape: false,
        		    firstLoad: true,
        		    showFooter: false,
        		    search: false,
                    showSearch: true,
                    showPageGo: false,
                    showRefresh: true,
                    showColumns: true,
                    showToggle: true,
                    showExport: true,
                    clickToSelect: false,
                    rememberSelected: false,
        		    fixedColumns: false,
        		    fixedNumber: 0,
        		    rightFixedColumns: false,
        		    rightFixedNumber: 0,
        		    queryParams: $.table.queryParams,
        		    rowStyle: {},
        		};
            	var options = $.extend(defaults, options);
                $.table._option = options;
                $.btTable = $('#' + options.id);
                $('#' + options.id).bootstrapTable({
                    url: options.url,                                   // 请求后台的URL（*）
                    contentType: "application/x-www-form-urlencoded",   // 编码类型
                    method: 'post',                                     // 请求方式（*）
                    cache: false,                                       // 是否使用缓存
                    height: options.height,                             // 表格的高度
                    striped: options.striped,                           // 是否显示行间隔色
                    sortable: true,                                     // 是否启用排序
                    sortStable: true,                                   // 设置为 true 将获得稳定的排序
                    sortName: options.sortName,                         // 排序列名称
                    sortOrder: options.sortOrder,                       // 排序方式  asc 或者 desc
                    pagination: options.pagination,                     // 是否显示分页（*）
                    pageNumber: 1,                                      // 初始化加载第一页，默认第一页
                    pageSize: options.pageSize,                         // 每页的记录行数（*） 
                    pageList: options.pageList,                         // 可供选择的每页的行数（*）
                    firstLoad: options.firstLoad,                       // 是否首次请求加载数据，对于数据较大可以配置false
                    escape: options.escape,                             // 转义HTML字符串
                    showFooter: options.showFooter,                     // 是否显示表尾
                    iconSize: 'outline',                                // 图标大小：undefined默认的按钮尺寸 xs超小按钮sm小按钮lg大按钮
                    toolbar: '#' + options.toolbar,                     // 指定工作栏
                    sidePagination: options.sidePagination,             // server启用服务端分页client客户端分页
                    search: options.search,                             // 是否显示搜索框功能
                    searchText: options.searchText,                     // 搜索框初始显示的内容，默认为空
                    showSearch: options.showSearch,                     // 是否显示检索信息
                    showPageGo: options.showPageGo,               		// 是否显示跳转页
                    showRefresh: options.showRefresh,                   // 是否显示刷新按钮
                    showColumns: options.showColumns,                   // 是否显示隐藏某列下拉框
                    showToggle: options.showToggle,                     // 是否显示详细视图和列表视图的切换按钮
                    showExport: true,                     // 是否支持导出文件
                    uniqueId: options.uniqueId,                         // 唯 一的标识符
                    clickToSelect: options.clickToSelect,				// 是否启用点击选中行
                    detailView: options.detailView,                     // 是否启用显示细节视图
                    onClickRow: options.onClickRow,                     // 点击某行触发的事件
                    onDblClickRow: options.onDblClickRow,               // 双击某行触发的事件
                    onClickCell: options.onClickCell,                   // 单击某格触发的事件
                    onDblClickCell: options.onDblClickCell,             // 双击某格触发的事件
                    rememberSelected: options.rememberSelected,         // 启用翻页记住前面的选择
                    fixedColumns: options.fixedColumns,                 // 是否启用冻结列（左侧）
                    fixedNumber: options.fixedNumber,                   // 列冻结的个数（左侧）
                    rightFixedColumns: options.rightFixedColumns,       // 是否启用冻结列（右侧）
                    rightFixedNumber: options.rightFixedNumber,         // 列冻结的个数（右侧）
                    onReorderRow: options.onReorderRow,                 // 当拖拽结束后处理函数
                    queryParams: options.queryParams,                   // 传递参数（*）
                    rowStyle: options.rowStyle,                         // 通过自定义函数设置行样式
                    columns: options.columns,                           // 显示列信息（*）
                    responseHandler: $.table.responseHandler,           // 在加载服务器发送来的数据之前处理函数
                    onLoadSuccess: $.table.onLoadSuccess,               // 当所有数据被加载时触发处理函数
                    exportOptions: options.exportOptions,               // 前端导出忽略列索引
                    detailFormatter: options.detailFormatter,           // 在行下面展示其他数据列表
                });
            },
            // 查询条件
            queryParams: function(params) {
            	var curParams = {
            			// 传递参数查询参数
                        pageSize:       params.limit,
                        pageNum:        params.offset / params.limit + 1,
                        searchValue:    params.search
            		};
            	var currentId =  $.table._option.formId;
            	return $.extend(curParams, currentId); 
            },
            // 表格销毁
            destroy: function (tableId) {
            	$("#bootstrap-table").bootstrapTable('destroy');
	        },
            // 搜索-默认第一个form
            search: function(formId, data) {
            	var currentId = $('form').attr('id');
            	var array = $("#"+currentId).serializeArray();
            
            	var data = {} ;
            	if(array != null && array != undefined){
            		$.each(array,function(name,value){
            			data[value.name] =  value.value;
            		})
            	}
    		    var params = $.btTable.bootstrapTable('getOptions');
    		    params.queryParams = function(params) {
    		    	var curParams = {
    	        			pageSize: params.limit,
    	        			pageNum: params.offset / params.limit+1,
    	        	};
    		        return $.extend(curParams,data);
    		    }
    		    $.btTable.bootstrapTable('refresh', params);
    		},
            // 刷新表格
            refresh: function() {
            	$.btTable.bootstrapTable('refresh', {
                    silent: true
                });
            }, 
            // 获取当前页选中或者取消的行ID
            affectedRowIds: function(rows) {
            	var column = $.table._option.columns[1].field ;
            	var rowIds;
            	if ($.isArray(rows)) {
            	    rowIds = $.map(rows, function(row) {
            	        return row[column];
            	    });
            	} else {
            	    rowIds = [rows[column]];
            	}
            	return rowIds;
            },
      
        },
        // 表格树封装处理
        treeTable: {
            // 初始化表格
            init: function(options) {
            	var defaults = {
            		id: "bootstrap-tree-table",
                    type: 1, // 0 代表bootstrapTable 1代表bootstrapTreeTable
        		    height: 0,
        		    rootIdValue: null,
        		    ajaxParams: {},
        		    toolbar: "toolbar",
        		    striped: false,
        		    expandColumn: 1,
        		    showSearch: true,
        		    showRefresh: true,
        			showColumns: true,
        			expandAll: true,
        			expandFirst: true
        		};
            	var options = $.extend(defaults, options);
                $.table._option = options;
                $.bttTable = $('#' + options.id).bootstrapTreeTable({
                	code: options.code,                                 // 用于设置父子关系
        		    parentCode: options.parentCode,                     // 用于设置父子关系
        	    	type: 'post',                                        // 请求方式（*）
        	        url: options.url,                                   // 请求后台的URL（*）
        	        ajaxParams: options.ajaxParams,                     // 请求数据的ajax的data属性
        	        rootIdValue: options.rootIdValue,                   // 设置指定根节点id值
        	        height: options.height,                             // 表格树的高度
        			expandColumn: options.expandColumn,                 // 在哪一列上面显示展开按钮
        			striped: options.striped,                           // 是否显示行间隔色
        			bordered: true,                                     // 是否显示边框
        			toolbar: '#' + options.toolbar,                     // 指定工作栏
        			showSearch: options.showSearch,                     // 是否显示检索信息
        			showRefresh: options.showRefresh,                   // 是否显示刷新按钮
        			showColumns: options.showColumns,                   // 是否显示隐藏某列下拉框
        			expandAll: options.expandAll,                       // 是否全部展开
        			expandFirst: options.expandFirst,                   // 是否默认第一级展开--expandAll为false时生效
        	        columns: options.columns,                           // 显示列信息（*）
        	  
        	    });
            },
            // 条件查询
            search: function() {
            	var json = {}
            	$.each($("#menu-form").serializeArray(), function(i, field) {
               	 json[field.name] = field.value;
                });
            	console.log("json:"+json);
                $.bttTable.bootstrapTreeTable('refresh', json);
            },
            // 刷新
            refresh: function() {
            	$.bttTable.bootstrapTreeTable('refresh');
            },
          
        },
        // 树插件封装处理
        tree: {
        	_option: {},
        	_lastValue: {},
        	// 初始化树结构
        	init: function(options) {
        		var defaults = {
            		id: "tree",                    // 属性ID
            		expandLevel: 0,                // 展开等级节点
            		view: {
    			        selectedMulti: false,      // 设置是否允许同时选中多个节点
    			        nameIsHTML: true           // 设置 name 属性是否支持 HTML 脚本
    			    },
            		check: {
    				    enable: false,             // 置 zTree 的节点上是否显示 checkbox / radio
    				    nocheckInherit: true,      // 设置子节点是否自动继承
    				},
    				data: {
    			        key: {
    			            title: "title"         // 节点数据保存节点提示信息的属性名称
    			        },
    			        simpleData: {
    			            enable: true           // true / false 分别表示 使用 / 不使用 简单数据模式
    			        }
    			    },
        		};
            	var options = $.extend(defaults, options);
        		$.tree._option = options;
        		// 树结构初始化加载
        		var setting = {
    				callback: {
    			        onClick: options.onClick,                      // 用于捕获节点被点击的事件回调函数
    			        onCheck: options.onCheck,                      // 用于捕获 checkbox / radio 被勾选 或 取消勾选的事件回调函数
    			        onDblClick: options.onDblClick                 // 用于捕获鼠标双击之后的事件回调函数
    			    },
    				check: options.check,
    			    view: options.view,
    			    data: options.data
    			};
        	    $.get(options.url, function(data) {
        			var treeId = $("#treeId").val();
        			tree = $.fn.zTree.init($("#" + options.id), setting, data);
        			$._tree = tree;
        			var nodes = tree.getNodesByParam("level", options.expandLevel - 1);
        			for (var i = 0; i < nodes.length; i++) {
        				tree.expandNode(nodes[i], true, false, false);
        			}
        			var node = tree.getNodesByParam("id", treeId, null)[0];
        			$.tree.selectByIdName(treeId, node);
        		});
        	},
        	// 搜索节点
        	searchNode: function() {
        		// 取得输入的关键字的值
        		var value = $("#keyword").val();
        		if ($.tree._lastValue == value) {
        		    return;
        		}
        		// 保存最后一次搜索名称
        		$.tree._lastValue = value;
        		var nodes = $._tree.getNodes();
        		// 如果要查空字串，就退出不查了。
        		if (value == "") {
        		    $.tree.showAllNode(nodes);
        		    return;
        		}
        		$.tree.hideAllNode(nodes);
        		// 根据搜索值模糊匹配
        		$.tree.updateNodes($._tree.getNodesByParamFuzzy("name", value));
        	},
        	// 根据Id和Name选中指定节点
        	selectByIdName: function(treeId, node) {
        		if (treeId!=null &&treeId != "" && treeId == node.id) {
        			$._tree.selectNode(node, true);
        		}
        	},
        	// 显示所有节点
        	showAllNode: function(nodes) {
        		nodes = $._tree.transformToArray(nodes);
        		for (var i = nodes.length - 1; i >= 0; i--) {
        		    if (nodes[i].getParentNode() != null) {
        		    	$._tree.expandNode(nodes[i], true, false, false, false);
        		    } else {
        		    	$._tree.expandNode(nodes[i], true, true, false, false);
        		    }
        		    $._tree.showNode(nodes[i]);
        		    $.tree.showAllNode(nodes[i].children);
        		}
        	},
        	// 隐藏所有节点
        	hideAllNode: function(nodes) {
        	    var tree = $.fn.zTree.getZTreeObj("tree");
        	    var nodes = $._tree.transformToArray(nodes);
        	    for (var i = nodes.length - 1; i >= 0; i--) {
        	    	$._tree.hideNode(nodes[i]);
        	    }
        	},
        	// 显示所有父节点
        	showParent: function(treeNode) {
        		var parentNode;
        		while ((parentNode = treeNode.getParentNode()) != null) {
        			$._tree.showNode(parentNode);
        			$._tree.expandNode(parentNode, true, false, false);
        		    treeNode = parentNode;
        		}
        	},
        	// 显示所有孩子节点
        	showChildren: function(treeNode) {
        		if (treeNode.isParent) {
        		    for (var idx in treeNode.children) {
        		        var node = treeNode.children[idx];
        		        $._tree.showNode(node);
        		        $.tree.showChildren(node);
        		    }
        		}
        	},
        	// 更新节点状态
        	updateNodes: function(nodeList) {
        		$._tree.showNodes(nodeList);
        		for (var i = 0, l = nodeList.length; i < l; i++) {
        		    var treeNode = nodeList[i];
        		    $.tree.showChildren(treeNode);
        		    $.tree.showParent(treeNode)
        		}
        	},
        	// 获取当前被勾选集合
        	getCheckedNodes: function(column) {
        		var nodes = $._tree.getCheckedNodes(true);
        		var datac = $.map(nodes,function(row){
        			return row["id"]; 
				}).join();
        		return datac;
        	},
        	// 不允许根父节点选择
        	notAllowParents: function(_tree) {
    		    var nodes = _tree.getSelectedNodes();
    		    for (var i = 0; i < nodes.length; i++) {
    		        if (nodes[i].level == 0) {
    		            $.modal.msgError("不能选择根节点（" + nodes[i].name + "）");
    		            return false;
    		        }
    		        if (nodes[i].isParent) {
    		            $.modal.msgError("不能选择父节点（" + nodes[i].name + "）");
    		            return false;
    		        }
    		    }
        		return true;
        	},
        	// 不允许最后层级节点选择
        	notAllowLastLevel: function(_tree) {
    		    var nodes = _tree.getSelectedNodes();
    		    for (var i = 0; i < nodes.length; i++) {
                    if (!nodes[i].isParent) {
    		    		$.modal.msgError("不能选择最后层级节点（" + nodes[i].name + "）");
    		            return false;
    		        }
    		    }
        		return true;
        	},
        	// 隐藏/显示搜索栏
        	toggleSearch: function() {
        		$('#search').slideToggle(200);
        		$('#btnShow').toggle();
        		$('#btnHide').toggle();
        		$('#keyword').focus();
        	},
        	// 折叠
        	collapse: function() {
        		$._tree.expandAll(false);
        	},
        	// 展开
        	expand: function() {
        		$._tree.expandAll(true);
        	}
        }
});