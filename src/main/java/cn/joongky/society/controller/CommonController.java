package cn.joongky.society.controller;

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
import cn.joongky.society.pojo.ActivityApply;
import cn.joongky.society.pojo.SocietyNotice;
import cn.joongky.society.service.ActivityApplyService;
import cn.joongky.society.service.SocietyNoticeService;

@Controller
@RequestMapping("/common")
public class CommonController {
	@Inject
	private ActivityApplyService activityApplyService;
	@Inject
	private SocietyNoticeService societyNoticeService;
	//首页展示前五条活动信息
	@ResponseBody
	@RequestMapping(value = "/listActivity", method = RequestMethod.GET)
	public JsonResult listActivity(){
		JsonResult jr = new JsonResult();
		List<ActivityApply> aList = activityApplyService.findByStatusWithRowBound(0, "已通过");
		if(!aList.isEmpty()){
			jr.setResultCode(0);
			//查出前五条已通过活动信息
			jr.setResultData(aList);
		}else{
			jr.setResultCode(-1);
			jr.setResultData("无数据");
		}	
		return jr;
	}
	
	//首页展示公告信息
	@ResponseBody
	@RequestMapping(value = "/listNotice", method = RequestMethod.GET)
	public JsonResult listNotice(){
		JsonResult jr = new JsonResult();
		List<SocietyNotice> aList = societyNoticeService.findWithRowBound(0);
		if(!aList.isEmpty()){
			jr.setResultCode(0);
			//查出前五条已通过活动信息
			jr.setResultData(aList);
		}else{
			jr.setResultCode(-1);
			jr.setResultData("无数据");
		}	
		return jr;
	}
	
	@RequestMapping(value = "/getNotice", method = RequestMethod.GET)
	public ModelAndView getNotice(Model model,@RequestParam String noticeId){
		model.addAttribute("notice", societyNoticeService.findById(noticeId));
		return new ModelAndView("/common/notice_detail");
	}
	
	@RequestMapping(value = "/getActivity", method = RequestMethod.GET)
	public ModelAndView getActivity(Model model,@RequestParam String activityId){
		model.addAttribute("activity", activityApplyService.findByActivityId(activityId));
		return new ModelAndView("/common/activity_detail");
	}
	
	@RequestMapping(value = "/guidence", method = RequestMethod.GET)
	public String guidence(){
		return "/common/guidence";
	}
	
	@RequestMapping(value = "/activity_more", method = RequestMethod.GET)
	public ModelAndView activityMore(Model model, Integer pNo) {
		if (pNo != null) {
			pNo = pNo - 1;
			if (pNo < 0)
				pNo = 0;
			model.addAttribute("activities", activityApplyService.findByStatusWithRowBound(pNo, "已通过"));
		} else {
			model.addAttribute("activities", activityApplyService.findByStatusWithRowBound(0, "已通过"));
		}
		return new ModelAndView("/common/activity_more");
	}
	
	@RequestMapping(value = "/notice_more", method = RequestMethod.GET)
	public ModelAndView noticeMore(Model model, Integer pNo) {
		if (pNo != null) {
			pNo = pNo - 1;
			if (pNo < 0)
				pNo = 0;
			model.addAttribute("notices", societyNoticeService.findWithRowBound(pNo));
		} else {
			model.addAttribute("notices", societyNoticeService.findWithRowBound(0));
		}
		return new ModelAndView("/common/notice_more");
	}
	
	@ResponseBody
	@RequestMapping(value = "/activity/listPassTotalPage", method = RequestMethod.GET)
	public JsonResult passTotalPage(){
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(activityApplyService.listTotalPageByStatus("已通过"));
		return jr ;
	}
	@ResponseBody
	@RequestMapping(value = "/notice/listTotalPage", method = RequestMethod.GET)
	public JsonResult listTotalPage(){
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(societyNoticeService.listTotalPage());
		return jr ;
	}
}
