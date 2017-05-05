package cn.joongky.society.service;

import cn.joongky.society.pojo.SocietyApply;
import cn.joongky.society.pojo.SocietyInfo;

public interface SocietyInfoService {
	//添加社团信息
	SocietyInfo addByApply(String societyId,SocietyApply sa);
	//根据社团编号查找社团信息
	SocietyInfo findBySocietyId(String societyId);
	//更新社团人数
	SocietyInfo updateMemberCount(String societyId,int membersCount);
	//更新社团信息
	SocietyInfo updateById(String societyId,String societyName, String ImageUrl, String introduction, String typeId);
	//除logo更新
	SocietyInfo updateByIdWithOutlogo(String societyId, String societyName, String introduction, String typeId);
}    
