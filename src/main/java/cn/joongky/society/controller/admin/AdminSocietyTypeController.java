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
import cn.joongky.society.service.SocietyTypeService;

@Controller
@RequestMapping("/admin/societyType")
public class AdminSocietyTypeController {
	@Inject
	private SocietyTypeService stService;

	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public ModelAndView manage(Model model, Integer pNo) {
		// List<Institute> categories = instituteService.findAll();
		if (pNo != null) {
			pNo = pNo - 1;
			if (pNo < 0)
				pNo = 0;
			model.addAttribute("societyTypes", stService.findWithRowBound(pNo));
		} else {
			model.addAttribute("societyTypes", stService.findWithRowBound(0));
		}
		// model.addAttribute("categories",categories);
		return new ModelAndView("/admin/types");
	}

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonResult add(@RequestParam String societyTypeName,String studentId) {
		JsonResult jr = new JsonResult();
		int result = stService.addSocietyType(societyTypeName, studentId);
		if (result == 1) {
			jr.setResultCode(0);
			jr.setResultData("添加成功");
		} else {
			jr.setResultCode(-1);
			jr.setResultData("添加失败");
		}
		return jr;
	}

	@ResponseBody
	@RequestMapping(value = "/listToltalPage", method = RequestMethod.GET)
	public JsonResult listToltalPage() {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(stService.listToltalPage());
		return jr;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	public JsonResult deleteById(@RequestParam String typeId) {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(stService.deleteById(typeId));
		return jr;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public JsonResult findById(@RequestParam String typeId) {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(stService.findById(typeId));
		return jr;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateById", method = RequestMethod.POST)
	public JsonResult findById(@RequestParam String typeId,@RequestParam String societyTypeName,String creater) {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(stService.updateById(typeId, societyTypeName, creater));
		return jr;
	}
}
