package cn.joongky.society.service;

import java.util.List;
import java.util.Map;

import cn.joongky.society.pojo.ActivityApply;

public interface ActivityApplyService {
	//根据社团编号查找所有的活动信息
	List<ActivityApply> listBySocietyId(String societyId);
	
	//根据状态和社团编号查询所有活动信息
	List<ActivityApply> listBySocietyIdAndStatus(String societyId,String status);
	
	//添加活动信息
	int addApply(String societyId,String theme,String applyerId,String content,String holdTime);
	
	//查找活动申请信息详情
	ActivityApply findByActivityId(String activityId);
	
	//分页查找所有活动申请信息
	List<ActivityApply> listApplyWithRowBound(Integer page);
	
	// 查找总页数和总记录数
	Map<String, Integer> listToltalPage();
	
	// 根据社团编号查找总页数和总记录数
	Map<String, Integer> listToltalPageBySocietyId(String societyId);
	
	// 分页查找所有社团活动申请记录
	List<ActivityApply> findWithRowBound(Integer page);
}
