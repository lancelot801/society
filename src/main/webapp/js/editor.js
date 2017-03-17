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
			url : "http://localhost:8080/society_server/student/activity_apply/apply",
			type : "post",
			data :params,
			success : function(data) {
				if(data.resultCode == 0){	
					alert(data.resultData);
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