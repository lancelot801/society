package cn.joongky.society.service;

import java.util.List;
import java.util.Map;

import cn.joongky.society.pojo.SocietyMember;

public interface SocietyMemberService {
	//加入社团
	SocietyMember joinSociety(String societyId,String memberId,String position);
	//根据学号查找社团id
	List<SocietyMember> listByStudentId(String studentId);
	//获取当前社团人数
	int  getMembersCount(String societyId);
	//根据学号查找我的社团总页数和总记录数(尚未离开)
	Map<String,Integer> listToltalPage(String studentId); 
}
