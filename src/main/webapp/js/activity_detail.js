$(function() {
	//获取Url中的studentId参数
	function getParameter(name) { 
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r!=null){  
		return unescape(r[2]);
		}else{
			return null;
		}
	}

	function isContains(str, substr) {
	    return new RegExp(substr).test(str);
	}
	//init
	$(function(){
		var totalPage ;
		var totalRecords ;
		//获取当前的请求链接
		var url = window.location.href;
		var uri ;
		
		var activityId = getParameter('activityId');
		//获取uri
		if(url.indexOf("Status")>0){
			if(url.indexOf("&")>0){
				uri = url.substring(url.lastIndexOf("/")+1,url.indexOf("&"));
			}else{
				uri = url.substring(url.lastIndexOf("/")+1);
			}	
		}else{
			if(url.indexOf("?")>0)
			{
			  uri = url.substring(url.lastIndexOf("/")+1,url.indexOf("?"));
			}else{
			  uri = url.substring(url.lastIndexOf("/")+1);	
			}
		}
		$(document).ready(function() {	
			var applyerId ;
			var studentName ;
			$.ajax({
				url : "http://localhost:8080/society_server/student/activity_apply/findByActivityId?activityId="+activityId,
				type : "get",
				success : function(result) {
					applyerId = result.resultData.applyerId;
					$.ajax({
						url : "http://localhost:8080/society_server/student/getInfo?studentId="+applyerId,
						type : "post",
						success : function(data) {
							studentName = data.resultData.sname;
						},
						error : function(error) {
							alert(error.responseText);
						},
						async : false
					});
					$(".activity_title").html("活动标题: " +result.resultData.theme+"<br/>"+
							"申请时间: "+result.resultData.applyTime + "<br/>"+
							"审核时间: "+result.resultData.checkedTime + "<br/>"+
							"申请者: " +applyerId + " " +studentName + "<br/>"+
							"当前状态: " + result.resultData.status );
					 $("#activityId").val(activityId);
					 $("#applyerId").val(applyerId);
					 $("#content").append(result.resultData.content);
					 if(result.resultData.status != "待审核"){
						 var fb = document.getElementById("fb");
						 fb.style.display = "none";
					 }
					 
				},
				error : function(error) {
					alert(error.resultData);
				},
				async : false
			});
			var pageNo = getParameter('pNo');
			if(!pageNo){
				pageNo = 1;
			}	
			//生成分页
			//有些参数是可选的，比如lang，若不传有默认值
			kkpager.generPageHtml({
				pno : pageNo,
				//总页码
				total : totalPage,
				//总数据条数
				totalRecords : totalRecords,
				//链接前部
				hrefFormer : uri,
				//链接尾部
				//hrefLatter : '.html',
				getLink : function(n){
					if(uri.indexOf("Status")>0)
					{
						return this.hrefFormer + this.hrefLatter + "&pNo="+n
					}else{
						return this.hrefFormer + this.hrefLatter + "?pNo="+n;
					}
				}
			});
	});
});

	
	$('#detailForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			feedBack : {
				validators : {
					notEmpty : {
						message : '反馈不能为空'
					},
				}
			}
		}
	});
	
	//反馈审核信息
	$("#submitBtn").click(function() {
		var Validator = $('#detailForm').data('bootstrapValidator');
		Validator.validate();
		if (!Validator.isValid()) {
			return;
		} 
		$.ajax({
			url : "http://localhost:8080/society_server/admin/activity_apply/passApply",
			type : "post",
			data:  $('#detailForm').serialize(),
			success : function(data) {
				alert("审核成功!");
				window.location.href=window.location.href; 
				window.location.reload; 
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		}); 
	});
	
	//反馈审核信息
	$("#notPassBtn").click(function() {
		var Validator = $('#detailForm').data('bootstrapValidator');
		Validator.validate();
		if (!Validator.isValid()) {
			return;
		} 
		$.ajax({
			url : "http://localhost:8080/society_server/admin/activity_apply/notPassApply",
			type : "post",
			data:  $('#detailForm').serialize(),
			success : function(data) {
				alert("审核成功!");
				window.location.href=window.location.href; 
				window.location.reload; 
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