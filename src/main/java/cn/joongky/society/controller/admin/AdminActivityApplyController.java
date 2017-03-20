package cn.joongky.society.controller.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.joongky.society.JsonResult;
import cn.joongky.society.service.ActivityApplyService;

@Controller
@RequestMapping("/admin/activity_apply")
public class AdminActivityApplyController {
	@Inject
	private ActivityApplyService activityApplyService;

	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public ModelAndView manage(Model model, Integer pNo) {
		if (pNo != null) {
			pNo = pNo - 1;
			if (pNo < 0)
				pNo = 0;
			model.addAttribute("activities", activityApplyService.findWithRowBound(pNo));
		} else {
			model.addAttribute("activities", activityApplyService.findWithRowBound(0));
		}
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
	

	
}
