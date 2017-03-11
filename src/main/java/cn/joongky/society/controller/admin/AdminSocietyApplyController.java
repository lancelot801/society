package cn.joongky.society.controller.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.joongky.society.JsonResult;
import cn.joongky.society.service.SocietyApplyService;

@Controller
@RequestMapping("/admin/society_apply")
public class AdminSocietyApplyController {
	@Inject
	private SocietyApplyService saService;

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

}
