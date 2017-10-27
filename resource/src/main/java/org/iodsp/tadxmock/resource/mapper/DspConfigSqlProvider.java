package org.iodsp.tadxmock.resource.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.iodsp.tadxmock.resource.pojo.DspConfig;

public class DspConfigSqlProvider {

    public String insertSelective(DspConfig record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("DSP_CONFIG");
        
        if (record.getDspId() != null) {
            sql.VALUES("DSP_ID", "#{dspId,jdbcType=VARCHAR}");
        }
        
        if (record.getMappingUrl() != null) {
            sql.VALUES("MAPPING_URL", "#{mappingUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getBidUrl() != null) {
            sql.VALUES("BID_URL", "#{bidUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getWinNoticeUrl() != null) {
            sql.VALUES("WIN_NOTICE_URL", "#{winNoticeUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getQps() != null) {
            sql.VALUES("QPS", "#{qps,jdbcType=INTEGER}");
        }
        
        if (record.getNoCmResponse() != null) {
            sql.VALUES("NO_CM_RESPONSE", "#{noCmResponse,jdbcType=VARCHAR}");
        }
        
        if (record.getUseTuserinfo() != null) {
            sql.VALUES("USE_TUSERINFO", "#{useTuserinfo,jdbcType=VARCHAR}");
        }
        
        if (record.getRtbMsgFormat() != null) {
            sql.VALUES("RTB_MSG_FORMAT", "#{rtbMsgFormat,jdbcType=VARCHAR}");
        }
        
        if (record.getAddTime() != null) {
            sql.VALUES("ADD_TIME", "#{addTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(DspConfig record) {
        SQL sql = new SQL();
        sql.UPDATE("DSP_CONFIG");

        if (record.getMappingUrl() != null) {
            sql.SET("MAPPING_URL = #{mappingUrl,jdbcType=VARCHAR}");
        }

        if (record.getBidUrl() != null) {
            sql.SET("BID_URL = #{bidUrl,jdbcType=VARCHAR}");
        }

        if (record.getWinNoticeUrl() != null) {
            sql.SET("WIN_NOTICE_URL = #{winNoticeUrl,jdbcType=VARCHAR}");
        }

        if (record.getQps() != null) {
            sql.SET("QPS = #{qps,jdbcType=INTEGER}");
        }

        if (record.getNoCmResponse() != null) {
            sql.SET("NO_CM_RESPONSE = #{noCmResponse,jdbcType=VARCHAR}");
        }

        if (record.getUseTuserinfo() != null) {
            sql.SET("USE_TUSERINFO = #{useTuserinfo,jdbcType=VARCHAR}");
        }

        if (record.getRtbMsgFormat() != null) {
            sql.SET("RTB_MSG_FORMAT = #{rtbMsgFormat,jdbcType=VARCHAR}");
        }

        if (record.getAddTime() != null) {
            sql.SET("ADD_TIME = #{addTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }

        sql.WHERE("DSP_ID = #{dspId,jdbcType=VARCHAR}");

        return sql.toString();
    }
}