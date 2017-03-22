$(function() {
	function getParameter(name) { 
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r!=null) return unescape(r[2]); return null;
	}
	
	$(document).ready(function() {
		var token = $("#studentId").val();
		$('#passwordForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				prePwd : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
						},
						remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
	                        url: 'http://localhost:8080/society_server/user/checkPassword?studentId='+token,//验证地址
	                        message: '密码不正确',//提示消息
	                        delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
	                        type: 'GET'//请求方式
	                    },  
					}
				},
				currentPwd : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
						},
						identical : {
							field : 'currentPwd2',
							message : '两次密码不一致'
						},
						stringLength : {
							min : 6,
							max : 18,
							message : '请输入6到18位密码'
						},
					}
				},
				currentPwd2 : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
						},
						identical : {
							field : 'currentPwd',
							message : '两次密码不一致'
						},
						stringLength : {
							min : 6,
							max : 18,
							message : '请输入6到18位密码'
						},
					}
				}
			}
		});
	
	});
	
	
	
	//修改按钮
	$("#updateBtn").click(function() {
		var Validator = $('#passwordForm').data('bootstrapValidator');
		Validator.validate();
		if (!Validator.isValid()) {
			return;
		} 
		$.ajax({
			url : "http://localhost:8080/society_server/user/resetPassword",
			type : "post",
			data:  $('#passwordForm').serialize(),
			success : function(data) {
				if(data.resultCode == 0){
					alert("修改成功!");
					window.location.href="/society_server/user/quit"; 
				}
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		});
	});  
});