package cn.joongky.society.dao;

import cn.joongky.society.pojo.SocietyType;
import cn.joongky.society.pojo.SocietyTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SocietyTypeMapper {
    int countByExample(SocietyTypeExample example);

    int deleteByExample(SocietyTypeExample example);

    int deleteByPrimaryKey(String typeId);

    int insert(SocietyType record);

    int insertSelective(SocietyType record);

    List<SocietyType> selectByExampleWithRowbounds(SocietyTypeExample example, RowBounds rowBounds);

    List<SocietyType> selectByExample(SocietyTypeExample example);

    SocietyType selectByPrimaryKey(String typeId);

    int updateByExampleSelective(@Param("record") SocietyType record, @Param("example") SocietyTypeExample example);

    int updateByExample(@Param("record") SocietyType record, @Param("example") SocietyTypeExample example);

    int updateByPrimaryKeySelective(SocietyType record);

    int updateByPrimaryKey(SocietyType record);
}