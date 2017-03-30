package cn.joongky.society.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.joongky.society.JsonResult;
import cn.joongky.society.pojo.SocietyInfo;
import cn.joongky.society.pojo.SocietyMember;
import cn.joongky.society.pojo.SocietyType;
import cn.joongky.society.service.SocietyInfoService;
import cn.joongky.society.service.SocietyMemberService;
import cn.joongky.society.service.SocietyTypeService;


@Controller
@RequestMapping("/student/societyInfo")
public class SocietyInfoController {
	@Inject
	private SocietyInfoService sInfoService;
	@Inject
	private SocietyMemberService sMemberService;
	@Inject
	private SocietyTypeService sTypeService;
	@RequestMapping(value = "manage", method = RequestMethod.GET)
	public ModelAndView applyCreateSociety(Model model, String studentId) {
		List<SocietyInfo> sInfoList = new ArrayList<>();
		List<SocietyMember> sMemberList = sMemberService.listByStudentId(studentId);
		List<SocietyType> sTypeList = new ArrayList<>();
		if (!sMemberList.isEmpty()) {
			for (SocietyMember sMember : sMemberList) {
				sInfoList.add(sInfoService.findBySocietyId(sMember.getSocietyId()));
				String typeId = sInfoService.findBySocietyId(sMember.getSocietyId()).getTypeId();
				sTypeList.add(sTypeService.findById(typeId));
			}
			model.addAttribute("societyTypes", sTypeList);
			model.addAttribute("societyMembers", sMemberList);
			model.addAttribute("societyInfos", sInfoList);
		}
		return new ModelAndView("/student/mySociety");
	}
	
	@ResponseBody
	@RequestMapping(value = "/listToltalPage", method = RequestMethod.GET)
	public JsonResult listToltalPage(@RequestParam String studentId) {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(sMemberService.listToltalPage(studentId));
		return jr;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public JsonResult findById(@RequestParam String societyId) {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(sInfoService.findBySocietyId(societyId));
		return jr;
	}
}
