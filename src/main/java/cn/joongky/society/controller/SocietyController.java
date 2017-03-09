package cn.joongky.society.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/society")
public class SocietyController {
		
	@RequestMapping(value="applyCreateSociety", method = RequestMethod.GET)
	public String applyCreateSociety(String studentId)
	{
		return "/student/applySociety";
	}
}
