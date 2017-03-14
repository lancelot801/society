package cn.joongky.society.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cn.joongky.exception.AdminException;
import cn.joongky.society.dao.UserLoginMapper;
import cn.joongky.society.pojo.UserLogin;
import cn.joongky.society.pojo.UserLoginExample;
import cn.joongky.society.service.UserLoginService;
import cn.joongky.society.util.BasicSysUtil;
import cn.joongky.society.util.EncryptUtil;

@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {
	@Inject
	private UserLoginMapper userLoginMapper;

	@Override
	public UserLogin login(String token, String password) {
		UserLoginExample example = new UserLoginExample();
		example.or().andStudentIdEqualTo(token);
		example.or().andEmailEqualTo(token);
		example.or().andMobileEqualTo(token);
		List<UserLogin> userlist = userLoginMapper.selectByExample(example);
		UserLogin ul;
		if (userlist.size() == 1) {
			ul = userlist.get(0);
			String salt = ul.getSalt();
			String currentPassword = ul.getCurrentPassword();
			if (EncryptUtil.encodeByMD5(password + salt).equals(currentPassword)) {
				return ul;
			} else {
				throw new AdminException("用户名或密码错误,拒绝登录");
			}
		} else {
			throw new AdminException("用户不存在,拒绝登录");
		}
	}

	@Override
	public int register(String studentId, String password) {
		UserLogin ul = new UserLogin();
		Date now = new Date();
		ul.setStudentId(studentId);
		ul.setUserLoginId(BasicSysUtil.getUUID());
		// 随机盐
		String salt = BasicSysUtil.getUUID();
		// MD5加密 盐和密码的顺序不能乱
		ul.setCurrentPassword(EncryptUtil.encodeByMD5(password + salt));
		ul.setSalt(salt);
		ul.setCreatedTime(now);
		ul.setUpdatedTime(now);
		// 新注册用户角色为新人
		ul.setRole("newBee");
		return userLoginMapper.insertSelective(ul);
	}

	@Override
	public int existStudentId(String studentId) {
		UserLoginExample example = new UserLoginExample();
		example.or().andStudentIdEqualTo(studentId);
		return userLoginMapper.countByExample(example);
	}

	@Override
	public UserLogin findById(String studentId) {
		UserLoginExample example = new UserLoginExample();
		example.or().andStudentIdEqualTo(studentId);
		List<UserLogin> uList = userLoginMapper.selectByExample(example);
		if (!uList.isEmpty()) {
			return uList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public UserLogin addOtherInfo(String studentId, String nickname, String email, String mobile) {
		Date now = new Date();
		UserLoginExample example = new UserLoginExample();
		example.or().andStudentIdEqualTo(studentId);
		UserLogin ul = userLoginMapper.selectByExample(example).get(0);
		ul.setEmail(email);
		ul.setMobile(mobile);
		ul.setNickname(nickname);
		ul.setUpdatedTime(now);
		userLoginMapper.updateByPrimaryKeySelective(ul);
		return userLoginMapper.selectByExample(example).get(0);
	}
}
