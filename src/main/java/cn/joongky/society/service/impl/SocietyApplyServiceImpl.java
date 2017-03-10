package cn.joongky.society.service.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cn.joongky.society.dao.SocietyApplyMapper;
import cn.joongky.society.pojo.SocietyApply;
import cn.joongky.society.service.SocietyApplyService;
import cn.joongky.society.util.BasicSysUtil;

@Service("societyApplyService")
public class SocietyApplyServiceImpl implements SocietyApplyService {
	@Inject
	private SocietyApplyMapper saMapper;

	@Override
	public SocietyApply addApply(String societyName, String ImageUrl, String introduction, String typeId,
			String applyerId) {
		SocietyApply sa = new SocietyApply();
		Date now = new Date();
		
		sa.setApplyId(BasicSysUtil.getUUID());
		sa.setAppliedTime(now);
		sa.setApplyerId(applyerId);
		sa.setCheckStatus("待审核");
		sa.setIntroduction(introduction);
		sa.setLogoUrl(ImageUrl);
		sa.setSocietyName(societyName);
		sa.setTypeId(typeId);
		saMapper.insertSelective(sa);
		return saMapper.selectByPrimaryKey(sa.getApplyId());
	}

}
