package cn.joongky.society.dao;

import cn.joongky.society.pojo.SocietyApply;
import cn.joongky.society.pojo.SocietyApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SocietyApplyMapper {
    int countByExample(SocietyApplyExample example);

    int deleteByExample(SocietyApplyExample example);

    int deleteByPrimaryKey(String applyId);

    int insert(SocietyApply record);

    int insertSelective(SocietyApply record);

    List<SocietyApply> selectByExampleWithRowbounds(SocietyApplyExample example, RowBounds rowBounds);

    List<SocietyApply> selectByExample(SocietyApplyExample example);

    SocietyApply selectByPrimaryKey(String applyId);

    int updateByExampleSelective(@Param("record") SocietyApply record, @Param("example") SocietyApplyExample example);

    int updateByExample(@Param("record") SocietyApply record, @Param("example") SocietyApplyExample example);

    int updateByPrimaryKeySelective(SocietyApply record);

    int updateByPrimaryKey(SocietyApply record);
}