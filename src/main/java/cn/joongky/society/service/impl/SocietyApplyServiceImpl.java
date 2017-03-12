package cn.joongky.society.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.joongky.society.dao.SocietyApplyMapper;
import cn.joongky.society.pojo.SocietyApply;
import cn.joongky.society.pojo.SocietyApplyExample;
import cn.joongky.society.service.SocietyApplyService;
import cn.joongky.society.util.BasicSysUtil;
import cn.joongky.society.util.ConfigUtil;

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

	@Override
	public Map<String, Integer> listToltalPage() {
		Integer totalPage, totalRecord;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (saMapper.countByExample(null) % limit != 0) {
			totalPage = saMapper.countByExample(null) / limit + 1;
		} else {
			totalPage = saMapper.countByExample(null) / limit;
		}
		totalRecord = saMapper.countByExample(null);
		Map<String, Integer> map = new HashMap<>();
		map.put("totalPage", totalPage);
		map.put("totalRecords", totalRecord);
		return map;
	}

	@Override
	public Map<String, Integer> listToltalPageByStatus(String status) {
		SocietyApplyExample example = new SocietyApplyExample();
		example.or().andCheckStatusEqualTo(status);
		Integer totalPage, totalRecord;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (saMapper.countByExample(example) % limit != 0) {
			totalPage = saMapper.countByExample(example) / limit + 1;
		} else {
			totalPage = saMapper.countByExample(example) / limit;
		}
		totalRecord = saMapper.countByExample(example);
		Map<String, Integer> map = new HashMap<>();
		map.put("totalPage", totalPage);
		map.put("totalRecords", totalRecord);
		return map;
	}

	@Override
	public List<SocietyApply> findAll() {
		return saMapper.selectByExample(null);
	}

	@Override
	public List<SocietyApply> findAllByStatus(String status) {
		SocietyApplyExample example = new SocietyApplyExample();
		example.or().andCheckStatusEqualTo(status);
		return saMapper.selectByExample(example);
	}

	@Override
	public List<SocietyApply> findWithRowBound(Integer page) {
		SocietyApplyExample example = new SocietyApplyExample();
		example.setOrderByClause("applied_time DESC");
		Integer totalPage;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (saMapper.countByExample(example) % limit != 0) {
			totalPage = saMapper.countByExample(example) / limit + 1;
		} else {
			totalPage = saMapper.countByExample(example) / limit;
		}

		if (page >= totalPage)
			page = totalPage - 1;
		RowBounds rowBounds = new RowBounds(page * limit, limit);
		List<SocietyApply> saList = saMapper.selectByExampleWithRowbounds(example, rowBounds);
		return saList;
	}

	@Override
	public List<SocietyApply> findWithRowBoundAndStatus(Integer page, String status) {
		SocietyApplyExample example = new SocietyApplyExample();
		example.setOrderByClause("applied_time DESC");
		example.or().andCheckStatusEqualTo(status);
		Integer totalPage;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (saMapper.countByExample(example) % limit != 0) {
			totalPage = saMapper.countByExample(example) / limit + 1;
		} else {
			totalPage = saMapper.countByExample(example) / limit;
		}

		if (page >= totalPage)
			page = totalPage - 1;
		RowBounds rowBounds = new RowBounds(page * limit, limit);
		List<SocietyApply> saList = saMapper.selectByExampleWithRowbounds(example, rowBounds);
		return saList;
	}

	@Override
	public SocietyApply findById(String applyId) {
		return saMapper.selectByPrimaryKey(applyId);
	}

	@Override
	public int updateStatusById(String applyId,String feedBackId,String checkStatus) {
		SocietyApply sa = saMapper.selectByPrimaryKey(applyId);
		Date now = new Date();
		sa.setCheckedTime(now);
		sa.setCheckStatus(checkStatus);
		sa.setFeedbackId(feedBackId);
		return saMapper.updateByPrimaryKeySelective(sa);
	}

}
