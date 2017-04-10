package cn.joongky.society.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.joongky.society.JsonResult;
import cn.joongky.society.service.SocietyNoticeService;
import cn.joongky.society.util.ConfigUtil;
@Controller
@RequestMapping("/admin/notice")
public class AdminNoticeController {
	@Inject
	private SocietyNoticeService snoticeService;
	@RequestMapping(value = "/publishNotice", method = RequestMethod.GET)
	public String manage() {
		return "/admin/publish_notice";
	}
	
	@RequestMapping(value = "/noticeManage", method = RequestMethod.GET)
	public ModelAndView noticemanage(Model model, Integer pNo) {
		if (pNo != null) {
			pNo = pNo - 1;
			if (pNo < 0)
				pNo = 0;
			model.addAttribute("notices", snoticeService.findWithRowBound(pNo));
		} else {
			model.addAttribute("notices", snoticeService.findWithRowBound(0));
		}
		return new ModelAndView("/admin/notice_manage");
	}
	@ResponseBody
	@RequestMapping(value = "/publish",method = RequestMethod.POST)
	public JsonResult publish(@RequestParam String publisher,@RequestParam String theme,@RequestParam String content){
		JsonResult jr = new JsonResult();
		int result = snoticeService.publishNotice(publisher, theme, content);
		if(result>0){
			jr.setResultCode(0);
			jr.setResultData("发布成功");	
		}else{
			jr.setResultCode(-1);
			jr.setResultData("发布失败");
		}
			
		return jr;
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
	public void uploadImg(MultipartFile myFileName,HttpServletResponse response) throws IOException{
		String realName = myFileName.getOriginalFilename();
		long timeStamp = System.currentTimeMillis();
		if (myFileName != null && myFileName.getOriginalFilename()!="") {
			// 图片存储路径
			String filePath = ConfigUtil.getValue("img_url")+ ConfigUtil.getValue("notice_img");
			File file = new File(filePath);
			// 如果文件夹不存在创建文件夹
			if (!file.exists()) {
				file.mkdirs();
			}
			try {
				// 存入文件
				myFileName.transferTo(new File(filePath + "/"+ timeStamp + myFileName.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		 // 返回图片的URL地址
        response.getWriter().write("/idCard" + ConfigUtil.getValue("notice_img")+"/" + timeStamp+ realName);
	}
	
	@ResponseBody
	@RequestMapping(value = "/listTotalPage", method = RequestMethod.GET)
	public JsonResult listTotalPage() {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(snoticeService.listTotalPage());
		return jr;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	public JsonResult deleteById(@RequestParam String noticeId) {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(snoticeService.deleteById(noticeId));
		return jr;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public JsonResult findById(@RequestParam String noticeId) {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(snoticeService.findById(noticeId));
		return jr;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateById", method = RequestMethod.POST)
	public JsonResult updateById(@RequestParam String noticeId,@RequestParam String theme,@RequestParam String content) {
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(snoticeService.updateById(noticeId, theme, content));
		return jr;
	}
}
