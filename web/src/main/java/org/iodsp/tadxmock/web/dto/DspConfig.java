package org.iodsp.tadxmock.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DspConfig extends BasicAuth {
    @JsonProperty("mapping_url")
    private String mappingUrl;

    @JsonProperty("bid_url")
    private String bidUrl;

    @JsonProperty("win_notice_url")
    private String winNoticeUrl;

    private Integer qps;

    @JsonProperty("no_cm_response")
    private String noCmResponse;

    @JsonProperty("use_tuserinfo")
    private String useTUserinfo;

    @JsonProperty("rtb_msg_format")
    private String rtbMsgFormat;
}
