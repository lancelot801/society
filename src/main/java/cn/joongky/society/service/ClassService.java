package cn.joongky.society.service;

import java.util.List;
import java.util.Map;

import cn.joongky.society.pojo.Classes;

public interface ClassService {
     //添加班级
	int addClass(String instituteId,String className);
	
	//查找所有班级
	List<Classes> findAll();
	
	//根据学院查找所有班级
	List<Classes> findAllByInstituteId(String instituteId);
	
	//分页查找所有班级
	List<Classes> findWithRowBound(Integer page);
	
	//根据学院编号分页查找班级
	List<Classes>  findByInstituteAndPage(String instituteId,Integer page);
	
	//查出总页数和总记录数
	Map<String,Integer> listToltalPage(); 
	
	//根据学院查出总页数和总记录数
	Map<String,Integer> queryToltalPageByInstituteId(String instituteId);
}
