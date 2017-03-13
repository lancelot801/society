package cn.joongky.society.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cn.joongky.society.dao.SocietyMemberMapper;
import cn.joongky.society.pojo.SocietyMember;
import cn.joongky.society.pojo.SocietyMemberExample;
import cn.joongky.society.service.SocietyMemberService;
import cn.joongky.society.util.BasicSysUtil;

@Service("societyMemberService")
public class SocietyMemberServiceImpl implements SocietyMemberService{
	@Inject
	private SocietyMemberMapper sMemberMapper;

	@Override
	public SocietyMember joinSociety(String societyId, String memberId, String position) {
		SocietyMember sm = new SocietyMember();
		Date now = new Date();
		sm.setSmemberId(BasicSysUtil.getUUID());
		sm.setSocietyId(societyId);
		sm.setMemberId(memberId);
		sm.setPosition(position);
		sm.setJoinedTime(now);
		sMemberMapper.insertSelective(sm);
		return sMemberMapper.selectByPrimaryKey(sm.getSmemberId());
	}

	@Override
	public List<SocietyMember> listByStudentId(String studentId) {
		SocietyMemberExample example = new SocietyMemberExample();
		example.or().andMemberIdEqualTo(studentId);
		return sMemberMapper.selectByExample(example);
	}

	@Override
	public int getMembersCount(String societyId) {
		SocietyMemberExample example = new SocietyMemberExample();
		example.or().andSocietyIdEqualTo(societyId)
					.andLeftTimeIsNull();
		return sMemberMapper.countByExample(example);
	}
}
