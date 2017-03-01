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
		   message: 'This value is not valid',
	         feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	         fields: { 
	           studentId: {
	        	   validators: {
	                    notEmpty: {
	                        message: '学号不能为空'
	                     },
	                     numeric: {
	                    	 message: '学号必须为数字'
	                     },
	                     stringLength: {
	                    	 min: 11,
	                    	 max: 11,
	                    	 message: '请输入11位学号'
	                     },
	                 }  
	           }, 
	           password: {
	                validators: {
	                    notEmpty: {
	                        message: '密码不能为空'
	                     },
	                    identical: {
	                        field: 'confirmPassword',
	                         message: '两次密码不一致'
	                    },
	                    different: {
	                        field: 'studentId',
	                       message: '密码应与学号不同'
	                     },
	                     stringLength: {
	                    	 min: 6,
	                    	 max: 18,
	                    	 message: '请输入6到18位密码'
	                     }, 
	                 }
	             },
	            confirmPassword: {
	               validators: {
	                  notEmpty: {
	                         message: '密码不能为空'
	                   },
	                    identical: {
	                        field: 'password',
	                       message: '两次密码不一致'
	                    },
	                   different: {
	                       field: 'studentId',
	                      message: '密码应与学号不同'
	                   },
	                   stringLength: {
	                    	 min: 6,
	                    	 max: 18,
	                    	 message: '请输入6到18位密码'
	                     },    
	               }
	            }
	         }
	});

	// 注册按钮
	$("#registerBtn").click(function() {
		$('#registerForm').bootstrapValidator('validate');
		
		
	});

});