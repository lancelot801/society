package cn.joongky.society.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.joongky.society.JsonResult;
import cn.joongky.society.pojo.StudentInfo;
import cn.joongky.society.service.StudentInfoService;
import cn.joongky.society.service.UserLoginService;

@Controller
@RequestMapping("/student")
public class StudentInfoController {
	@Inject
	private StudentInfoService sInfoService;
	@Inject
	private UserLoginService ulService;

	@RequestMapping(value = "/showInfo", method = RequestMethod.GET)
	public ModelAndView showInfo(Model model, @RequestParam String studentId) {
		StudentInfo si = sInfoService.getInfo(studentId);
		if (si != null) {
			model.addAttribute("studentInfo", si);
		}
		return new ModelAndView("student/info");
	}

	@ResponseBody
	@RequestMapping(value = "/updateStudentInfo", method = RequestMethod.POST)
	public JsonResult updateStudentInfo(HttpSession session, @RequestParam String studentId, String instituteId,
			String classId, String sname, String sex, String nickname, String email, String mobile,
			MultipartFile identityCard1, MultipartFile identityCard2) {
		JsonResult jr = new JsonResult();
		// String identityId = BasicSysUtil.getUUID();
		// 修改个人信息提示补充userlogin
		StudentInfo si = sInfoService.updateStudentInfo(studentId, instituteId, classId, sname, sex, nickname, email,
				mobile);
		ulService.addOtherInfo(studentId, nickname, email, mobile);
		jr.setResultCode(0);
		jr.setResultData(si);
		return jr;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getInfo", method = RequestMethod.POST)
	public JsonResult getInfo(@RequestParam String studentId)
	{
		JsonResult jr = new JsonResult();
		StudentInfo si = sInfoService.getInfo(studentId);
		jr.setResultCode(0);
		jr.setResultData(si);
		return jr;
	}
}
