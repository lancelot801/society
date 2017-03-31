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
import cn.joongky.society.pojo.StudentInfo;
import cn.joongky.society.service.FeedBackService;
import cn.joongky.society.service.SocietyApplyService;
import cn.joongky.society.service.SocietyInfoService;
import cn.joongky.society.service.SocietyMemberService;
import cn.joongky.society.service.StudentInfoService;
import cn.joongky.society.util.BasicSysUtil;
import cn.joongky.society.util.MailUtil;

@Controller
@RequestMapping("/admin/society_apply")
public class AdminSocietyApplyController {
	@Inject
	private SocietyApplyService saService;
	@Inject
	private FeedBackService fbackService;
	@Inject
	private SocietyInfoService sInfoService;
	@Inject
	private SocietyMemberService sMemberService;
	@Inject
	private StudentInfoService studentInfoService;

	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public ModelAndView manage(Model model, Integer pNo) {
		if (pNo != null) {
			pNo = pNo - 1;
			if (pNo < 0)
				pNo = 0;
			model.addAttribute("societyApplies", saService.findWithRowBound(pNo));
		} else {
			model.addAttribute("societyApplies", saService.findWithRowBound(0));
		}
		return new ModelAndView("/admin/checkSociety");
	}

	@ResponseBody
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public JsonResult findByApplyId(@RequestParam String applyId) {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(saService.findById(applyId));
		return jr;
	}

	@ResponseBody
	@RequestMapping(value = "/passApply", method = RequestMethod.POST)
	public JsonResult passApply(@RequestParam String societyApplyId, @RequestParam String applyerId,
			@RequestParam String feedBack, String operatorId, @RequestParam String societyName) throws Exception {
		JsonResult jr = new JsonResult();
		Map<String, Object> map = new HashMap<String, Object>();

		// 块方法同步锁
		synchronized (this) {
			String feedBackId = BasicSysUtil.getUUID();
			String societyId = BasicSysUtil.getUUID();
			// // 修改社团申请状态
			// map.put("society_apply",
			// saService.updateStatusById(societyApplyId, feedBackId, "已通过"));
			// // 添加反馈表信息
			// map.put("feed_back", fbackService.add(feedBackId, feedBack,
			// operatorId));
			// // 添加社团信息
			// map.put("society_info", sInfoService.add(societyId,
			// saService.findById(societyApplyId)));
			// // 添加社团人员表信息
			// map.put("society_member", sMemberService.joinSociety(societyId,
			// applyerId, "社团会长"));
			saService.updateStatusById(societyApplyId, feedBackId, "已通过");
			fbackService.add(feedBackId, feedBack, operatorId);
			sInfoService.addByApply(societyId, saService.findById(societyApplyId));
			sMemberService.joinSociety(societyId, applyerId, "社团会长");
			//修改社团总数信息
			int nowCount = sMemberService.getMembersCount(societyId)+ 1 ;
			sInfoService.updateMemberCount(societyId, nowCount);
			// 发送邮件通知
			StudentInfo stu = studentInfoService.getInfo(applyerId);
			String title = "社团申请通知";
			String text = "<div style='font-family:Microsoft YaHei'>亲爱的同学，您好！<br/>欢迎使用校园社团管理系统,<i style='font-size:20px;'>学号: "
					+ stu.getStudentId() + " 姓名: " + stu.getSname() + "您申请的社团 " + societyName + "</i>"
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
	public JsonResult notPassApply(@RequestParam String societyApplyId, @RequestParam String applyerId,
			@RequestParam String feedBack, String operatorId, String societyName) throws Exception {
		JsonResult jr = new JsonResult();
		synchronized (this) {
			String feedBackId = BasicSysUtil.getUUID();
			saService.updateStatusById(societyApplyId, feedBackId, "不通过");
			fbackService.add(feedBackId, feedBack, operatorId);
			StudentInfo stu = studentInfoService.getInfo(applyerId);
			String title = "社团申请通知";
			String text = "<div style='font-family:Microsoft YaHei'>亲爱的同学，您好！<br/>欢迎使用校园社团管理系统,<i style='font-size:20px;'>学号: "
					+ stu.getStudentId() + " 姓名: " + stu.getSname() + "。很抱歉,您申请的社团 " + societyName + "未能通过审核</i>"
					+ "<i style='color:red;font-size:20px;'>" + "未能通过审核</i>" + "<i style='font-size:20px;'>反馈原因:</i>"
					+ "<i style='color:red;font-size:20px;'>" + feedBack + "</i></div>";
			MailUtil.sendMail(title, text, stu.getEmail());
		}
		jr.setResultCode(-1);
		jr.setResultData("审核不通过");
		return jr;
	}
	
	@ResponseBody
	@RequestMapping(value = "/listToltalPage", method = RequestMethod.GET)
	public JsonResult listToltalPage() {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(saService.listToltalPage());
		return jr;
	}
}
