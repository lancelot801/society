package cn.joongky.society.dao;

import cn.joongky.society.pojo.ActivityActor;
import cn.joongky.society.pojo.ActivityActorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ActivityActorMapper {
    int countByExample(ActivityActorExample example);

    int deleteByExample(ActivityActorExample example);

    int deleteByPrimaryKey(String activityActorId);

    int insert(ActivityActor record);

    int insertSelective(ActivityActor record);

    List<ActivityActor> selectByExampleWithRowbounds(ActivityActorExample example, RowBounds rowBounds);

    List<ActivityActor> selectByExample(ActivityActorExample example);

    ActivityActor selectByPrimaryKey(String activityActorId);

    int updateByExampleSelective(@Param("record") ActivityActor record, @Param("example") ActivityActorExample example);

    int updateByExample(@Param("record") ActivityActor record, @Param("example") ActivityActorExample example);

    int updateByPrimaryKeySelective(ActivityActor record);

    int updateByPrimaryKey(ActivityActor record);
}