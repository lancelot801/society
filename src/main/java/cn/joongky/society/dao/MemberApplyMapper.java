package cn.joongky.society.dao;

import cn.joongky.society.pojo.MemberApply;
import cn.joongky.society.pojo.MemberApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MemberApplyMapper {
    int countByExample(MemberApplyExample example);

    int deleteByExample(MemberApplyExample example);

    int deleteByPrimaryKey(String applyId);

    int insert(MemberApply record);

    int insertSelective(MemberApply record);

    List<MemberApply> selectByExampleWithRowbounds(MemberApplyExample example, RowBounds rowBounds);

    List<MemberApply> selectByExample(MemberApplyExample example);

    MemberApply selectByPrimaryKey(String applyId);

    int updateByExampleSelective(@Param("record") MemberApply record, @Param("example") MemberApplyExample example);

    int updateByExample(@Param("record") MemberApply record, @Param("example") MemberApplyExample example);

    int updateByPrimaryKeySelective(MemberApply record);

    int updateByPrimaryKey(MemberApply record);
}