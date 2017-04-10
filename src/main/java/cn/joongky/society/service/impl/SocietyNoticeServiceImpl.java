package cn.joongky.society.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.joongky.society.dao.SocietyNoticeMapper;
import cn.joongky.society.pojo.SocietyNotice;
import cn.joongky.society.pojo.SocietyNoticeExample;
import cn.joongky.society.service.SocietyNoticeService;
import cn.joongky.society.util.BasicSysUtil;
import cn.joongky.society.util.ConfigUtil;

@Service("societyNoticeService")
public class SocietyNoticeServiceImpl implements SocietyNoticeService {
	@Inject
	private SocietyNoticeMapper snMapper;

	@Override
	public int publishNotice(String publisher, String theme, String content) {
		Date now = new Date();
		SocietyNotice sn = new SocietyNotice();
		sn.setNoticeId(BasicSysUtil.getUUID());
		sn.setTheme(theme);
		sn.setPublishedTime(now);
		sn.setContent(content);
		sn.setPublisher(publisher);
		return snMapper.insertSelective(sn);
	}

	@Override
	public SocietyNotice findById(String noticeId) {
		return snMapper.selectByPrimaryKey(noticeId);
	}

	@Override
	public Map<String, Integer> listTotalPage() {
		Integer totalPage;
		Integer totalRecord;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (snMapper.countByExample(null) % limit != 0) {
			totalPage = snMapper.countByExample(null) / limit + 1;
		} else {
			totalPage = snMapper.countByExample(null) / limit;
		}
		totalRecord = snMapper.countByExample(null);
		Map<String, Integer> map = new HashMap<>();
		map.put("totalPage", totalPage);
		map.put("totalRecords", totalRecord);
		return map;
	}

	@Override
	public List<SocietyNotice> findWithRowBound(Integer page) {
		SocietyNoticeExample example = new SocietyNoticeExample();
		example.setOrderByClause("published_time DESC");
		Integer totalPage;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (snMapper.countByExample(example) % limit != 0) {
			totalPage = snMapper.countByExample(example) / limit + 1;
		} else {
			totalPage = snMapper.countByExample(example) / limit;
		}

		if (page >= totalPage)
			page = totalPage - 1;
		RowBounds rowBounds = new RowBounds(page * limit, limit);
		return snMapper.selectByExampleWithBLOBsWithRowbounds(example, rowBounds);
	}

	@Override
	public int deleteById(String noticeId) {
		return snMapper.deleteByPrimaryKey(noticeId);
	}

	@Override
	public int updateById(String noticeId, String theme, String content) {
		Date now = new Date();
		SocietyNotice sn = snMapper.selectByPrimaryKey(noticeId);
		sn.setTheme(theme);
		sn.setContent(content);
		sn.setPublishedTime(now);
		return snMapper.updateByPrimaryKeyWithBLOBs(sn);
	}

}
