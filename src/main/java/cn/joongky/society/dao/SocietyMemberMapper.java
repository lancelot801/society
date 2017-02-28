package cn.joongky.society.dao;

import cn.joongky.society.pojo.SocietyMember;
import cn.joongky.society.pojo.SocietyMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SocietyMemberMapper {
    int countByExample(SocietyMemberExample example);

    int deleteByExample(SocietyMemberExample example);

    int deleteByPrimaryKey(String smemberId);

    int insert(SocietyMember record);

    int insertSelective(SocietyMember record);

    List<SocietyMember> selectByExampleWithRowbounds(SocietyMemberExample example, RowBounds rowBounds);

    List<SocietyMember> selectByExample(SocietyMemberExample example);

    SocietyMember selectByPrimaryKey(String smemberId);

    int updateByExampleSelective(@Param("record") SocietyMember record, @Param("example") SocietyMemberExample example);

    int updateByExample(@Param("record") SocietyMember record, @Param("example") SocietyMemberExample example);

    int updateByPrimaryKeySelective(SocietyMember record);

    int updateByPrimaryKey(SocietyMember record);
}