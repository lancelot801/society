package cn.joongky.society.service;

import cn.joongky.society.pojo.UserLogin;

public interface UserLoginService {
	
	//登录方法
	UserLogin login(String token, String password);
	
	//注册用户
	int register(String studentId, String password);
	
	//判断学号是否存在
	int existStudentId(String studentId);
}
