package cn.joongky.society.service;

import cn.joongky.society.pojo.SocietyMember;

public interface SocietyMemberService {
	
	SocietyMember joinSociety(String societyId,String memberId,String position);
}
