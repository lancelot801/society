package cn.joongky.society.service;

import java.util.List;
import java.util.Map;

import cn.joongky.society.pojo.SocietyNotice;

public interface SocietyNoticeService {
	
	//发布公告
	int publishNotice(String publisher,String theme,String content);
	
	//根据编号查询公告信息
	SocietyNotice findById(String noticeId);
	
	//查找出公告总记录数和总页数
	Map<String,Integer> listTotalPage(); 
	
	//分页查找所有公告信息
	List<SocietyNotice> findWithRowBound(Integer page);
	
	//删除公告信息
	int deleteById(String noticeId);
	
	//修改公告信息
	int updateById(String noticeId,String theme,String content);
}
