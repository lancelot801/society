package cn.joongky.society.service.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cn.joongky.society.dao.StudentInfoMapper;
import cn.joongky.society.pojo.StudentInfo;
import cn.joongky.society.service.StudentInfoService;

@Service("studentInfoService")
public class StudentInfoServiceImpl implements StudentInfoService{
		
		@Inject
		private StudentInfoMapper sinfoMapper;
		
		@Override
		public StudentInfo addBasicInfo(String studentId) {
		    StudentInfo sinfo = new StudentInfo();
		    Date now = new Date();
		    sinfo.setStudentId(studentId);
		    sinfo.setCreatedTime(now);
			sinfo.setUpdatedTime(now);
			sinfoMapper.insertSelective(sinfo);
			return sinfoMapper.selectByPrimaryKey(studentId);
		}
}
