package cn.joongky.society.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import cn.joongky.society.dao.ClassesMapper;
import cn.joongky.society.pojo.Classes;
import cn.joongky.society.pojo.ClassesExample;
import cn.joongky.society.service.ClassService;
import cn.joongky.society.util.BasicSysUtil;
import cn.joongky.society.util.ConfigUtil;

@Service("classService")
public class ClassServiceImpl implements ClassService{
	@Inject
	private ClassesMapper classesMapper;
	
	@Override
	public int addClass(String instituteId, String className) {
		Classes  cla = new Classes();
		cla.setClassId(BasicSysUtil.getUUID());
		cla.setClassName(className);
		cla.setInstituteId(instituteId);
		return classesMapper.insertSelective(cla);
	}

	@Override
	public List<Classes> findAll() {
		List<Classes> cList = classesMapper.selectByExample(null);
		return cList;
	}

	@Override
	public List<Classes> findAllByInstituteId(String instituteId) {
		ClassesExample example = new ClassesExample();
		example.or().andInstituteIdEqualTo(instituteId);
		return classesMapper.selectByExample(example);
	}

	@Override
	public List<Classes> findWithRowBound(Integer page) {
		Integer totalPage;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if ( classesMapper.countByExample(null) % limit != 0) {
			totalPage = classesMapper.countByExample(null) / limit + 1;
		} else {
			totalPage =  classesMapper.countByExample(null) / limit;
		}

		if (page >= totalPage)
			page = totalPage - 1;
		RowBounds rowBounds = new RowBounds(page * limit, limit);
		List<Classes> courseList = classesMapper.selectByExampleWithRowbounds(null, rowBounds);
		return courseList;
	}

	@Override
	public List<Classes> findByInstituteAndPage(String instituteId, Integer page) {
		ClassesExample example = new ClassesExample();
		example.or().andInstituteIdEqualTo(instituteId);
		Integer totalPage;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if ( classesMapper.countByExample(example) % limit != 0) {
			totalPage = classesMapper.countByExample(example) / limit + 1;
		} else {
			totalPage =  classesMapper.countByExample(example) / limit;
		}

		if (page >= totalPage)
			page = totalPage - 1;
		RowBounds rowBounds = new RowBounds(page * limit, limit);
		List<Classes> courseList = classesMapper.selectByExampleWithRowbounds(example, rowBounds);
		return courseList;
	}

	@Override
	public Map<String, Integer> listToltalPage() {
		Integer totalPage,totalRecord;
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (classesMapper.countByExample(null) % limit != 0) {
			totalPage = classesMapper.countByExample(null) / limit + 1;
		} else {
			totalPage =classesMapper.countByExample(null) / limit;
		}
		totalRecord = classesMapper.countByExample(null);
		Map<String,Integer> map = new HashMap<>();
		map.put("totalPage", totalPage);
		map.put("totalRecord", totalRecord);
		return map;
	}

	@Override
	public Map<String, Integer> queryToltalPageByInstituteId(String instituteId) {
		Integer totalPage,totalRecord;
		ClassesExample example = new ClassesExample();
		example.or().andInstituteIdEqualTo(instituteId);
		Integer limit = Integer.parseInt(ConfigUtil.getValue("page_size"));
		if (classesMapper.countByExample(example) % limit != 0) {
			totalPage = classesMapper.countByExample(example) / limit + 1;
		} else {
			totalPage =classesMapper.countByExample(example) / limit;
		}
		totalRecord = classesMapper.countByExample(example);
		Map<String,Integer> map = new HashMap<>();
		map.put("totalPage", totalPage);
		map.put("totalRecord", totalRecord);
		return map;
	}	
}
