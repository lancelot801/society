<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<link rel="shortcut icon" href="<%=request.getContextPath()%>/img/my_ico.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<style type="text/css">
.tb960x90 {display:none!important;display:none}</style>
<link href="<%=request.getContextPath()%>/css/pintuer.css" rel="stylesheet">
<title>嗨呀,出错啦！</title>
</head>
<body>
 	<!--  <h2>${exception.message}</h2>-->
  <div class="container" style=" margin-top:8%;"> 
   <div class="panel margin-big-top">
      <div class="text-center">
         <br>
         <h2 class="padding-top"> 
         <stong>500 Server Error</stong> 
         <br/>
         <stong>服务器内部错误</stong> 
         </h2>
         <div class=""> 
            <div class="float-left">
                <img src="<%=request.getContextPath()%>/img/ds-1.gif">
                <div class="alert"> 卧槽！页面不见了！ </div>
            </div>
            <div class="float-right">
               <img src="<%=request.getContextPath()%>/img/ds-2.png" width="260"> 
            </div>
          </div>
          <div class="padding-big">
               <a href="http://localhost:8080/society_server/" class="button bg-yellow">返回首页</a>
               <a href="#" class="button">保证不打死管理员</a>
          </div> 
      </div> 
   </div> 
</body>
</html>