<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../../common.jsp"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统菜单添加</title>
<style type="text/css">
        .ico-list .fa{
            margin: 5px;
            padding: 5px;
            cursor:pointer;
            font-size: 18px;
            width: 28px;
            border-radius: 3px;
        }
        .ico-list .fa:hover {
            background-color: #1d9d74;
            color: #ffffff;}
</style>
</head>
<body class="white-bg">
	<div class="wrapper wrapper-content animated fadeInRight ibox-content">
		<form class="form-horizontal m" id="form-menu-add">
			<input id="treeId" name="parentId" type="hidden" value="${sysMenu.menuId}" />
			<div class="form-group">
				<label class="col-sm-3 control-label ">上级菜单：</label>
				<div class="col-sm-8">
				    <div class="input-group">
					    <input class="form-control" type="text" onclick="selectMenuTree()" id="treeName" readonly="readonly" value="${sysMenu.menuName}">
				        <span class="input-group-addon"><i class="fa fa-search"></i></span>
				    </div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单类型：</label>
				<div class="col-sm-8">
					<label class="radio-box"> <input type="radio" name="menuType"  value="M" /> 目录 </label> 
					<label class="radio-box"> <input type="radio" name="menuType"  value="C" /> 菜单 </label> 
					<label class="radio-box"> <input type="radio" name="menuType"  value="F" /> 按钮 </label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单名称：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="menuName" id="menuName" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">请求地址：</label>
				<div class="col-sm-8">
					<input id="url" name="url" class="form-control" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">权限标识：</label>
				<div class="col-sm-8">
					<input id="perms" name="perms" class="form-control" type="text">
					<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 控制器中定义的权限标识，如：@RequiresPermissions("")</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">显示排序：</label>
				<div class="col-sm-8">
					<input class="form-control" type="text" name="orderNum" required>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">图标：</label>
				<div class="col-sm-8">
					<input id="icon" name="icon" class="form-control" type="text" placeholder="选择图标" >
                    <div class="ms-parent" style="width: 100%;">
                        <div class="icon-drop animated flipInX" style="display: none;max-height:200px;overflow-y:auto" >
                           <div class="ico-list">
							     <i class="fa fa-address-book" aria-hidden="true"></i>
							
							     <i class="fa fa-address-book-o" aria-hidden="true"></i>
							
							     <i class="fa fa-address-card" aria-hidden="true"></i>
							
							     <i class="fa fa-address-card-o" aria-hidden="true"></i>
							
							     <i class="fa fa-adjust" aria-hidden="true"></i>
							
							     <i class="fa fa-american-sign-language-interpreting" aria-hidden="true"></i>
							
							     <i class="fa fa-anchor" aria-hidden="true"></i>
							
							     <i class="fa fa-archive" aria-hidden="true"></i>
							
							     <i class="fa fa-area-chart" aria-hidden="true"></i>
							
							     <i class="fa fa-arrows" aria-hidden="true"></i>
							
							     <i class="fa fa-arrows-h" aria-hidden="true"></i>
							
							     <i class="fa fa-arrows-v" aria-hidden="true"></i>
							
							     <i class="fa fa-asl-interpreting" aria-hidden="true"></i>
							
							     <i class="fa fa-assistive-listening-systems" aria-hidden="true"></i>
							
							     <i class="fa fa-asterisk" aria-hidden="true"></i>
							
							     <i class="fa fa-at" aria-hidden="true"></i>
							
							     <i class="fa fa-audio-description" aria-hidden="true"></i>
							
							     <i class="fa fa-automobile" aria-hidden="true"></i>
							
							     <i class="fa fa-balance-scale" aria-hidden="true"></i>
							
							     <i class="fa fa-ban" aria-hidden="true"></i>
							
							     <i class="fa fa-bank" aria-hidden="true"></i>
							
							     <i class="fa fa-bar-chart" aria-hidden="true"></i>
							
							     <i class="fa fa-bar-chart-o" aria-hidden="true"></i>
							
							     <i class="fa fa-barcode" aria-hidden="true"></i>
							
							     <i class="fa fa-bars" aria-hidden="true"></i>
							
							     <i class="fa fa-bath" aria-hidden="true"></i>
							
							     <i class="fa fa-bathtub" aria-hidden="true"></i>
							
							     <i class="fa fa-battery" aria-hidden="true"></i>
							
							     <i class="fa fa-battery-0" aria-hidden="true"></i>
							
							     <i class="fa fa-battery-1" aria-hidden="true"></i>
							
							     <i class="fa fa-battery-2" aria-hidden="true"></i>
							
							     <i class="fa fa-battery-3" aria-hidden="true"></i>
							
							     <i class="fa fa-battery-4" aria-hidden="true"></i>
							
							     <i class="fa fa-battery-empty" aria-hidden="true"></i>
							
							     <i class="fa fa-battery-full" aria-hidden="true"></i>
							
							     <i class="fa fa-battery-half" aria-hidden="true"></i>
							
							     <i class="fa fa-battery-quarter" aria-hidden="true"></i>
							
							     <i class="fa fa-battery-three-quarters" aria-hidden="true"></i>
							
							     <i class="fa fa-bed" aria-hidden="true"></i>
							
							     <i class="fa fa-beer" aria-hidden="true"></i>
							
							     <i class="fa fa-bell" aria-hidden="true"></i>
							
							     <i class="fa fa-bell-o" aria-hidden="true"></i>
							
							     <i class="fa fa-bell-slash" aria-hidden="true"></i>
							
							     <i class="fa fa-bell-slash-o" aria-hidden="true"></i>
							
							     <i class="fa fa-bicycle" aria-hidden="true"></i>
							
							     <i class="fa fa-binoculars" aria-hidden="true"></i>
							
							     <i class="fa fa-birthday-cake" aria-hidden="true"></i>
							
							     <i class="fa fa-blind" aria-hidden="true"></i>
							
							     <i class="fa fa-bluetooth" aria-hidden="true"></i>
							
							     <i class="fa fa-bluetooth-b" aria-hidden="true"></i>
							
							     <i class="fa fa-bolt" aria-hidden="true"></i>
							
							     <i class="fa fa-bomb" aria-hidden="true"></i>
							
							     <i class="fa fa-book" aria-hidden="true"></i>
							
							     <i class="fa fa-bookmark" aria-hidden="true"></i>
							
							     <i class="fa fa-bookmark-o" aria-hidden="true"></i>
							
							     <i class="fa fa-braille" aria-hidden="true"></i>
							
							     <i class="fa fa-briefcase" aria-hidden="true"></i>
							
							     <i class="fa fa-bug" aria-hidden="true"></i>
							
							     <i class="fa fa-building" aria-hidden="true"></i>
							
							     <i class="fa fa-building-o" aria-hidden="true"></i>
							
							     <i class="fa fa-bullhorn" aria-hidden="true"></i>
							
							     <i class="fa fa-bullseye" aria-hidden="true"></i>
							
							     <i class="fa fa-bus" aria-hidden="true"></i>
							
							     <i class="fa fa-cab" aria-hidden="true"></i>
							
							     <i class="fa fa-calculator" aria-hidden="true"></i>
							
							     <i class="fa fa-calendar" aria-hidden="true"></i>
							
							     <i class="fa fa-calendar-check-o" aria-hidden="true"></i>
							
							     <i class="fa fa-calendar-minus-o" aria-hidden="true"></i>
							
							     <i class="fa fa-calendar-o" aria-hidden="true"></i>
							
							     <i class="fa fa-calendar-plus-o" aria-hidden="true"></i>
							
							     <i class="fa fa-calendar-times-o" aria-hidden="true"></i>
							
							     <i class="fa fa-camera" aria-hidden="true"></i>
							
							     <i class="fa fa-camera-retro" aria-hidden="true"></i>
							
							     <i class="fa fa-car" aria-hidden="true"></i>
							
							     <i class="fa fa-caret-square-o-down" aria-hidden="true"></i>
							
							     <i class="fa fa-caret-square-o-left" aria-hidden="true"></i>
							
							     <i class="fa fa-caret-square-o-right" aria-hidden="true"></i>
							
							     <i class="fa fa-caret-square-o-up" aria-hidden="true"></i>
							
							     <i class="fa fa-cart-arrow-down" aria-hidden="true"></i>
							
							     <i class="fa fa-cart-plus" aria-hidden="true"></i>
							
							     <i class="fa fa-cc" aria-hidden="true"></i>
							
							     <i class="fa fa-certificate" aria-hidden="true"></i>
							
							     <i class="fa fa-check" aria-hidden="true"></i>
							
							     <i class="fa fa-check-circle" aria-hidden="true"></i>
							
							     <i class="fa fa-check-circle-o" aria-hidden="true"></i>
							
							     <i class="fa fa-check-square" aria-hidden="true"></i>
							
							     <i class="fa fa-check-square-o" aria-hidden="true"></i>
							
							     <i class="fa fa-child" aria-hidden="true"></i>
							
							     <i class="fa fa-circle" aria-hidden="true"></i>
							
							     <i class="fa fa-circle-o" aria-hidden="true"></i>
							
							     <i class="fa fa-circle-o-notch" aria-hidden="true"></i>
							
							     <i class="fa fa-circle-thin" aria-hidden="true"></i>
							
							     <i class="fa fa-clock-o" aria-hidden="true"></i>
							
							     <i class="fa fa-clone" aria-hidden="true"></i>
							
							     <i class="fa fa-close" aria-hidden="true"></i>
							
							     <i class="fa fa-cloud" aria-hidden="true"></i>
							
							     <i class="fa fa-cloud-download" aria-hidden="true"></i>
							
							     <i class="fa fa-cloud-upload" aria-hidden="true"></i>
							
							     <i class="fa fa-code" aria-hidden="true"></i>
							
							     <i class="fa fa-code-fork" aria-hidden="true"></i>
							
							     <i class="fa fa-coffee" aria-hidden="true"></i>
							
							     <i class="fa fa-cog" aria-hidden="true"></i>
							
							     <i class="fa fa-cogs" aria-hidden="true"></i>
							
							     <i class="fa fa-comment" aria-hidden="true"></i>
							
							     <i class="fa fa-comment-o" aria-hidden="true"></i>
							
							     <i class="fa fa-commenting" aria-hidden="true"></i>
							
							     <i class="fa fa-commenting-o" aria-hidden="true"></i>
							
							     <i class="fa fa-comments" aria-hidden="true"></i>
							
							     <i class="fa fa-comments-o" aria-hidden="true"></i>
							
							     <i class="fa fa-compass" aria-hidden="true"></i>
							
							     <i class="fa fa-copyright" aria-hidden="true"></i>
							     </div>
                        </div>
                    </div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单状态：</label>
				<div class="col-sm-8">
				    <div class="radio-box" >
						<input type="radio" name="visible" checked value="0"> 显示
						&nbsp;&nbsp;&nbsp;
						<input type="radio" name="visible"  value="1"> 隐藏
					
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
        var prefix = "/stu_work_sys/system/menu";
        
        window.onload = function(){
        	
        	$("input:radio").iCheck({
        		radioClass :"iradio_minimal-orange"
        	});
        	$("input[name='icon']").focus(function() {
                $(".icon-drop").show();
             });
         	$("#form-menu-add").click(function(event) {
         	    var obj = event.srcElement || event.target;
         	    if (!$(obj).is("input[name='icon']")) {
         	    	$(".icon-drop").hide();
         	    }
         	});
         	$(".icon-drop").find(".ico-list i").on("click", function() {
         		$('#icon').val($(this).attr('class'));
             }); 
           	
         	$('input[name="menuType"]').on("ifChecked", function(event){ 
         		var menuType = $(event.target).val();
         		if (menuType == "M") {
                     $("#url").parents(".form-group").hide();
                     $("#perms").parents(".form-group").hide();
                     $("#icon").parents(".form-group").show();
        
                     $("input[name='visible']").parents(".form-group").show();
                 } else if (menuType == "C") {
                 	$("#url").parents(".form-group").show();
                     $("#perms").parents(".form-group").show();
                     $("#icon").parents(".form-group").show();
                     $("input[name='visible']").parents(".form-group").show();
                 } else if (menuType == "F") {
                 	$("#url").parents(".form-group").hide();
                     $("#perms").parents(".form-group").show();
                     $("#icon").parents(".form-group").hide();
                     $("input[name='visible']").parents(".form-group").hide();
                 }
         	});  
        }
        
        $("#form-menu-add").validate({
        	onkeyup: false,
        	rules:{
        		menuType:{
        			required:true,
        		},
        		menuName:{
        			remote: {
                        url: prefix + "/checkUnique",
                        type: "post",
                        dataType: "json",
                        data: {
                        	"parentId": function() {
		                		return $("input[name='parentId']").val();
		                    },
                        	"menuName" : function() {
                                return $("#menuName").val();
                            }
                        },
                        dataFilter: function(data, type) {
                        	return data;
                        }
                    }
        		},
        		url:{
        			remote:{
        				url: prefix + "/checkUnique",
        				type:"post",
        				dataType:"json",
        				data:{
        					"url" : function(){
        						return $("#url").val();
        					}
        				},
        				 dataFilter: function(data, type) {
                         	return data;
                         }
        			}
        		},
        		orderNum:{
        			digits:true
        		},
        	},
        	messages: {
                "menuName": {
                    remote: "菜单已经存在"
                },
                "url" :{
                	remote:"链接重复"
                }
            },
            focusCleanup: true
        });
        
        function submitHandler() {
	        	submit(prefix+"/addsave","post","json",$('#form-menu-add').serialize(),1);
	        
	    }
	
       
     
        /*菜单管理-新增-选择菜单树*/
        function selectMenuTree() {
        	var treeId = $("#treeId").val();
        	var menuId = treeId > 0 ? treeId : 1;
        	var url = prefix + "/selectMenuTree/" + menuId;
			var options = {
				title: '菜单选择',
				width: "380",
				url: url,
				callBack: doSubmit
			};
			$.modal.openOptions(options);
		}
		
		function doSubmit(index, layero){
			var body = layer.getChildFrame('body', index);
   			$("#treeId").val(body.find('#treeId').val());
   			$("#treeName").val(body.find('#treeName').val());
   			layer.close(index);
		}
		
	
    </script>
</body>
</html>
