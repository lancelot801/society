$(function() {
	/*
	$(document).ready(function() {
		var studentId = getParameter('studentId');
		$.ajax({
			url : "http://localhost:8080/society_server/student/showInfo?studentId"+ studentId,
			type : "post",
			success : function(result) {
				totalPage = result.resultData.totalPage;
				totalRecords = result.resultData.totalRecords;
			},
			error : function(error) {
					alert(error.resultData);
			},
					async : false
		});
	}); */

	$('#studentInfoForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			email : {
				validators : {
					notEmpty : {
						message : '邮箱不能为空'
					},
				    emailAddress: {
                        message: '邮箱地址格式有误'
                    }
				}
			},
			mobile : {
				validators : {
					notEmpty : {
						message : '手机号不能为空'
					},
					stringLength : {
						min : 11,
						max : 11,
						message : '请输入11位手机号'
					},
				}
			},
			nickname : {
				validators : {
					notEmpty : {
						message : '昵称不能为空'
					},
				}
			}
		}
	});
	
	//修改按钮
	$("#updateBtn").click(function() {
		var Validator = $('#studentInfoForm').data('bootstrapValidator');
		Validator.validate();
		if (!Validator.isValid()) {
			return;
		} 
		$.ajax({
			url : "http://localhost:8080/society_server/student/updateStudentInfo",
			type : "post",
			data:  new FormData($('#studentInfoForm')[0]),
			cache: false,
			processData: false,
			contentType: false,
			success : function(data) {
				if(data.resultCode == 0){
					alert("修改成功!");
				}
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		});
	});  
});