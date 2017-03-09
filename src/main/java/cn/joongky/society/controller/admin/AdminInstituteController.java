package cn.joongky.society.controller.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.joongky.society.JsonResult;
import cn.joongky.society.service.InstituteService;

@Controller
@RequestMapping("/admin/institute")
public class AdminInstituteController {
	@Inject
	private InstituteService instituteService;

	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public ModelAndView manage(Model model,Integer pNo){
		//List<Institute> categories = instituteService.findAll();
		if(pNo!=null)
		{
			pNo = pNo -1;
			if(pNo<0)
				pNo = 0;
			model.addAttribute("institutes", instituteService.findWithRowBound(pNo));
		}else{
			model.addAttribute("institutes", instituteService.findWithRowBound(0));
		}
		//model.addAttribute("categories",categories);
		return new ModelAndView("/admin/institutes");
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonResult add(@RequestParam String instituteName) {
		JsonResult jr = new JsonResult();
		int result = instituteService.addInstitute(instituteName);
		if (result == 1) {
			jr.setResultCode(0);
			jr.setResultData("添加成功");
		} else {
			jr.setResultCode(-1);
			jr.setResultData("添加失败");
		}
		return jr;
	}
	
	@ResponseBody
	@RequestMapping(value = "/listToltalPage", method = RequestMethod.GET)
	public JsonResult listToltalPage(){
		JsonResult jr = new JsonResult();
		jr.setResultCode(0);
		jr.setResultData(instituteService.listToltalPage());
		return jr ;
	}
}
