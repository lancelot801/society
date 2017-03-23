$(function() {
	//获取Url中的studentId参数
	function getParameter(name) { 
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r!=null) return unescape(r[2]); return null;
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
		
		var courseStatus = getParameter('courseStauts');
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
			$.ajax({
				url : "http://localhost:8080/society_server/admin/notice/listToltalPage",
				type : "get",
				success : function(result) {
					totalPage = result.resultData.totalPage;
					totalRecords = result.resultData.totalRecords;
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

	$("button.deleteBtn").click(function() {
		if (confirm('确定要删除此信息吗？')) {
			var id = $(this).parents("tr").find("td").eq(0).html();
			$.ajax({
				url : "http://localhost:8080/society_server/admin/notice/deleteById?noticeId=" + id,
				type : "post",
				success : function(result) {
					if (result.resultCode == 0) {
						alert("删除成功！");
						window.location.href=window.location.href; 
						window.location.reload; 
					} else {
						alert("非常抱歉 ," + result.resultData);
					}
				},
				error : function(error) {
					alert(error.resultData);
				},
				async : false
			});
			return true;
		} else {
			return false;
		}
	});
	
	$("button.queryBtn").click(function() {
		$("#noticeModal").modal().draggable({
			handle : ".modal-header",
			cursor : 'move',
			refreshPositions : false
		});
		var id = $(this).parents("tr").find("td").eq(0).html();
		$.ajax({
			url : "http://localhost:8080/society_server/admin/notice/findById?noticeId=" + id,
			type : "get",
			success : function(data) {
				$("#noticeId").val(data.resultData.noticeId);
				$("#theme").val(data.resultData.theme);
				editor.clear();
				editor.$txt.append(data.resultData.content);
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		});
	});
	//修改学院信息
	$("#submitBtn").click(function() {
		var Validator = $('#noticeForm').data('bootstrapValidator');
		Validator.validate();
		if (!Validator.isValid()) {
			return;
		} 
		  var html = editor.$txt.html();
	    	"use strict"; 
		    let params = {};
		    params = {
		    	noticeId :	$("#noticeId").val(),
		    	theme : $("#theme").val(),
		    	content: html,
		    };
		$.ajax({
			url : "http://localhost:8080/society_server/admin/notice/updateById",
			type : "post",
			data:  params,
			success : function(data) {
				alert("修改成功!");
				window.location.href="/society_server/admin//notice/noticeManage"; 
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		}); 
	});
});