$(function() {
	$("button.deleteBtn").click(function() {
		if (confirm('确定要删除此信息吗？')) {
			var id = $(this).parents("tr").find("td").eq(0).html();
			$.ajax({
				url : "http://api.flyplus1.com/course/deleteById?courseId=" + id,
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
	
	$("button.checkedBtn").click(function() {
		if (confirm('确定通过该课程吗？')) {
			var id = $(this).parents("tr").find("td").eq(0).html();
			$.ajax({
				url : "http://api.flyplus1.com/admin/course/checkedCourseById?courseId=" + id,
				type : "post",
				success : function(result) {
					if (result.resultCode == 0) {
						alert("修改成功！");
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
	
	$("button.addBtn").click(function() {
		$("#addCourseModal").modal().draggable({
			handle : ".modal-header",
			cursor : 'move',
			refreshPositions : false
		});
	});
	
	$("button.queryBtn").click(function() {
		$("#courseModal").modal().draggable({
			handle : ".modal-header",
			cursor : 'move',
			refreshPositions : false
		});
		var id = $(this).parents("tr").find("td").eq(0).html();
		
		$.ajax({
			url : "http://api.flyplis1.com/course/findById?courseId=" + id,
			type : "post",
			success : function(data) {
				$("#courseId").val(data.resultData.courseId)
				$("#categoryId").val(data.resultData.categoryId);
				$("#courseName").val(data.resultData.courseName);
				$("#description").val(data.resultData.description);
	
				var status = data.resultData.courseStatus ;
				var courseStatus = document.getElementById("courseStatus");  
				for(var i=0; i<courseStatus.options.length; i++){  
					if(courseStatus.options[i].value == String (data.resultData.courseStatus)){  
						courseStatus.options[i].selected = true;  
				        break;  
				    }  
				}  
				/*
				if(data.resultData.courseStatus =='报名中' || data.resultData.courseStatus =='开课中' || data.resultData.courseStatus=='已结束'){
					$("#submitBtn").hide();
				}else{
					$("#submitBtn").show();
				}*/
				
				$("#price").val(data.resultData.price);
				$("#startTime").val(data.resultData.startTime);
				$("#lessonNumber").val(data.resultData.lessonNumber);
				$("#courseImg").attr("src","http://img.flyplus1.com"+data.resultData.imgUrl);
				var openAudio = document.getElementById("openAudio");  
				for(var i=0; i<openAudio.options.length; i++){  
					if(openAudio.options[i].value == String (data.resultData.openAudio)){  
						openAudio.options[i].selected = true;  
				        break;  
				    }  
				}  
				$("#sequence").val(data.resultData.sequence);
			},
			error : function(error) {
				alert(error.responseText);
			},
			async : false
		});
	});
	
	$("#submitBtn").click(function() {
		$.ajax({
			url : "http://api.flyplus1.com/course/updateById",
			type : "post",
			data:  new FormData($('#updateCourse')[0]),
			cache: false,
			processData: false,
			contentType: false,
			success : function(data) {
				alert("修改成功!");
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