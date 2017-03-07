package cn.joongky.society.dao;

import cn.joongky.society.pojo.IdentityCard;
import cn.joongky.society.pojo.IdentityCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IdentityCardMapper {
    int countByExample(IdentityCardExample example);

    int deleteByExample(IdentityCardExample example);

    int deleteByPrimaryKey(String identityCardId);

    int insert(IdentityCard record);

    int insertSelective(IdentityCard record);

    List<IdentityCard> selectByExampleWithRowbounds(IdentityCardExample example, RowBounds rowBounds);

    List<IdentityCard> selectByExample(IdentityCardExample example);

    IdentityCard selectByPrimaryKey(String identityCardId);

    int updateByExampleSelective(@Param("record") IdentityCard record, @Param("example") IdentityCardExample example);

    int updateByExample(@Param("record") IdentityCard record, @Param("example") IdentityCardExample example);

    int updateByPrimaryKeySelective(IdentityCard record);

    int updateByPrimaryKey(IdentityCard record);
}