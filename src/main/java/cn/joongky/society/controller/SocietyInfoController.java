package cn.joongky.society.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.joongky.society.JsonResult;
import cn.joongky.society.pojo.SocietyInfo;
import cn.joongky.society.pojo.SocietyMember;
import cn.joongky.society.pojo.SocietyType;
import cn.joongky.society.service.SocietyInfoService;
import cn.joongky.society.service.SocietyMemberService;
import cn.joongky.society.service.SocietyTypeService;
import cn.joongky.society.util.ConfigUtil;


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
	@RequestMapping(value = "/listTotalPage", method = RequestMethod.GET)
	public JsonResult listTotalPage(@RequestParam String studentId) {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(sMemberService.listTotalPage(studentId));
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
	
	@ResponseBody
	@RequestMapping(value = "/updateById", method = RequestMethod.POST)
	public JsonResult updateById(@RequestParam String societyId,String societyName,MultipartFile logo,String
			typeId,String introduction,String applyerId) {
			JsonResult jr = new JsonResult();
			jr.setResultCode(0);
			String ImageUrl = "";
			if (logo != null && logo.getOriginalFilename()!="") {
			// 图片存储路径
			String filePath = ConfigUtil.getValue("img_url") + "/" + applyerId + "/society_logo";
			long timeStamp = System.currentTimeMillis();
			File file = new File(filePath);
			// 如果文件夹不存在创建文件夹
			if (!file.exists()) {
				file.mkdirs();
			}
			try {
				// 存入文件
				logo.transferTo(new File(filePath + "/" + timeStamp + logo.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			ImageUrl = "/" + applyerId + "/society_logo" + "/" + timeStamp + logo.getOriginalFilename();
			jr.setResultData(sInfoService.updateById(societyId, societyName, ImageUrl, introduction, typeId));
		}else{
			jr.setResultData(sInfoService.updateByIdWithOutlogo(societyId, societyName, introduction, typeId));
		}
		
		
		return jr;
	}
	
}
