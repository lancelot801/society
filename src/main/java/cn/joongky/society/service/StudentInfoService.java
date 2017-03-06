package cn.joongky.society.service;

import cn.joongky.society.pojo.StudentInfo;

public interface StudentInfoService {
       //用户注册的同时添加信息到studentInfo
	 StudentInfo addBasicInfo(String studentId);
	 
	 //根据学生id获取学生信息
	 StudentInfo getInfo(String studentId);
}
