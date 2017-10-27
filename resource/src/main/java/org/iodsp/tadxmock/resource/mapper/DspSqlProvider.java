package org.iodsp.tadxmock.resource.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.iodsp.tadxmock.resource.pojo.Dsp;

public class DspSqlProvider {

    public String insertSelective(Dsp record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("DSP");
        
        if (record.getDspId() != null) {
            sql.VALUES("DSP_ID", "#{dspId,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("NAME", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDesc() != null) {
            sql.VALUES("DESC", "#{desc,jdbcType=VARCHAR}");
        }
        
        if (record.getToken() != null) {
            sql.VALUES("TOKEN", "#{token,jdbcType=VARCHAR}");
        }
        
        if (record.getAddTime() != null) {
            sql.VALUES("ADD_TIME", "#{addTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Dsp record) {
        SQL sql = new SQL();
        sql.UPDATE("DSP");
        
        if (record.getName() != null) {
            sql.SET("NAME = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDesc() != null) {
            sql.SET("DESC = #{desc,jdbcType=VARCHAR}");
        }
        
        if (record.getToken() != null) {
            sql.SET("TOKEN = #{token,jdbcType=VARCHAR}");
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