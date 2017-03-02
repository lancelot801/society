$(function() {

	$(document).ready(function() {
		$("#theTarget").skippr();
	});

	$("#theTarget").skippr({
		transition : 'slide',
		speed : 1000,
		easing : 'easeOutQuart',
		navType : 'block',
		childrenElementType : 'div',
		arrows : true,
		autoPlay : false,
		autoPlayDuration : 5000,
		keyboardOnAlways : true,
		hidePrevious : false
	});

	// 登录
	$("#userlogin").click(function() {
		$("#mylogin").modal().draggable({
			handle : ".modal-header",
			cursor : 'move',
			refreshPositions : false
		});
		$('#loginForm').bootstrapValidator('validate');
	});

	// 注册模态框
	$("#registAccount").click(function() {
		$("#registerModal").modal().draggable({
			handle : ".modal-header",
			cursor : 'move',
			refreshPositions : false
		});
	});

	$('#registerForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			studentId : {
				validators : {
					notEmpty : {
						message : '学号不能为空'
					},
					numeric : {
						message : '学号必须为数字'
					},
					stringLength : {
						min : 11,
						max : 11,
						message : '请输入11位学号'
					},
					threshold :  11 ,
					remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
                        url: 'http://localhost:8080/society_server/user/existStudentId',//验证地址
                        message: '用户已存在',//提示消息
                        delay :  1000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                        type: 'GET'//请求方式
                    },  
				}
			},
			password : {
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
					identical : {
						field : 'confirmPassword',
						message : '两次密码不一致'
					},
					different : {
						field : 'studentId',
						message : '密码应与学号不同'
					},
					stringLength : {
						min : 6,
						max : 18,
						message : '请输入6到18位密码'
					},
				}
			},
			confirmPassword : {
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
					identical : {
						field : 'password',
						message : '两次密码不一致'
					},
					different : {
						field : 'studentId',
						message : '密码应与学号不同'
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

	// 登录表单校验
	$('#loginForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			loginToken : {
				validators : {
					notEmpty : {
						message : '学号不能为空'
					},
				}
			},
			loginPassword : {
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
				}
			},
		}
	});

	// 注册按钮
	$("#registerBtn").click(function() {
		var Validator = $('#registerForm').data('bootstrapValidator');
		Validator.validate();
		if (!Validator.isValid()) {
			return;
		} 
		$.ajax({
			url : "http://localhost:8080/society_server/user/register",
			type : "post",
			data : $('#registerForm').serialize(),
			success : function(data) {
				debugger;
				if (data.resultCode == 0) {
					alert("注册成功!");
				} else {
					alert("注册失败cc!");
				}
				window.location.href = window.location.href;
				window.location.reload;
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		});

	});

});