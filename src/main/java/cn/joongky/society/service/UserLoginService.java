package cn.joongky.society.service;

import cn.joongky.society.pojo.UserLogin;

public interface UserLoginService {

	// 登录方法
	UserLogin login(String token, String password);

	// 注册用户
	int register(String studentId, String password);

	// 判断学号是否存在
	int existStudentId(String studentId);

	// 根据id查找userlogin
	UserLogin findById(String studentId);

	// 添加昵称,邮箱和手机号
	UserLogin addOtherInfo(String studentId, String nickname, String email, String mobile);
	
	//判断原密码是否正确
	int checkPassword(String studentId,String prePwd);
	
	//修改密码
	int resetPwd(String studentId,String password);
}
