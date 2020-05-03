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
            	console.log(data);
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
      
        }
});