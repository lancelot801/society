package cn.joongky.society.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cn.joongky.society.dao.SocietyMemberMapper;
import cn.joongky.society.pojo.SocietyMember;
import cn.joongky.society.pojo.SocietyMemberExample;
import cn.joongky.society.service.SocietyMemberService;
import cn.joongky.society.util.BasicSysUtil;
import cn.joongky.society.util.ConfigUtil;

@Service("societyMemberService")
public class SocietyMemberServiceImpl implements SocietyMemberService {
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
		example.or().andSocietyIdEqualTo(societyId).andLeftTimeIsNull();
		return sMemberMapper.countByExample(example);
	}

	@Override
	public Map<String, Integer> listToltalPage(String studentId) {
		Integer totalPage;
		Integer totalRecord;
		SocietyMemberExample example = new SocietyMemberExample();
		example.or().andMemberIdEqualTo(studentId)
					.andLeftTimeIsNull();
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (sMemberMapper.countByExample(example) % limit != 0) {
			totalPage = sMemberMapper.countByExample(example) / limit + 1;
		} else {
			totalPage = sMemberMapper.countByExample(example) / limit;
		}
		totalRecord = sMemberMapper.countByExample(example);
		Map<String, Integer> map = new HashMap<>();
		map.put("totalPage", totalPage);
		map.put("totalRecords", totalRecord);
		return map;
	}
}
