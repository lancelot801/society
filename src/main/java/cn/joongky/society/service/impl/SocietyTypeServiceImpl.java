package cn.joongky.society.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.joongky.society.dao.SocietyTypeMapper;
import cn.joongky.society.pojo.SocietyType;
import cn.joongky.society.pojo.SocietyTypeExample;
import cn.joongky.society.service.SocietyTypeService;
import cn.joongky.society.util.BasicSysUtil;
import cn.joongky.society.util.ConfigUtil;

@Service("societyTypeService")
public class SocietyTypeServiceImpl implements SocietyTypeService{
	@Inject
	private SocietyTypeMapper stMapper;
	@Override
	public int addSocietyType(String typeName, String creater) {
		Date now = new Date();
		SocietyType st = new SocietyType();
		st.setTypeId(BasicSysUtil.getUUID());
		st.setTypeName(typeName);
		st.setCreatedTime(now);
		st.setUpdatedTime(now);
		st.setCreater(creater);
		return stMapper.insertSelective(st);
	}

	@Override
	public Map<String, Integer> listTotalPage() {
		Integer totalPage,totalRecord;
		
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (stMapper.countByExample(null) % limit != 0) {
			totalPage = stMapper.countByExample(null) / limit + 1;
		} else {
			totalPage = stMapper.countByExample(null) / limit;
		}
		totalRecord = stMapper.countByExample(null);
		Map<String,Integer> map = new HashMap<>();
		map.put("totalPage", totalPage);
		map.put("totalRecords", totalRecord);
		return map;
	}

	@Override
	public List<SocietyType> findAll() {
		return stMapper.selectByExample(null);
	}

	@Override
	public List<SocietyType> findWithRowBound(Integer page) {
		SocietyTypeExample example = new SocietyTypeExample();
		example.setOrderByClause("type_name ASC");
		Integer totalPage;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (stMapper.countByExample(example) % limit != 0) {
			totalPage = stMapper.countByExample(example) / limit + 1;
		} else {
			totalPage = stMapper.countByExample(example) / limit;
		}

		if (page >= totalPage)
			page = totalPage - 1;
		RowBounds rowBounds = new RowBounds(page * limit, limit);
		return  stMapper.selectByExampleWithRowbounds(example, rowBounds);
	}

	@Override
	public int deleteById(String typeId) {
		return stMapper.deleteByPrimaryKey(typeId);
	}

	@Override
	public SocietyType findById(String typeId) {
		return stMapper.selectByPrimaryKey(typeId);
	}

	@Override
	public SocietyType updateById(String typeId, String typeName, String creater) {
		Date now = new Date();
		SocietyType st = stMapper.selectByPrimaryKey(typeId);
		st.setTypeName(typeName);
		st.setCreater(creater);
		st.setUpdatedTime(now);
		stMapper.updateByPrimaryKeySelective(st);
		return stMapper.selectByPrimaryKey(typeId);
	}

}
