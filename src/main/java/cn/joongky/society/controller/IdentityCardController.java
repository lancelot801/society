package cn.joongky.society.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.joongky.society.JsonResult;
import cn.joongky.society.pojo.IdentityCard;
import cn.joongky.society.service.IdentityCardService;

@Controller
@RequestMapping("/identityCard")
public class IdentityCardController {
	@Inject
	private IdentityCardService idService;
	
	@ResponseBody
	@RequestMapping(value = "/getIdCardByStudentId", method = RequestMethod.GET)
	public JsonResult getIdCardByStudentId(@RequestParam String studentId) {
		JsonResult jr = new JsonResult();
		List<IdentityCard> idList = idService.getIdList(studentId);
		if (idList.size() > 0) {
			jr.setResultCode(0);
			jr.setResultData(idList);
		} else {
			jr.setResultCode(-1);
			jr.setResultData("尚未上传学生证");
		}
		return jr;
	}
}
