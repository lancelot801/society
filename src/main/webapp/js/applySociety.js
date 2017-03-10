$(function() {
	//获取Url中的studentId参数
	function getParameter(name) { 
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r!=null) return unescape(r[2]); return null;
	};
	
	$(document).ready(function() {
		var token = getParameter("studentId");
		$.ajax({
			url : "http://localhost:8080/society_server/identityCard/getIdCardByStudentId?studentId="+token,
			type : "get",
			success : function(data) {
				if(data.resultCode == 0){	
				}else{
					alert("对不起,请先完善个人信息再申请");
					//返回上一个页面
					window.history.back(-1); 
				}
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		});
		/*
		$.ajax({
			url : "http://localhost:8080/society_server/societyType/list",
			type : "get",
			success : function(data) {
				if(data.resultCode == 0){	
					
				}else{
					
				}
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		});*/
	});
	
	$('#societyApply').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			societyName : {
				validators : {
					notEmpty : {
						message : '社团名称不能为空'
					}
				}
			},
			introduction : {
				validators : {
					notEmpty : {
						message : '社团简介不能为空'
					}
				}
			},
			logoUrl:{
				validators : {
					notEmpty : {
						message : '社团logo不能为空'
					}
				}
			}
		}
	});
	
	//申请社团
	$("#applyBtn").click(function() {
		var Validator = $('#societyApply').data('bootstrapValidator');
		Validator.validate();
		if (!Validator.isValid()) {
			return;
		} 
		$.ajax({
			url : "http://localhost:8080/society_server/societyApply/add",
			type : "post",
			data:  new FormData($('#societyApply')[0]),
			cache: false,
			processData: false,
			contentType: false,
			success : function(data) {
				if(data.resultCode == 0){
					alert("申请成功!");
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