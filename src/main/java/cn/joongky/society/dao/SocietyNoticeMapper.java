package cn.joongky.society.dao;

import cn.joongky.society.pojo.SocietyNotice;
import cn.joongky.society.pojo.SocietyNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SocietyNoticeMapper {
    int countByExample(SocietyNoticeExample example);

    int deleteByExample(SocietyNoticeExample example);

    int deleteByPrimaryKey(String noticeId);

    int insert(SocietyNotice record);

    int insertSelective(SocietyNotice record);

    List<SocietyNotice> selectByExampleWithRowbounds(SocietyNoticeExample example, RowBounds rowBounds);

    List<SocietyNotice> selectByExample(SocietyNoticeExample example);

    SocietyNotice selectByPrimaryKey(String noticeId);

    int updateByExampleSelective(@Param("record") SocietyNotice record, @Param("example") SocietyNoticeExample example);

    int updateByExample(@Param("record") SocietyNotice record, @Param("example") SocietyNoticeExample example);

    int updateByPrimaryKeySelective(SocietyNotice record);

    int updateByPrimaryKey(SocietyNotice record);
}