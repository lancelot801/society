package cn.joongky.society.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.joongky.society.JsonResult;
import cn.joongky.society.pojo.UserLogin;
import cn.joongky.society.service.UserLoginService;

@RestController
@RequestMapping("/user")
public class UserLoginController {
	 @Inject
	 private UserLoginService userLoginService;
	 
	 @RequestMapping("login")
	 public JsonResult login (@RequestParam String token,@RequestParam String password){
			UserLogin ul = userLoginService.login(token, password);
			JsonResult jr = new JsonResult();
			if (ul != null) {
				//Person p = personService.getPersonByOpenid(ul.getPartyId());
				//request.getSession().setAttribute("person", p);
				jr.setResultCode(0);
				jr.setResultData("登录成功");
			} else {
				jr.setResultCode(-10);
				jr.setResultData("用户账号或密码不正确");
			}
			return jr;
	 }
	 
	 @RequestMapping("/register")
	 public JsonResult register (@RequestParam String studentId,@RequestParam String password){
			int result = userLoginService.register(studentId, password);
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
}
