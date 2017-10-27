package org.iodsp.tadxmock.resource.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.iodsp.tadxmock.resource.pojo.Dsp;

@Mapper
public interface DspMapper {
    @Delete({
        "delete from DSP",
        "where DSP_ID = #{dspId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String dspId);

    @Insert({
        "insert into DSP (DSP_ID, NAME, ",
        "DESC, TOKEN, ADD_TIME, ",
        "UPDATE_TIME)",
        "values (#{dspId,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{desc,jdbcType=VARCHAR}, #{token,jdbcType=VARCHAR}, #{addTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Dsp record);

    @InsertProvider(type=DspSqlProvider.class, method="insertSelective")
    int insertSelective(Dsp record);

    @Select({
        "select",
        "DSP_ID, NAME, DESC, TOKEN, ADD_TIME, UPDATE_TIME",
        "from DSP",
        "where DSP_ID = #{dspId,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="DSP_ID", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="NAME", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="DESC", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="TOKEN", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="ADD_TIME", javaType=LocalDateTime.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="UPDATE_TIME", javaType=LocalDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Dsp selectByPrimaryKey(String dspId);

    @UpdateProvider(type=DspSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Dsp record);

    @Update({
        "update DSP",
        "set NAME = #{name,jdbcType=VARCHAR},",
          "DESC = #{desc,jdbcType=VARCHAR},",
          "TOKEN = #{token,jdbcType=VARCHAR},",
          "ADD_TIME = #{addTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where DSP_ID = #{dspId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Dsp record);

    @Results({
            @Result(column = "DSP_ID", property = "dspId"),
            @Result(column = "NAME", property = "name"),
            @Result(column = "DESC", property = "desc"),
            @Result(column = "TOKEN", property = "token"),
            @Result(column = "ADD_TIME", property = "addTime"),
            @Result(column = "UPDATE_TIME", property = "updateTime")
    })
    @Select("Select * from dsp")
    List<Dsp> find();
}