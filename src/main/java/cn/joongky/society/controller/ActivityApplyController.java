package cn.joongky.society.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.joongky.society.JsonResult;
import cn.joongky.society.pojo.ActivityApply;
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
		activityApplyService.addApply(societyId, theme, applyerId, content, holdTime);
		// 发送邮件通知
		StudentInfo stu  = studentInfoService.getInfo(applyerId);
		String userEmail = ConfigUtil.getValue("admin_mail");
		String title = "社团申请通知";
		String text = "<div style='font-family:Microsoft YaHei'>亲爱的管理员，您好！<br/>欢迎使用校园社团管理系统,<i style='font-size:20px;'>学号: "
				+ stu.getStudentId() + " 姓名: " + stu.getSname() + "提交了主题为</i>" + "<i style='color:red;font-size:20px;'>"
				+ theme + "社团活动申请,请尽快审核!</i></div>";
		MailUtil.sendMail(title, text, userEmail);
		jr.setResultCode(0);
		jr.setResultData(content);
		return jr;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findByActivityId", method = RequestMethod.GET)
	public JsonResult findByActivityId(@RequestParam String activityId){
		JsonResult jr = new JsonResult();
		ActivityApply aapply = activityApplyService.findByActivityId(activityId);
		if(aapply!=null){
			jr.setResultCode(0);
			jr.setResultData(aapply);
		}else{
			jr.setResultCode(-1);
			jr.setResultData("所查询的活动不存在");
		}
		return jr;
	}
}
