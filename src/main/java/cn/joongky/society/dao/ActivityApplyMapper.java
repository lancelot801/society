package cn.joongky.society.dao;

import cn.joongky.society.pojo.ActivityApply;
import cn.joongky.society.pojo.ActivityApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ActivityApplyMapper {
    int countByExample(ActivityApplyExample example);

    int deleteByExample(ActivityApplyExample example);

    int deleteByPrimaryKey(String activityId);

    int insert(ActivityApply record);

    int insertSelective(ActivityApply record);

    List<ActivityApply> selectByExampleWithRowbounds(ActivityApplyExample example, RowBounds rowBounds);

    List<ActivityApply> selectByExample(ActivityApplyExample example);

    ActivityApply selectByPrimaryKey(String activityId);

    int updateByExampleSelective(@Param("record") ActivityApply record, @Param("example") ActivityApplyExample example);

    int updateByExample(@Param("record") ActivityApply record, @Param("example") ActivityApplyExample example);

    int updateByPrimaryKeySelective(ActivityApply record);

    int updateByPrimaryKey(ActivityApply record);
}