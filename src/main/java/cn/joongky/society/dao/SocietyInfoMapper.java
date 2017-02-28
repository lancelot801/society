package cn.joongky.society.dao;

import cn.joongky.society.pojo.SocietyInfo;
import cn.joongky.society.pojo.SocietyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SocietyInfoMapper {
    int countByExample(SocietyInfoExample example);

    int deleteByExample(SocietyInfoExample example);

    int deleteByPrimaryKey(String societyId);

    int insert(SocietyInfo record);

    int insertSelective(SocietyInfo record);

    List<SocietyInfo> selectByExampleWithRowbounds(SocietyInfoExample example, RowBounds rowBounds);

    List<SocietyInfo> selectByExample(SocietyInfoExample example);

    SocietyInfo selectByPrimaryKey(String societyId);

    int updateByExampleSelective(@Param("record") SocietyInfo record, @Param("example") SocietyInfoExample example);

    int updateByExample(@Param("record") SocietyInfo record, @Param("example") SocietyInfoExample example);

    int updateByPrimaryKeySelective(SocietyInfo record);

    int updateByPrimaryKey(SocietyInfo record);
}