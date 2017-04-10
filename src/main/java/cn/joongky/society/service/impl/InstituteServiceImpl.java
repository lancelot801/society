package cn.joongky.society.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.joongky.society.dao.InstituteMapper;
import cn.joongky.society.pojo.Institute;
import cn.joongky.society.pojo.InstituteExample;
import cn.joongky.society.service.InstituteService;
import cn.joongky.society.util.BasicSysUtil;
import cn.joongky.society.util.ConfigUtil;

@Service("instituteService")
public class InstituteServiceImpl implements InstituteService {
	@Inject
	private InstituteMapper instituteMapper;
	@Override
	public int addInstitute(String instituteName) {
		
		Institute ins = new Institute();
		ins.setInstituteId(BasicSysUtil.getUUID());
		ins.setInstituteName(instituteName);
		
		return instituteMapper.insertSelective(ins);
	}
	@Override
	public Map<String, Integer> listTotalPage() {
		Integer totalPage;
		Integer totalRecord;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (instituteMapper.countByExample(null) % limit != 0) {
			totalPage = instituteMapper.countByExample(null) / limit + 1;
		} else {
			totalPage = instituteMapper.countByExample(null) / limit;
		}
		totalRecord = instituteMapper.countByExample(null);
		Map<String,Integer> map = new HashMap<>();
		map.put("totalPage", totalPage);
		map.put("totalRecords", totalRecord);
		return map;
	}
	@Override
	public List<Institute> findAll() {
		return instituteMapper.selectByExample(null);
	}
	@Override
	public List<Institute> findWithRowBound(Integer page) {
		InstituteExample example = new InstituteExample();
		example.setOrderByClause("institute_name ASC");
		Integer totalPage;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (instituteMapper.countByExample(null) % limit != 0) {
			totalPage = instituteMapper.countByExample(example) / limit + 1;
		} else {
			totalPage = instituteMapper.countByExample(example) / limit;
		}

		if (page >= totalPage)
			page = totalPage - 1;
		RowBounds rowBounds = new RowBounds(page * limit, limit);
		return instituteMapper.selectByExampleWithRowbounds(example, rowBounds);
	}
	@Override
	public int deleteById(String instituteId) {
		return instituteMapper.deleteByPrimaryKey(instituteId);
	}
	@Override
	public Institute findById(String instituteId) {
		return instituteMapper.selectByPrimaryKey(instituteId);
	}
	@Override
	public Institute updateById(String instituteId, String instituteName) {
		Institute ins  = instituteMapper.selectByPrimaryKey(instituteId);
		ins.setInstituteName(instituteName);
		instituteMapper.updateByPrimaryKeySelective(ins);
		return instituteMapper.selectByPrimaryKey(instituteId);
	}
	
}
