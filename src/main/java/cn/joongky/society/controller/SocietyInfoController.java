package cn.joongky.society.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.joongky.society.pojo.SocietyInfo;
import cn.joongky.society.pojo.SocietyMember;
import cn.joongky.society.service.SocietyInfoService;
import cn.joongky.society.service.SocietyMemberService;

@Controller
@RequestMapping("/societyInfo")
public class SocietyInfoController {
	@Inject
	private SocietyInfoService sInfoService;
	@Inject
	private SocietyMemberService sMemberService;
	@RequestMapping(value = "manage", method = RequestMethod.GET)
	public ModelAndView applyCreateSociety(Model model, String studentId) {
		List<SocietyInfo> sInfoList = new ArrayList<>();
		List<SocietyMember> sMemberList = sMemberService.listByStudentId(studentId);
		for(SocietyMember sMember : sMemberList)
		{
			sInfoList.add(sInfoService.findBySocietyId(sMember.getSocietyId()));
		}
		model.addAttribute("societyMembers", sMemberList);
		model.addAttribute("societyInfos", sInfoList);
		return new ModelAndView("/student/mySociety");
	}
}
