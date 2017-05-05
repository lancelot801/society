$(function() {
	
	
	//反馈审核信息
	$("#applyBtn").click(function() {

		 // 获取编辑器区域完整html代码
        var html = editor.$txt.html();
    	"use strict"; 
	    let params = {};
	    params = {
	    	societyId :	$("#societyId").val(),
	    	applyerId : $("#applyerId").val(),
	    	theme : $("#theme").val(),
//	    	orderTitle : $("#orderTitle").val(),
//	    	orderStatus : $("#orderStatus").val(),
//	    	totalAmt : $("#totalAmt").val(),
//	    	WechatImg :document.getElementById("WechatImg").src,
	    	holdTime : $("#holdTime").val(),
	    	content: html,
	    };
        $.ajax({
			url : "/society_server/student/activity_apply/apply",
			type : "post",
			data :params,
			success : function(data) {
				if(data.resultCode == 0){	
					swal('活动申请成功', '等待管理员审核!', 'success');
					//延时刷新页面
					setTimeout(function(){
						window.location.href=window.location.href; 
						window.location.reload; },1500);
				}
			},
			error : function(error) {
				swal('活动申请失败', '网络连接异常!', 'error');
				//延时刷新页面
				setTimeout(function(){
					window.location.href=window.location.href; 
					window.location.reload; },3000);
			},
			async : false
		});
	});
	
	$('#noticeForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			theme : {
				validators : {
					notEmpty : {
						message : '公告主题不能为空'
					},
				}
			}
		}
	});
	
	//发布公告
	$("#noticeBtn").click(function() {
		var Validator = $('#noticeForm').data('bootstrapValidator');
		Validator.validate();
		if (!Validator.isValid()) {
			return;
		} 
		 // 获取编辑器区域完整html代码
        var html = editor.$txt.html();
    	"use strict"; 
	    let params = {};
	    params = {
	    	publisher : $("#publisher").val(),
	    	theme : $("#theme").val(),
	    	content: html,
	    };
        $.ajax({
			url : "/society_server/admin/notice/publish",
			type : "post",
			data :params,
			success : function(data) {
				if(data.resultCode == 0){	
					swal('公告发布成功', '快去首页看看吧!', 'success');
					//延时刷新页面
					setTimeout(function(){
						window.location.href=window.location.href; 
						window.location.reload; },1500);
				}else{
					swal('抱歉', '公告发布失败!', 'error');
					//延时刷新页面
					setTimeout(function(){
						window.history.back(-1); },1500);
				}
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		});
	});
	// 时间
	 $(".form_datetime").datetimepicker({
		 language: 'zh-CN',
        autoclose: 1,
        todayBtn: 1,
        pickerPosition: "bottom-left",
        minuteStep: 5,
        format: 'yyyy-mm-dd',
        minView: 'month'    //日期时间选择器所能够提供的最精确的时间选择视图。
	    });
	 
});