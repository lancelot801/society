package cn.joongky.society.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.joongky.society.JsonResult;
import cn.joongky.society.ValidJson;
import cn.joongky.society.service.UserLoginService;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	 @Inject
	 private UserLoginService userLoginService;
	 
	 @RequestMapping(value="/login",method = RequestMethod.GET)
	 public String login (@RequestParam String token,@RequestParam String password){	
		 	 userLoginService.login(token, password);
			return "admin/activities";
	 }
	 
	 @RequestMapping(value="/register",method = RequestMethod.POST )
	 public JsonResult register (@RequestParam String studentId,@RequestParam String password){
		  	int result =0;
		    if(studentId != null && password != null)
		 	{
		    	result = userLoginService.register(studentId, password);
		 	}
			JsonResult jr = new JsonResult();
			if (result ==1) {
				jr.setResultCode(0);
				jr.setResultData("注册成功");
			} else {
				jr.setResultCode(-1);
				jr.setResultData("注册失败");
			}
			return jr;
	 }
	 
	 @RequestMapping(value="/existStudentId",method=RequestMethod.GET)
	 public ValidJson existStudentId(@RequestParam String studentId)
	 {   ValidJson vj = new ValidJson();
		 int result = userLoginService.existStudentId(studentId);
		 if(result>0)
		 {
			vj.setValid(false);
		 }else{
			vj.setValid(true);
		 }
		 return vj;
	 }
}
