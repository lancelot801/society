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
import cn.joongky.society.service.ActivityApplyService;
import cn.joongky.society.service.SocietyInfoService;

@Controller
@RequestMapping("/student/activity_apply")
public class ActivityApplyController {
	@Inject
	private SocietyInfoService sInfoService;
	@Inject
	private ActivityApplyService activityApplyService;

	@RequestMapping(value = "/publish", method = RequestMethod.GET)
	public ModelAndView applyCreateSociety(Model model, String studentId, String societyId) {
		model.addAttribute("societyInfo", sInfoService.findBySocietyId(societyId));
		return new ModelAndView("/student/applyActivity");
	}

	@ResponseBody
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public JsonResult editor(@RequestParam String societyId, @RequestParam String applyerId, @RequestParam String theme,
			@RequestParam String content, @RequestParam String holdTime) {
		JsonResult jr = new JsonResult();
		activityApplyService.addApply(societyId, theme, applyerId, content, holdTime);
		jr.setResultCode(0);
		jr.setResultData(content);
		return jr;
	}
}
