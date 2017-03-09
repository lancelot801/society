$(function() {
	//获取Url中的studentId参数
	function getParameter(name) { 
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r!=null) return unescape(r[2]); return null;
	};

	function isContains(str, substr) {
	    return new RegExp(substr).test(str);
	};
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
				url : "http://localhost:8080/society_server/admin/institute/listToltalPage",
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