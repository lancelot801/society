package cn.joongky.society.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cn.joongky.society.dao.IdentityCardMapper;
import cn.joongky.society.pojo.IdentityCard;
import cn.joongky.society.service.IdentityCardService;
import cn.joongky.society.util.BasicSysUtil;

@Service("identityCardService")
public class IdentityCardServiceImpl  implements IdentityCardService{
	@Inject
	private IdentityCardMapper icMapper;
	@Override
	public int addCard(String ImageUrl, String studentId) {
		IdentityCard ic1 = new IdentityCard();
		ic1.setIdentityCardId(BasicSysUtil.getUUID());
		ic1.setCardUrl(ImageUrl);
		ic1.setStudentId(studentId);
		int result1 = icMapper.insertSelective(ic1);
		return result1;
	}

}
