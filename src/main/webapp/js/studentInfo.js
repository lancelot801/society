$(function() {
	function getParameter(name) { 
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r!=null) return unescape(r[2]); return null;
	};
	
	$(document).ready(function() {
		var token = getParameter("studentId");
		$.ajax({
			url : "http://localhost:8080/society_server/student/getInfo?studentId="+token,
			type : "post",
			success : function(data) {
				
				if(data.resultCode == 0){
					var instituteId = document.getElementById("instituteId");  
					for(var i=0; i<instituteId.options.length; i++){  
						if(instituteId.options[i].value == String (data.resultData.instituteId)){  
							instituteId.options[i].selected = true;  
					        break;  
					    }  
					}  
					
					var classId = document.getElementById("classId");  
					for(var i=0; i<classId.options.length; i++){  
						if(classId.options[i].value == String (data.resultData.classId)){  
							classId.options[i].selected = true;  
					        break;  
					    }  
					} 
					var sex = document.getElementById("sex");  
					for(var i=0; i<sex.options.length; i++){  
						if(sex.options[i].value == String (data.resultData.sex)){  
							sex.options[i].selected = true;  
					        break;  
					    }  
					}  
				}
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		});
		
		
		$.ajax({
			url : "http://localhost:8080/society_server/identityCard/getIdCardByStudentId?studentId="+token,
			type : "get",
			success : function(data) {
				if(data.resultCode == 0){
					var dataRole = eval(data.resultData); 
					for(var i= 0; i< dataRole.length;i++)
					{
					 $("#identityCard"+(i+1)).attr("src","/idCard"+dataRole[i].cardUrl);
					}
				}
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		});
		
	});
	
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
					window.location.href=window.location.href; 
					window.location.reload; 
				}
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		});
	});  
});