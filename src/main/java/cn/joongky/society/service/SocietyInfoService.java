package cn.joongky.society.service;

import cn.joongky.society.pojo.SocietyApply;
import cn.joongky.society.pojo.SocietyInfo;

public interface SocietyInfoService {
	SocietyInfo add(String societyId,SocietyApply sa);
}
