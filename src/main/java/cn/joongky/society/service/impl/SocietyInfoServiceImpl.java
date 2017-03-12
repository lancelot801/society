package cn.joongky.society.service.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cn.joongky.society.dao.SocietyInfoMapper;
import cn.joongky.society.pojo.SocietyApply;
import cn.joongky.society.pojo.SocietyInfo;
import cn.joongky.society.service.SocietyInfoService;

@Service("societyInfoService")
public class SocietyInfoServiceImpl implements SocietyInfoService{
	@Inject
	private SocietyInfoMapper sInfoMapper;

	@Override
	public SocietyInfo add(String societyId, SocietyApply sa) {
		SocietyInfo si = new SocietyInfo();
		Date now = new Date();
		si.setSocietyId(societyId);
		si.setIntroduction(sa.getIntroduction());
		si.setSocietyName(sa.getSocietyName());
		si.setLogoUrl(sa.getLogoUrl());
		si.setCreatedTime(now);
		sInfoMapper.insertSelective(si);
		return sInfoMapper.selectByPrimaryKey(societyId);
	}
}
