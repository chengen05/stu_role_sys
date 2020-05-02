$(function() {
	validate();
	
});


/** 提交表单验证 */
$.validator.setDefaults({
    submitHandler: function() {
		login();
    }
});



function login() {
	$.modal.loading($("#btnSubmit").data("loading"));
	var username = $.common.trim($("input[name='username']").val());
    var password = $.common.trim($("input[name='password']").val());
   // var validateCode = $("input[name='validateCode']").val();
    var rememberMe = $("input[name='rememberme']").is(':checked');
    $.ajax({
        type: "post",
        url:  "tologin",
        data: {
            "username": username,
            "password": password,
          //  "validateCode" : validateCode,
            "rememberMe": rememberMe
        },
        success: function(r) {
        	console.log(r);
            if (r.code == 200) {
                location.href = 'index';
            } else {
            	$.modal.closeLoading();
            	$('.imgcode').click();
            	$(".code").val("");
            	$.modal.msg(r.msg);
            }
        }
    });
}

function validate() {
	$("#signupForm").validate({
        rules: {
            username: {
                required: true
            },
            password: {
                required: true
            }
        },
        messages: {
            username: {
                required:  "请输入您的用户名",
            },
            password: {
                required: "请输入您的密码",
            }
        },
        errorPlacement : function(error, element) {   
        	console.log(element);
            element.parent('div').append(error);    
        } 
    });
}