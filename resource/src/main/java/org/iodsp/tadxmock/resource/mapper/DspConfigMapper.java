package org.iodsp.tadxmock.resource.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.iodsp.tadxmock.resource.pojo.DspConfig;

import java.time.LocalDateTime;

@Mapper
public interface DspConfigMapper {
    @Delete({
            "delete from DSP_CONFIG",
            "where DSP_ID = #{dspId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String dspId);

    @Insert({
        "insert into DSP_CONFIG (DSP_ID, MAPPING_URL, ",
        "BID_URL, WIN_NOTICE_URL, ",
        "QPS, NO_CM_RESPONSE, ",
        "USE_TUSERINFO, RTB_MSG_FORMAT, ",
        "ADD_TIME, UPDATE_TIME)",
        "values (#{dspId,jdbcType=VARCHAR}, #{mappingUrl,jdbcType=VARCHAR}, ",
        "#{bidUrl,jdbcType=VARCHAR}, #{winNoticeUrl,jdbcType=VARCHAR}, ",
        "#{qps,jdbcType=INTEGER}, #{noCmResponse,jdbcType=VARCHAR}, ",
        "#{useTuserinfo,jdbcType=VARCHAR}, #{rtbMsgFormat,jdbcType=VARCHAR}, ",
        "#{addTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(DspConfig record);

    @InsertProvider(type=DspConfigSqlProvider.class, method="insertSelective")
    int insertSelective(DspConfig record);


    @UpdateProvider(type=DspConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DspConfig record);

    @Select({
            "select ",
            "DSP_ID, MAPPING_URL, ",
            "BID_URL, WIN_NOTICE_URL, ",
            "QPS, NO_CM_RESPONSE, ",
            "USE_TUSERINFO, RTB_MSG_FORMAT, ",
            "ADD_TIME, UPDATE_TIME" +
            "from DSP_CONFIG",
            "where DSP_ID = #{dspId,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
            @Arg(column="DSP_ID", javaType=String.class, jdbcType= JdbcType.VARCHAR, id=true),
            @Arg(column="MAPPING_URL", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="BID_URL", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="QPS", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
            @Arg(column="NO_CM_RESPONSE", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="USE_TUSERINFO", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="RTB_MSG_FORMAT", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="ADD_TIME", javaType=LocalDateTime.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="UPDATE_TIME", javaType=LocalDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    DspConfig selectByPrimaryKey(String dspId);

}