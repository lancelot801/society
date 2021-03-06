package cn.joongky.society.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.joongky.society.JsonResult;
import cn.joongky.society.pojo.ActivityApply;
import cn.joongky.society.pojo.SocietyInfo;
import cn.joongky.society.pojo.StudentInfo;
import cn.joongky.society.service.ActivityApplyService;
import cn.joongky.society.service.SocietyInfoService;
import cn.joongky.society.service.StudentInfoService;
import cn.joongky.society.util.ConfigUtil;
import cn.joongky.society.util.MailUtil;

@Controller
@RequestMapping("/student/activity_apply")
public class ActivityApplyController {
	@Inject
	private SocietyInfoService sInfoService;
	@Inject
	private ActivityApplyService activityApplyService;
	@Inject
	private StudentInfoService studentInfoService;

	@RequestMapping(value = "/publish", method = RequestMethod.GET)
	public ModelAndView applyCreateSociety(Model model, String studentId, String societyId) {
		model.addAttribute("societyInfo", sInfoService.findBySocietyId(societyId));
		return new ModelAndView("/student/applyActivity");
	}

	@ResponseBody
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public JsonResult editor(@RequestParam String societyId, @RequestParam String applyerId, @RequestParam String theme,
			@RequestParam String content, @RequestParam String holdTime) throws Exception {
		JsonResult jr = new JsonResult();
		synchronized (this) {
			// 发送邮件通知
			StudentInfo stu = studentInfoService.getInfo(applyerId);
			String userEmail = ConfigUtil.getValue("admin_mail");
			String title = "活动申请通知";
			String text = "<div style='font-family:Microsoft YaHei'>亲爱的管理员，您好！<br/>欢迎使用校园社团管理系统,<i style='font-size:20px;'>学号: "
					+ stu.getStudentId() + " 姓名: " + stu.getSname() + " 提交了主题为</i>"
					+ "<i style='color:red;font-size:20px;'>" + theme + "社团活动申请,请尽快审核!</i></div>";
			MailUtil.sendMail(title, text, userEmail);
			activityApplyService.addApply(societyId, theme, applyerId, content, holdTime);
			jr.setResultCode(0);
			jr.setResultData(content);
		}
		return jr;
	}

	@ResponseBody
	@RequestMapping(value = "/findByActivityId", method = RequestMethod.GET)
	public JsonResult findByActivityId(@RequestParam String activityId) {
		JsonResult jr = new JsonResult();
		ActivityApply aapply = activityApplyService.findByActivityId(activityId);
		if (aapply != null) {
			jr.setResultCode(0);
			jr.setResultData(aapply);
		} else {
			jr.setResultCode(-1);
			jr.setResultData("所查询的活动不存在");
		}
		return jr;
	}

	@ResponseBody
	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	public void uploadImg(MultipartFile myFileName, HttpServletResponse response) throws IOException {
		String realName = myFileName.getOriginalFilename();
		long timeStamp = System.currentTimeMillis();
		if (myFileName != null && myFileName.getOriginalFilename() != "") {
			// 图片存储路径
			String filePath = ConfigUtil.getValue("img_url") + ConfigUtil.getValue("activity_img");
			File file = new File(filePath);
			// 如果文件夹不存在创建文件夹
			if (!file.exists()) {
				file.mkdirs();
			}
			try {
				// 存入文件
				myFileName.transferTo(new File(filePath + "/" + timeStamp + myFileName.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		// 返回图片的URL地址
		response.getWriter().write("/idCard" + ConfigUtil.getValue("activity_img") + "/" + timeStamp + realName);
	}

	@RequestMapping(value = "/listMyApply", method = RequestMethod.GET)
	public ModelAndView applyCreateSociety(Model model, Integer pNo, @RequestParam String studentId) {
		List<ActivityApply> aaList;
		if (pNo != null) {
			pNo = pNo - 1;
			if (pNo < 0)
				pNo = 0;
			aaList = activityApplyService.findByStudentIdWithRowBound(pNo, studentId);
		} else {
			aaList = activityApplyService.findByStudentIdWithRowBound(0, studentId);
		}
		model.addAttribute("activities", aaList);
		List<SocietyInfo> sInfoList = new ArrayList<>();
		for (ActivityApply aa : aaList) {
			sInfoList.add(sInfoService.findBySocietyId(aa.getSocietyId()));
		}
		model.addAttribute("sInfoList", sInfoList);
		return new ModelAndView("/student/my_activity_apply");
	}

	@ResponseBody
	@RequestMapping(value = "/listTotalPage", method = RequestMethod.GET)
	public JsonResult listTotalPage() {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(activityApplyService.listTotalPage());
		return jr;
	}

	@ResponseBody
	@RequestMapping(value = "/listTotalPageByStudentId", method = RequestMethod.GET)
	public JsonResult listTotalPageByStudentId(@RequestParam String studentId) {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(activityApplyService.listTotalPageByStudentId(studentId));
		return jr;
	}

	@RequestMapping(value = "/getDetail", method = RequestMethod.GET)
	public String getActivityDetail() {
		return "/student/activityDetail";
	}

	@ResponseBody
	@RequestMapping(value = "/updateApply", method = RequestMethod.POST)
	public JsonResult updateApply(@RequestParam String activityId, String theme, String content, String holdTime)
			throws Exception {
		JsonResult jr = new JsonResult();
		activityApplyService.updateByActivityId(activityId, theme, content, holdTime);
		// 发送邮件通知
		// StudentInfo stu = studentInfoService.getInfo(applyerId);
		// String userEmail = ConfigUtil.getValue("admin_mail");
		// String title = "社团申请通知";
		// String text = "<div style='font-family:Microsoft
		// YaHei'>亲爱的管理员，您好！<br/>欢迎使用校园社团管理系统,<i style='font-size:20px;'>学号: "
		// + stu.getStudentId() + " 姓名: " + stu.getSname() + "提交了主题为</i>" + "<i
		// style='color:red;font-size:20px;'>"
		// + theme + "社团活动申请,请尽快审核!</i></div>";
		// MailUtil.sendMail(title, text, userEmail);
		jr.setResultCode(0);
		jr.setResultData(content);
		return jr;
	}
}
