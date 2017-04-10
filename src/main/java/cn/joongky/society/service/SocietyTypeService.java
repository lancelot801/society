package cn.joongky.society.service;

import java.util.List;
import java.util.Map;

import cn.joongky.society.pojo.SocietyType;


public interface SocietyTypeService {
		//添加社团类别
	  int addSocietyType(String typeName,String creater);
	  
	  //查找总页数和总记录数
	  Map<String,Integer> listTotalPage(); 
	  
	  //查找所有的社团类别
	  List<SocietyType> findAll();
	  
	  //分页查找所有社团
	  List<SocietyType> findWithRowBound(Integer page);
	  
	  //根据id删除社团类别
	  int deleteById(String typeId);
	  
	  //根据id查找社团类别信息
	  SocietyType findById(String typeId);
	  
	  //根据id修改社团类别信息
	  SocietyType updateById(String typeId,String typeName,String creater);
}
