package cn.joongky.society.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.joongky.society.JsonResult;
import cn.joongky.society.service.SocietyTypeService;

@Controller
@RequestMapping("/societyType")
public class SocietyTypeController {
	@Inject
	private SocietyTypeService stService;

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonResult list() {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(stService.findAll());
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

}
