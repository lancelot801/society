package cn.joongky.society.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
public class ErrorController {

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String error1(ModelMap model) {
		return "error/404";
	}

	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public String error2(ModelMap model) {
		return "error/500";
	}
	
	@RequestMapping(value = "/authority", method = RequestMethod.GET)
	public String adminException(ModelMap model) {
		return "error/authority";
	}
}

