package cn.joongky.society.dao;

import cn.joongky.society.pojo.Classes;
import cn.joongky.society.pojo.ClassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClassesMapper {
    int countByExample(ClassesExample example);

    int deleteByExample(ClassesExample example);

    int deleteByPrimaryKey(String classId);

    int insert(Classes record);

    int insertSelective(Classes record);

    List<Classes> selectByExampleWithRowbounds(ClassesExample example, RowBounds rowBounds);

    List<Classes> selectByExample(ClassesExample example);

    Classes selectByPrimaryKey(String classId);

    int updateByExampleSelective(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByExample(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}