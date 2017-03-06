package cn.joongky.society.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.joongky.society.pojo.StudentInfo;
import cn.joongky.society.service.StudentInfoService;

@Controller
@RequestMapping("/student")
public class StudentInfoController {
	@Inject
	private StudentInfoService sInfoService;
	
	@RequestMapping(value="/showInfo",method = RequestMethod.GET)
	public ModelAndView showInfo(Model model,String studentId)
	{
		StudentInfo si =  sInfoService.getInfo(studentId);
		if(si!=null){
			model.addAttribute("studentInfo", si);
		}	
		return new ModelAndView("student/info");
	}
}
