package cn.joongky.society.service;

import cn.joongky.society.pojo.SocietyApply;

public interface SocietyApplyService {
	// 添加社团申请记录
	SocietyApply addApply(String societyName, String ImageUrl, String introduction, String typeId, String applyerId);
}
