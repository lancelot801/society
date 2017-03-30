$(function() {
	function getParameter(name) { 
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r!=null){  
		return unescape(r[2]);
		}else{
			return null;
		}
	}
	
	$(document).ready(function() {	
		var id = getParameter('activityId');
		var societyId;
		$.ajax({
			url : "http://localhost:8080/society_server/student/activity_apply/findByActivityId?activityId="+ id,
			type : "get",
			success : function(result) {
				 editor.$txt.html(result.resultData.content);
				 $("#theme").val(result.resultData.theme);
				 $("#holdTime").val(result.resultData.holdTime);
				 societyId = result.resultData.societyId;
					var currentBtn = document.getElementById("applyUpdateBtn");
				    if (result.resultData.status =="待审核") {
				        currentBtn.style.display = "inline"; //style中的display属性
				}
			},
			error : function(error) {
				alert(error.resultData);
			},
			async : false
		});
		
		 //查找社团名称
		 $.ajax({
				url : "http://localhost:8080/society_server/student/societyInfo/findById?societyId="+ societyId,
				type : "get",
				success : function(result) {
					 $("#societyName").val(result.resultData.societyName);
				},
				error : function(error) {
					alert(error.resultData);
				},
				async : false
			});
});
	//反馈审核信息
	$("#applyUpdateBtn").click(function() {

		 // 获取编辑器区域完整html代码
        var html = editor.$txt.html();
        var activityId = getParameter('activityId');
    	"use strict"; 
	    let params = {};
	    params = {
	    	theme : $("#theme").val(),
//	    	orderTitle : $("#orderTitle").val(),
//	    	orderStatus : $("#orderStatus").val(),
//	    	totalAmt : $("#totalAmt").val(),
//	    	WechatImg :document.getElementById("WechatImg").src,
	    	holdTime : $("#holdTime").val(),
	    	content: html,
	    	activityId : activityId
	    };
        $.ajax({
			url : "http://localhost:8080/society_server/student/activity_apply/updateApply",
			type : "post",
			data :params,
			success : function(data) {
				if(data.resultCode == 0){
					alert("活动申请成功,等待管理员审核");
					window.location.href=window.location.href; 
					window.location.reload; 
				}else{
					alert("对不起,添加活动申请失败");
					//返回上一个页面
					window.history.back(-1); 
				}
			},
			error : function(error) {
				alert(error.responseText);
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
			url : "http://localhost:8080/society_server/admin/notice/publish",
			type : "post",
			data :params,
			success : function(data) {
				if(data.resultCode == 0){	
					alert("公告发布成功");
					window.location.href=window.location.href; 
					window.location.reload; 
				}else{
					alert("对不起,发布活动失败");
					//返回上一个页面
					window.history.back(-1); 
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