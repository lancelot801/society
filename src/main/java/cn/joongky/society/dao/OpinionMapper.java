package cn.joongky.society.dao;

import cn.joongky.society.pojo.Opinion;
import cn.joongky.society.pojo.OpinionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OpinionMapper {
    int countByExample(OpinionExample example);

    int deleteByExample(OpinionExample example);

    int deleteByPrimaryKey(String opinionId);

    int insert(Opinion record);

    int insertSelective(Opinion record);

    List<Opinion> selectByExampleWithRowbounds(OpinionExample example, RowBounds rowBounds);

    List<Opinion> selectByExample(OpinionExample example);

    Opinion selectByPrimaryKey(String opinionId);

    int updateByExampleSelective(@Param("record") Opinion record, @Param("example") OpinionExample example);

    int updateByExample(@Param("record") Opinion record, @Param("example") OpinionExample example);

    int updateByPrimaryKeySelective(Opinion record);

    int updateByPrimaryKey(Opinion record);
}