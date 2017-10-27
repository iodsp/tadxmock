package org.iodsp.tadxmock.resource.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DspConfig implements Serializable {
    private String dspId;

    private String mappingUrl;

    private String bidUrl;

    private String winNoticeUrl;

    private Integer qps;

    private String noCmResponse;

    private String useTuserinfo;

    private String rtbMsgFormat;

    private LocalDateTime addTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;

    public DspConfig(String dspId, String mappingUrl, String bidUrl, String winNoticeUrl, Integer qps, String noCmResponse, String useTuserinfo, String rtbMsgFormat, LocalDateTime addTime, LocalDateTime updateTime) {
        this.dspId = dspId;
        this.mappingUrl = mappingUrl;
        this.bidUrl = bidUrl;
        this.winNoticeUrl = winNoticeUrl;
        this.qps = qps;
        this.noCmResponse = noCmResponse;
        this.useTuserinfo = useTuserinfo;
        this.rtbMsgFormat = rtbMsgFormat;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }

    public DspConfig() {
        super();
    }

    public String getDspId() {
        return dspId;
    }

    public void setDspId(String dspId) {
        this.dspId = dspId == null ? null : dspId.trim();
    }

    public String getMappingUrl() {
        return mappingUrl;
    }

    public void setMappingUrl(String mappingUrl) {
        this.mappingUrl = mappingUrl == null ? null : mappingUrl.trim();
    }

    public String getBidUrl() {
        return bidUrl;
    }

    public void setBidUrl(String bidUrl) {
        this.bidUrl = bidUrl == null ? null : bidUrl.trim();
    }

    public String getWinNoticeUrl() {
        return winNoticeUrl;
    }

    public void setWinNoticeUrl(String winNoticeUrl) {
        this.winNoticeUrl = winNoticeUrl == null ? null : winNoticeUrl.trim();
    }

    public Integer getQps() {
        return qps;
    }

    public void setQps(Integer qps) {
        this.qps = qps;
    }

    public String getNoCmResponse() {
        return noCmResponse;
    }

    public void setNoCmResponse(String noCmResponse) {
        this.noCmResponse = noCmResponse == null ? null : noCmResponse.trim();
    }

    public String getUseTuserinfo() {
        return useTuserinfo;
    }

    public void setUseTuserinfo(String useTuserinfo) {
        this.useTuserinfo = useTuserinfo == null ? null : useTuserinfo.trim();
    }

    public String getRtbMsgFormat() {
        return rtbMsgFormat;
    }

    public void setRtbMsgFormat(String rtbMsgFormat) {
        this.rtbMsgFormat = rtbMsgFormat == null ? null : rtbMsgFormat.trim();
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DspConfig other = (DspConfig) that;
        return (this.getDspId() == null ? other.getDspId() == null : this.getDspId().equals(other.getDspId()))
            && (this.getMappingUrl() == null ? other.getMappingUrl() == null : this.getMappingUrl().equals(other.getMappingUrl()))
            && (this.getBidUrl() == null ? other.getBidUrl() == null : this.getBidUrl().equals(other.getBidUrl()))
            && (this.getWinNoticeUrl() == null ? other.getWinNoticeUrl() == null : this.getWinNoticeUrl().equals(other.getWinNoticeUrl()))
            && (this.getQps() == null ? other.getQps() == null : this.getQps().equals(other.getQps()))
            && (this.getNoCmResponse() == null ? other.getNoCmResponse() == null : this.getNoCmResponse().equals(other.getNoCmResponse()))
            && (this.getUseTuserinfo() == null ? other.getUseTuserinfo() == null : this.getUseTuserinfo().equals(other.getUseTuserinfo()))
            && (this.getRtbMsgFormat() == null ? other.getRtbMsgFormat() == null : this.getRtbMsgFormat().equals(other.getRtbMsgFormat()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDspId() == null) ? 0 : getDspId().hashCode());
        result = prime * result + ((getMappingUrl() == null) ? 0 : getMappingUrl().hashCode());
        result = prime * result + ((getBidUrl() == null) ? 0 : getBidUrl().hashCode());
        result = prime * result + ((getWinNoticeUrl() == null) ? 0 : getWinNoticeUrl().hashCode());
        result = prime * result + ((getQps() == null) ? 0 : getQps().hashCode());
        result = prime * result + ((getNoCmResponse() == null) ? 0 : getNoCmResponse().hashCode());
        result = prime * result + ((getUseTuserinfo() == null) ? 0 : getUseTuserinfo().hashCode());
        result = prime * result + ((getRtbMsgFormat() == null) ? 0 : getRtbMsgFormat().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dspId=").append(dspId);
        sb.append(", mappingUrl=").append(mappingUrl);
        sb.append(", bidUrl=").append(bidUrl);
        sb.append(", winNoticeUrl=").append(winNoticeUrl);
        sb.append(", qps=").append(qps);
        sb.append(", noCmResponse=").append(noCmResponse);
        sb.append(", useTuserinfo=").append(useTuserinfo);
        sb.append(", rtbMsgFormat=").append(rtbMsgFormat);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}