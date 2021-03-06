         /** 消息提示并刷新父窗体 */
		function msgReload(msg, type){
			layer.msg(msg, {
        	    icon: icon(type),
        	    time: 500,
        	    shade: [0.1, '#8F8F8F']
        	},
        	function() {
        		parent.location.reload();
        	});
         }
         /**消息提示 */
         function msg(content,type){
        	 if (type != undefined) {
                 layer.msg(content, { icon: icon(type), time: 1000, shift: 5 });
             } else {
                 layer.msg(content);
             } 
         }
         /**图标 */
         function icon(type){
        	 var icon = "";
 			if (type == "warning") {
       	        icon = 0;
       	    } else if (type == "success") {
       	        icon = 1;
       	    } else if (type == "error") {
       	        icon = 2;
       	    } else {
       	        icon = 3;
       	    }
 			return icon;
         }
         /** 关闭遮罩层 */
		function closeblock(){
				setTimeout(function(){
         			$.unblockUI();
        	 	}, 50);
			};
		/** 关闭弹出层 */	
		function closeItem(){
				/** 得到iframe层的索引，在执行关闭*/
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
		}
		
		/** 弹出遮罩层 */
		function open(title, url, callback){
			width = 800;
			height = ($(window).height()-50);
			var index = layer.open({
				type:2,
				area: [width + 'px', height + 'px'],
	    		fix: false,
	    		//不固定
	    		maxmin: true,
	    		shade: 0.3,
	    		title: title,
	    		content: url,
	    		// 弹层外区域关闭
	    		shadeClose: true,
	    		yes: function(index, layero) {
	    	        var iframeWin = layero.find('iframe')[0];
	    	        iframeWin.contentWindow.submitHandler(index, layero);
	    	    },
	    	    cancel: function(index) {
	    	        return true;
	    	    }
			});
			layer.full(index);
		}
		
		/** ajax提交 various 判断类型，1重新加载父窗体，0 重新加载表格*/
		function submit(url,type,dataType,data,various){
			
			$.ajax({
        		url: url,
        		type: type,
        		dateType: dataType,
        		data:data,
        		success: function(result){
        			if(result.code == 200){
        				if(various == 1){
        					msgReload("成功,正在刷新数据请稍后……", "success");
        				}else{
        					msg("成功,正在刷新数据....","success");
        				}
        			}else if(result.code == 301){
        				 msg(result.msg,"warning");
        			}else{
        				msg(result.msg,"error");
        			}
        			if(various != 1){
        				location.reload();
        			}
        		}
        	});
		}