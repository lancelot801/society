package cn.joongky.society.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.joongky.society.dao.ActivityApplyMapper;
import cn.joongky.society.pojo.ActivityApply;
import cn.joongky.society.pojo.ActivityApplyExample;
import cn.joongky.society.service.ActivityApplyService;
import cn.joongky.society.util.BasicSysUtil;
import cn.joongky.society.util.ConfigUtil;

@Service("activityApplyService")
public class ActivityApplyServiceImpl implements ActivityApplyService {
	@Inject
	private ActivityApplyMapper activityApplyMapper;

	@Override
	public List<ActivityApply> listBySocietyId(String societyId) {
		ActivityApplyExample example = new ActivityApplyExample();
		example.or().andSocietyIdEqualTo(societyId);
		activityApplyMapper.selectByExampleWithBLOBs(example);
		return activityApplyMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<ActivityApply> listBySocietyIdAndStatus(String societyId, String status) {
		ActivityApplyExample example = new ActivityApplyExample();
		example.or().andSocietyIdEqualTo(societyId).andStatusEqualTo(status);
		activityApplyMapper.selectByExampleWithBLOBs(example);
		return activityApplyMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public int addApply(String societyId, String theme, String applyerId, String content, String holdTime) {
		ActivityApply activityApply = new ActivityApply();
		Date now = new Date();
		activityApply.setActivityId(BasicSysUtil.getUUID());
		activityApply.setSocietyId(societyId);
		activityApply.setContent(content);
		activityApply.setApplyTime(now);
		activityApply.setApplyerId(applyerId);
		activityApply.setTheme(theme);
		activityApply.setStatus("待审核");
		Date ConvertTime = null;
		if (holdTime != null && !holdTime.equals("")) {
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd"); // 时间格式
			try {
				ConvertTime = sim.parse(holdTime); // String强转时间
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		activityApply.setHoldTime(ConvertTime);
		return activityApplyMapper.insertSelective(activityApply);
	}

	@Override
	public ActivityApply findByActivityId(String activityId) {
		ActivityApplyExample example = new ActivityApplyExample();
		example.or().andActivityIdEqualTo(activityId);
		List<ActivityApply> aaList = activityApplyMapper.selectByExampleWithBLOBs(example);
		if (!aaList.isEmpty()) {
			return aaList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<ActivityApply> listApplyWithRowBound(Integer page) {
		ActivityApplyExample example = new ActivityApplyExample();
		Integer totalPage;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (activityApplyMapper.countByExample(example) % limit != 0) {
			totalPage = activityApplyMapper.countByExample(example) / limit + 1;
		} else {
			totalPage = activityApplyMapper.countByExample(example) / limit;
		}

		if (page >= totalPage)
			page = totalPage - 1;
		RowBounds rowBounds = new RowBounds(page * limit, limit);
		return  activityApplyMapper.selectByExampleWithRowbounds(example, rowBounds);
	}

	@Override
	public Map<String, Integer> listToltalPage() {
		Integer totalPage;
		Integer totalRecord;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (activityApplyMapper.countByExample(null) % limit != 0) {
			totalPage = activityApplyMapper.countByExample(null) / limit + 1;
		} else {
			totalPage = activityApplyMapper.countByExample(null) / limit;
		}
		totalRecord = activityApplyMapper.countByExample(null);
		Map<String, Integer> map = new HashMap<>();
		map.put("totalPage", totalPage);
		map.put("totalRecords", totalRecord);
		return map;
	}

	@Override
	public Map<String, Integer> listToltalPageBySocietyId(String societyId) {
		Integer totalPage;
		Integer totalRecord;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		ActivityApplyExample example = new ActivityApplyExample();
		example.or().andSocietyIdEqualTo(societyId);
		if (activityApplyMapper.countByExample(null) % limit != 0) {
			totalPage = activityApplyMapper.countByExample(null) / limit + 1;
		} else {
			totalPage = activityApplyMapper.countByExample(null) / limit;
		}
		totalRecord = activityApplyMapper.countByExample(null);
		Map<String, Integer> map = new HashMap<>();
		map.put("totalPage", totalPage);
		map.put("totalRecords", totalRecord);
		return map;
	}

	@Override
	public List<ActivityApply> findWithRowBound(Integer page) {
		ActivityApplyExample example = new ActivityApplyExample();
		example.setOrderByClause("apply_time DESC");
		Integer totalPage;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (activityApplyMapper.countByExample(example) % limit != 0) {
			totalPage = activityApplyMapper.countByExample(example) / limit + 1;
		} else {
			totalPage = activityApplyMapper.countByExample(example) / limit;
		}

		if (page >= totalPage)
			page = totalPage - 1;
		RowBounds rowBounds = new RowBounds(page * limit, limit);
		return activityApplyMapper.selectByExampleWithRowbounds(example, rowBounds);
	}

	@Override
	public ActivityApply updateActivityStatus(String activityId, String feedBackId, String status) {
		ActivityApply activityApply = activityApplyMapper.selectByPrimaryKey(activityId);
		Date now = new Date();
		activityApply.setCheckedTime(now);
		activityApply.setFeedbackId(feedBackId);
		activityApply.setStatus(status);
		activityApplyMapper.updateByPrimaryKeySelective(activityApply);
		return activityApplyMapper.selectByPrimaryKey(activityId);
	}

	@Override
	public List<ActivityApply> findByStatusWithRowBound(Integer page, String status) {
		ActivityApplyExample example = new ActivityApplyExample();
		example.or().andStatusEqualTo(status);
		Integer totalPage;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (activityApplyMapper.countByExample(example) % limit != 0) {
			totalPage = activityApplyMapper.countByExample(example) / limit + 1;
		} else {
			totalPage = activityApplyMapper.countByExample(example) / limit;
		}

		if (page >= totalPage)
			page = totalPage - 1;
		RowBounds rowBounds = new RowBounds(page * limit, limit);
		return  activityApplyMapper.selectByExampleWithRowbounds(example, rowBounds);
	}

}
