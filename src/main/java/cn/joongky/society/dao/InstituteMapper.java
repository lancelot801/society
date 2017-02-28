package cn.joongky.society.dao;

import cn.joongky.society.pojo.Institute;
import cn.joongky.society.pojo.InstituteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface InstituteMapper {
    int countByExample(InstituteExample example);

    int deleteByExample(InstituteExample example);

    int deleteByPrimaryKey(String instituteId);

    int insert(Institute record);

    int insertSelective(Institute record);

    List<Institute> selectByExampleWithRowbounds(InstituteExample example, RowBounds rowBounds);

    List<Institute> selectByExample(InstituteExample example);

    Institute selectByPrimaryKey(String instituteId);

    int updateByExampleSelective(@Param("record") Institute record, @Param("example") InstituteExample example);

    int updateByExample(@Param("record") Institute record, @Param("example") InstituteExample example);

    int updateByPrimaryKeySelective(Institute record);

    int updateByPrimaryKey(Institute record);
}