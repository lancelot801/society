package cn.joongky.society.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import cn.joongky.society.pojo.SocietyInfo;
import cn.joongky.society.pojo.StudentInfo;
import cn.joongky.society.service.ActivityApplyService;
import cn.joongky.society.service.FeedBackService;
import cn.joongky.society.service.SocietyInfoService;
import cn.joongky.society.service.StudentInfoService;
import cn.joongky.society.util.BasicSysUtil;
import cn.joongky.society.util.MailUtil;

@Controller
@RequestMapping("/admin/activity_apply")
public class AdminActivityApplyController {
	@Inject
	private ActivityApplyService activityApplyService;
	@Inject
	private SocietyInfoService sInfoService;
	@Inject
	private FeedBackService fbService;
	@Inject
	private StudentInfoService studentInfoService;
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public ModelAndView manage(Model model, Integer pNo) {
		List<ActivityApply> aaList;
		if (pNo != null) {
			pNo = pNo - 1;
			if (pNo < 0)
				pNo = 0;
			aaList = activityApplyService.findWithRowBound(pNo);
		} else {
			aaList = activityApplyService.findWithRowBound(0);
		}
		model.addAttribute("activities", aaList);
		List<SocietyInfo> sInfoList = new ArrayList<>();
		for (ActivityApply aa : aaList) {
			sInfoList.add(sInfoService.findBySocietyId(aa.getSocietyId()));
		}
		model.addAttribute("sInfoList", sInfoList);
		return new ModelAndView("/admin/checkActivity");
	}

	@ResponseBody
	@RequestMapping(value = "/listToltalPage", method = RequestMethod.GET)
	public JsonResult listToltalPage() {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(activityApplyService.listToltalPage());
		return jr;
	}

	@RequestMapping(value = "/getDetail", method = RequestMethod.GET)
	public String getActivityDetail() {
		return "/admin/activityDetail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/passApply", method = RequestMethod.POST)
	public JsonResult passApply(@RequestParam String activityId, @RequestParam String applyerId,
			@RequestParam String feedBack, String operatorId) throws Exception {
		JsonResult jr = new JsonResult();
		Map<String, Object> map = new HashMap<>();

		// 块方法同步锁
		synchronized (this) {
			String feedBackId = BasicSysUtil.getUUID();
			activityApplyService.updateActivityStatus(activityId, feedBackId, "已通过");
			fbService.add(feedBackId, feedBack, operatorId);
			ActivityApply aa = activityApplyService.findByActivityId(activityId);
			// 发送邮件通知
			StudentInfo stu = studentInfoService.getInfo(applyerId);
			String title = "社团活动申请通知";
			String text = "<div style='font-family:Microsoft YaHei'>亲爱的同学，您好！<br/>欢迎使用校园社团管理系统,<i style='font-size:20px;'>学号: "
					+ stu.getStudentId() + " 姓名: " + stu.getSname() + "您申请的活动 "+ aa.getTheme() + "</i>"
					+ "<i style='color:red;font-size:20px;'>" + "已通过审核</i></div>";
			MailUtil.sendMail(title, text, stu.getEmail());
		}
		List<Map<String, Object>> json = new ArrayList<>();
		json.add(map);
		jr.setResultCode(0);
		jr.setResultData(json);
		return jr;
	}

	@ResponseBody
	@RequestMapping(value = "/notPassApply", method = RequestMethod.POST)
	public JsonResult notPassApply(@RequestParam String activityId, @RequestParam String applyerId,
			@RequestParam String feedBack, String operatorId, String societyName) throws Exception {
		JsonResult jr = new JsonResult();
		synchronized (this) {
			String feedBackId = BasicSysUtil.getUUID();
			activityApplyService.updateActivityStatus(activityId, feedBackId, "不通过");
			ActivityApply aa = activityApplyService.findByActivityId(activityId);
			fbService.add(feedBackId, feedBack, operatorId);
			StudentInfo stu = studentInfoService.getInfo(applyerId);
			String title = "社团活动申请通知";
			String text = "<div style='font-family:Microsoft YaHei'>亲爱的同学，您好！<br/>欢迎使用校园社团管理系统,<i style='font-size:20px;'>学号: "
					+ stu.getStudentId() + " 姓名: " + stu.getSname() + "。很抱歉,您申请的社团活动 " + aa.getTheme() + "未能通过审核</i>"
					+ "<i style='color:red;font-size:20px;'>" + "未能通过审核</i>" + "<i style='font-size:20px;'>反馈原因:</i>"
					+ "<i style='color:red;font-size:20px;'>" + feedBack + "</i></div>";
			MailUtil.sendMail(title, text, stu.getEmail());
		}
		jr.setResultCode(-1);
		jr.setResultData("审核不通过");
		return jr;
	}
}
