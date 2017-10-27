package org.iodsp.tadxmock.resource.service;

import org.iodsp.tadxmock.resource.dto.DspBase;
import org.iodsp.tadxmock.resource.dto.DspConfig;
import org.iodsp.tadxmock.resource.exceptions.BaseExceptionEnums;
import org.iodsp.tadxmock.resource.exceptions.ServiceException;
import org.iodsp.tadxmock.resource.mapper.DspConfigMapper;
import org.iodsp.tadxmock.resource.mapper.DspMapper;
import org.iodsp.tadxmock.resource.pojo.Dsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DspService {

    Logger logger = LoggerFactory.getLogger(DspService.class);

    @Autowired
    DspMapper dspMapper;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    DspConfigMapper dspConfigMapper;

    public void save(DspBase dsp) {
        String id = "";
        if (dsp.getDspId() == null) {
            id = getSeqId();
            Dsp hasDsp = dspMapper.selectByPrimaryKey(id);
            if (hasDsp != null) {
                id = getSeqId();
            }
        } else {
            id = dsp.getDspId();
        }
        Dsp dspData = new Dsp(id, dsp.getName(), dsp.getDesc(),
                bCryptPasswordEncoder().encode(id), LocalDateTime.now(), LocalDateTime.now());
        logger.info("dsp id: {}", dspData);
        if (dsp.getDspId() == null) {
            dspMapper.insert(dspData);
        } else {
            Dsp hasDsp = dspMapper.selectByPrimaryKey(id);
            if (hasDsp == null) {
                throw new ServiceException(BaseExceptionEnums.NO_SUCH_EXCEPTION);
            }
            dspMapper.updateByPrimaryKeySelective(dspData);
        }
    }

    public void delete(String dspId) {
        Dsp hasDsp = dspMapper.selectByPrimaryKey(dspId);
        if (hasDsp == null) {
            throw new ServiceException(BaseExceptionEnums.NO_SUCH_EXCEPTION);
        }

        dspMapper.deleteByPrimaryKey(dspId);
        dspConfigMapper.deleteByPrimaryKey(dspId);
    }

    public void saveConfig(DspConfig dspConfig) {
        Dsp hasDsp = dspMapper.selectByPrimaryKey(dspConfig.getDspId());
        if (hasDsp == null) {
            throw new ServiceException(BaseExceptionEnums.NO_SUCH_EXCEPTION);
        }

        org.iodsp.tadxmock.resource.pojo.DspConfig data = new org.iodsp.tadxmock.resource.pojo.DspConfig();
        data.setDspId(dspConfig.getDspId());
        data.setMappingUrl(dspConfig.getMappingUrl());
        data.setBidUrl(dspConfig.getBidUrl());
        data.setWinNoticeUrl(dspConfig.getWinNoticeUrl());
        data.setQps(dspConfig.getQps());
        data.setNoCmResponse(dspConfig.getNoCmResponse());
        data.setUseTuserinfo(dspConfig.getUseTUserinfo());
        data.setRtbMsgFormat(dspConfig.getRtbMsgFormat());
        data.setUpdateTime(LocalDateTime.now());
        org.iodsp.tadxmock.resource.pojo.DspConfig hasConfig = dspConfigMapper.selectByPrimaryKey(dspConfig.getDspId());
        if (hasConfig != null) {
            dspConfigMapper.updateByPrimaryKeySelective(data);
        } else {
            data.setAddTime(LocalDateTime.now());
            dspConfigMapper.insert(data);
        }
    }

    public DspBase info(String dspId) {
        Dsp hasDsp = dspMapper.selectByPrimaryKey(dspId);
        if (hasDsp == null) {
            throw new ServiceException(BaseExceptionEnums.NO_SUCH_EXCEPTION);
        }

        DspBase dspBase = new DspBase();
        dspBase.setDspId(hasDsp.getDspId());
        dspBase.setToken(hasDsp.getToken());
        dspBase.setAddTime(hasDsp.getAddTime());
        dspBase.setUpdateTime(hasDsp.getUpdateTime());
        dspBase.setName(hasDsp.getName());
        dspBase.setDesc(hasDsp.getDesc());
        return dspBase;
    }

    public DspConfig infoConfig(String dspId) {
        org.iodsp.tadxmock.resource.pojo.DspConfig dspConfig = dspConfigMapper.selectByPrimaryKey(dspId);
        if (dspConfig == null) {
            throw new ServiceException(BaseExceptionEnums.NO_SUCH_EXCEPTION);
        }
        Dsp hasDsp = dspMapper.selectByPrimaryKey(dspId);
        if (hasDsp == null) {
            throw new ServiceException(BaseExceptionEnums.NO_SUCH_EXCEPTION);
        }

        DspConfig data = new DspConfig();
        data.setDspId(dspConfig.getDspId());
        data.setMappingUrl(dspConfig.getMappingUrl());
        data.setBidUrl(dspConfig.getBidUrl());
        data.setWinNoticeUrl(dspConfig.getWinNoticeUrl());
        data.setQps(dspConfig.getQps());
        data.setNoCmResponse(dspConfig.getNoCmResponse());
        data.setUseTUserinfo(dspConfig.getUseTuserinfo());
        data.setRtbMsgFormat(dspConfig.getRtbMsgFormat());
        data.setToken(hasDsp.getToken());
        return data;
    }

    protected String getSeqId() {
        Integer rand = (int)(Math.random() * 900) + 100;
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")) + rand;
    }
}
