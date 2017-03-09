package cn.joongky.society.service;

import java.util.List;

import cn.joongky.society.pojo.IdentityCard;

public interface IdentityCardService {
	int addCard(String ImageUrl,String studentId,String type);
	
	//根据学生编号获取学生证信息
	List<IdentityCard>  getIdList(String studentID);
}
