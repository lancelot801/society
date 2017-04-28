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
				url : "/society_server/admin/institute/listTotalPage",
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
	
	$('#addInstituteForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			instituteName : {
				validators : {
					notEmpty : {
						message : '学院名称不能为空'
					},
				}
			}
		}
	});
	
	$('#updateInstitute').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			instituteName : {
				validators : {
					notEmpty : {
						message : '学院名称不能为空'
					},
				}
			}
		}
	});
	
	$("button.addBtn").click(function() {
		$("#addInstituteModal").modal().draggable({
			handle : ".modal-header",
			cursor : 'move',
			refreshPositions : false
		});
	});
	//添加学院信息
	$("#addInstituteBtn").click(function() {
		var Validator = $('#addInstituteForm').data('bootstrapValidator');
		Validator.validate();
		if (!Validator.isValid()) {
			return;
		} 
		$.ajax({
			url : "/society_server/admin/institute/add",
			type : "post",
			data:  $('#addInstituteForm').serialize(),
			success : function(data) {
				if(data.resultCode == 0){
					swal('添加成功', '快去看看吧!', 'success');
					$("#addInstituteModal").modal('hide');
					//延时刷新页面
					setTimeout(function(){
						window.location.href=window.location.href; 
						window.location.reload; },1000);
				}
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		});	
		
		
	});  
	
	$("button.deleteBtn").click(function() {
		var id = $(this).parents("tr").find("td").eq(0).html();
		swal({
			  title: '确认删除吗?',
			  text: '你将要删除本条信息!',
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonText: '是的,删除它!',
			  cancelButtonText: '不,保持原状',
			}).then(function(isConfirm) {
			  if (isConfirm === true) {
					$.ajax({
						url : "/society_server/admin/institute/deleteById?instituteId=" + id,
						type : "post",
						success : function(result) {
							if (result.resultCode == 0) {
								 swal(
										'已删除!',
										'这条记录已经被删除.',
										'success'
									);
								//延时刷新页面
									setTimeout(function(){
										window.location.href=window.location.href; 
										window.location.reload; },1000);
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

			  } else if (isConfirm === false) {
			    swal(
			      '已取消',
			      '这条记录是安全的 :)',
			      'error'
			    );
			  
			  } else {
			    // Esc, close button or outside click
			    // isConfirm is undefined
			  }
			});
	});
	
	$("button.queryBtn").click(function() {
		$("#instituteModal").modal().draggable({
			handle : ".modal-header",
			cursor : 'move',
			refreshPositions : false
		});
		var id = $(this).parents("tr").find("td").eq(0).html();
		$.ajax({
			url : "/society_server/admin/institute/findById?instituteId=" + id,
			type : "get",
			success : function(data) {
				$("#instituteId").val(data.resultData.instituteId);
				$("#instituteName2").val(data.resultData.instituteName);
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		});
	});
	//修改学院信息
	$("#submitBtn").click(function() {
		var Validator = $('#updateInstitute').data('bootstrapValidator');
		Validator.validate();
		if (!Validator.isValid()) {
			return;
		} 
		$.ajax({
			url : "/society_server/admin/institute/updateById",
			type : "post",
			data:  $('#updateInstitute').serialize(),
			success : function(data) {
				 swal(
							'修改成功!',
							'这条记录已修改.',
							'success'
						);
					//延时刷新页面
						setTimeout(function(){
							window.location.href=window.location.href; 
							window.location.reload; },1000);
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		}); 
	});
});