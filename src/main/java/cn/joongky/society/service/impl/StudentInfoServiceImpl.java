package cn.joongky.society.service.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cn.joongky.society.dao.StudentInfoMapper;
import cn.joongky.society.pojo.StudentInfo;
import cn.joongky.society.service.StudentInfoService;

@Service("studentInfoService")
public class StudentInfoServiceImpl implements StudentInfoService {

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

	// 根据学生编号获取学生基本信息
	@Override
	public StudentInfo getInfo(String studentId) {
		return sinfoMapper.selectByPrimaryKey(studentId);
	}

	// 修改学生信息
	@Override
	public StudentInfo updateStudentInfo(String studentId, String institueId, String classId, String sname, String sex,
			String nickname, String email, String mobile) {
		StudentInfo si = sinfoMapper.selectByPrimaryKey(studentId);
		Date now = new Date();

		si.setInstituteId(institueId);
		si.setClassId(classId);
		si.setSname(sname);
		si.setSex(sex);
		si.setNickname(nickname);
		si.setEmail(email);
		si.setMobile(mobile);
		si.setUpdatedTime(now);

		sinfoMapper.updateByPrimaryKeySelective(si);

		return sinfoMapper.selectByPrimaryKey(studentId);
	}
}
