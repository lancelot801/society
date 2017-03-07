package cn.joongky.society.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.joongky.society.JsonResult;
import cn.joongky.society.ValidJson;
import cn.joongky.society.pojo.UserLogin;
import cn.joongky.society.service.StudentInfoService;
import cn.joongky.society.service.UserLoginService;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	@Inject
	private UserLoginService userLoginService;
	@Inject
	private StudentInfoService sInfoService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String token, @RequestParam String password, HttpSession session)
			throws Exception {
		UserLogin ul = userLoginService.login(token, password);
		/*
		 * String userEmail = ConfigUtil.getValue("admin_mail"); String title =
		 * "用户登录通知"; String text =
		 * "<div style='font-family:Microsoft YaHei'>亲爱的用户，您好！<br/>欢迎使用校园社团管理系统,你的用户审核<i style='color:red;font-size:20px;'>失败</i>，请重新申请！</div>"
		 * ; MailUtil.sendMail(title, text, userEmail);
		 */
		session.setAttribute("userLogin", ul);
		return "admin/activities";
	}

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public JsonResult register(@RequestParam String studentId, @RequestParam String password) {
		int result = 0;
		if (studentId != null && password != null) {
			result = userLoginService.register(studentId, password);
		}
		JsonResult jr = new JsonResult();
		if (result == 1) {
			// 注册的同时向学生表中添加学生基本信息
			sInfoService.addBasicInfo(studentId);
			jr.setResultCode(0);
			jr.setResultData("注册成功");
		} else {
			jr.setResultCode(-1);
			jr.setResultData("注册失败");
		}
		return jr;
	}

	@ResponseBody
	@RequestMapping(value = "/existStudentId", method = RequestMethod.GET)
	public ValidJson existStudentId(@RequestParam String studentId) {
		ValidJson vj = new ValidJson();
		int result = userLoginService.existStudentId(studentId);
		if (result > 0) {
			vj.setValid(false);
		} else {
			vj.setValid(true);
		}
		return vj;
	}

	@RequestMapping(value = "quit", method = RequestMethod.GET)
	public String quit(HttpSession session) {
		session.invalidate();
		// 为空默认index 速度慢 或者制定为index.jsp
		// return ("redirect:/");
		return ("redirect:/index.jsp");
	}
}
