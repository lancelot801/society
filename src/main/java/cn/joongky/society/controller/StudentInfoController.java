package cn.joongky.society.controller;

import java.io.File;
import java.io.IOException;

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
import cn.joongky.society.service.IdentityCardService;
import cn.joongky.society.service.StudentInfoService;
import cn.joongky.society.service.UserLoginService;
import cn.joongky.society.util.ConfigUtil;

@Controller
@RequestMapping("/student")
public class StudentInfoController {
	@Inject
	private StudentInfoService sInfoService;
	@Inject
	private UserLoginService ulService;
	@Inject
	private IdentityCardService idCardService;

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
		String ImageUrl1 = "";
		String ImageUrl2 = "";
		if (identityCard1 != null && identityCard1.getOriginalFilename()!="") {
			// 图片存储路径
			String filePath = ConfigUtil.getValue("img_url") + "/" + studentId + "/identityCard";
			long timeStamp = System.currentTimeMillis();
			File file = new File(filePath);
			// 如果文件夹不存在创建文件夹
			if (!file.exists()) {
				file.mkdirs();
			}
			try {
				// 存入文件
				identityCard1.transferTo(new File(filePath + "/" + timeStamp + identityCard1.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			ImageUrl1 = "/" + studentId + "/identityCard" + "/" + timeStamp + identityCard1.getOriginalFilename();
			if (idCardService.getByTypeAndId(studentId, "cover") == null) {
				idCardService.addCard(ImageUrl1, studentId, "cover");
			} else {
				idCardService.updateCard(ImageUrl1, studentId, "cover");
			}

		}
		if (identityCard2 != null && identityCard2.getOriginalFilename()!="") {
			// 图片存储路径
			String filePath = ConfigUtil.getValue("img_url") + "/" + studentId + "/identityCard";
			long timeStamp = System.currentTimeMillis();
			File file = new File(filePath);
			// 如果文件夹不存在创建文件夹
			if (!file.exists()) {
				file.mkdirs();
			}
			try {
				// 存入文件
				identityCard2.transferTo(new File(filePath + "/" + timeStamp + identityCard2.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			ImageUrl2 = "/" + studentId + "/identityCard" + "/" + timeStamp + identityCard2.getOriginalFilename();
			if (idCardService.getByTypeAndId(studentId, "content") == null) {
				idCardService.addCard(ImageUrl2, studentId, "content");
			} else {
				idCardService.updateCard(ImageUrl2, studentId, "content");
			}
		}
		jr.setResultCode(0);
		jr.setResultData(si);
		return jr;
	}

	@ResponseBody
	@RequestMapping(value = "/getInfo", method = RequestMethod.POST)
	public JsonResult getInfo(@RequestParam String studentId) {
		JsonResult jr = new JsonResult();
		StudentInfo si = sInfoService.getInfo(studentId);

		if (si != null && si.getInstituteId() != null && si.getClassId() != null) {
			jr.setResultCode(0);
			jr.setResultData(si);
		} else {
			jr.setResultCode(-1);
			jr.setResultData("个人信息缺失");
		}
		return jr;
	}
}
