package cn.joongky.society.controller;

import java.io.File;
import java.io.IOException;
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
import cn.joongky.society.pojo.SocietyType;
import cn.joongky.society.pojo.StudentInfo;
import cn.joongky.society.service.SocietyApplyService;
import cn.joongky.society.service.SocietyTypeService;
import cn.joongky.society.service.StudentInfoService;
import cn.joongky.society.util.ConfigUtil;
import cn.joongky.society.util.MailUtil;

@Controller
@RequestMapping("/societyApply")
public class SocietyApplyController {
	@Inject
	private SocietyTypeService stService;
	@Inject
	private SocietyApplyService saService;
	@Inject
	private StudentInfoService studentInfoService;
	@RequestMapping(value = "manage", method = RequestMethod.GET)
	public ModelAndView applyCreateSociety(Model model, String studentId) {
		List<SocietyType> stList = stService.findAll();
		model.addAttribute("societyTypes", stList);
		return new ModelAndView("/student/applySociety");
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public JsonResult addApplyCreateSociety(@RequestParam String societyName, @RequestParam String applyerId,
			MultipartFile logoUrl, @RequestParam String typeId, @RequestParam String introduction) throws Exception{
		String ImageUrl = "";
		if (logoUrl != null) {
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
				logoUrl.transferTo(new File(filePath + "/" + timeStamp + logoUrl.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			ImageUrl = "/" + applyerId + "/society_logo" + "/" + timeStamp + logoUrl.getOriginalFilename();
			saService.addApply(societyName, ImageUrl, introduction, typeId, applyerId);
			//申办后给管理员发送邮件通知
			StudentInfo stu = studentInfoService.getInfo(applyerId);
			String userEmail = ConfigUtil.getValue("admin_mail"); 
			String title = "社团申请通知"; 
			String text ="<div style='font-family:Microsoft YaHei'>亲爱的管理员，您好！<br/>欢迎使用校园社团管理系统,<i style='font-size:20px;'>学号: "
			 + stu.getStudentId()+" 姓名: "+stu.getSname()+"提交了</i>" +"<i style='color:red;font-size:20px;'>"+stService.findById(typeId).getTypeName()
			 		+ "申请,请尽快审核</i></div>"; 
			  MailUtil.sendMail(title, text, userEmail);
			 
		}
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData("申请成功");
		return jr;
	}
}
